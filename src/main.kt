fun main() {
    val arr1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16) // => 11
    val arr2 = listOf(1, 2, 4, 5, 6) // => 3
    val arr3 = emptyList<Int>() // => 1
    val arr4 = listOf(2, 3, 4, 5, 6) // => 1
    val arr5 = listOf(1, 2, 3, 4, 5, 6) // => 7
    val arr6 = listOf(1, 2, 3, 4, 6, 7) // => 5
    val arr7 = listOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20,
        21,
        22,
        23,
        24,
        25,
        26,
        27,
        28,
        29,
        30,
        31,
        32,
        33,
        34,
        35,
        36,
        37,
        38,
        39,
        40,
        41,
        42,
        43,
        44,
        45,
        46,
        47,
        48
    ) // => 11
    val arr8 = myArr(100_000, 9858)

    val arrays = listOf(arr8)
    testArrays(arrays)
}

fun myArr(size: Int, skip: Int): List<Int> {
    val arr = arrayListOf<Int>()
    for (i in 1..size) {
        if (i != skip) arr.add(i)
    }
    return arr.toList()
}

fun testArrays(arrays: List<List<Int>>) {
    for (i in arrays.indices) {
        val arr = arrays[i]
        if (arr.isNullOrEmpty()) println("Массив ${i + 1} - пустой. Значит нет цифры ${arr.lastIndex + 2}")
        else if (arr.lastIndex == arr[arr.lastIndex] - 1) println("Массив ${i + 1} - нет цифры ${arr.lastIndex + 2}")
        else if (arr.lastIndex == arr[arr.lastIndex] - 2 && arr.first() != 1) println("Массив ${i + 1} - нет цифры 1 , но это нарушение уловий задания")
        else println("Массив ${i + 1} - нет цифры ${myBinarySearch(arr)}")
    }
}

fun myBinarySearch(arr: List<Int>): Int {
    var minIndex = 0
    var maxIndex = arr.lastIndex
    var middleIndex = 0
    var searchingNumber = 0
    var i = 0
    var find = false

    while (!find) {
        i++
        middleIndex = (maxIndex + minIndex) / 2
        if (minIndex == maxIndex - 1 || minIndex == maxIndex) {
            searchingNumber = minIndex + 2
            println("Нашли за $i итераций ")
            find = true
        } else if (middleIndex == arr[middleIndex] - 2) {
            maxIndex = middleIndex
        } else if (middleIndex == arr[middleIndex] - 1) {
            minIndex = middleIndex
        }
    }
    return searchingNumber
}



