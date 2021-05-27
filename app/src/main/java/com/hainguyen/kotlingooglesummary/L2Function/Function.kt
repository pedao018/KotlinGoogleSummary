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

        //---Filter--------------------------------------------------->
        fun filter() {
            val names = listOf("Jack", "James", "Sam", "Rocky", "Fury")

            //---Filtered--------------------------------------------------->
            //it refers to each item as the filter loops through. Phải để = it, ko để = giá trị khác được
            val eager = names.filter { it[0] == 'J' }
            Log.e(
                "Filter",
                "Eager: $eager. Type: ${eager.javaClass}"
            ) //Eager: [Jack, James]. Type: class java.util.ArrayList

            val filtered = names.asSequence().filter { it[0] == 'J' }
            Log.e("Filtered", "$filtered") //kotlin.sequences.FilteringSequence@9274478

            val newList = filtered.toList()
            Log.e(
                "Filter",
                "New list: $newList. Type ${newList.javaClass}"
            ) //New list: [Jack, James]. Type class java.util.ArrayList


            //---Lazymap--------------------------------------------------->
            val lazyMap = names.asSequence().map {
                Log.e("Filter", "access: $it")
                it//Phải thêm it vô ở cuối này, nếu ko khi gọi lazyMap.first hoặc .toList thì nó in ra giá trị lạ
            }
            //Lazy: kotlin.sequences.TransformingSequence@964e751
            Log.e("Filter", "Lazy: $lazyMap")

            //access: Jack
            //Lazy first: Jack
            Log.e("Filter", "Lazy first: ${lazyMap.first()}")

            //access: Jack
            //access: James
            //access: Sam
            //access: Rocky
            //access: Fury
            //Lazy to list: [Jack, James, Sam, Rocky, Fury]
            Log.e("Filter", "Lazy to list: ${lazyMap.toList()}")


            //---Lazy filter map--------------------------------------------------->
            val lazyFilterMap = names.asSequence().filter { it[0] == 'J' }.map {
                Log.e("Filter", "access: $it")
                it
            }
            //access: Jack
            //access: James
            //Lazy Filter Map: [Jack, James]
            Log.e("Filter", "Lazy Filter Map: ${lazyFilterMap.toList()}")

            val lazyFilterMap2 = names.asSequence().filter { it[0] == 'J' }.map {
                Log.e("Filter", "access: $it")
            }
            //access: Jack
            //access: James
            //Lazy Filter Map: [21, 22]
            Log.e("Filter", "Lazy Filter Map: ${lazyFilterMap2.toList()}")

            //---Spices Example--------------------------------------------------->
            spicesExample()
        }

        //---Spices Example--------------------------------------------------->
        fun spicesExample() {
            val spices = listOf(
                "curry",
                "pepper",
                "cayenne",
                "ginger",
                "green curry",
                "red curry",
                "red pepper"
            )
            //Tìm item có chứa chữ curry
            Log.e(
                "Filter",
                "${spices.filter { it.contains("curry") }}"
            ) //[curry, green curry, red curry]

            //Tìm item có chứa chữ curry và sắp xếp độ dài tăng dần
            Log.e(
                "Filter",
                "${spices.filter { it.contains("curry") }.sortedBy { it.length }}"
            )//[curry, red curry, green curry]
            val seq =
                spices.asSequence().filter { it.contains("curry") }.sortedByDescending { it.length }
            Log.e("Filter", "${seq.toList()}") //[green curry, red curry, curry]

            //Tìm item có chứa chữ bắt đầu bằng 'c' và kết thúc bằng 'e'
            val seq1 = spices.asSequence().filter { it[0] == 'c' && it[it.lastIndex] == 'e' }
            val seq2 = spices.asSequence().filter { it.startsWith('c') && it.endsWith('e') }
            val seq3 = spices.asSequence().filter { it.startsWith('c') }.filter { it.endsWith('e') }
            Log.e(
                "Filter",
                "Tìm item có chứa chữ bắt đầu bằng 'c' và kết thúc bằng 'e' 1: ${seq1.toList()}"
            )//Tìm item có chứa chữ bắt đầu bằng 'c' và kết thúc bằng 'e' 1: [cayenne]
            Log.e(
                "Filter",
                "Tìm item có chứa chữ bắt đầu bằng 'c' và kết thúc bằng 'e' 2: ${seq2.toList()}"
            )//Tìm item có chứa chữ bắt đầu bằng 'c' và kết thúc bằng 'e' 2: [cayenne]
            Log.e(
                "Filter",
                "Tìm item có chứa chữ bắt đầu bằng 'c' và kết thúc bằng 'e' 3: ${seq3.toList()}"
            )//Tìm item có chứa chữ bắt đầu bằng 'c' và kết thúc bằng 'e' 3: [cayenne]

            //Lấy 3 phần tử đầu tiên và tìm những item có chữ 'c' ở đầu
            val seq4 = spices.take(3).asSequence().filter { it[0] == 'c' }
            Log.e(
                "Filter",
                "Lấy 3 phần tử đầu tiên và tìm những item có chữ 'c' ở đầu: ${seq4.toList()}"
            )//Lấy 3 phần tử đầu tiên và tìm những item có chữ 'c' ở đầu: [curry, cayenne]
        }

        //---Lambdas and higher-order functions--------------------------------------------------->
        fun lambdas() {
            var power = resertPower()
            //Có 2 cách khai báo lambdas (no name function)
            val increasePower: (Int) -> Int = { powerParam -> powerParam + 500 }
            val usePower = { powerParam: Int -> powerParam - 5 }

            Log.e("Lambdas", "$power")//1

            power = attack(power, increasePower)
            Log.e("Lambdas", "$power")//501

            for (i in 1..10) {
                power = attack(power, usePower)
            }
            Log.e("Lambdas", "$power")//451

            for (i in 1..10) {
                //power = attack(power, powerUp()) -> phần mềm code sẽ báo lỗi
                power = attack(power, ::powerUp)
            }
            Log.e("Lambdas", "$power")//551


            //Tạo lambdas khi gọi hàm
            power = attack(power, { powerParam -> powerParam + 300 })
            Log.e("Lambdas", "$power")//851


            //Gọi lambdas lúc bình thường
            increasePower(power)
            Log.e("Lambdas", "$power")//851
            usePower(power)
            Log.e("Lambdas", "$power")//851
            //=> phải để power = increasePower(power) thì nó mới cập nhật power
            power = increasePower(power)
            Log.e("Lambdas", "$power")//1351

        }

        fun resertPower() = 1
        fun powerUp(power: Int) = power + 10
        fun attack(power: Int, operation: (Int) -> Int): Int = operation(power)
    }
}