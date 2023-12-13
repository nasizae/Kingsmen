package com.example.kingsmen.presentation.ui.records

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingsmen.data.model.ModelHistoryRecords
import com.example.kingsmen.databinding.ItemHistoryRecordsBinding

class HistoryRecordsAdapter (private val onclick:(model:ModelHistoryRecords)->Unit): RecyclerView.Adapter<HistoryRecordsAdapter.HistoryRecordsHolder>() {
    private val productlist = ArrayList<ModelHistoryRecords>()


    fun addData(productModelItem: List<ModelHistoryRecords>){
        productlist.clear()
        productlist.addAll(productModelItem)
        notifyItemRangeChanged(productlist.size,productModelItem.size - productlist.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryRecordsHolder {
        return HistoryRecordsHolder(
            ItemHistoryRecordsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = productlist.size

    override fun onBindViewHolder(holder: HistoryRecordsHolder, position: Int) {
        holder.bind(productlist[position])
    }

    inner class HistoryRecordsHolder(private val binding: ItemHistoryRecordsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(modelItem: ModelHistoryRecords) {
            binding.procedure.text=modelItem.name
            binding.price.text=modelItem.price.toString()+" c."
            itemView.setOnClickListener {
                onclick(modelItem)
            }

        }

    }
}