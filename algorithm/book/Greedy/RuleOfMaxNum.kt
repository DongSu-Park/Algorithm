/**
 * 큰 수의 법칙 (그리디, 2019 국가 교육기관 코딩 테스트)
 *
 * OO의 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰수를 만드는 법칙
 * 단, 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징
 *
 * 예를 들어 2,4,5,4,6으로 이루어진 배열이 있을 때 M이 8이고, K가 3이라고 가정하자
 * 이 경우 특정한 인덱스의 수가 연속해서 세번까지만 더해질 수 있으므로 큰 수의 법칙에 따른 결과
 * 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5 = 46이 된다
 *
 * 단 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다.
 * 예를 들어 순서 3,4,3,4,3으로 이루어진 배열이 있을 때 M이 7이고 K가 2라고 가정하자
 * 이 경우 두 번째 원소에 해당하는 4와 4번째 원소에 해당하는 4를 번갈아 두번씩 더하는 것이 가능하다
 * 4 + 4 + 4 + 4 + 4 + 4 + 4 = 28
 *
 * 배열의 크기 N, 숫자가 더해지는 횟수 M, K가 주어질 때 해당 법칙에 따른 결과를 출력하시오.
 * */

class RuleOfMaxNum {
    fun solution(n: Int, m: Int, k: Int, nums: IntArray) : Int{
        var answer = 0
        var count = m

        val arrayNums = nums.toList().sorted()
        val firstNum = arrayNums[n-1]
        val secondNum = arrayNums[n-2]

        while (count > 0){
            for (i in 0 until k){
                answer += firstNum
                count--
                if (count == 0) break
            }

            if (firstNum != secondNum){
                answer += secondNum
                count--
            }
        }

        return answer
    }
}

fun main() {
    val solution = RuleOfMaxNum()
    println(solution.solution(5,8,3, intArrayOf(2,4,5,4,6)))
    println(solution.solution(5, 7,2, intArrayOf(3,4,3,4,3)))
}