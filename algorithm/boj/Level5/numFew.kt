/**
 * a = 150
 * b = 266
 * c = 427
 * a * b * c = 150 * 266 * 427 = 17037300
 * -> 0은 3번 1이 1번 3이 2번 7이 2번
 * -> 출력 결과 3 1 0 2 0 0 0 2 0 0
 * -> a,b,c는 모두 100보다 같거나 크고, 1000보다 작은 자연수이다.
 * */

fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    var num : Int? = null

    if ((a in 100..1000) and (b in 100..1000) and (c in 100..1000)){
        num = a * b * c
    }

    val numArray = intArrayOf(0,0,0,0,0,0,0,0,0,0)

    if (num != null){
        for (i in 0 until num.toString().length){
            when (num.toString()[i]){
                '0' -> numArray[0]++
                '1' -> numArray[1]++
                '2' -> numArray[2]++
                '3' -> numArray[3]++
                '4' -> numArray[4]++
                '5' -> numArray[5]++
                '6' -> numArray[6]++
                '7' -> numArray[7]++
                '8' -> numArray[8]++
                '9' -> numArray[9]++
            }
        }

        for (k in 0 until numArray.size){
            println(numArray[k])
        }
    }
}