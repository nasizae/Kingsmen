package com.example.kingsmen.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB:ViewBinding,VM:ViewModel>(@LayoutRes idLayout: Int):Fragment(idLayout) {
    private var _binding:VB?=null
    protected val binding:VB get() = _binding!!

    protected   abstract val viewModel:VM

    abstract fun inflateBinding(inflater: LayoutInflater,container:ViewGroup?):VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=inflateBinding(inflater,container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListenrs()
    }

    abstract fun initListenrs()

}