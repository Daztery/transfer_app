package com.daztery.transferapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.daztery.transferapp.data.Payment
import com.daztery.transferapp.databinding.ActivityMainBinding
import com.daztery.transferapp.presentation.adapter.payments.PaymentsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PaymentsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPaymentsRecycler()

    }

    private fun initPaymentsRecycler() {
        adapter = PaymentsAdapter(listOf(Payment("Andres", 20.0)))
        val manager = LinearLayoutManager(this)
        binding.rvPayments.layoutManager = manager
        binding.rvPayments.adapter = adapter
    }

}