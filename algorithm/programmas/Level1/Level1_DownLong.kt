/**
 * 숫자 내림차순 정렬
 * */
class Level1_DownLong {
    fun solution(n: Long): Long{
        var answer : Long = 0

        answer = n.toString().toList().sorted().reversed().joinToString(separator = "").toLong()

        return answer
    }
}

fun main() {
    val solution = Level1_DownLong()
    println(solution.solution(118372))
}