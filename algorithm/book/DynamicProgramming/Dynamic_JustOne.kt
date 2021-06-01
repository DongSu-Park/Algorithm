import kotlin.math.min

/**
 * 1로 만들기
 *
 * 문제 설명
 *  정수 X가 주어질 때 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지 이다.
 *   1. X가 5로 나누어 떨어지면 5으로 나눈다.
 *   2. X가 3으로 나누어 떨어지면 3으로 나눈다.
 *   3. X가 2로 나누어 떨어지면 2로 나눈다.
 *   4. X에서 1을 뺀다.
 *  정수 X가 주어졌을 때, 연산 4개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 구하시오.
 *  예를 들어 정수가 26이면 다음과 같이 계산해서 3번의 연산이 최솟값이다.
 *   1. 26 -1 = 25
 *   2. 25 / 5 = 5
 *   3. 5 / 5 = 1
 * */
class Dynamic_JustOne {
    lateinit var cashing : Array<Int>
    fun solution (num : Int): Int{
        cashing = Array<Int>(30001){0}
        return justOneBottomUp(num)
    }

    private fun justOneBottomUp(num: Int): Int {
        for (i in 2 until num + 1){
            // 현재의 수에서 1을 빼는 경우
            cashing[i] = cashing[i - 1] + 1

            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0){
                cashing[i] = min(cashing[i], cashing[i / 2] + 1)
            }

            // 현재의 수가 3로 나누어 떨어지는 경우
            if (i % 3 == 0){
                cashing[i] = min(cashing[i], cashing[i / 3] + 1)
            }

            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0){
                cashing[i] = min(cashing[i], cashing[i / 5] + 1)
            }
        }

        return cashing[num]
    }
}

fun main() {
    val solution = Dynamic_JustOne()
    println(solution.solution(26)) // 3
}