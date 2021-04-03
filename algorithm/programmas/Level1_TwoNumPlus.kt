/**
 * 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
 *  예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
 * */

class Level1_TwoNumPlus {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0

        if (a < b){
            for (n in a..b){
                answer += n
            }
        } else { // b가 a보다 더 클 경우를생각
            for(n in b..a){
                answer += n
            }
        }

        return answer
    }
}

fun main() {
    val a = 3
    val b = 3
    val solution = Level1_TwoNumPlus()
    print(solution.solution(a,b))
}