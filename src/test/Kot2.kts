package test

open class Person(name: String) {
    var name: String = ""
        get() = field
        set(name: String) { field = name }

    init {
        this.name = name;
    }

    override fun toString(): String {
        return name
    }
}

class Student : Person {
    var university: String = ""
        get() = field

    constructor(name: String) : super(name)
    constructor(name: String, university: String) : super(name) {
        this.university = university
    }

    override fun toString(): String {
        return String.format("Student: %s", this.name)
    }
}

fun myf(pers: Person) {
    println(pers)
}

val person = Person("Name")
val student = Student("Matt")
val person1: Person = Student("MYName")

myf(person)
myf(student)
myf(person1)