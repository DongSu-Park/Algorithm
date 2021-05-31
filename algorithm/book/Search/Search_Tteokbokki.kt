/**
 * 떡볶이 떡 만들기
 * - 떡볶이 떡을 요청한 cm에 맞게 자를 수 있는 절단기의 길이 값을 구하시오
 * - 예를 들어 떡볶이의 떡이 각각 19, 14, 10, 17인 경우 절단기의 높이를 15cm로 설정하면
 *   4, 0, 0, 2 -> 총 합이 6cm 이므로 요청한 cm와 같아서 리턴한 결과가 15 를 출력하면 됨.
 *
 * */
class Search_Tteokbokki {
    fun solution(tteoks: IntArray, requestSumCM: Int): Int{
        val tteoksList = tteoks.toList().sorted()

        return binarySearchTteoks(tteoksList, tteoksList.max(), requestSumCM)
    }

    private fun binarySearchTteoks(tteoksList: List<Int>, tteokMax: Int?, requestSumCM: Int): Int {
        var start = 0
        var end = tteokMax
        var middle = (start + end!!) / 2
        var findSliceCM = 0

        while (start <= end!!){
            if (sliceTteoks(tteoksList ,middle) == requestSumCM){ // 요청한 길이와 자른 결과의 합과 같을 경우
                findSliceCM = middle // 해당 중앙 값이 절단기의 길이로 갱신
                break
            }

            if (sliceTteoks(tteoksList, middle) > requestSumCM){ // 자른 결과의 합이 요청한 길이보다 큰 경우 오른쪽을 탐색
                start = middle + 1
                middle = (start + end!!) / 2
            } else { // 자른 결과의 합이 요청한 길이보다 작은 경우 왼쪽을 탐색
                end = middle - 1
                middle = (start + end!!) / 2
            }
        }

        return findSliceCM
    }

    private fun sliceTteoks(tteoksList: List<Int>, middle: Int): Int {
        // 떡을 자르고 남은 떡의 길이의 합을 구하는 함수
        val list = tteoksList.toMutableList()

        for (i in 0 until tteoksList.size){
            if (list[i] >= middle){
                list[i] = list[i] - middle
            } else {
                list[i] = 0
            }
        }

        return list.sum()
    }
}

fun main() {
    val solution = Search_Tteokbokki()
    println(solution.solution(intArrayOf(19,14,10,17), 6)) // 15
}