/**
 * 숫자 카드 게임
 *
 * 문제 설명
 * 숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.
 * 단, 게임의 룰을 지키며 카드를 뽑아야 하고 룰은 다음과 같다
 *  1. 숫자가 쓰인 카드들이 N X M 형태로 놓여 있다. 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
 *  2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
 *  3. 그 다음 선택한 행에 포함된 카드들 중 가장 숫자가 낮은 카드르 뽑아야 한다.
 *  4. 따라서 처음에 카드를 골나낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을
 *     것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.
 *
 * 예시
 * 3 1 2
 * 4 1 4
 * 2 2 2
 * -> 위의 게임 룰에 따라 각 행 중에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 가장 높은 숫자의 카드를 뽑는 상황은
 * 3번째 행의 2를 고르는 것이 가장 적합 (1, 2행은 각각 1, 1을 뽑게 됨)
 * */

class NumCardGame {
    fun solution(array: Array<IntArray>): Int {
        var max = 0
        for (i in 0 until array.size){
            if (max < array[i].minOrNull()!!){ // 각 행의 최소 숫자가 이전에 고른 값보다 클 경우
                max = array[i].minOrNull()!! // max 변수 값 변경
            }
        }

        return max
    }

}

fun main() {
    val solution = NumCardGame()

    println(solution.solution(arrayOf(intArrayOf(3,1,2), intArrayOf(4,1,4), intArrayOf(2,2,2))))
    println(solution.solution(arrayOf(intArrayOf(7,3,1,8), intArrayOf(3,3,3,4))))
}