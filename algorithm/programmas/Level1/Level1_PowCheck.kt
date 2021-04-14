/**
 * 정수 제곱근 판별
 *
 * 문제 설명
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 *
 * 문제 풀이 과정
 * 여기서 중점은 "양의 정수 x의 제곱" 즉 3.0 4.0.. 등의 양의 정수로 딱 떨어지는 제곱근이 맞는것에 리턴문을 작성해야함
 * 문제의 의도는 자료형을 얼마나 잘 쓰는가를 판단하는것 같음
 * 일단 sqrt로 입력한 n의 제곱의 수를 가져오고
 * 저장한 상수에 (Double)에 Int형으로 치환한 저장한 상수를 나눠서 1.0이 나오면 (나눴을 때 소수점이 있는지 없는지 판단)
 * 리턴문 작성 아니면 -1
 * 즉 제곱근에 정수가 아닌 소수점이 있는지 없는지를 검사해야함~!!
 * */

class Level1_PowCheck {
    fun solution(n: Long): Long {
        var answer: Long = -1

        val sqrt = Math.sqrt(n.toDouble()) // 제곱 판단
        if (sqrt / sqrt.toInt() == 1.0){ // 양의 정수 제곱근이 맞다면
            answer = Math.pow(sqrt + 1, 2.0).toLong()
        }

        return answer
    }
}

fun main() {
    val solution = Level1_PowCheck()

    println(solution.solution(121))
    println(solution.solution(3))
    println(solution.solution(27))

}