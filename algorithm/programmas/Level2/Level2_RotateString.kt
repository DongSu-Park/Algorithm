/**
 * 괄호 회전하기 (월간 코드 챌린지 시즌 2)
 *
 * 문제 설명
 * 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
 * (), [], {} 는 모두 올바른 괄호 문자열입니다.
 * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
 * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
 *
 * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
 * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 * */

class Level2_RotateString {
    fun solution(s: String): Int{
        var answer = 0

        // 1) 몇번 회전해야하는지 확인
        var rotateCount = s.length - 1

        // 2) 올바른 괄호 문자열인지 확인하고 문자열 회전
        var source = s

        while (rotateCount > -1){
            val list = source.toList()
            val stack = mutableListOf<Char>()

            for (i in 0 until list.size){
                if (list[i] == ']' || list[i] == ')' || list[i] == '}'){
                    stack.add(list[i])

                    if (stack.size >= 2 && (stack[stack.lastIndex - 1] == list[i] - 1 || stack[stack.lastIndex - 1] == list[i] - 2)){
                        stack.removeAt(stack.size - 1)
                        stack.removeAt(stack.size - 1)
                    }
                } else {
                    stack.add(list[i])
                }
            }

            if (stack.isEmpty()){
                answer++
            }

            // 문자열 회전 (subSequence로 첫번째 부터 끝까지 자르고 첫번째 문자를 뒷쪽에 배치)
            val temp = "${source.subSequence(1, source.length)}${source[0]}"
            source = temp
            rotateCount--
        }
        
        return answer
    }
}

fun main() {
    val solution = Level2_RotateString()

    println(solution.solution("[](){}")) // 3
    println(solution.solution("}]()[{")) // 2
    println(solution.solution("[)(]")) // 0
    println(solution.solution("}}}")) // 0
}