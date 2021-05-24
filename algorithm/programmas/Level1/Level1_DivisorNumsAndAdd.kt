/**
 * 약수의 개수와 덧셈 (월간 코드 챌린지 시즌 2)
 *
 * 문제 설명
 * 두 정수 left와 right가 매개변수로 주어집니다.
 * left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
 * 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요
 * */

class Level1_DivisorNumsAndAdd {
    fun solution(left: Int, right : Int): Int{
        var answer = 0

        for (num in left..right){
            val list = mutableListOf<Int>()

            var k = 1
            while (k <= num){
                if (num % k == 0){
                    list.add(num / k)
                }
                k++
            }

            if (list.size % 2 == 0){
                answer += num
            } else {
                answer -= num
            }
        }
        return answer
    }
}

fun main() {
    val solution = Level1_DivisorNumsAndAdd()
    println(solution.solution(13,17)) // 43
    println(solution.solution(24,27)) // 52

}