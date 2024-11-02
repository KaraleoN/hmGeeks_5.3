package com.example.retrofit.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.data.model.PercentageModel
import com.example.retrofit.databinding.ItemPercentageBinding

class PercentageAdapter : RecyclerView.Adapter<PercentageAdapter.PercentageViewHolder>() {

    private var dataList: List<PercentageModel> = listOf()

    inner class PercentageViewHolder(private val binding: ItemPercentageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(percentageModel: PercentageModel) {
            binding.tvFirstName.text = percentageModel.firstName
            binding.tvSecondName.text = percentageModel.secondName
            binding.tvResult.text = "${percentageModel.result}%"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PercentageViewHolder {
        val binding = ItemPercentageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PercentageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PercentageViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(newData: List<PercentageModel>) {
        dataList = newData
        notifyDataSetChanged()
    }
}