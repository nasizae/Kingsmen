package com.example.kingsmen.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kingsmen.data.model.ModelMastersItem
import com.example.kingsmen.databinding.ItemBarberBinding

class MasterAdapter(private val onclick:(mastersItem: ModelMastersItem)->Unit):Adapter<MasterAdapter.MasterHolder>()  {
    private var _list= mutableListOf<ModelMastersItem>()
    val list :List<ModelMastersItem> get() = _list

    fun addData(mastersItem: List<ModelMastersItem>){
        _list.clear()
        _list.addAll(mastersItem)
        notifyItemRangeChanged(_list.size,mastersItem.size - _list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterHolder {
        return MasterHolder(ItemBarberBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: MasterHolder, position: Int) {
        holder.bind(list.get(position))
    }

    inner class MasterHolder(private val binding: ItemBarberBinding):ViewHolder(binding.root) {
        fun bind(mastersItem: ModelMastersItem){
            with(binding){
                tvBarberName.text=mastersItem.login
                tvProcent.text=mastersItem.rate.toString()
                imgBarber.load(mastersItem.source_img)
                itemView.setOnClickListener {
                    onclick(mastersItem)
                }
            }
        }
    }
}