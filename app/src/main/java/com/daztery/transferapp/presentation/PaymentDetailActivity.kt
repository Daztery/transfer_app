package com.daztery.transferapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.daztery.transferapp.data.Payment
import com.daztery.transferapp.databinding.ActivityPaymentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPaymentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val payment = getPayment()

        if (payment != null) {
            binding.apply {
                txtFullName.text = payment.fullName
                txtAmount.text = payment.amount.toString()
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun getPayment(): Payment? {
        val payment: Payment? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("payment", Payment::class.java)
        } else {
            intent.getParcelableExtra("payment")
        }
        return payment
    }
}