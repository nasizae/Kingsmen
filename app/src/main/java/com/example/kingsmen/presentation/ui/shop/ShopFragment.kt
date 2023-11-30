package com.example.kingsmen.presentation.ui.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kingsmen.R
import com.example.kingsmen.core.BaseFragment
import com.example.kingsmen.databinding.FragmentShopBinding

class ShopFragment : BaseFragment<FragmentShopBinding, ShopViewModel>(R.layout.fragment_shop) {
    override val viewModel: ShopViewModel
        get() = ShopViewModel()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShopBinding {
        return FragmentShopBinding.inflate(inflater, container, false)
    }

    override fun initListenrs() {

    }
}