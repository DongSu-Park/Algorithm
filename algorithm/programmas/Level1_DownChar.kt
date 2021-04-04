/**
 * 문자열 내림차순으로 배치하기
 * -> 아스키코드??
 * */

class Level1_DownChar {
    fun solution(s: String): String{
        var answer = ""

        answer = s.toList().sorted().reversed().joinToString(separator = "")
        // toList = String을 Char형으로 변환하고 리스트로 정렬
        // sorted = 오름차순 정렬
        // reversed = 내림차순 정렬
        // joinToString = String형으로 묶음
        // separator = 그냥 하면 ','으로 나오므로 "" 공백으로 표시

        return answer
    }
}

fun main() {
    val solution = Level1_DownChar()
    val input = "Zbcdefg"

    val output = solution.solution(input)
    println(output)
}