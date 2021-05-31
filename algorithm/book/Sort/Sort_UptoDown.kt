/**
 * 위에서 아래로
 * - 크기에 상관없이 나열되어 있는 수를 내림차순으로 정렬하시오.
 * */
class Sort_UptoDown {
    fun solution(nums: IntArray): IntArray{
        return nums.toList().sortedDescending().toIntArray() // 간단하게 내부 정렬 알고리즘 사용하여 내림차순으로 정렬
    }
}

fun main() {
    val solution = Sort_UptoDown()

    println(solution.solution(intArrayOf(15,27,12)).toList()) // 27,15,12
}