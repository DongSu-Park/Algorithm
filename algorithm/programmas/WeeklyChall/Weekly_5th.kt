/**
 * 모음 사전 (프로그래머스 위클리 챌린지 5주차 문제)
 *
 * 문제 설명
 *  사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는,
 *  길이 5 이하의 모든 단어가 수록되어 있습니다.
 *  사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
 *  단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지
 *  return 하도록 solution 함수를 완성해주세요.
 *
 * 입출력 예시
 * "AAAAE" => 6
 * "I" => 1563
 * "EIO" => 1189
 *
 * 해결 방법
 * DFS를 이용한 스택 구조로 설계 하였고 해당 주차마다 스택에 있는 값과 비교해서 같으면 answer를 리턴
 * */
class Weekly_5th {
    fun solution(word: String): Int {
        var answer = 0

        val mStack = mutableListOf<Char>()
        val alpha = listOf<Char>('A','E','I','O','U')

        while (true){
            if (!mStack.isEmpty()){
                var stCheck = ""
                for (i in 0 until mStack.size){
                    stCheck += mStack[i]
                }

                if (stCheck == word) break
            }

            if (mStack.size == 5){
                if (mStack.last() != 'U'){
                    // 최상단의 단어가 U가 아닌 경우
                    // 한단계 올림
                    val temp = mStack.last()
                    mStack.removeAt(mStack.lastIndex)
                    mStack.add(alpha[alpha.indexOf(temp) + 1])
                } else {
                    // 최상단의 단어가 U인 경우
                    while (true){
                        mStack.removeLast() // 최상단 삭제
                        // 제거 후 최상단이 U가 아닌 경우 한 단계 올린 후 루프 종료
                        // U인 경우 루프로 인해 pop 을 한번 더 수행
                        if (mStack.last() != 'U'){
                            val temp = mStack.last()
                            mStack.removeAt(mStack.lastIndex)
                            mStack.add(alpha[alpha.indexOf(temp) + 1])
                            break
                        }
                    }
                }
            } else {
                mStack.add(alpha[0])
            }

            // 단어 위치 값 증가
            answer++
        }

        return answer
    }
}

fun main() {
    val solution = Weekly_5th();
    println(solution.solution("AAAAE")) // 6
    println(solution.solution("AAAE")) // 10
    println(solution.solution("I")) // 1563
    println(solution.solution("EIO")) // 1189
}