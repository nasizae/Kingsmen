package com.example.kingsmen.presentation.ui.home.barber.portfolio

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kingsmen.data.model.ModelMastersItem
import com.example.kingsmen.data.network.RetrofitClient
import com.example.kingsmen.data.remote.RemoteDataSource
import com.example.kingsmen.databinding.FragmentPortfolioBinding
import com.example.kingsmen.domain.repository.Repository

class PortfolioFragment : Fragment() {
    private lateinit var binding: FragmentPortfolioBinding
    private val retrofitClient= RetrofitClient().createApiService()
    private val remoteDataSource= RemoteDataSource(retrofitClient)
    private val repository= Repository(remoteDataSource)
    private val viewModel= PortfolioViewModel(repository)
    private val adapter= PortfolioAdapter()
    private lateinit var args: PortfolioFragmentArgs
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentPortfolioBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initLiveData()
    }

    private fun initListeners() {
       val data= arguments?.getSerializable("key") as ModelMastersItem
        viewModel.getPortfolio(data.id)
        Log.e("ololo", "initListeners: ${data.id}", )
    }

    private fun initLiveData() {
        viewModel.getPortfolio.observe(viewLifecycleOwner){
            adapter.addData(it)
            binding.rvPortfolio.adapter=adapter
        }
        viewModel.loading.observe(viewLifecycleOwner){
            if(it){
                binding.loading.root.visibility=View.VISIBLE
            }
            else{
                binding.loading.root.visibility=View.GONE
            }
        }
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }
    }

}