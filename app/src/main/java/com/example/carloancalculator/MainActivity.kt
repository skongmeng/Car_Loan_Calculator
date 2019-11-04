package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener({
            calculateRepayment()
        })

        reset.setOnClickListener({
            resetAct()
        })
    }

    private fun resetAct() {
        onBackPressed();
    }

    private fun calculateRepayment() {
        if (carPrice.text.isEmpty()) {
            carPrice.setError(getString(R.string.error_input))
            return
        }

        val car_price: Int = carPrice.text.toString().toInt()
        val down_payment: Int = downPayment.text.toString().toInt()
        val loan_v: Int = car_price - down_payment
        loan.setText(getString(R.string.loan) + "${loan_v}")
        val periodOfPayment: Int = loadPeriod.text.toString().toInt()
        val Interest_Rate: Float = InterestRate.text.toString().toFloat()
        val interest: Float = loan_v * Interest_Rate / 100 * periodOfPayment
        Interest.setText(getString(R.string.interest) + "${interest}")
        val mon_payment: Float = (interest + loan_v) / 12 / periodOfPayment
        MonPayment.setText(getString(R.string.monthly_repayment) + "${mon_payment}")

    }


}
