/**
 * N개의 최소공배수 (연습문제)
 *
 * 문제 설명
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * arr은 길이 1이상, 15이하인 배열입니다.
 * arr의 원소는 100 이하인 자연수입니다.
 *
 * */
class Level2_LeastCommonMultiple {
    fun solution(arr: IntArray): Int{
        // 최소공배수를 찾는 기준의 시작은 배열의 최대값을 대상으로 함
        var lcm = arr.sorted().lastIndex
        while (true){
            var count = 0

            for (i in 0 until arr.size){
                if (lcm % arr[i] == 0){
                    count++
                }
            }

            // 만약 모든 배열을 나눴을 때 모두 다 나누어 떨어진 경우 그 값이 N개의 최소공배수
            if (count == arr.size) break

            // 아닌 경우 값을 증가하면서 탐색
            lcm++
        }

        return lcm
    }
}

fun main() {
    val solution = Level2_LeastCommonMultiple()

    println(solution.solution(intArrayOf(2,6,8,14)))
    println(solution.solution(intArrayOf(1,2,3)))
}