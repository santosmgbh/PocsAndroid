package com.boleuti.poccoursescreen

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.boleuti.poccoursescreen.databinding.ClassItemBinding


class TestListAdapter :
    ListAdapter<TestListAdapter.ItemList, TestListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ClassItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ClassItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemList: ItemList) {
            binding.tvText.text = itemList.text
            Log.e("ADAPTER", "binding item: ${itemList.id}")
        }

    }

    data class ItemList(val id: Int, val text: String)

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemList>() {
            override fun areItemsTheSame(
                oldItem: ItemList,
                newItem: ItemList
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: ItemList,
                newItem: ItemList
            ): Boolean = oldItem == newItem
        }
    }
}

