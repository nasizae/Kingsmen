package com.example.kingsmen.presentation.ui.home.barber.record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kingsmen.R
import com.example.kingsmen.databinding.FragmentRecordBinding

class RecordFragment : Fragment() {

     private lateinit var binding: FragmentRecordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRecordBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListiners()
    }

    private fun initListiners() {
        binding.btnStock.setOnClickListener {
            if (binding.rvStock.visibility == View.GONE) {
                binding.rvStock.visibility = View.VISIBLE
            }
            else{
                binding.rvStock.visibility = View.GONE
            }
        }
    }

}