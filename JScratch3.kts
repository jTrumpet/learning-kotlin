// 05-Apr-23
// Udemy course: Android 12 Jetpack Compose Developer

main()

fun main() {
/*    var s20ultra = MobilePhone("Android", "Samsung", "S20 Ultra")
    var iPhone14Pro = MobilePhone("iOS", "Apple", "iPhone 14 Pro")
    var pixel = MobilePhone()*/
    // Creating instances of classes
    /*var john = Person("John", "Robertson",25)
    john.hobby = "play video games"
    john.stateHobby()
    var jordan = Person("Jordan", "Glover")
    jordan.hobby = "write poetry"
    jordan.stateHobby()*/
    
//    var myCar = Car()
//    println("brand is : ${myCar.brand}")
//    println("Max car speed: ${myCar.maxSpeed}")
//    myCar.maxSpeed = 300
//    println("Max car speed now: ${myCar.maxSpeed}")
//    myCar.maxSpeed = -200    //Produces an error since the setter only permits values greater than zero
//    println("Max car speed now: ${myCar.maxSpeed}")
    
    
/*    val user1 = User(1, "James")
//    val name = user1.name
//    println(name)
    user1.name = "Michael"
    val user2 = User(1, "Michael")
    println(user1 ==user2)
    
    println("User Details: $user1")
    
    val updatedUser =  user1.copy(name="James Baxter")
    println(user1)
    println(updatedUser)
    
    
    println(updatedUser.component1()) // print 1
    println(updatedUser.component2()) // print James Baxter
    
    // same as val id = updatedUser.id val name = updatedUser.name 
    val (id,name) = updatedUser
    println("id=$id, name=$name")*/
    
    var pixel = MobilePhone()
    pixel.chargeBattery(20)
    
    
}

// Data classes are simple but useful classes that we can quickly make and easily modify. Avoids a lot of the overhead
data class User(val id: Long, var name: String)


/*
 The Car class demonstrates the use of the following:
 * lateinit: allows you to declare a member vriable without initializing it, null or otherwise. Be sure to initialize it before using it though
 * getters and setters: pretty standard stuff, just strange syntax for me. They can have acccess modifiers as well.
*/
class Car {
    lateinit var owner : String
    
    val brand: String = "BMW"
        get() {
            return field.toLowerCase()
        }
    
    var maxSpeed: Int = 250
//      get() = field
        set(value) {
            field = if(value > 0) value else throw IllegalArgumentException("Max speed cannot be less than zero")
        }
    
    var model: String = "M5"
        private set
    
    init {
        this.owner = "Jordan"
        this.model = "M3"
    }
}


// This Person class demonstrates some of the basic functionalities of a class
// * constructor in method signature
// * member variables
// * secondary constructors
// * member functions
class Person(firstName: String = "John", lastName: String = "Doe") {
    // Member Variables - Properties
    var age: Int? = null
    var firstName: String? = null
    var lastName: String? = null
    var fullName: String? = null
    var hobby: String = "watch Netflix"
    
    // Initializer Block
    init {
        this.firstName = firstName
        this.lastName = lastName
        this.fullName = "$firstName $lastName"
        println("My name is $firstName $lastName")
//        stateHobby()
    }
    
    // Member secondary constructor
    // the this(firstName,lastName) tells this constructor the first two properties are the same as the primary constractor
    constructor(firstName: String, lastName: String, age: Int) : this(firstName,lastName) {
        this.firstName = firstName
        this.lastName = lastName
        this.fullName = "$firstName $lastName"
        this.age = age
        println("My name is $fullName and I am $age years old.")
    }
    
    // Member functions - Members
    fun stateHobby() = println("$firstName's hobby is to $hobby.")
}

// Shadowing is a concept in kotlin that allows for a parameter for a function or class to have the
// same name as a variable within the same scope. The variable declared within scope will take precedence

//MobilePhone class that demonstarates the default values in constructor which is found in method signature
class MobilePhone(osName: String = "Android", brand: String = "Google", model: String = "Pixel 7 Pro") {
    // Data Members
    var osName: String? = null
    var brand: String? = null
    var model: String? = null
    var battery: Int = 45
    private set(value) {
        field = if(value >= 0 && value <= 100) value else throw IllegalArgumentException("battery cannot be below 0% or above 100%")
    }
    
    // Initializer Block, first line of code when this object is initialized
    init {
        this.osName = osName
        this.brand = brand
        this.model = model
        println("The phone $model from $brand uses $osName as its Operating System.")
    }
    
    // Member functions
    fun chargeBattery(chargedBy: Int) {
        println("${this.model} battery level before charging: ${this.battery}%"
                + "\nAmount to charge: $chargedBy%")
        this.battery += chargedBy
        println("Phone battery level after charging: ${this.battery}%")
    }
}
