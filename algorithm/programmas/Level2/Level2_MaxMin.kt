/**
 * 최댓값과 최솟값
 *
 * 문자열 s가 공백으로 구분된 숫자로 구성, 해당 문자열에서 최솟값과 최댓값을 "x y"형태로 출력
 *
 * */
class Level2_MaxMin {
    fun solution(s: String): String {
        val sList = s.split(" ")

        val stringToInt = mutableListOf<Int>()
        for (i in 0 until sList.size){
            stringToInt.add(Integer.parseInt(sList[i]))
        }

        return "${stringToInt.min()} ${stringToInt.max()}"
    }
}

fun main() {
    val solution = Level2_MaxMin()

    println(solution.solution("1 2 3 4"))
    println(solution.solution("-1 -2 -3 -4"))
    println(solution.solution("-1 -1"))
}