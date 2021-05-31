/**
 * 선택 정렬
 *  - 리스트 중 가장 작은 데이터를 선택해 맨 앞의 데이터와 바꾸고, 그 다음 작은 데이터를 선택해
 *    앞에서 두 번째 데이터와 바꾸는 과정
 *  - 시간 복잡도 : 평균 O(n^2), 최악 O(n^2) -> 이중 반복문 사용
 *  - 장점 : 작은 데이터에서 정렬할때 쉽게 구현 가능
 *  - 단점 : 데이터의 개수가 많으면 매우 비효율적 (다른 알고리즘에 비해 비효율)
 * */
class SelectionSort {
    fun solution(nums : IntArray): IntArray{
        val list = nums
        for (i in 0 until list.size){
            var min_index = i
            for (j in i+1 until list.size){
                if (list[min_index] > list[j]){
                    min_index = j
                }
            }
            val temp = nums[i]
            list[i] = list[min_index]
            list[min_index] = temp
        }

        return list
    }
}

fun main() {
    val solution = SelectionSort()
    println(solution.solution(intArrayOf(7,5,9,0,3,1,6,2,4,8)).toList()) //0,1,2,3...,9
}