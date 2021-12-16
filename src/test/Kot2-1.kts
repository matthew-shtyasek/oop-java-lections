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

open class A {
    private var x = 1
    protected var y = 2
    internal var z = 3
    public var i = 4
}

class B : A() {
    fun bbb() {
        print(this.y)
        print(this.z)
        print(this.i)
    }
}

var a = A()
print(a.z)
print(a.i)


fun myf(animal: Animal) {
    animal.addAge()
    println(animal.age)
    animal.addAge()
    println(animal.age)
    animal.say()
}

var cat = Cat()
var dog = Dog()

myf(cat)
myf(dog)