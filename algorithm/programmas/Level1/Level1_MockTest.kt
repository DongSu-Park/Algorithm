/**
 * 모의고사 (완전탐색 연습문제)
 *
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *  1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ..
 *  2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ..
 *  3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 *  시험은 최대 10,000 문제로 구성되어있습니다.
 *  문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 *  가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * */

data class Tester(val person : Int, var count : Int)
class Level1_MockTest {
    fun solution(answers: IntArray): IntArray {
        // 테스터의 정보를 저장
        val tester = mutableListOf<Tester>()
        for (i in 1..3){
            tester.add(Tester(i, 0))
        }

        // 테스터가 찍는 반복된 방식을 ArrayList에 저장
        val testerAnswer = arrayListOf<IntArray>(intArrayOf(1,2,3,4,5), intArrayOf(2,1,2,3,2,4,2,5), intArrayOf(3,3,1,1,2,2,4,4,5,5))

        // 완전 탐색
        for (i in 0 until answers.size){
            if (answers[i] == testerAnswer[0][i % 5]){
                tester[0].count++
            }

            if (answers[i] == testerAnswer[1][i % 8]){
                tester[1].count++
            }

            if (answers[i] == testerAnswer[2][i % 10]){
                tester[2].count++
            }
        }

        // 가장 많은 문제를 맞힌 사람을 answer에 넣기
        val answer = mutableListOf<Int>()
        answer.add(tester[0].person)
        var max = tester[0].count

        for (k in 1 until tester.size){
            if (max < tester[k].count){
                answer.clear()
                answer.add(tester[k].person)
                max = tester[k].count
            } else if (max == tester[k].count){
                answer.add(tester[k].person)
            }
        }

        // 오름차순으로 정렬하여 리턴
        return answer.toIntArray().sortedArray()
    }
}

fun main() {
    val solution = Level1_MockTest()

    println(solution.solution(intArrayOf(1,2,3,4,5)).toList()) // [1]
    println(solution.solution(intArrayOf(1,3,2,4,2)).toList()) // [1,2,3]
}