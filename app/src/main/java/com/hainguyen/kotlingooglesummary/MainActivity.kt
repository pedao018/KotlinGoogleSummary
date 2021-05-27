package com.hainguyen.kotlingooglesummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hainguyen.kotlingooglesummary.L1KotlinBasics.KotlinBasics
import com.hainguyen.kotlingooglesummary.L2Function.Function
import com.hainguyen.kotlingooglesummary.L3ClassAndObject.ClassAndObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ClassAndObject.runApp()
    }
}