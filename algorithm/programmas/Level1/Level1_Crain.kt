/**
 * 크레인 인형뽑기 게임 (2019 카카오 개발자 겨울 인턴십)
 *
 * 문제 설명
 * 게임개발자인 "죠르디"는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
 * "죠르디"는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
 *
 * 게임 화면은 "1 x 1" 크기의 칸들로 이루어진 "N x N" 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
 * (위 그림은 "5 x 5" 크기의 예시입니다).
 * 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
 * 모든 인형은 "1 x 1" 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
 * 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다.
 * 집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
 * 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.
 *
 * 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
 * 위 상태에서 이어서 [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 두 개가 없어집니다.
 *
 * 크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
 * 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)
 * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
 * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
 * */

class Level1_Crain {
    fun solution(board: Array<IntArray>, moves: IntArray): Int{
        var score = 0

        // 각 위치의 인형들을 HashMap으로 관리
        val boardHashMap = hashMapOf<Int,MutableList<Int>>()
        boardHashMap.apply {
            for (j in 0 until board.size){
                val list = mutableListOf<Int>()
                for (i in 0 until board.size){
                    list.add(board[i][j])
                }
                set(j+1, list)
            }
        }

        // 크레인 박스를 MutableList로 설정하고 크레인 게임 시작
        val boxMutableList = mutableListOf<Int>()
        var target = 0
        for (i in 0 until moves.size){
            if (!boardHashMap[moves[i]].isNullOrEmpty()){
                var j = 0
                while (j < boardHashMap[moves[i]]!!.size){ // 각 위치의 인형 탐색
                    if (boardHashMap[moves[i]]!![j] != 0){ // 인형을 발견하면
                        target = boardHashMap[moves[i]]!![j] // 크레인에 인형을 가져가고
                        boardHashMap[moves[i]]!![j] = 0 // 해당 위치에 인형을 0으로 변경하여 삭제

                        if (boxMutableList.isNullOrEmpty()){ // 크레인 박스에 아무것도 없다면
                            boxMutableList.add(target) // 그냥 추가
                        } else if (boxMutableList[boxMutableList.size - 1] == target){ // 크레인 박스의 최상단 인덱스가 크레인으로 뽑은 인형과 같다면
                            boxMutableList.removeAt(boxMutableList.size - 1) // 최상단 인덱스를 삭제하고
                            score += 2 // score 변수를 +2 (크레인으로 뽑은 인형과 원래 크레인 박스 최상단에 있는 인형)
                        } else {
                            boxMutableList.add(target) // 크레인 박스에 스택 추가
                        }
                        break
                    }
                    j++
                }
            }
        }

        return score
    }
}

fun main() {
    val solution = Level1_Crain()
    val inputBoard = arrayOf(intArrayOf(0,0,0,0,0), intArrayOf(0,0,1,0,3), intArrayOf(0,2,5,0,1), intArrayOf(4,2,4,4,2), intArrayOf(3,5,1,3,1))
    val moves = intArrayOf(1,5,3,5,1,2,1,4)
    println(solution.solution(inputBoard, moves))
}