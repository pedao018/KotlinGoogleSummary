package com.hainguyen.kotlingooglesummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hainguyen.kotlingooglesummary.OneKotlinBasics.KotlinBasics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KotlinBasics.kotlinBasics()
    }
}