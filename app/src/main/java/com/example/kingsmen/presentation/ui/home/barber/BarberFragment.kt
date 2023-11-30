package com.example.kingsmen.presentation.ui.home.barber

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.kingsmen.R
import com.example.kingsmen.databinding.FragmentBarberBinding
import com.example.kingsmen.presentation.ui.home.barber.viewpageradapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class BarberFragment : Fragment() {

    private lateinit var binding: FragmentBarberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBarberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        // Установка цветов текста для активного и неактивного состояний
        tabLayout.setTabTextColors(ContextCompat.getColor(requireContext(),R.color.white),
                                    ContextCompat.getColor(requireContext(),R.color.brown))

        // Установка цвета подсветки выбранного таба
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(requireContext(),R.color.brown))
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Записи"
                1 -> tab.text = "Портфолио"
                2 -> tab.text = "отзывы"
            }
        }.attach()
    }

}