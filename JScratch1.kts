// 03-Apr-2023
// Understanding nullable in kotlin

main()

fun main() {
    // name = null -> Compilation ERROR
    var nullableName :String? = "Denis"
//    nullableName = null
    
//    var len2 = nullableName?.length
    // ?.let will only run what is in brackets if the variable is not null. short form of if(!null)-else
//    nullableName?.let { println(it.length) }
    
    // ?: Elvis operator. Kind of like a ternary, but for nullable values. returns value if it isnot null, otherwise returns the other thing.
    val name = nullableName ?: "Guest"
    println("name is $name")
    
    // !! Not-null assertion operator. Asserts that a value is not null and will throw a NullPointerException if it is null
    println(nullableName!!.toLowerCase())
    
    // Nullable chain. You can chain nullable operators together like checking if an object has a member present or not and
    // checks if that member has a certain data member of not
//    val wifesAge: String? = user?.wife?.age ?: 0
    
    // old-fashioned and not necessary in kotlin
//    if(nullableName != null){
//        var len2 = nullableName.length
//    }else{
//        null
//    }
    
    
}