/**
 * 왕실의 나이트
 *
 * 체스판은 8*8의 좌표 평면
 * 나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
 * 나이트는 특정 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
 *  1. 수평으로 두 칸 이동한 뒤 수직으로 한 칸 이동하기 (ex. 오른쪽으로 두 칸 위로 한 칸)
 *  2. 수직으로 두 칸 이동한 뒤 수평으로 한 칸 이동하기 (ex. 위로 두 칸 오른쪽으로 한 칸)
 *
 * 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
 * 이때 왕실의 정원에서 행 위치를 표현할 때는 1~8로 표현하며 열 위치를 표현할 때는 a부터 h로 표현한다.
 * 예로 나이트가 1행 1열에 위치하고 있으면 a1 임
 *
 * 나이트가 이동할 수 있는 모든 경우의 수
 *  1. 오른쪽으로 두칸 위로 한칸 (2,1)
 *  2. 오른쪽으로 한칸 위로 두칸 (1,2)
 *  3. 왼쪽으로 두칸 위로 한칸 (-2, 1)
 *  4. 왼쪽으로 한칸 위로 두칸 (-1, 2)
 *  5. 오른쪽으로 두칸 아래로 한칸 (2, -1)
 *  6. 오른쪽으로 한칸 아래로 두칸 (1, -2)
 *  7. 왼쪽으로 두칸 아래로 한칸 (-2, -1)
 *  8. 왼쪽으로 한칸 아래로 두 칸 (-1, -2)
 * */
class Chess {
    fun solution(position : String): Int{
        var answer = 8
        val step = arrayOf(intArrayOf(2,1), intArrayOf(1,2), intArrayOf(-2,1), intArrayOf(-1,2), intArrayOf(2,-1),
            intArrayOf(1,-2), intArrayOf(-2,-1), intArrayOf(-1,-2)) // 모든 경우의 수

        val positionArray = intArrayOf(position[0]-'a' + 1, Integer.parseInt(position[1].toString())) // a, 1 -> 1, 1

        for (i in 0 until step.size){
            val positionX = positionArray[0] + step[i][0]
            val positionY = positionArray[1] + step[i][1]
            if (positionX <= 0 || positionX >= 9 || positionY <= 0 || positionY >= 9){ // 지나갈수 없는 경우의 수가 생기면 총 경우의 수에서 차감
                answer--
            }
        }
        return answer
    }
}

fun main() {
    val solution = Chess()
    println(solution.solution("a1")) // a열 1행 -> 2가지
    println(solution.solution("c2")) // c열 2행 -> 6가지
}