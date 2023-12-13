package com.example.kingsmen.presentation.ui.home.journal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.kingsmen.data.network.RetrofitClient
import com.example.kingsmen.data.remote.RemoteDataSource
import com.example.kingsmen.databinding.FragmentInfoJournalBinding
import com.example.kingsmen.domain.repository.Repository

class InfoJournalFragment : Fragment() {

    private lateinit var args: InfoJournalFragmentArgs
    private lateinit var binding: FragmentInfoJournalBinding
    private val retrofitClient= RetrofitClient().createApiService()
    private val remoteDataSource= RemoteDataSource(retrofitClient)
    private val repository= Repository(remoteDataSource)
    private val viewModel = JournalViewModel(repository)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentInfoJournalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLiveData()
        initClicker()

    }

    private fun initClicker() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun initLiveData() {
        args=InfoJournalFragmentArgs.fromBundle(requireArguments())
        viewModel.getJournal(args.journal)
        viewModel.journal.observe(viewLifecycleOwner){
            binding.imgBarber.load(it.source_img)
            binding.tvDesc.text=it.text
            binding.tvName.text=it.title
        }
        viewModel.loading.observe(viewLifecycleOwner){
            if(it){
                binding.loading.root.visibility=View.VISIBLE
            }
            else{
                binding.loading.root.visibility=View.GONE
                binding.btnBack.visibility=View.VISIBLE
            }
        }
    }
}