package test

interface Animal {
    var age: Int

    fun say()
    fun addAge() {
        ++age
    }
}

class Dog : Animal {
    override var age = 0

    override fun say() {
        println("Gav-gav")
    }
}

class Cat : Animal {
    override var age = 9
    override fun say() {
        println("Meow")
    }
}

//===================================FIGURES=======================

interface Figure {
    fun perimeter(): Int
}

interface Color {
    fun getName(): String
}

open class Square(a: Int, color: Color) : Figure {
    var a = a
        get() = field
        set(a: Int) {
            if (a > 0)
                field = a
        }

    var color = color
        get() = field
        set(color: Color) {
            field = color
        }

    override fun perimeter(): Int {
        return a * 4
    }
}

class Red : Color {
    private var name = "red"
    override fun getName(): String {
        return this.name
    }
}

var red: Red = Red()
var s = Square(2, Red())
s.color = red