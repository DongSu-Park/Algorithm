/**
 * 다이나믹 프로그래밍 - 탑 다운, 보텀 업 방식
 *  - 큰 문제를 해결하기 위해 작은 문제를 해결하는 방식 (재귀 방식) = 탑 다운 방식
 *  - 반면 단순 반복문을 이용한 작은 문제부터 큰 문제까지 올라가는 방식 (반복문 이용 방식) = 보텀 업 방식
 *  - 탑 다운 방식 중 기본적인 예시 => 피보나치 수열
 *  - 문제는 주어진 num이 100인 경우 연산 횟수가 기하급수적으로 늘어남에 따라 계산이 안됨
 *     해결 방안 -> 메모이제이션 방식 (캐싱 방식)으로 이미 계산이 완료되었으면 계산 할 필요 없이 가져다 쓰면 됨
 *  - 다이나믹 프로그래밍 조건
 *      1. 큰 문제를 작은 문제로 나눌 수 있다. (ex.피보나치 수열 같은 패턴 문제)
 *      2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서 동일하다 (탑 다운 메모이제이션 방식 사용)
 * */
class DynamicFibonacci {
    lateinit var cashing : Array<Float>
    fun solution(num: Int, s: String) : Float{
        cashing = Array<Float>(num + 1){0f} // 임의의 배열을 지정
        var fibonacci : Float = 0f
        when(s){
            "topDown" -> {
                fibonacci = topDownFibo(num) // 탑 다운 방식
            }

            "bottomUp" -> {
                fibonacci = bottomUpFibo(num) // 보텀 업 방식
            }
        }

        cashing = emptyArray()
        return fibonacci
    }

    private fun bottomUpFibo(num: Int): Float {
        // 피보나치 수열에서 1, 2의 결과는 1로 정해져 있음 (3은 fibo(1) + fibo(2) = 2)
        cashing[1] = 1f
        cashing[2] = 1f

        for (i in 3..num){ // 작은 문제부터 큰 문제 순으로 올라가는 방식
            cashing[i] = cashing[i - 1] + cashing[i - 2]
        }

        return cashing[num]
    }

    private fun topDownFibo(num: Int): Float {
        if (num == 1 || num == 2){
            return 1f
        }

        if (cashing[num] != 0f){
            // 해당 피보나치 수가 이미 계산이 완료되어 있다면 (이미 배열에 저장되어 있다면)
            // 재귀를 호출할 필요 없이 해당 배열에서 꺼내 씀 (이미 계산된 피보나치 수열은 재귀연산할 필요가 없음)
            return cashing[num]
        } else {
            cashing[num] = topDownFibo(num - 1) + topDownFibo(num - 2)
        }
        // 최종 캐싱된 배열의 숫자를 리턴
        return cashing[num]
    }
}

fun main() {
    val solution = DynamicFibonacci()
    println(solution.solution(99, "topDown")) // 2.1892292E20 (실수의 범위를 넘었음)
    println(solution.solution(99, "bottomUp")) // 2.1892292E20
}