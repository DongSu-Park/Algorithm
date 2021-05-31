/**
 * 이진 탐색
 *  - 반으로 쪼개면서 탐색하는 방식
 *  - 찾으려는 데이터와 중간점에 위치에 있는 데이터를 반복적으로 비교
 *  - 위치를 나타내는 변수 3개를 사용, 탐색하고 하는 범위의 시작점, 끝점, 중간점을 이용
 *  - 단 이 방식은 해당 리스트가 정렬이 되어 있을 때만 사용 가능
 *  - 트리 자료구조 방식에서 이진 탐색 트리를 이용할 때 이진 탐색을 사용
 *  - 시간복잡도 : O(logN)
 * */
class BinarySearch {
    fun solution(nums : IntArray, findNum : Int): Int?{
        var start = 0
        var end = nums.size - 1
        var middle = (start + end) / 2

        var findPos : Int? = null

        while (start <= end){
            if (nums[middle] == findNum){
                findPos = middle
                break
            }
            if (nums[middle] > findNum){ // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
                end = middle - 1
                middle = (start + end) / 2
            } else { // 반대의 경우 오른쪽 확인
                start = middle + 1
                middle = (start + end) / 2
            }
        }


        if (findPos != null){
            return findPos + 1
        } else {
            return null
        }
    }
}

fun main() {
    val solution = BinarySearch()
    println(solution.solution(intArrayOf(0,2,4,6,8,10,12,14,16,18), 4)) // 3
}