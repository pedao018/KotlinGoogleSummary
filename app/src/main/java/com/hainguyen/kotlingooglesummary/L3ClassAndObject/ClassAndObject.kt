package com.hainguyen.kotlingooglesummary.L3ClassAndObject

import android.util.Log

class ClassAndObject {

    companion object {
        fun runApp() {
            //---Primary constructor và init. Secondary constructor ------------------------------->
            val p = Person()
            //Person initializing: 0, , 0
            //Có thể gọi nhiều khối init
            //Code chạy từ trên xuống dưới Word
            //Person(id=0, name='', age = 0)
            Log.e("ClassAndObject", "${p.getInfo()}")

            val p1 = Person1(1, "Jack", 10)
            val p12 = Person1(name = "Jack", age = 10)
            Log.e("ClassAndObject", "${p1.age}") //10


            //---Factory function. Get, Set ------------------------------------------------------->
            //val p2 = Person2(1, "Jack") -> báo lỗi
            val p2 = Person2.calcSalary(50)
            Log.e("ClassAndObject", "${p2}") //Person2(id=1, name='Jack', salary=1500)
            p2.newSalary = 55
            Log.e(
                "ClassAndObject",
                "${p2}"
            ) //Person2(id=1, name='Jack', salary=1500, newSalary = 0, bonus=8000)


            //Subclasses and inheritance ---------------------------------------------------------->
            var car = Car()
            Log.e("ClassAndObject", "${car.getCarInfo()}") //Car(sheet=0, wheel=0)
            car = Motobike()
            Log.e("ClassAndObject", "${car.getCarInfo()}") //Motobike(sheet=1, wheel=2)
            var car2 = Car2()
            Log.e("ClassAndObject", "${car2.getCarInfo()}") //Car(sheet=0, wheel=0, price=0)
            var car21 = Motobike2(1, 2, 5000)
            Log.e(
                "ClassAndObject",
                "${car21.getCarInfo()}"
            ) //Motobike(sheet=1, wheel=2) 	 Car(sheet=1, wheel=2, price=5000)
            Log.e("ClassAndObject", "${car21.hookOneWheel()}") //Jump One Wheel


            //Abstract classes and Interfaces------------------------------------------------------>
            val a1 = American()
            val a2 = Asian()
            Log.e("ClassAndObject", a1.getInfo()) //American: Height = 1.8. HairColor = Black
            Log.e("ClassAndObject", a2.getInfo()) //Asian: Height = 1.7. HairColor = Black
            Log.e("ClassAndObject", a2.getInfo2()) //Info 2 Asian: Height = 1.7. HairColor = Black
            a1.play() //American play soccer
            a1.eat() //American eat Hambuger
            a2.play() //Asian play games
            //Eat function
            //Asian eat Hu tieu my
            a2.eat()


            //---Interface delegation -------------------------------------------------------------->
            var shark = Shark()
            Log.e("ClassAndObject", "Shark: " + shark.color + "\n") //Shark: Grey
            shark.eat() //Eat Meat
            shark = Shark(FishColor_Red)
            Log.e("ClassAndObject", "Shark: " + shark.color + "\n") //Shark: Red
            val clownFish = ClownFish()
            Log.e("ClassAndObject", "Clown: " + clownFish.fishColor.color + "") //Clown: Red
        }
    }


    //---Primary constructor và init. Secondary constructor -------------------------------------->
    class Person(
        val id: Int = 0,//Có thể đặt param này required: val id: Int, val name...
        var name: String = "",
        var age: Short = 0
    ) {
        init {
            Log.e("ClassAndObject", "Person initializing: $id, $name, $age")
        }

        init {
            Log.e("ClassAndObject", "Có thể gọi nhiều khối init")
            //Log.e("ClassAndObject", "$word") //phần mềm báo lỗi vì code chạy từ trên xuống dưới
        }

        val word = "Word"
        val score = 0

        init {
            Log.e("ClassAndObject", "Code chạy từ trên xuống dưới $word")
        }

        //Đây là secondary constructor, được gọi sau khi gọi primary constructor ở trên
        constructor(salary: Int) : this() {
            Log.e("ClassAndObject", "Salary: $salary")
        }

        fun getInfo(): String = "Person(id=$id, name='$name', age = $age)"
    }

    //Nếu không khai báo val, var cho thuộc tính thì Kotlin tự hiểu nó là 1 biến,
    //không phải là thuộc tính của class đó
    class Person1(id: Int = 0, name: String, var age: Int)


    //---Factory function. Get, Set ---------------------------------------------------------------->
    //Constructor có thể đặt visible cho nó
    class Person2 private constructor(val id: Int, val name: String, val salary: Int) {

        private var bonus = 0
        var newSalary: Int
            get() = when (salary) {
                in 1..20 -> 1000
                in 21..50 -> 3000
                in 51..100 -> 7000
                else -> 0
            }
            set(value) {
                bonus = when (value) {
                    in 1..20 -> 2000
                    in 21..50 -> 5000
                    in 51..100 -> 8000
                    else -> 0
                }
            }

        //Factory function
        companion object {
            fun calcSalary(level: Int) = when (level) {
                in 1..20 -> Person2(1, "Jack", 1000)
                else -> Person2(1, "Jack", 1000 + (level * 10))
            }
        }

        override fun toString(): String {
            return "Person2(id=$id, name='$name', salary=$salary, newSalary = $newSalary, bonus=$bonus)"
        }
    }


    //Subclasses and inheritance ------------------------------------------------------------------>
    open class Car(var sheet: Int = 0, var wheel: Int = 0) {
        open fun getCarInfo(): String = "Car(sheet=$sheet, wheel=$wheel)"
    }

    class Motobike() : Car(1, 2) {
        override fun getCarInfo(): String = "Motobike(sheet=$sheet, wheel=$wheel)"
    }

    open class Car2(open var sheet: Int = 0, open var wheel: Int = 0, var price: Int = 0) {
        open fun getCarInfo(): String = "Car(sheet=$sheet, wheel=$wheel, price=$price)"
    }

    class Motobike2(override var sheet: Int, override var wheel: Int, money: Int) :
        Car2(sheet = sheet, wheel = money, price = money) {
        fun hookOneWheel(): String = "Jump One Wheel"

        override fun getCarInfo(): String =
            "Motobike(sheet=$sheet, wheel=$wheel) \t ${super.getCarInfo()}"
    }


    //Abstract classes and Interfaces-------------------------------------------------------------->
    abstract class Human() {
        abstract val height: Float
        val hairColor: String = "Black"
        abstract fun getInfo(): String
        fun getInfo2(): String =
            "Info 2 ${this.javaClass.simpleName}: Height = $height. HairColor = $hairColor"
    }

    interface Behavior {
        fun eat() {
            Log.e("ClassAndObject", "Eat function")
        }

        fun play()
    }

    class American : Human(), Behavior {
        override val height: Float
            get() = 1.8F

        override fun getInfo(): String =
            "${this.javaClass.simpleName}: Height = $height. HairColor = $hairColor"

        override fun eat() {
            Log.e("ClassAndObject", "American eat Hambuger")
        }

        override fun play() {
            Log.e("ClassAndObject", "American play soccer")
        }
    }

    class Asian : Human(), Behavior {
        override val height: Float
            get() = 1.7F

        override fun getInfo(): String =
            "${this.javaClass.simpleName}: Height = $height. HairColor = $hairColor"

        override fun eat() {
            super.eat()
            Log.e("ClassAndObject", "Asian eat Hu tieu my")
        }

        override fun play() {
            Log.e("ClassAndObject", "Asian play games")
        }
    }

    //Khai báo 1 biến interface
    private val behaviorEvent = object : Behavior {
        override fun play() {
            TODO("Not yet implemented")
        }

        override fun eat() {
            super.eat()
        }
    }


    //---Interface delegation ---------------------------------------------------------------------->
    interface FishColor {
        val color: String
    }

    interface FishAction {
        fun eat()
    }

    object FishColor_Grey : FishColor {
        override val color: String
            get() = "Grey"
    }

    object FishColor_Red : FishColor {
        override val color: String
            get() = "Red"
    }

    class PrintFishAction_Eat(val food: String) : FishAction {
        override fun eat() {
            Log.e("ClassAndObject", "$food")
        }
    }

    //Đặt default color cho Shark là Grey, nhưng có thể đặt lại một màu khác.
    //Khai báo như này nó tự động có Shark.color là thuộc tính của nó, còn ClownFish sẽ ko được như vậy
    class Shark(fishColor: FishColor = FishColor_Grey) : FishColor by fishColor,
        FishAction by PrintFishAction_Eat("Eat Meat")

    class ClownFish(val fishColor: FishColor = FishColor_Red)
}