package com.example.kingsmen.presentation.ui.shop

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kingsmen.App
import com.example.kingsmen.R
import com.example.kingsmen.core.BaseFragment
import com.example.kingsmen.data.model.ProductModelItem
import com.example.kingsmen.data.network.RetrofitClient
import com.example.kingsmen.data.remote.RemoteDataSource
import com.example.kingsmen.databinding.AlerdialogBayBinding
import com.example.kingsmen.databinding.FragmentShopBinding
import com.example.kingsmen.domain.repository.Repository
import com.example.kingsmen.presentation.ui.shop.adapter.ShopAdapter

class ShopFragment : BaseFragment<FragmentShopBinding, ShopViewModel>(R.layout.fragment_shop) {
    private val retrofitClient = RetrofitClient().createApiService()
    private val remoteDataSource = RemoteDataSource(retrofitClient)
    private val repository = Repository(remoteDataSource)
    override val viewModel = ShopViewModel(repository)
    private val shopAdapter = ShopAdapter(this::onClick)

    private lateinit var alertDialog: AlertDialog

    private fun createAlertDialog(productModelItem: ProductModelItem) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext(),R.style.CustomAlertDialogStyle)
        val alertDialogBinding = AlerdialogBayBinding.inflate(layoutInflater)
        alertDialogBuilder.setView(alertDialogBinding.root)

        alertDialogBinding.btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialogBinding.btnYes.setOnClickListener {
        App.database.productDao().insert(productModelItem)
            alertDialog.dismiss()
        }
        alertDialog = alertDialogBuilder.create()
    }

    private fun onClick(productModelItem: ProductModelItem) {
        createAlertDialog(productModelItem)
        alertDialog.show()
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShopBinding {
        return FragmentShopBinding.inflate(inflater, container, false)
    }

    override fun initClicker() {


    }

    override fun initListenrs() {
        viewModel.getProduct()
    }

    @SuppressLint("SetTextI18n")
    override fun initLivedata() {

        viewModel.product.observe(viewLifecycleOwner) {
            shopAdapter.addData(it)
            binding.rvProduct.adapter = shopAdapter
            binding.count.text = shopAdapter.itemCount.toString() + " товаров"
        }
        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            if (loading) {
                binding.loading.root.visibility = View.VISIBLE
            } else {
                binding.loading.root.visibility = View.GONE
            }
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }
    }
}

