package com.youngseo3.lacuna.myapplication.ui.main.community

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.youngseo3.lacuna.myapplication.data.entities.BoardWrite
import com.youngseo3.lacuna.myapplication.databinding.ItemCommunityWritingRvBinding

class WritingRVAdapter(val itemList: ArrayList<BoardWrite>): RecyclerView.Adapter<WritingRVAdapter.WritingViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): WritingRVAdapter.WritingViewHolder {
        val binding: ItemCommunityWritingRvBinding = ItemCommunityWritingRvBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return WritingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WritingRVAdapter.WritingViewHolder, position: Int) {
        holder.topic.text = itemList[position].topic
        holder.title.text = itemList[position].title
        holder.content.text = itemList[position].content

    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class WritingViewHolder(val binding: ItemCommunityWritingRvBinding) : RecyclerView.ViewHolder(binding.root) {
        val topic : TextView = binding.itemWritingTopicTv
        val title : TextView = binding.itemWritingTitleTv
        val content : TextView = binding.itemWritingContentTv
    }

}