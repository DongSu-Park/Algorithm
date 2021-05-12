/**
 * Problems : Median of Two Sorted Arrays
 * Difficulty : Hard
 * Url : https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * 문제 설명
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *  -> nums1, nums2의 각각 리스트의 숫자를 합친 후 (중복 제외) 합친 리스트의 중앙값을 찾으세요
 *      만약 리스트의 개수가 짝수인 경우 중앙에 인접한 두 배열의 값을 합친 후 2로 나눠서 값을 리턴
 * */

class No4_MedianOfTwoSortedArrays {
    fun solution(nums1: IntArray, nums2: IntArray): Double{

        val numList = mutableListOf<Int>()

        for (i in 0 until nums1.size){
            numList.add(nums1[i])
        }

        for (j in 0 until nums2.size){
            numList.add(nums2[j])
        }

        numList.sort() // 모든 값을 정렬

        var answer : Double = 0.00

        if (numList.size % 2 == 0){
            // 배열의 길이가 짝수인 경우
            answer = ((numList[numList.size / 2 - 1].toDouble() + numList[numList.size / 2].toDouble()) / 2)
        } else {
            // 배열의 길이가 홀수인 경우
            answer = numList[numList.size / 2].toDouble()
        }
        
        return answer
    }

}

fun main() {
    val solution = No4_MedianOfTwoSortedArrays()

    println(solution.solution(intArrayOf(1,3), intArrayOf(2))) // 2.00000
    println(solution.solution(intArrayOf(1,2), intArrayOf(3,4))) // 2.5000
    println(solution.solution(intArrayOf(0,0), intArrayOf(0,0))) // 0.0000
}