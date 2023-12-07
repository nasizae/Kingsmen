package com.example.kingsmen.presentation.ui.home.barber.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kingsmen.data.model.ModelPortfolioItem
import com.example.kingsmen.databinding.ItemPortfolioBinding

class PortfolioAdapter:Adapter<PortfolioAdapter.PortfolioHolder>() {

    private val _list= mutableListOf<ModelPortfolioItem>()
    val list :List<ModelPortfolioItem> get() = _list
    fun addData(modelPortfolioItem: List<ModelPortfolioItem>){
        _list.clear()
        _list.addAll(modelPortfolioItem)
        notifyItemRangeChanged(_list.size,modelPortfolioItem.size - _list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioHolder {
       return PortfolioHolder(ItemPortfolioBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: PortfolioHolder, position: Int) {
        holder.bind(list.get(position))
    }

    inner class PortfolioHolder(private val binding: ItemPortfolioBinding):ViewHolder(binding.root) {
        fun bind(modelPortfolioItem: ModelPortfolioItem){
            binding.imgPortfolio.load(modelPortfolioItem.source_img)
        }
    }
}