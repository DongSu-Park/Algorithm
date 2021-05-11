/**
 * Problems : Two Sum
 * Difficulty : Easy
 * Url : https://leetcode.com/problems/two-sum/
 *
 * 문제 설명
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *  -> 배열이 주어졌을 때 두 개를 고르고 더했을 때 target의 숫자와 일치한 배열의 위치를 리턴
 *
 *
 * */

class No1_TwoSum {
    fun solution(nums: IntArray, target: Int): IntArray{
        val answer = IntArray(2)

        for (i in 0 until nums.size){
            for (j in i+1 until nums.size){
                if (nums[i] + nums[j] == target){
                    answer[0] = i
                    answer[1] = j
                }
            }
        }

        return answer
    }
}

fun main() {
    val solution = No1_TwoSum()

    println(solution.solution(intArrayOf(2,7,11,15), 9).toList())
    println(solution.solution(intArrayOf(3,2,4),6).toList())
    println(solution.solution(intArrayOf(3,3), 6).toList())
}