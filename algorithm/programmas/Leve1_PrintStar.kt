/**
 * 직사각형 별찍기
 * */

class Leve1_PrintStar {
}

fun main() {
    val (a,b) = readLine()!!.split(' ').map(String::toInt)
    for (i in 1..b){
        for (j in 1..a){
            print("*")
        }
        println()
    }
}