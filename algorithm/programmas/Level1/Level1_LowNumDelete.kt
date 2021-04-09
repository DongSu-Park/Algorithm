/**
 * 제일 작은 수 제거하기
 *
 * */

class Level1_LowNumDelete {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()

        // 제출한 방식
        /*
        val inputArray = arrayListOf<Int>()
        for (i in 0 until arr.size){
            inputArray.add(arr[i])
        }

        val lowNum = inputArray.toList().sorted().first()

        inputArray.remove(lowNum)
        if (inputArray.size == 0){
            inputArray.add(-1)
        }

        answer = inputArray.toIntArray()
        */

        // 모범답안
        if (arr.size == 1){
            answer = intArrayOf(-1)
            return answer
        }
        val arrayOutput = arr.toMutableList()
        arrayOutput.remove(arrayOutput.minOrNull())

        answer = arrayOutput.toIntArray()

        return answer
    }
}

fun main() {
    val solution = Level1_LowNumDelete()
    val inputArray = intArrayOf(10)
    val output = solution.solution(inputArray)
    println(output)
}