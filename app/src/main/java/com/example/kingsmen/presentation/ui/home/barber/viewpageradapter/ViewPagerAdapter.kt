package com.example.kingsmen.presentation.ui.home.barber.viewpageradapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kingsmen.presentation.ui.home.barber.portfolio.PortfolioFragment
import com.example.kingsmen.presentation.ui.home.barber.record.RecordFragment
import com.example.kingsmen.presentation.ui.home.barber.reviews.ReviewsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
 private var fragmentArgs:Bundle?=null
    fun setArguments(args:Bundle){
        fragmentArgs=args
    }

    override fun getItemCount()=3

    override fun createFragment(position: Int): Fragment {
     return when(position){
        0->{val fragment=RecordFragment()
        fragment.arguments=fragmentArgs
        fragment}
         1->{val fragment=PortfolioFragment()
             fragment.arguments=fragmentArgs
             fragment
         }
         2->{
             val fragment=ReviewsFragment()
         fragment.arguments=fragmentArgs
         fragment}
         else ->RecordFragment()
        }
    }
}