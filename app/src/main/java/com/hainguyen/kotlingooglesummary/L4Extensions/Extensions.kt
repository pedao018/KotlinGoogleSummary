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

            //getOrElse: N???u get key = null th?? g???i function
            laptop.getOrElse("HP") {
                Log.e(
                    "haha",
                    "getOrElse: N???u get key = null th?? g???i function"
                )
            }//getOrElse: N???u get key = null th?? g???i function

            Log.e(
                "haha",
                "${laptop}"
            )//{APPLE=[Macbook Air 2015, Macbook Pro 2015, Macbook Pro 2020], ASUS=[Vivo Book, Gaming ROG, Gaming TUF]}

            //getOrPut : N???u get key = null th?? add key ???? v??o
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
            Log.e("haha", "${laptop2.any()}") //true - ng?????c v???i isEmpty()

            //T??m c?? Vivo Book trong map n??y ko
            Log.e("haha", "${laptop2.any { it.value.contains("Boo") }}")//false
            Log.e("haha", "${laptop2.any { it.value.any { p -> p.contains("Boo") } }}")//true

            //laptop2.put --> kh??ng ch???y ???????c, ph???n m???m code b??o l???i v?? mapOf l?? read-only


            //--------------------------------------------------------------------------->
            val chickens = mutableMapOf(
                "G?? Ti???n Giang" to listOf("G?? tr???ng TG", "G?? m??i TG"),
                "G?? Qu??ng Ng??i" to listOf("G?? tr???ng QN", "G?? m??i QN")
            )

            //{G?? Ti???n Giang=[G?? tr???ng TG, G?? m??i TG], G?? Qu??ng Ng??i=[G?? tr???ng QN, G?? m??i QN]}
            Log.e("haha", "${chickens}")

            //put s??? g??n l???i gi?? tr??? cho key n???u ???? c?? ho???c th??m m???i n???u ch??a c??
            chickens.put("G?? Ti???n Giang", listOf("g?? haha TG"))
            chickens.put("G?? C???n Th??", listOf("g?? haha CT"))
            //{G?? Ti???n Giang=[g?? haha TG], G?? Qu??ng Ng??i=[G?? tr???ng QN, G?? m??i QN], G?? C???n Th??=[g?? haha CT]}
            Log.e("haha", "${chickens}")

            //getOrPut s??? ko g??n l???i gi?? tr??? cho key n???u ???? t???n t???i ho???c th??m m???i n???u ch??a c??
            chickens.getOrPut("G?? Qu??ng Ng??i") { listOf("g?? haha TG") }
            chickens.getOrPut("G?? V??ng T??u") { listOf("g?? haha VT") }
            //{G?? Ti???n Giang=[g?? haha TG], G?? Qu??ng Ng??i=[G?? tr???ng QN, G?? m??i QN], G?? C???n Th??=[g?? haha CT], G?? V??ng T??u=[g?? haha VT]}
            Log.e("haha", "${chickens}")
        }

        //---Extensions ---------------------------------------------------------------------------->
        open class Dog(val type: String, open var color: String) {
            fun eat() = "Eat food"
        }

        class ChoCo(override var color: String) : Dog("Ch?? C???", color)

        class ExtentionsDog(val dog: Dog? = null, val choCo: ChoCo? = null) {
            //Extensions function
            fun Dog.inRa() = "Dog"
            fun Dog.inRa2() = "Dog2"
            fun ChoCo.inRa() = "Ch?? C???"

            //Extensions properties
            val Dog.isChoCo: Boolean
                get() = type.equals("Ch?? C???")

            //Extensions function ho???c properties ch??? g???i ???????c trong file ch???a h??m ????,
            //mu???n g???i ???????c trong class kh??c th?? ph???i l??m nh?? n??y
            fun printDog() {
                Log.e("haha", dog?.inRa() ?: "B??? Null")
                Log.e("haha", dog?.inRa2() ?: "B??? Null")
                dog.pull()
                Log.e("haha", choCo?.inRa() ?: "B??? Null")
            }

            fun isChoCo(): String = if (dog?.isChoCo ?: false) "L?? Ch?? C???" else "Kh??ng ph???i ch?? c???"

            fun Dog?.pull() {
                this?.apply { "print hahaha" }
            }
        }

        fun extentionsExample() {
            val dog = Dog("Ch?? Nh???t", "V??ng")
            val choCo = ChoCo("??en")
            val functionDog = ExtentionsDog(choCo = choCo)
            functionDog.printDog()
            //B??? Null
            //B??? Null
            //Ch?? C???

            val dog2 = Dog("Ch?? C???", "??en")
            val functionDog2 = ExtentionsDog(dog = dog2)
            Log.e("haha", functionDog2.isChoCo())//L?? Ch?? C???

            val dog3 = Dog("Ch?? C???2","??en")
            val functionDog3 = ExtentionsDog(dog = dog3)
            Log.e("haha", functionDog3.isChoCo())//Kh??ng ph???i ch?? c???
        }
    }
}