/**
 * 핸드폰 번호 가리기
 * 뒤의 4자리 숫자를 제외한 나머지 숫자를 '*'로 변경
 * */

class Level1_PhoneNumHide {
    fun solution(phone_number: String): String {
        var answer = ""

        val phoneNum = phone_number.toMutableList()
        if (phoneNum.size in 4..20){
            for (i in 0 until phoneNum.size-4){
                phoneNum[i] = '*'
            }
        }

        answer = phoneNum.joinToString(separator = "")

        return answer
    }
}

fun main() {
    val solution = Level1_PhoneNumHide()
    println(solution.solution("01033334444"))
    println(solution.solution("027778888"))
}