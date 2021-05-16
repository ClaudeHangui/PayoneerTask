package com.changui.payoneerhomeexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.changui.payoneerhomeexercise.presentation.PaymentMethodsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        this.title = "Payment Methods"
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PaymentMethodsFragment.newInstance())
                    .commitNow()
        }
    }
}