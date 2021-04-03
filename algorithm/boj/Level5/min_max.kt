fun main() {
    val inputNum = readLine()!!.toInt()
    val inputString = readLine()!!.toString()
    val token = inputString.split(' ')

    val inputArray  = arrayListOf<Int>()
    for (i in 0 until inputNum){
        inputArray.add(token[i].toInt())
    }

    inputArray.sort()

    print("${inputArray.first()} ${inputArray.last()}")
}