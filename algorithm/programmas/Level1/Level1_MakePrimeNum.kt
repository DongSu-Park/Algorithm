/**
 * 소수 만들기
 * 문제 설명
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
 * 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 * */
class Level1_MakePrimeNum {
    fun solution(nums: IntArray): Int{
        var answer = 0

        for (i in 0 until nums.size-2){
            for (j in i+1 until nums.size-1){
                for (k in j+1 until nums.size){
                    val addNum = nums[i] + nums[j] + nums[k]
                    if (primeCheck(addNum)) answer++
                }
            }
        }

        return answer
    }

    fun primeCheck(num : Int): Boolean{
        // ** 소수 계산 방식 **
        // 초기값을 true로 두고 2부터 num-1 까지 모두 나머지를 계산할 때
        // 하나라도 나누어 떨어지면 false 처리 아니면 true로 소수 확정)
        var isPrime = true
        for (i in 2..num-1){
            if (num % i == 0) isPrime = false
        }
        return isPrime
    }
}

fun main() {
    val solution = Level1_MakePrimeNum()
    val inputNums = intArrayOf(1,2,3,4)
    println(solution.solution(inputNums))
}