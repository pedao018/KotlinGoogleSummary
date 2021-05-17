package com.hainguyen.kotlingooglesummary.OneKotlinBasics

import android.util.Log

class KotlinBasics {
    companion object {
        fun kotlinBasics() {
            //---Khai báo biến(Declare variables)--------------------------------------------------->
            Log.e("KotlinBasics", "Khai báo biến")
            var a = 0 //Khai báo = var có thể set lại biến mới
            val b = 0 //Khai báo = val thì chỉ set biến mới 1 lần

            a = a + 1
            Log.e("KotlinBasics", "$a")

            //b = b + 1 //Báo lỗi

            //---Plus, minus, times, division--------------------------------------------------->
            Log.e("KotlinBasics", "Plus, minus, times, division")
            var number1: Int = 5
            var number2 = 5.0
            Log.e("KotlinBasics", "${number1.plus(2)}")
            Log.e("KotlinBasics", "${number1.minus(3)}")
            Log.e("KotlinBasics", "${number1.times(2)}")
            Log.e("KotlinBasics", "${number1.div(2)}")
            Log.e("KotlinBasics", "${number1.div(2.0)}")
            Log.e("KotlinBasics", "${number2.div(2)}")
        }
    }
}