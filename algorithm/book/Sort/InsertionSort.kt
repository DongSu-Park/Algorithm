/**
 * 삽입 정렬
 *  - 특정한 데이터를 적절한 위치에 '삽입' 한다의 의미에서 데이터를 하나씩 확인하며, 각 데이터를 적절한 위치에 삽입하는 알고리즘
 *  - 시간 복잡도 : 평균 O(n^2) 최악 O(n^2), 최선 O(n) -> 이중 반복문 사용
 *  - 장점 : 정렬이 거의 다 된 시점에서 사용하면 최선의 시간 복잡도를 가지고 활용함
 *  - 단점 : 선택 정렬과 마찬가지로 이중 반복문 사용으로 인한 데이터가 많을수록 비효율적
 * */
class InsertionSort {
    fun solution(nums : IntArray): IntArray{
        val list = nums

        for (i in 1 until list.size){
            for (j in i downTo 1){
                if (list[j] < list[j - 1]){
                    val temp = list[j]
                    list[j] = list[j - 1]
                    list[j - 1] = temp
                } else break
            }
        }

        return list
    }
}

fun main() {
    val solution = InsertionSort()
    println(solution.solution(intArrayOf(7,5,9,0,3,1,6,2,4,8)).toList()) // 0.1.2.3....9
}