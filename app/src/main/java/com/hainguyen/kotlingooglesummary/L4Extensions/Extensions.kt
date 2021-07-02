package com.hainguyen.kotlingooglesummary.L4Extensions

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

class Extensions {
    companion object {
        fun runApp() {
            //---Pairs and Tripples --------------------------------------------------------------->
            //pairs_And_Tripples()

            //---Collections ---------------------------------------------------------------------->
            collections()

            //---Collections ---------------------------------------------------------------------->
            extentionsExample()
        }

        //---Pairs and Tripples -------------------------------------------------------------------->
        fun pairs_And_Tripples() {
            val twoList = "shark" to "clownfish"
            Log.e("haha", "${twoList.first} and ${twoList.second}") //shark and clownfish
            //destructure pairs
            val (fish1, fish2) = twoList
            Log.e("haha", "$fish1 and $fish2") //shark and clownfish

            val numbers = Triple(6, 9, 42)
            Log.e("haha", "${numbers.toList()}") //[6, 9, 42]
            Log.e("haha", "${numbers.toString()}") //(6, 9, 42)
            //destructure tripple
            val (num1, num2, num3) = numbers
            Log.e("haha", "$num1 and $num2 and $num3") //6 and 9 and 42

            val names = ("Jack" to "Sam") to "James"
            Log.e(
                "haha",
                "${names.first.first} and ${names.first.second} and ${names.second}"
            ) //Jack and Sam and James
            val (name1, name2) = names
            Log.e("haha", "$name1 and $name2") //(Jack, Sam) and James
        }

        //---Collections -------------------------------------------------------------------------->
        fun collections() {
            val numbers_01 = listOf(1, 2, 3, 4, 5)
            Log.e("haha", "${numbers_01.contains(7)}") //false
            Log.e("haha", "${numbers_01.contains(5)}") //true
            Log.e("haha", "${numbers_01.reversed()}") //[5, 4, 3, 2, 1]
            Log.e("haha", "${numbers_01.subList(0, 2)}") //[1, 2]
            Log.e("haha", "${numbers_01.sum()}") //15

            val names_01 = listOf("Jack", "James", "Sam", "Joe")
            Log.e("haha", "${names_01.sumBy { if (it.startsWith('J')) 1 else 0 }}") //3


            //--------------------------------------------------------------------------->
            val laptop = hashMapOf(
                "ASUS" to listOf("Vivo Book", "Gaming ROG", "Gaming TUF"),
                "APPLE" to listOf("Macbook Air 2015", "Macbook Pro 2015", "Macbook Pro 2020")
            )
            Log.e("haha", "${laptop.get("ASUS")}")//[Vivo Book, Gaming ROG, Gaming TUF]
            Log.e("haha", "${laptop.get("HP")}")//null
            Log.e("haha", "${laptop.getOrDefault("HP", listOf())}")//[]

            //getOrElse: Nếu get key = null thì gọi function
            laptop.getOrElse("HP") {
                Log.e(
                    "haha",
                    "getOrElse: Nếu get key = null thì gọi function"
                )
            }//getOrElse: Nếu get key = null thì gọi function

            Log.e(
                "haha",
                "${laptop}"
            )//{APPLE=[Macbook Air 2015, Macbook Pro 2015, Macbook Pro 2020], ASUS=[Vivo Book, Gaming ROG, Gaming TUF]}

            //getOrPut : Nếu get key = null thì add key đó vào
            laptop.getOrPut("ASUS", { listOf("HP Elitebook") })
            Log.e(
                "haha",
                "${laptop}"
            )//{APPLE=[Macbook Air 2015, Macbook Pro 2015, Macbook Pro 2020], ASUS=[Vivo Book, Gaming ROG, Gaming TUF]}
            laptop.getOrPut("HP", { listOf("HP Elitebook") })
            Log.e(
                "haha",
                "${laptop}"
            )//{APPLE=[Macbook Air 2015, Macbook Pro 2015, Macbook Pro 2020], HP=[HP Elitebook], ASUS=[Vivo Book, Gaming ROG, Gaming TUF]}


            //--------------------------------------------------------------------------->
            val asus = setOf("Vivo Book", "Gaming ROG", "Gaming TUF")
            val apple = setOf("Macbook Air 2015", "Macbook Pro 2015", "Macbook Pro 2020")
            val laptop2 = mapOf("ASUS" to asus, "APPLE" to apple)
            Log.e("haha", "${laptop2.any()}") //true - ngược với isEmpty()

            //Tìm có Vivo Book trong map này ko
            Log.e("haha", "${laptop2.any { it.value.contains("Boo") }}")//false
            Log.e("haha", "${laptop2.any { it.value.any { p -> p.contains("Boo") } }}")//true

            //laptop2.put --> không chạy được, phần mềm code báo lỗi vì mapOf là read-only


            //--------------------------------------------------------------------------->
            val chickens = mutableMapOf(
                "Gà Tiền Giang" to listOf("Gà trống TG", "Gà mái TG"),
                "Gà Quãng Ngãi" to listOf("Gà trống QN", "Gà mái QN")
            )

            //{Gà Tiền Giang=[Gà trống TG, Gà mái TG], Gà Quãng Ngãi=[Gà trống QN, Gà mái QN]}
            Log.e("haha", "${chickens}")

            //put sẽ gán lại giá trị cho key nếu đã có hoặc thêm mới nếu chưa có
            chickens.put("Gà Tiền Giang", listOf("gà haha TG"))
            chickens.put("Gà Cần Thơ", listOf("gà haha CT"))
            //{Gà Tiền Giang=[gà haha TG], Gà Quãng Ngãi=[Gà trống QN, Gà mái QN], Gà Cần Thơ=[gà haha CT]}
            Log.e("haha", "${chickens}")

            //getOrPut sẽ ko gán lại giá trị cho key nếu đã tồn tại hoặc thêm mới nếu chưa có
            chickens.getOrPut("Gà Quãng Ngãi") { listOf("gà haha TG") }
            chickens.getOrPut("Gà Vũng Tàu") { listOf("gà haha VT") }
            //{Gà Tiền Giang=[gà haha TG], Gà Quãng Ngãi=[Gà trống QN, Gà mái QN], Gà Cần Thơ=[gà haha CT], Gà Vũng Tàu=[gà haha VT]}
            Log.e("haha", "${chickens}")
        }

        //---Extensions ---------------------------------------------------------------------------->
        open class Dog(val type: String, open var color: String) {
            fun eat() = "Eat food"
        }

        class ChoCo(override var color: String) : Dog("Chó Cỏ", color)

        class ExtentionsDog(val dog: Dog? = null, val choCo: ChoCo? = null) {
            //Extensions function
            fun Dog.inRa() = "Dog"
            fun Dog.inRa2() = "Dog2"
            fun ChoCo.inRa() = "Chó Cỏ"

            //Extensions properties
            val Dog.isChoCo: Boolean
                get() = type.equals("Chó Cỏ")

            //Extensions function hoặc properties chỉ gọi được trong file chứa hàm đó,
            //muốn gọi được trong class khác thì phải làm như này
            fun printDog() {
                Log.e("haha", dog?.inRa() ?: "Bị Null")
                Log.e("haha", dog?.inRa2() ?: "Bị Null")
                dog.pull()
                Log.e("haha", choCo?.inRa() ?: "Bị Null")
            }

            fun isChoCo(): String = if (dog?.isChoCo ?: false) "Là Chó Cỏ" else "Không phải chó cỏ"

            fun Dog?.pull() {
                this?.apply { "print hahaha" }
            }
        }

        fun extentionsExample() {
            val dog = Dog("Chó Nhật", "Vàng")
            val choCo = ChoCo("Đen")
            val functionDog = ExtentionsDog(choCo = choCo)
            functionDog.printDog()
            //Bị Null
            //Bị Null
            //Chó Cỏ

            val dog2 = Dog("Chó Cỏ", "Đen")
            val functionDog2 = ExtentionsDog(dog = dog2)
            Log.e("haha", functionDog2.isChoCo())//Là Chó Cỏ

            val dog3 = Dog("Chó Cỏ2","Đen")
            val functionDog3 = ExtentionsDog(dog = dog3)
            Log.e("haha", functionDog3.isChoCo())//Không phải chó cỏ
        }
    }
}