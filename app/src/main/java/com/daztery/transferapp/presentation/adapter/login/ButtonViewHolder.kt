package com.daztery.transferapp.presentation.adapter.login

import androidx.recyclerview.widget.RecyclerView
import com.daztery.transferapp.databinding.ItemButtonPasswordBinding

class ButtonViewHolder(private val binding: ItemButtonPasswordBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(value: String, clickListener: (String) -> Unit) {
        binding.button.text = value
        binding.button.setOnClickListener {
            clickListener(value)
        }
    }
}