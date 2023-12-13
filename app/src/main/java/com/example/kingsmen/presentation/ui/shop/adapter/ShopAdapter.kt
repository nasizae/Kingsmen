package com.example.kingsmen.presentation.ui.shop.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.kingsmen.data.model.ProductModelItem
import com.example.kingsmen.databinding.ItemShopProductBinding

class ShopAdapter(private val onclick:(productmodelitem:ProductModelItem)->Unit):Adapter<ShopAdapter.ShopHolder>() {

    private val _list= mutableListOf<ProductModelItem>()
    val list:List<ProductModelItem> get() = _list

    fun addData(productModelItem: List<ProductModelItem>){
        _list.clear()
        _list.addAll(productModelItem)
        notifyItemRangeChanged(_list.size,productModelItem.size - _list.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopHolder {
        return ShopHolder(ItemShopProductBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: ShopHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ShopHolder(private val binding: ItemShopProductBinding):ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(productModelItem: ProductModelItem){
            with(binding){
                Glide.with(imgProduct).load(productModelItem.source_img).into(imgProduct)
                tvNameProduct.text=productModelItem.title
                count.text=productModelItem.volume.toString()+"мл"
                btnBay.text=productModelItem.price.toString()+"c."

            }
            itemView.setOnClickListener {
                onclick(productModelItem)
            }
        }

    }
}