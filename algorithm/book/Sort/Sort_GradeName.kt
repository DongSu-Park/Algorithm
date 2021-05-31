/**
 * 성적이 낮은 순서로 학생 출력하기
 * - 학생의 이름과 성적으로 구분되는 정보가 주어질 때, 성적이 낮은 순서대로 학생의 이름을 출력하시오.
 * */
data class Grade(val names: String, val grade: Int)
class Sort_GradeName {
    fun solution(names: Array<String>, grade: IntArray): Array<String>{
        var list = mutableListOf<Grade>()
        for (i in 0 until names.size){
            list.add(Grade(names[i], grade[i]))
        }

        list = list.sortedBy { it.grade }.toMutableList()

        val answer = mutableListOf<String>()
        for (i in 0 until list.size){
            answer.add(list[i].names)
        }

        return answer.toTypedArray()
    }
}

fun main() {
    val solution = Sort_GradeName()
    println(solution.solution(arrayOf("홍길동","이순신"), intArrayOf(95,77)).toList()) // 이순신, 홍길동
}