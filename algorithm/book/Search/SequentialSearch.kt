/**
 * 순차 탐색
 *  - 리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 과정
 *  - 데이터의 개수가 N개 일때 최대 N번의 비교 연산이 필요
 *  - 시간복잡도 : 최상 O(1), 최악 O(n)
 * */
class SequentialSearch {
    fun solution(nameList: Array<String>, findName: String) : Int{
        var findPos = 0
        for (i in 0 until nameList.size){ // 0부터 순차적으로 리스트 안에 있는 특정한 데이터를 찾기
            if (nameList[i] == findName){
                findPos = i
            }
        }

        return findPos + 1
    }
}

fun main() {
    val solution = SequentialSearch()
    println(solution.solution(arrayOf("Haneul", "Jonggu", "Dongbin", "Taeil", "Sangwook"), "Dongbin")) // 3
}