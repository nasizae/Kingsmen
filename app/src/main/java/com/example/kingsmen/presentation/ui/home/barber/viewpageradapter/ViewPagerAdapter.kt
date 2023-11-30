package com.example.kingsmen.presentation.ui.home.barber.viewpageradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kingsmen.presentation.ui.home.barber.portfolio.PortfolioFragment
import com.example.kingsmen.presentation.ui.home.barber.record.RecordFragment
import com.example.kingsmen.presentation.ui.home.barber.reviews.ReviewsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount()=3

    override fun createFragment(position: Int): Fragment {
     return when(position){
        0->RecordFragment()
         1->PortfolioFragment()
         2->ReviewsFragment()
         else ->RecordFragment()
        }
    }
}