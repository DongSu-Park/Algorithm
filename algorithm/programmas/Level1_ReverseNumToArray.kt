/**
 * 자연수 뒤집어 배열로 만들기
 * */

class Level1_ReverseNumToArray {
    fun solution(n: Long): IntArray{
        var answer = intArrayOf()
        val inputNum = n.toString()
        val inputArray = arrayListOf<Int>()
        for (i in 0 until inputNum.length){
            inputArray.add(Integer.parseInt(inputNum[i].toString()))
        }

        inputArray.reverse()
        answer = inputArray.toIntArray()

        return answer
    }
}

fun main() {
    val solution = Level1_ReverseNumToArray()

    println(solution.solution(12345))
}