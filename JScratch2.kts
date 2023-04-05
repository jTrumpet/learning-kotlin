// 05-Apr-23
// quicksort algorithm provided by kotlin

main()

fun main() {
    val arr = intArrayOf(3, 5, 1, 4, 2)
    quicksort(arr, 0, arr.size - 1)
    println(arr.joinToString())
}

fun quicksort(arr: IntArray, low: Int, high: Int) {
    println(arr.joinToString())
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        println("pivotIndex: $pivotIndex")
        quicksort(arr, low, pivotIndex - 1)
        quicksort(arr, pivotIndex + 1, high)
    }
}

// returns appropriate pivot index given high and low index of a subset of an array
fun partition(arr: IntArray, low: Int, high: Int): Int {
    // the value too pivot on is chosen
    val pivot = arr[high]
    // i is the pivot index being returned, sort of. It's initially set to just outside of range of low and high
    var i = low - 1
    // sort from low to high
    for (j in low until high) {
        // move lesser value to the furthest left, front of array
        if (arr[j] < pivot) {
            i++
            swap(arr, i, j)
        }
    }
    // all other values not already swapped are guranteed to be greater than current pivot value
    // move it to the left of these values
    swap(arr, i + 1, high)
    return i + 1
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
