/**
 * 두 배열의 원소 교체
 *  - 두 배열 A,B가 있고, 같은 N개의 원소가 주어질 때 최대 K번 바꿔치기 연산을 수행하여 모든 원소의 합의 최대값을 구하시오.
 * */

class Sort_SwapTwoArray {
    fun solution(arrayA : IntArray, arrayB : IntArray, swapCount: Int) : Int{
        val listA = arrayA.toList().sorted().toMutableList()// 오름차순으로 정렬
        val listB = arrayB.toList().sortedDescending() // 내림차순으로 정렬

        var count = 0
        var pos = 0
        while (count < swapCount){
            if (listA[pos] < listB[pos]){
                listA[pos] = listB[pos]
            } else { // a의 원소가 b의 원소보다 크거나 같으면 스왑을 할 필요가 없음
                break
            }
            pos++
            count++
        }


        return listA.sum()
    }
}

fun main() {
    val solution = Sort_SwapTwoArray()
    println(solution.solution(intArrayOf(1,2,5,4,3), intArrayOf(5,5,6,6,5), 3)) // 26
}
