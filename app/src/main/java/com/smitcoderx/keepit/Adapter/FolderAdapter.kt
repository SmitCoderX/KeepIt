package com.smitcoderx.keepit.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smitcoderx.keepit.Model.Folder
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.databinding.ItemFolderLayoutBinding

class FolderAdapter : RecyclerView.Adapter<FolderAdapter.FolderViewHolder>() {

    inner class FolderViewHolder(private val binding: ItemFolderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(folder: Folder) {
            binding.apply {
                Glide.with(itemView)
                    .load(R.drawable.ic_keep_folder)
                    .into(ivFolder)

                tvFolderName.text = folder.folderName
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        val binding =
            ItemFolderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FolderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<Folder>() {
        override fun areItemsTheSame(oldItem: Folder, newItem: Folder) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Folder, newItem: Folder) =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, differCallback)
}