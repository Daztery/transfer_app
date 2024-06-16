package com.daztery.transferapp.presentation.adapter.payments

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.daztery.transferapp.data.Payment
import com.daztery.transferapp.databinding.ItemPaymentBinding
import com.daztery.transferapp.presentation.PaymentDetailActivity

class PaymentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPaymentBinding.bind(view)

    fun bind(payment: Payment) {
        binding.txtFullName.text = payment.fullName

        val amount = "S/ ${payment.amount}"
        binding.txtAmount.text = amount

        binding.card.setOnClickListener {
            val intent = Intent(it.context, PaymentDetailActivity::class.java)
            intent.putExtra("payment", payment)
            it.context.startActivity(intent)
        }
    }
}