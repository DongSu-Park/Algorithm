/**
 * 자릿수 더하기
 *
 * 문제 설명
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 * 제한사항
 * N의 범위 : 100,000,000 이하의 자연수
 * */

class Level1_AddDigit {
    fun solution(n: Int): Int{
        var answer = 0
        val input = n.toString().toList() // 리스스 형태로 변환
        for (i in 0 until input.size){
            answer += Integer.parseInt(input[i].toString()) // String을 int형으로 (아스키코드 상관없이)
        }

        return answer
    }
}

fun main() {
    val solution = Level1_AddDigit()
    println(solution.solution(123))
    println(solution.solution(987))
}