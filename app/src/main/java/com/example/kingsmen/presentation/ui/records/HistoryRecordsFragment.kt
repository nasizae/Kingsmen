package com.example.kingsmen.presentation.ui.records

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kingsmen.App
import com.example.kingsmen.data.model.ModelHistoryRecords
import com.example.kingsmen.databinding.FragmentHistoryRecordsBinding

class HistoryRecordsFragment : Fragment() {
    private lateinit var binding:FragmentHistoryRecordsBinding
    private lateinit var adapter: HistoryRecordsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHistoryRecordsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initRoom()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initRoom() {
        adapter= HistoryRecordsAdapter(this::Click)
        val data= App.database1.records().getAll()
        adapter.addData(data)
        binding.rvHistoryRecords.adapter=adapter
        adapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun Click(modelHistoryRecords: ModelHistoryRecords) {
        App.database1.records().delete(modelHistoryRecords)
        adapter.notifyDataSetChanged()
    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}