package com.example.kingsmen.presentation.ui.barbershop

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kingsmen.data.network.RetrofitClient
import com.example.kingsmen.data.remote.RemoteDataSource
import com.example.kingsmen.databinding.FragmentBarberShopBinding
import com.example.kingsmen.domain.repository.Repository
import com.example.kingsmen.presentation.ui.barbershop.adapter.BarberShopAdapter


class BarberShopFragment : Fragment() {
    private lateinit var binding: FragmentBarberShopBinding
    private val retrofitClient = RetrofitClient().createApiSrvice()
    private val remoteDataSource = RemoteDataSource(retrofitClient)
    private val repository = Repository(remoteDataSource)
    private val barberShopViewModel = BarberShopViewModel(repository)
    private var barberShopAdapter = BarberShopAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBarberShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initLiveData()
        initView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initLiveData() {
        barberShopViewModel.barbershop.observe(viewLifecycleOwner){
            barberShopAdapter.addData(it.barberShopModel)
        }
        barberShopViewModel.loading.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "lol", Toast.LENGTH_SHORT).show()
        }
        barberShopViewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initView() {
        barberShopViewModel.getBarberShop()
        binding.rvBarbershop.adapter=barberShopAdapter
    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}
