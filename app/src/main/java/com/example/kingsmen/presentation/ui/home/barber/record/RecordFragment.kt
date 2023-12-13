package com.example.kingsmen.presentation.ui.home.barber.record

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kingsmen.App
import com.example.kingsmen.R
import com.example.kingsmen.data.model.ModelHistoryRecords
import com.example.kingsmen.databinding.AlertdialogRecordsBinding
import com.example.kingsmen.databinding.FragmentRecordBinding
import com.google.android.material.button.MaterialButton

class RecordFragment : Fragment() {

    private lateinit var binding: FragmentRecordBinding
    private lateinit var list: ArrayList<ModelHistoryRecords>
    private lateinit var recordAdapter: RecordAdapter
    var click = false
    private lateinit var alertDialog:AlertDialog


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = ArrayList()
        list.add(
            ModelHistoryRecords(
                1,
                590,
                "Стрижка Happy",
                "https://foodkupoon.ru/upload/actions/front-big-18354_16637661390.jpg",
                "Стрижка 990 с. с понедельника по четверг с 12:00 до 15:00 по промокоду “Happy22”"
            )
        )
        list.add(
            ModelHistoryRecords(
                2,
                1000,
                "отец + сын",
                "https://f1.dikidi.net/c3/v2262/io18f6ucl2.jpg",
                "Стрижка 1000 с. с вторника  по четверг с 11:00 до 14:00 по промокоду “FatSon1” "
            )
        )
        list.add(
            ModelHistoryRecords(
                3,
                590,
                "стрижка brushed back",
                "https://static.tildacdn.com/tild3334-3737-4039-b166-653266356331/_.jpg",
                "Волосы укладываются назад создавая гладкую и структурированную стрижку."
            )
        )
        recordAdapter = RecordAdapter(list, this::onClick)
        binding.rvStock.adapter = recordAdapter
        binding.btnStock.setOnClickListener {
            if (binding.rvStock.visibility == View.GONE) {
                binding.rvStock.visibility = View.VISIBLE
            } else {
                binding.rvStock.visibility = View.GONE
            }

        }
        initClicker()
    }

    private fun initClicker() {
        with(binding) {

            val listButton: List<MaterialButton> = listOf(
                btn1000, btn1100,
                btn1200, btn1300,
                btn1400, btn1500,
                btn1600, btn1700,
                btn1800, btn1900,
                btn2000, btn2100
            )
            for (button in listButton) {
                button.setOnClickListener { onclick ->
                    click = true
                    if (click) {
                        button.setBackgroundColor(button.context.resources.getColor(R.color.brown))
                    }
                    for (abutton in listButton) {
                        if (abutton.id != onclick.id) {
                            click = false
                            abutton.setBackgroundColor(button.context.resources.getColor(R.color.black))
                        }

                        btnRecords.setOnClickListener {
                            if (button.id == onclick.id) {
                                click = true
                                if (click) {
                                    button.setBackgroundColor(button.context.resources.getColor(R.color.grey))
                                }

                            }
                            alertDialog.show()
                        }
                    }
                }
            }
        }
    }

    private fun onClick(modelHistoryRecords: ModelHistoryRecords) {
        createAlertDialog(modelHistoryRecords)

    }
    private fun createAlertDialog(modelHistoryRecords: ModelHistoryRecords) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext(), R.style.CustomAlertDialogStyle)
        val alertDialogBinding = AlertdialogRecordsBinding.inflate(layoutInflater)
        alertDialogBuilder.setView(alertDialogBinding.root)

        alertDialogBinding.btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialogBinding.btnYes.setOnClickListener {
            App.database1.records().insert(modelHistoryRecords)
            alertDialog.dismiss()
        }
        alertDialog = alertDialogBuilder.create()
    }
}