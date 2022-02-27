fun main() {
    val arr8 = myArr(100_000, 9858)
    val arrays = listOf(arr8)
    testArrays(arrays)


    val queue = Queue(3)
    queue.insert(10)
    queue.insert(20)
    println(queue.isFull())
    queue.remove()
    queue.insert(30)
    queue.insert(40)
    println(queue.isFull())
    while (!queue.isEmpty()) {
        println(queue.remove())
    }
    println(queue.isEmpty())
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
    var middleIndex: Int
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

class Stack(val size: Int) {
    private val stackArray = LongArray(size)
    private var top = -1

    fun push(number: Long) {
        stackArray[++top] = number
    }

    fun pop(): Long {
        return stackArray[top--]
    }

    fun peek(): Long {
        return stackArray[top]
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun isFull(): Boolean {
        return top == size - 1
    }
}

class Queue(private val size: Int) {
    private val queueArray = LongArray(size)
    private var front = 0
    private var rear = -1
    private var items = 0

    fun insert(number: Long) {
        if (rear == size - 1) {
            rear = -1
        }
        queueArray[++rear] = number
        items++
    }

    fun remove(): Long {
        val temp = queueArray[front++]
        if (front == size) {
            front = 0
        }
        items--
        return temp
    }

    fun peekFront(): Long {
        return queueArray[front]
    }

    fun isEmpty(): Boolean {
        return items == 0
    }

    fun isFull(): Boolean {
        return items == size
    }

    fun size(): Int {
        return size
    }
}



