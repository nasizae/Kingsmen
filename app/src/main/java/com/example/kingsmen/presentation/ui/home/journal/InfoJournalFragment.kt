package com.example.kingsmen.presentation.ui.home.journal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
    private val viewModel= JournalViewModel(repository)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentInfoJournalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args=InfoJournalFragmentArgs.fromBundle(requireArguments())
            viewModel.getJournal(args.journal)
        Log.e("ololo", "onViewCreated: ${args.journal}", )

        viewModel.journal.observe(viewLifecycleOwner){

                binding.tvName.text=it.toString()
                binding.tvDesc.text=it.toString()
                binding.imgBarber.load(it)

        }
        viewModel.loading.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
        }
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }

    }


}