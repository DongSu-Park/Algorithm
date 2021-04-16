/**
 * 상하좌우
 * 
 * NxN의 정사각형 공간에 LRUD의 문자열을 각각 입력했을 때 최종 위치는?
 * 단 막혀있는 공간에서 움직임이 입력되면 무시된다.
 * */
class Position {
    fun solution (num : Int, command: String): IntArray{
        val answer = intArrayOf(1, 1)
        var positionX = 1
        var positionY = 1
        val list = command.toMutableList()

        for (i in 0 until list.size){
            when(list[i]){
                'L' -> if (positionY - 1 != 0) positionY -= 1
                'R' -> if (positionY + 1 < num) positionY += 1
                'U' -> if (positionX - 1 != 0) positionX -= 1
                'D' -> if (positionX + 1 < num) positionX += 1
            }
        }

        answer.apply {
            set(0, positionX)
            set(1, positionY)
        }

        return answer
    }
}

fun main() {
    val solution = Position()
    println(solution.solution(5, "RRRUDD")) // 3, 4
    println(solution.solution(5,"RRRRRR")) // 1, 4
}