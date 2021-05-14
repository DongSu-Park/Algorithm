/**
 * Problems : Container With Most Water
 * Difficulty : Medium
 * Url : https://leetcode.com/problems/container-with-most-water/
 *
 * 문제 설명
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *  -> 양의 정수로 이루어진 배열에서 가장 많은 양의 물을 담을 수 있는 컨테이너의 면적을 구하시오
 *  -> 반복문을 두번 사용하는 선택 정렬식 알고리즘을 사용하면 O(n^2)를 사용하므로 긴 배열의 테스트 케이스에서 타임아웃 발생
 *      양쪽의 인덱스를 비교하는 퀵 정렬식 알고리즘을 사용하면 O(nlogN)를 사용하므로 선택 정렬식 알고리즘 보다 더욱 효율적으로 사용 됨.
 * */

class No11_ContainerWithMostWater {
    fun solution(nums: IntArray): Int{
        var max = 0

        var height = 0
        var width = 0

        var startIndex = 0
        var lastIndex = nums.lastIndex

        // 양쪽을 비교 (퀵 정렬 방식)
        while (lastIndex - startIndex > 0){
            if (nums[startIndex] > nums[lastIndex]){
                height = nums[lastIndex]
            } else{
                height = nums[startIndex]
            }

            width = lastIndex - startIndex

            if (max <= height * width){
                max = height * width
            }

            if (nums[lastIndex] > nums[startIndex]){
                startIndex++
            } else {
                lastIndex--
            }

        }

        return max
    }
}

fun main() {
    val solution = No11_ContainerWithMostWater()

    println(solution.solution(intArrayOf(1,8,6,2,5,4,8,3,7))) // 49
    println(solution.solution(intArrayOf(1,1))) // 1
    println(solution.solution(intArrayOf(4,3,2,1,4))) // 16
    println(solution.solution(intArrayOf(1,2,1))) // 2
}