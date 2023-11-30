package com.example.kingsmen.presentation.ui.barbershop.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kingsmen.data.model.ModelBarberShop
import com.example.kingsmen.databinding.ItemBarbershopBinding

class BarberShopAdapter : Adapter<BarberShopAdapter.BarberShopHolder>() {

    private val _list = mutableListOf<ModelBarberShop.BarberShopModel>()
    private val list get() = _list

    fun addData(barberShopModel: List<ModelBarberShop.BarberShopModel>) {
        _list.clear()
        _list.addAll(barberShopModel)
        notifyItemRangeInserted(_list.size, barberShopModel.size - _list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarberShopHolder {
        return BarberShopHolder(
            ItemBarbershopBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: BarberShopHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class BarberShopHolder(private val binding: ItemBarbershopBinding) :
        ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(barberShopModel: ModelBarberShop.BarberShopModel) {
            with(binding) {
                tvNameBarbershop.text = barberShopModel.title
                tvFtime.text = barberShopModel.ftime + "-"
                tvTtime.text = barberShopModel.ttime
                tvNavigation.text = barberShopModel.address
                poster.load(barberShopModel.source_img)
            }
            Log.e("ololo", "bind:$barberShopModel ", )
        }

    }
}