package com.hainguyen.kotlingooglesummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hainguyen.kotlingooglesummary.L1KotlinBasics.KotlinBasics
import com.hainguyen.kotlingooglesummary.L2Function.Function
import com.hainguyen.kotlingooglesummary.L3ClassAndObject.ClassAndObject
import com.hainguyen.kotlingooglesummary.L4Extensions.Extensions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Extensions.runApp()
    }
}