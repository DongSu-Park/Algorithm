/**
 * 부품 찾기
 * - 부품이 있는 리스트에서 고객이 찾고자 하는 부품이 리스트 안에 있는지 확인
 * - 예를 들어 리스트에 8, 3, 7, 9, 2가 있을때 요청하는 부품이 5,7,9 인 경우 출력 결과 false, true, ture 를 출력
 * */
class Search_FindParts {
    fun solution(partList : IntArray, findList : IntArray): Array<Boolean>{
        val answer = Array<Boolean>(findList.size){false}

        // 1) contain 함수를 이용한 문제 풀이
//        for (i in 0 until findList.size){
//            if (partList.contains(findList[i])){
//                answer[i] = true
//            }
//        }

        // 2) 이진 탐색 알고리즘을 이용한 문제 풀이
        val sortPartList = partList.toList().sorted()
        for (i in 0 until findList.size){
            answer[i] = binarySearch(sortPartList, findList[i])
        }

        return answer
    }

    private fun binarySearch(sortPartList: List<Int>, findNum: Int): Boolean {
        var start = 0
        var end = sortPartList.size -1
        var middle = (start + end) / 2
        var isFind = false

        while (start <= end){ // 시작 지점 끝점보다 넘을 경우 반복문 해제
            if (sortPartList[middle] == findNum){
                // 해당 중앙 인덱스가 찾는 값이라면 true로 반환
                isFind = true
                break
            }

            if (sortPartList[middle] > findNum){
                // 찾는 값이 중앙의 값보다 작으면 왼쪽을 탐색
                end = middle - 1 // 끝점을 이전 중간 인덱스의 왼쪽 인덱스로 갱신
                middle = (start + end) / 2 // 중앙 인덱스 다시 갱신
            } else { // 찾는 값이 중앙의 값보다 크면 오른쪽을 탐색
                start = middle + 1 // 시작 지점을 중간 인덱스의 오른쪽 인덱스로 갱신
                middle = (start + end) / 2 // 중앙 인덱스 다시 갱신
            }
        }
        return isFind
    }
}

fun main() {
    val solution = Search_FindParts()
    println(solution.solution(intArrayOf(8,3,7,9,2), intArrayOf(5,7,9)).toList()) // [false, true, true]
}