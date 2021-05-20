/**
 * JadenCase 문자열 만들기
 *
 * 문제 설명
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 * */
class Level2_JadenCase {
    fun solution(s: String): String {
        var answer = ""
        var jadenCase = ""

        val list = s.split("")

        for (i in 0 until list.size) {
            if (list[i] == " " || i == list.size - 1) { // 공백을 발견한 경우 또는 마지막에 도달한 경우
                if (jadenCase != "") {
                    val word = jadenCase.toLowerCase().toCharArray()
                    if ((word[0] in 'A'..'Z') || (word[0] in 'a'..'z')) {
                        word[0] = word[0].toUpperCase()
                        answer += word.joinToString(separator = "")
                        jadenCase = ""
                    } else {
                        answer += word.joinToString(separator = "")
                        jadenCase = ""
                    }
                }

                answer += list[i] // 공백 추가
            } else {
                jadenCase += list[i]
            }
        }

        return answer
    }
}

fun main() {
    val solution = Level2_JadenCase()

    println(solution.solution("3people unFollowed me")) // "3people Unfollowed Me"
    println(solution.solution("for the last week")) // "For The Last Week"
    println(solution.solution(" adgagd 3eagdag ")) // " Adgagd 3eagdag "
}