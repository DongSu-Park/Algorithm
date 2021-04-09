import java.lang.NumberFormatException

/**
 * 문제 설명
 * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
 * 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
 *
 * 제한 사항
 * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
 * */

class Level1_StringBasic {
    fun solution(s: String): Boolean{
        var answer = true

        // 익셉션 발생 시 false 처리 방식 (왠만하면 이렇게 하진 말자...)
//        if ((s.length == 4 || s.length == 6)){
//            try {
//                s.toInt()
//                answer = true
//            } catch (e : NumberFormatException){
//                answer = false
//            }
//        } else{
//            answer = false
//        }

        // 올바른 방식은 이것...
        answer = (s.length == 4 || s.length == 6) && s.toIntOrNull() != null

        return answer
    }
}

fun main() {
    val solution = Level1_StringBasic()

    val input1 = "a234"
    val output1 = solution.solution(input1)

    println(output1)

    val input2 = "1234"
    val output2 = solution.solution(input2)

    println(output2)
}