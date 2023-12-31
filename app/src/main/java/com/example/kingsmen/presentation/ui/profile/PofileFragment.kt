package com.example.kingsmen.presentation.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kingsmen.R
import com.example.kingsmen.core.BaseFragment
import com.example.kingsmen.databinding.FragmentProfileBinding

class PofileFragment :
    BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {
    override val viewModel: ProfileViewModel
        get() = ProfileViewModel()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater,container,false)
    }

    override fun initClicker() {

    }

    override fun initListenrs() {
        with(binding) {
            btnCard.setOnClickListener {
                findNavController().navigate(R.id.cardFragment)
            }
            btnSettings.setOnClickListener {
                findNavController().navigate(R.id.settingProfileFragment)
            }
            btnHistoryShops.setOnClickListener {
                findNavController().navigate(R.id.historyShopFragment)
            }
            btnHistoryRecord.setOnClickListener {
                findNavController().navigate(R.id.historyRecordsFragment)
            }
        }
    }

    override fun initLivedata() {

    }
}