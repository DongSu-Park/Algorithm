/**
 * 행렬의 곱셈 (연습문제)
 *
 * 문제 설명
 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 * */

class Level2_ArrayMultiplex {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        for (i in 0 until arr1.size){
            val multiplexArray = Array<Int>(arr2[0].size){0}
            for (k in 0 until arr2[0].size){
                var sum = 0
                for (j in 0 until arr2.size){
                    sum += arr1[i][j] * arr2[j][k]
                }
                multiplexArray[k] = sum
            }
           answer.add(multiplexArray.toIntArray())
        }

        return answer.toTypedArray()
    }
}

fun main() {
    val solution = Level2_ArrayMultiplex()
    println(solution.solution(arrayOf(intArrayOf(1,4), intArrayOf(3,2), intArrayOf(4,1)),
        arrayOf(intArrayOf(3,3), intArrayOf(3,3))).toList()) // [[15, 15], [15, 15], [15, 15]]
}