/**
 * 약수의 합
 * */

class Level1_divisor {
    fun solution (n: Int): Int{
        var answer = 0

        for (i in 1..n){
            if (n % i == 0){
                answer += i
            }
        }

        return answer
    }
}

fun main() {
    val solution = Level1_divisor()

    val input1 = 12
    val output1 = solution.solution(input1)
    println(output1)

    val input2 = 5
    val output2 = solution.solution(input2)
    println(output2)
}