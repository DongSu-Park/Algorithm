/**
 * 문자열을 정수로 바꾸기
 * - 문제 설명 -
 * 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
 * 
 * - 제한 조건 -
 * s의 길이는 1 이상 5이하입니다.
 * s의 맨앞에는 부호(+, -)가 올 수 있습니다.
 * s는 부호와 숫자로만 이루어져있습니다.
 * s는 "0"으로 시작하지 않습니다.
 * */

class Level1_StringToInt {
    fun solution(s: String): Int{
        var answer = 0

        val input = s

        if (input.length in 1..5 && input.toList()[0] != '0'){
           answer = input.toInt()
        }

        return answer
    }
}

fun main() {
    val solution = Level1_StringToInt()
    val input = "1234"
    val output = solution.solution(input)

    println(output)
}