/**
 * 피보나치 수
 * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567로 나눈 나머지를 리턴하는 함수를 완성하시오
 * */

class Level2_FibonacciNum {
    fun solution(n: Int): Int{
        var answer = 0

        if (n == 2) {
            return 1
        }

        var num1 = 1 // 피보나치수 1에 대한
        var num2 = 1 // 피보나치수 2에 대한
        for (i in 3..n){
            answer = num1 + num2
            answer %= 1234567
            num1 = num2
            num2 = answer
        }

        return answer
    }

}

fun main() {
    val solution = Level2_FibonacciNum()

    println(solution.solution(3)) // 2
    println(solution.solution(5)) // 5
}