/**
 * 상호평가 (프로그래머스 위클리 챌린지 2주차)
 *
 * 문제 설명
 * 대학 교수인 당신은, 상호평가를 통하여 학생들이 제출한 과제물에 학점을 부여하려고 합니다.
 * 아래는 0번부터 4번까지 번호가 매겨진 5명의 학생들이 자신과 다른 학생의 과제를 평가한 점수표입니다.
 *  예시 링크 : https://programmers.co.kr/learn/courses/30/lessons/83201?language=kotlin
 * 점수에서 제외 조건은 자기 점수가 평가 점수 항목에서 최고점 또는 최저점이면 제외하지만
 * 해당 점수가 평가 점수 항목에서 2개 이상 이면 유일한 최고점 또는 최저점이 아니므로 제외하지 않습니다.
 *
 * 조건에 적합한 점수는 제외하고 평균을 구한 후 기준에 따라 학점으로 부여하고 출력하시오
 * 
 * */
class Weekly_2nd {
    fun solution(scores: Array<IntArray>): String {
        var answer: String = ""

        for (i in 0 until scores.size) {
            val checkArray: ArrayList<Int> = arrayListOf()
            var myScore = 0

            for (j in 0 until scores[i].size) {
                if (i == j) {
                    // 자신 스코어를 따로 저장해놓음
                    myScore = scores[j][i]
                    checkArray.add(scores[j][i])
                } else {
                    checkArray.add(scores[j][i])
                }
            }

            // 체크 항목
            // 자기 점수가 최고점 또는 최저점이면 제외하는데
            // 같은 점수가 배열안에 있으면 제외하고 아니면 그대로 나둔다
            if ((checkArray.max() == myScore || checkArray.min() == myScore) &&
                checkArray.filter { it.equals(myScore) }.size == 1
            ) {
                checkArray.remove(myScore)
            }

            answer += checkGrade(checkArray, checkArray.size)
        }
        return answer
    }

    private fun checkGrade(checkArray: ArrayList<Int>, size: Int): String? {
        // 계산된 평균을 학점으로 바꿔줌
        val average: Float = (checkArray.sum() / size).toFloat()
        var grade = ""
        when (average) {
            in 90.0..100.0 -> grade = "A"
            in 80.0..89.9 -> grade = "B"
            in 70.0..79.9 -> grade = "C"
            in 50.0..69.9 -> grade = "D"
            else -> grade = "F"
        }

        return grade
    }
}

fun main() {
    val solution = Weekly_2nd()

    println(
        solution.solution(
            arrayOf(
                intArrayOf(100, 90, 98, 88, 65),
                intArrayOf(50, 45, 99, 85, 77), intArrayOf(47, 88, 95, 80, 67),
                intArrayOf(61, 57, 100, 80, 65), intArrayOf(24, 90, 94, 75, 65)
            )
        )
    ) // "FBABD"

    println(
        solution.solution(
            arrayOf(
                intArrayOf(50, 90), intArrayOf(50, 87)
            )
        )
    ) // "DA"

    println(
        solution.solution(
            arrayOf(
                intArrayOf(70, 49, 90), intArrayOf(68, 50, 38),
                intArrayOf(73, 31, 100)
            )
        )
    ) // "CFD"
}