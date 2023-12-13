package com.example.kingsmen.presentation.ui.shop

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kingsmen.App
import com.example.kingsmen.R
import com.example.kingsmen.data.model.ProductModelItem
import com.example.kingsmen.databinding.AlerdialogBayBinding
import com.example.kingsmen.databinding.FragmentHistoryShopBinding
import com.example.kingsmen.presentation.ui.shop.adapter.HistoryShopAdapter

class HistoryShopFragment : Fragment() {
    private lateinit var binding: FragmentHistoryShopBinding
    private lateinit var historyShopAdapter:HistoryShopAdapter
    private lateinit var alertDialog: AlertDialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHistoryShopBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initRoom()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRoom() {
        historyShopAdapter=HistoryShopAdapter(this::OnclickDelete)
        val data= App.database.productDao().getAll()
        historyShopAdapter.addData(data)
        binding.rvHistoryShop.adapter=historyShopAdapter
        historyShopAdapter.notifyDataSetChanged()
    }
    private fun createAlertDialog(productModelItem: ProductModelItem) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext(), R.style.CustomAlertDialogStyle)
        val alertDialogBinding = AlerdialogBayBinding.inflate(layoutInflater)
        alertDialogBuilder.setView(alertDialogBinding.root)

        alertDialogBinding.btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialogBinding.btnYes.setOnClickListener {
            App.database.productDao().gelete(productModelItem)
            alertDialog.dismiss()
        }
        alertDialog = alertDialogBuilder.create()
    }

    private fun OnclickDelete(productModelItem: ProductModelItem) {
        createAlertDialog(productModelItem)
        alertDialog.show()
    }
    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}