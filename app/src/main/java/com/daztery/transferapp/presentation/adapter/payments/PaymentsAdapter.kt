package com.daztery.transferapp.presentation.adapter.payments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daztery.transferapp.R
import com.daztery.transferapp.data.Payment

class PaymentsAdapter(
    private val paymentsList: List<Payment>,
) : RecyclerView.Adapter<PaymentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PaymentsViewHolder(layoutInflater.inflate(R.layout.item_payment,parent,false))
    }

    override fun getItemCount(): Int = paymentsList.size

    override fun onBindViewHolder(holder: PaymentsViewHolder, position: Int) {
        val item = paymentsList[position]
        holder.render(item)
    }

}