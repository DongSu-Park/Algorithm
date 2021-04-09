/**
 * 평균 구하기
 * */

class Level1_Average {
    fun solution(arr: IntArray): Double{
        // 내 답안
        /*
        var answer = 0.00
        for (i in 0 until arr.size){
            answer += arr[i]
        }
        answer /= arr.size

        return answer
        */

        // 모범 답안 (그냥 average 함수를 사용하면 평균 구해짐)
        return arr.average()
    }
}

fun main() {
    val solution = Level1_Average()
    println(solution.solution(intArrayOf(1,2,3,4)))
    println(solution.solution(intArrayOf(5,5)))
}
