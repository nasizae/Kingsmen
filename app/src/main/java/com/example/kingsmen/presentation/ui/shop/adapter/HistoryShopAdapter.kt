package com.example.kingsmen.presentation.ui.shop.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kingsmen.data.model.ProductModelItem
import com.example.kingsmen.databinding.ItemHistoryShopsBinding

class HistoryShopAdapter (private val onclick:(productModelItem: ProductModelItem)->Unit): Adapter<HistoryShopAdapter.HistoryShopHolder>() {
    private val productlist = ArrayList<ProductModelItem>()


    fun addData(productModelItem: List<ProductModelItem>){
        productlist.clear()
        productlist.addAll(productModelItem)
        notifyItemRangeChanged(productlist.size,productModelItem.size - productlist.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryShopHolder {
        return HistoryShopHolder(
            ItemHistoryShopsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = productlist.size

    override fun onBindViewHolder(holder: HistoryShopHolder, position: Int) {
        holder.bind(productlist[position])
    }

    inner class HistoryShopHolder(private val binding: ItemHistoryShopsBinding) :
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(productModelItem: ProductModelItem) {
            binding.imgShops.load(productModelItem.source_img)
            binding.count.text = productModelItem.volume.toString() + "ml"
            binding.price.text = productModelItem.price.toString()+" c."
            binding.tvNameProduct.text = productModelItem.title
            itemView.setOnClickListener {
        onclick(productModelItem)
            }
        }

    }
}