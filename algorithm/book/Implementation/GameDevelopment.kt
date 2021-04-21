/**
 * 게임 개발자
 *
 * 0 - 북쪽 / 1 - 동쪽 / 2 - 남쪽 / 3 - 서쪽
 * 유저는 이동할 때 시계 반대방향으로 회전하면서 체크한다.
 * */

class GameDevelopment {
    fun solution (userPosition : IntArray, map: Array<IntArray>):Int{
        var answer = 0


        return answer
    }
}

fun main() {
    val solution = GameDevelopment()
    val inputUserPosition = intArrayOf(1,1,0) // 1,1에 위치 0은 북쪽을 바라보고 있음
    val inputMap = arrayOf(intArrayOf(1,1,1,1), intArrayOf(1,0,0,1), intArrayOf(1,1,0,1), intArrayOf(1,1,1,1))

    println(solution.solution(inputUserPosition, inputMap)) // 3
}