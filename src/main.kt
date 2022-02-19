import kotlin.random.Random

fun main() {
    val laptops = createLaptops(10_000)
    val sortedLaptopList = laptops.sortedWith(compareBy({ it.price }, { it.memory }, {it.manufacturer}))
}

fun createLaptops(quantity: Int): ArrayList<Laptop> {
    val manufacturers = listOf("Lenovo", "Acer", "Apple", "Dell", "HP", "MSI", "Asus")

    val prices = arrayListOf<Int>()
    for (i in 500..2000 step 50) {
        prices.add(i)
    }

    val memoryList = arrayListOf<Int>()
    for (i in 4..24 step 4) {
        memoryList.add(i)
    }

    val laptops = arrayListOf<Laptop>()
    for (i in 1..quantity) {
        laptops.add(
            Laptop(
                prices[Random.nextInt(prices.size)],
                memoryList[Random.nextInt(memoryList.size)],
                manufacturers[Random.nextInt(manufacturers.size)]
            )
        )
    }
    return laptops
}

fun selectionSortV3(arr: ArrayList<Int>): ArrayList<Int> {
    fun swap(a: Int, b: Int) {
        val tmp = arr[a]
        arr[a] = arr[b]
        arr[b] = tmp
    }

    var minIndex = 0
    var maxIndex = 0
    var lastIndex = arr.size - 1

    for (firstIndex in 0 until arr.size/2+1) {
        var min = Int.MAX_VALUE
        var max = 0
        for (j in firstIndex..lastIndex) {
            if (min > arr[j]) {
                min = arr[j]
                minIndex = j
            }
            if (max < arr[j]) {
                max = arr[j]
                maxIndex = j
            }
        }
        println("Итерация: ${firstIndex + 1} Массив: $arr")
        if (maxIndex == firstIndex && minIndex != lastIndex) {
            swap(maxIndex, lastIndex)
            swap(minIndex, firstIndex)
        } else if (minIndex == lastIndex && maxIndex != firstIndex){
            swap(minIndex, firstIndex)
            swap(maxIndex, lastIndex)
        } else if (minIndex == lastIndex && maxIndex == firstIndex){
            swap(firstIndex, lastIndex)
        } else {
            swap(maxIndex, lastIndex)
            swap(minIndex, firstIndex)
        }
        lastIndex--
    }
    return arr
}

data class Laptop(
    val price: Int,
    val memory: Int,
    val manufacturer: String
)