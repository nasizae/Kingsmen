package com.example.kingsmen.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kingsmen.R
import com.example.kingsmen.core.BaseFragment
import com.example.kingsmen.data.model.ModelMastersItem
import com.example.kingsmen.data.network.RetrofitClient
import com.example.kingsmen.data.remote.RemoteDataSource
import com.example.kingsmen.databinding.FragmentHomeBinding
import com.example.kingsmen.domain.repository.Repository

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    private val retrofitClient=RetrofitClient().createApiService()
    private val remoteDataSource=RemoteDataSource(retrofitClient)
    private val repository=Repository(remoteDataSource)
    override val viewModel= HomeViewModel(repository)
    private val adapter=MasterAdapter(this::onItemClick)


    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initClicker() {
        var id =0
        binding.btnJournal1.setOnClickListener {
            id=1
            findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToInfoJournalFragment(id))
        }
        binding.btnJournal2.setOnClickListener {
            id=2
            findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToInfoJournalFragment(id))
        }
        binding.btnJournal3.setOnClickListener {
            id=3
            findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToInfoJournalFragment(id))
        }

    }

    override fun initListenrs() {
        viewModel.getMasters()
    }

    override fun initLivedata() {
        viewModel.masters.observe(viewLifecycleOwner){
            adapter.addData(it)
            binding.rvMasterBarber.adapter=adapter
        }
        viewModel.loading.observe(viewLifecycleOwner){
            if(it){
                binding.loading.root.visibility= View.VISIBLE
            }
            else{
                binding.loading.root.visibility= View.GONE
            }
        }
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }
    }
    fun onItemClick(mastersItem: ModelMastersItem){
        findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToBarberFragment(mastersItem))

    }
}