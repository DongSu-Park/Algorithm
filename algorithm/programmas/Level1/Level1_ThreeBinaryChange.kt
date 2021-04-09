/**
 * 자연수 n이 매개변수로 주어집니다.
 * n을 3진법 상에서 앞뒤로 뒤집은 후,
 * 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * ex. 45 -> 7
 *     125 -> 229
 * */

class Level1_ThreeBinaryChange {
    fun solution(n: Int): Int{
        var input = n
        val threeArray = arrayListOf<Int>()

        while (input != 0){
            threeArray.add(input % 3)
            input /= 3
        }

        var answer: Int = 0
        for (i in 0 until threeArray.size){
            answer += threeArray[i] * Math.pow(3.0, (threeArray.size-1-i).toDouble()).toInt() // Math.pow()를 사용하여 거듭제곱
        }

        return answer
    }
}

fun main() {
    val solution = Level1_ThreeBinaryChange()
    val exOne = 45
    val exTwo = 125

    println(solution.solution(exOne))
    println(solution.solution(exTwo))
}