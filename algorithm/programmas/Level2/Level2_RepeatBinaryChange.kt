/**
 * 이진 변환 반복하기 (월간 코드 챌린지 시즌1)
 *
 * 문제 설명
 * 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
 * x의 모든 0을 제거합니다.
 * x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
 *
 * 예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
 * 0과 1로 이루어진 문자열 s가 매개변수로 주어집니다.
 * s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때,
 * 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * */

class Level2_RepeatBinaryChange {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf(0,0)

        var countRound = 0 // 회차 카운트
        var countDelZero = 0 // 0 제거 카운트

        var targetString = s.toMutableList()
        var binaryChange = "0"

        while (binaryChange != "1"){
            // 총 회차 카운트 증가
            countRound++

            // 첫번째 단계 - 0을 제거
            var i = 0
            while (i < targetString.size){
                if (targetString[i] == '0'){
                    targetString.removeAt(i) // 해당 0을 삭제
                    countDelZero++ // 0 제거 카운트를 ++
                    i--
                }
                i++
            }

            // 두번째 단계 - 이진 변환
            binaryChange = targetString.size.toString(2) // 0 제거 후 길이로 2진법 변환
            if (binaryChange == "1"){
                break
            }
            targetString = binaryChange.toMutableList()
        }

        answer[0] = countRound
        answer[1] = countDelZero

        return answer
    }
}

fun main() {
    val solution = Level2_RepeatBinaryChange()

    println(solution.solution("110010101001").toList()) // 3,8
    println(solution.solution("01110").toList()) // 3, 3
    println(solution.solution("1111111").toList()) // 4, 1
}