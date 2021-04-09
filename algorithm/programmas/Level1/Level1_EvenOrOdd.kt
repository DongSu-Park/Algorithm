/**
 * 짝수와 홀수
 * 짝수이면 Even 반환 홀수이면 Odd 반환
 * */

class Level1_EvenOrOdd {
    fun solution(num: Int): String{
        return if (num % 2 == 0) "Even" else "Odd"
    }
}

fun main() {
    val solution = Level1_EvenOrOdd()
    println(solution.solution(3))
    println(solution.solution(4))
}

