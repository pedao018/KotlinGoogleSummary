package com.hainguyen.kotlingooglesummary.L2Function

import android.util.Log
import kotlin.random.Random

class Function {
    companion object {
        val smartPhones = arrayOf("Sony", "Samsung", "Apple", "LG")

        //---Required Parameter. Single-expression--------------------------------------------------->
        fun requiredParameterAndSingleExpress() {
            var result: String = actionToPhone("")
            result += "\n" + actionToPhone("", true)
            result += "\n" + actionToPhone("Haha")
            result += "\n" + actionToPhone("Haha", true)
            result += "\n" + actionToPhone(getRandomPhone())
            result += "\n" + actionToPhone(getRandomPhone(), true)
            Log.e("Function", "Required Parameter. Single-expression: \n" + result)
        }

        //Required Parameter, biến phone là required, isPrintPhoneInfo là không có Required
        fun actionToPhone(phone: String, isPrintPhoneInfo: Boolean = false): String =
            when {
                phone.equals("") -> "Empty String Phone!!!"
                isPrintPhoneInfo -> printPhoneInfo(phone)
                else -> "Print $phone"
            }


        //Single-expression functions , dấu = thay cho return
        fun printPhoneInfo(phone: String): String = when (phone) {
            in smartPhones -> "This is $phone."
            else -> "Not In Phone Array"
        }

        //Single-expression functions , dấu = thay cho return
        fun getRandomPhone(): String = smartPhones[Random.nextInt(smartPhones.size - 1)]
    }
}