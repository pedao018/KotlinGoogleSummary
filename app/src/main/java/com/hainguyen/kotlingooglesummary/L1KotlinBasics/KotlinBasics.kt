package com.hainguyen.kotlingooglesummary.L1KotlinBasics

import android.util.Log
import java.util.*

class KotlinBasics {
    companion object {
        //---Khai báo biến(Declare variables)--------------------------------------------------->
        fun declareVariable() {
            Log.e("KotlinBasics", "Khai báo biến")
            var a = 0 //Khai báo = var có thể set lại biến mới
            val b = 0 //Khai báo = val thì chỉ set biến mới 1 lần
            a = a + 1
            Log.e("KotlinBasics", "$a")
            //b = b + 1 //Báo lỗi
        }

        //---Plus, minus, times, division--------------------------------------------------->
        fun plusMinusTimesDivision() {
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

        //---Cast Type này sang type khác--------------------------------------------------->
        fun castType() {
            val type1: Int = 5
            type1.toString()
            type1.toByte()
        }

        //---Có thể dùng _ khi con số quá dài--------------------------------------------------->
        fun khaiBaoSoDai() {
            Log.e("KotlinBasics", "Có thể dùng _ khi con số quá dài")
            val longNumber = 1_000_000_000
            Log.e("KotlinBasics", "$longNumber")
        }

        //---Range, When (Switch Case)--------------------------------------------------->
        fun range_when() {
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
        }

        //---Nullability--------------------------------------------------->
        fun nullability() {
            val numberInt: Int? = null //Dùng ? phần mềm mới cho qua
            var p1: Person? = null
            // ?: operator (Elvis Operator)
            Log.e("KotlinBasics", "${p1?.toString() ?: "Person is Null"}") //Person is Null
            Log.e("KotlinBasics", "${p1?.name?.toString() ?: "Name is Null"}") //Name is Null
            // !! operator ("double-bang" or "bang bang" operator)
            //p1!!.name.toString() // -> Đảm bảo rằng p1 là non-null, nếu p1 bị null thì throw null exeption
        }

        //---List--------------------------------------------------->
        fun listInKotlin() {
            //List in Kotlin can't be change after declaring
            val persons = listOf("Jack", "James", "Sam")
            Log.e("KotlinBasics", "$persons") //[Jack, James, Sam]
            Log.e("KotlinBasics", "${persons[0]}") //Jack
            //Có thể declare nhiều data type khác nhau trong list
            val mixObjectList = listOf("Jack", 1, true)
            Log.e("KotlinBasics", "$mixObjectList") //[Jack, 1, true]
            Log.e("KotlinBasics", "${mixObjectList.get(1)}") //1

            //List có thể edit là mutableList
            val myEditList = mutableListOf("Jack", "James", 10, true)
            Log.e("KotlinBasics", "${myEditList}")//[Jack, James, 10, true]
            myEditList.removeAt(0)
            myEditList.add("Haha") //Bây giờ sao lại add được ??
            myEditList.set(0, "Hihi")
            Log.e("KotlinBasics", "${myEditList}") //[Hihi, 10, true, Haha]

            //khai báo val thì không thể set nó với 1 list mới, khai báo = var mới được
            //With an array defined with val, you can't change which array the variable refers to, but you can still change the contents of the array.
            //myEditList = mutableListOf("Hihi","Haha") //-> phần mềm code sẽ báo lỗi
        }

        //---Arrays In Kotlin--------------------------------------------------->
        fun arraysInKotlin() {
            //Arrays một khi đã tạo thì ko thể thay đổi size của array đó, nhưng có thể thay đổi giá trị của item trong nó.
            //Chỉ có thể tạo 1 array mới bằng cách copy array cũ.
            val persons = arrayOf("Jack", "James", "Sam")
            Log.e("KotlinBasics", Arrays.toString(persons)) //[Jack, Jame, Sam]
            Log.e("KotlinBasics", "$persons") //[Ljava.lang.String;@299ae1e
            persons.set(0, "Hahaha")
            Log.e("KotlinBasics", Arrays.toString(persons)) //[Hahaha, Jame, Sam]

            //Mix Arrays
            val mixArrays = arrayOf("Fish", 2)
            Log.e("KotlinBasics", Arrays.toString(mixArrays)) //[Fish, 2]

            //Primitive type Arrays, có thể tránh overhead of boxing
            val arrayInt = intArrayOf(1, 2, 3)
            val arrayByte = intArrayOf(4, 5, 6)

            //Combine array
            val combineArray = arrayByte + arrayInt
            Log.e("KotlinBasics", Arrays.toString(combineArray)) //[4, 5, 6, 1, 2, 3]

            //Add array to list
            val numbers = intArrayOf(1, 2, 3)
            val person = listOf("Jack", "James")
            val oddList = listOf(numbers, person)
            val oddArray = arrayOf(oddList, numbers)
            Log.e("KotlinBasics", "$oddList") //[[I@7b076ff, [Jack, James]]
            Log.e(
                "KotlinBasics",
                Arrays.toString(oddArray)
            ) //[[[I@7b076ff, [Jack, James]], [I@7b076ff]

            //Other feature of Kotlin Array
            val arrayCode = Array(5) { it + 2 }//5 là số lượng phần tử, it là index
            Log.e("KotlinBasics", Arrays.toString(arrayCode)) //[2, 3, 4, 5, 6]
        }

        fun loop() {
            val persons = arrayOf("Jack", "James", "Sam")

            //Lặp thường
            var result: String = ""
            for (item in persons) {
                result += item + " "
            }
            Log.e("KotlinBasics", result) //Jack James Sam

            //Lặp có index
            result = ""
            for ((viTri, phanTu) in persons.withIndex()) {
                result += "Position: $viTri. Item: $phanTu."
            }
            Log.e(
                "KotlinBasics",
                result
            ) //Position: 0. Item: Jack.Position: 1. Item: James.Position: 2. Item: Sam.


            //Lặp in có downTo, step
            result = ""
            for (i in 1..5)
                result += "$i "
            Log.e("KotlinBasics", result) //1 2 3 4 5
            result = ""
            for (i in 5 downTo 1)
                result += "$i "
            Log.e("KotlinBasics", result)//5 4 3 2 1
            result = ""
            for (i in 1..10 step 3)
                result += "$i "
            Log.e("KotlinBasics", result) //1 4 7 10
            result = ""
            for (i in 'a'..'f')
                result += "$i "
            Log.e("KotlinBasics", result) //a b c d e f


            //while và do while
            var number1 = 0
            while (number1 < 50) {
                number1++
            }
            Log.e("KotlinBasics", "$number1") //50
            do {
                number1--
            } while (number1 > 50) //49
            Log.e("KotlinBasics", "$number1") //49

            //repeat
            result = ""
            repeat(3) { result += "Ahihi " }
            Log.e("KotlinBasics", result) //Ahihi Ahihi Ahihi

            //Practice Example
            val numberArray = Array(5) { it + 11 }
            val mutableString = mutableListOf<String>()
            for (item in numberArray) {
                mutableString.add("$item")
            }
            Log.e("KotlinBasics", "$mutableString") //[11, 12, 13, 14, 15]
        }

        fun kotlinBasics() {
            //---Khai báo biến(Declare variables)--------------------------------------------------->
            declareVariable()

            //---Plus, minus, times, division--------------------------------------------------->
            plusMinusTimesDivision()

            //---Cast Type này sang type khác--------------------------------------------------->
            castType()

            //---Có thể dùng _ khi con số quá dài--------------------------------------------------->
            khaiBaoSoDai()

            //---Range, When (Switch Case)--------------------------------------------------->
            range_when()

            //---Nullability--------------------------------------------------->
            nullability()

            //---List--------------------------------------------------->
            listInKotlin()

            //---Arrays In Kotlin--------------------------------------------------->
            arraysInKotlin()

            //---Loop--------------------------------------------------->
            loop()
        }
    }
}