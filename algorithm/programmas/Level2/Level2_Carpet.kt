/**
 * 카펫 (완전탐색 연습문제)
 *
 * 문제 설명
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * */

class Level2_Carpet {
    fun solution(brown: Int, yellow: Int): IntArray {
        val answer = intArrayOf(0, 0)

        // 1) 두 색을 더해서 직사각형 또는 정사각형이 되는 리스트 세트 구하기 (단 가로가 세로보다 커야 함)
        val carpetNum = brown + yellow
        val carpetDivisorList = mutableListOf<Int>()
        val carpetRectList = mutableListOf<IntArray>()

        for (i in 1..carpetNum){ // 카펫 전체 수에서 약수를 구함
            if (carpetNum % i == 0){
                carpetDivisorList.add(carpetNum / i)
            }
        }

        var xPos : Int? = null
        var yPos : Int? = null

        if (carpetDivisorList.size % 2 == 0){ // 사이즈가 짝수, 홀수인 경우를 나눠서 중앙 포지션 설정
            xPos = carpetDivisorList.size / 2 - 1
            yPos = carpetDivisorList.size / 2
        } else {
            xPos = carpetDivisorList.size / 2
            yPos = carpetDivisorList.size / 2
        }

        while (yPos < carpetDivisorList.size){ // 중앙 부터 양쪽으로 탐색
            carpetRectList.add(intArrayOf(carpetDivisorList[xPos], carpetDivisorList[yPos]))
            xPos--
            yPos++
        }

        // 2) 직사각형에서 중앙에 노란색이 들어갈 자리의 개수가 yellow 정수와 같은지 확인
        for (i in 0 until carpetRectList.size){
            val weightMidNum = carpetRectList[i][0] - 2 // 가로의 가장 왼쪽과 오른쪽을 제외한 중앙 위치
            val heightMidNum = carpetRectList[i][1] - 2 // 세로의 가장 위쪽과 아래쪽을 제외한 중앙 위치

            if (weightMidNum * heightMidNum == yellow){
                answer[0] = carpetRectList[i][0]
                answer[1] = carpetRectList[i][1]
            }
        }

        return answer
    }
}

fun main() {
    val solution = Level2_Carpet()

    println(solution.solution(10,2).toList()) // [4,3]
    println(solution.solution(8,1).toList()) // [3,3]
    println(solution.solution(24,24).toList()) // [8,6]
}