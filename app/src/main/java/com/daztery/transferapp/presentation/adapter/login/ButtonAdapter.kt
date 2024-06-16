package com.daztery.transferapp.presentation.adapter.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daztery.transferapp.databinding.ItemButtonPasswordBinding

class ButtonAdapter(
    private val buttons: List<String>,
    private val onClickListener: (String) -> Unit
) :
    RecyclerView.Adapter<ButtonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val binding =
            ItemButtonPasswordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ButtonViewHolder(binding)
    }

    override fun getItemCount(): Int = buttons.size

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val buttonValue = buttons[position]
        holder.bind(buttonValue, onClickListener)
    }

}