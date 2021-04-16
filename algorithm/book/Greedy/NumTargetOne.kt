/**
 * 1이 될 때 까지
 *
 * 문제 설명
 * 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
 * 단 두 번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.
 *  1. N에서 1을 뺀다
 *  2. N에서 K로 나눈다
 *
 * 예를 들어 N = 17, K = 4일 경우
 *  1. 17 - 1 = 16
 *  2. 16 / 4 = 4
 *  3. 4 / 4 = 1
 *  => 총 3번..
 * */

class NumTargetOne {
    fun solution(n: Int, k: Int): Int{
        var count = 0
        var num = n

        while (num != 1){ // num이 1이 되면 반복문 탈출
            if (num % k == 0){ // k로 나누어 떨어지면 나누고 count++
                num /= k
                count++
            } else { // 나누어 떨어지지 않으면 -1하고 count++
                num -= 1 // 원래 num--를 해도 상관 없지만 문제의 의미 그대로 코딩하는게 적합해서 상수 1를 지칭
                count++
            }
        }

        return count
    }
}

fun main() {
    val solution = NumTargetOne()
    println(solution.solution(17, 4)) // 3
    println(solution.solution(25, 5)) // 2
    println(solution.solution(27, 4)) // 7
}