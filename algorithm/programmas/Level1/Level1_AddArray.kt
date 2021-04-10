/**
 * 행렬의 덧셈
 * */

class Level1_AddArray {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray>{
        var answer = Array<IntArray>(arr1.size) { IntArray(arr1[0].size) } // 이중배열 초기화

        for (i in 0 until arr1.size){
            for (j in 0 until arr1[i].size){
                answer[i][j] = arr1[i][j] + arr2[i][j]
            }
        }

        return answer
    }
}

fun main() {
    val solution = Level1_AddArray()

    val arr1 = arrayOf(intArrayOf(1,2), intArrayOf(2,3))
    val arr2 = arrayOf(intArrayOf(3,4), intArrayOf(5,6))

    println(solution.solution(arr1, arr2))

    val arr3 = arrayOf(intArrayOf(1), intArrayOf(2))
    val arr4 = arrayOf(intArrayOf(3), intArrayOf(4))

    println(solution.solution(arr3, arr4))
}