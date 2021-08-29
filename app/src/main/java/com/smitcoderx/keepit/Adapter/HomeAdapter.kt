package com.smitcoderx.keepit.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.smitcoderx.keepit.Model.Notes
import com.smitcoderx.keepit.databinding.ItemHomeLayoutBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(private val binding: ItemHomeLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(notes: Notes) {
            binding.apply {
                tvItemTitle.text = notes.title
                tvItemDesc.text = notes.description
                tvItemType.text = notes.type
                tvItemTime.text = notes.date
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            ItemHomeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<Notes>() {
        override fun areItemsTheSame(oldItem: Notes, newItem: Notes) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Notes, newItem: Notes) =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, differCallback)
}