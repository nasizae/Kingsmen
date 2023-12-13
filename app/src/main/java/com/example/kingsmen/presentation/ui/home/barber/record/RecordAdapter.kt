package com.example.kingsmen.presentation.ui.home.barber.record

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kingsmen.data.model.ModelHistoryRecords
import com.example.kingsmen.databinding.ItemAkciiBinding

class RecordAdapter(private val list:ArrayList<ModelHistoryRecords>,private val onclick: (modelHistory: ModelHistoryRecords) -> Unit) :
    Adapter<RecordAdapter.RecordHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordHolder {
        return RecordHolder(
            ItemAkciiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecordHolder, position: Int) {
        holder.bind(list[position])
    }

   inner class RecordHolder(private val binding: ItemAkciiBinding) : ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(modelHistory: ModelHistoryRecords) {
            binding.haircutsHappy.text = modelHistory.name
            binding.priceHappy.text = modelHistory.price.toString()+" c."
            binding.descHappy.text=modelHistory.desc
            binding.img.load(modelHistory.image)
           itemView.setOnClickListener {
               onclick(modelHistory)
               binding.btnHeckHappy.isChecked=true
           }
        }
    }
}
