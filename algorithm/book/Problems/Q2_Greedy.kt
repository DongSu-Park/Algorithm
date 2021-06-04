/**
 * 문제 2 - 곱하기 혹은 더하기 (그리디 문제)
 *
 * - 문제 설명
 * 각 자리 숫자가 0~9로만 이루어진 문자열 S가 주어질 때 왼쪽 부터 오른쪽으로 하나씩 모든 숫자를 확인하여
 * 숫자 사이에 'x' 혹은 '+' 연산자를 넣어 결과적으로 만들 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.
 *
 * - 핵심 패턴
 * 앞에서부터 자리수를 가지고 계산 할 때 두 수 중 하나라도 0 혹은 1이 있는 경우이면 두 수를 더하고 아닌 경우에는 곱하면 최대값이 됨.
 *
 * */
class Q2_Greedy {
    fun solution(nums: String) : Int{
        val list = nums.toList()

        var sum = Integer.parseInt(list[0].toString())

        for (i in 1 until list.size){
            // 두 수 중에 0 혹은 1이 있는 경우 더하고 그 외에는 다 곱하기.
            if (sum == 0 ||  Integer.parseInt(list[i].toString()) == 0 || sum == 1 || Integer.parseInt(list[i].toString()) == 1){
                sum += Integer.parseInt(list[i].toString())
            } else {
                sum *= Integer.parseInt(list[i].toString())
            }
        }

        return sum
    }
}

fun main() {
    val solution = Q2_Greedy()
    println(solution.solution("02984")) // 576
    println(solution.solution("567")) // 210
    println(solution.solution("2117")) // 28
}