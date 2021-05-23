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


            //---Cast Type này sang type khác--------------------------------------------------->
            val type1: Int = 5
            type1.toString()
            type1.toByte()


            //---Có thể dùng _ khi con số quá dài--------------------------------------------------->
            Log.e("KotlinBasics", "Có thể dùng _ khi con số quá dài")
            val longNumber = 1_000_000_000
            Log.e("KotlinBasics", "$longNumber")


            //---Range, When (Switch Case)--------------------------------------------------->
            Log.e("KotlinBasics", "Range, When (Switch Case)")
            val numberFish = 20
            if (numberFish in 1..20)
                Log.e("KotlinBasics", "$numberFish")
            else
                Log.e("KotlinBasics", "Out of range")
            //When có truyền biến
            when (numberFish) {
                in 1..20 -> Log.e("KotlinBasics", "$numberFish")
                else -> Log.e("KotlinBasics", "Out of range")
            }
            //When ko truyền biến
            when {
                numberFish in 1..20 -> Log.e("KotlinBasics", "$numberFish")
                else -> Log.e("KotlinBasics", "Out of range")
            }


            //---Nullability--------------------------------------------------->
            val numberInt: Int? = null //Dùng ? phần mềm mới cho qua
            var p1: Person? = null
            // ?: operator (Elvis Operator)
            Log.e("KotlinBasics", "${p1?.toString() ?: "Person is Null"}")
            Log.e("KotlinBasics", "${p1?.name?.toString() ?: "Name is Null"}")
            // !! operator ("double-bang" or "bang bang" operator)
            //p1!!.name.toString() // -> Đảm bảo rằng p1 là non-null, nếu p1 bị null thì throw null exeption


            //---List--------------------------------------------------->
            //List in Kotlin can't be change after declaring
            val persons = listOf("Jack", "James", "Sam")
            Log.e("KotlinBasics", "$persons")
            Log.e("KotlinBasics", "${persons[0]}")
            //Có thể declare nhiều data type khác nhau trong list
            val mixObjectList = listOf("Jack", 1, true)
            Log.e("KotlinBasics", "$mixObjectList")
            Log.e("KotlinBasics", "${mixObjectList.get(1)}")

            //List có thể edit là mutableList
            val myEditList = mutableListOf("Jack", "James", 10, true)
            Log.e("KotlinBasics", "${myEditList}")
            myEditList.removeAt(0)
            myEditList.add("Haha") //Bây giờ sao lại add được ??
            myEditList.set(0, "Hihi")
            Log.e("KotlinBasics", "${myEditList}")

            //khai báo val thì không thể set nó với 1 list mới, khai báo = var mới được
            //With an array defined with val, you can't change which array the variable refers to, but you can still change the contents of the array.
            //myEditList = mutableListOf("Hihi","Haha") //-> phần mềm code sẽ báo lỗi
        }
    }
}