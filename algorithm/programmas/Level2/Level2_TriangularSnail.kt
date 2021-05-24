/**
 * 삼각 달팽이 (월간 코드 챌린지 시즌 1)
 *
 * 문제 설명
 * 정수 n이 매개변수로 주어집니다.
 * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
 * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 * */
class Level2_TriangularSnail {
    fun solution(n: Int): IntArray {
        // 배열 만들기
        val answerList = mutableListOf<Array<Int>>()
        for (i in 0 until n){
            val list = Array<Int>(1+i){it -> 0}
            answerList.add(list)
        }

        // 배열에 추가
        var xPos = 0
        var yPos = 0
        var numMax = 0
        var num = 2
        for (i in 1..n){
            numMax += i
        }

        answerList[0][0] = 1

        val mode = listOf<String>("down","right","up") // down, right, up
        var count = n
        var addCount = 1
        var modPos = 0

        while (num <= numMax){
            when(mode[modPos]){
                "down" -> {
                    xPos++
                    answerList[xPos][yPos] = num
                    addCount++
                }

                "right" -> {
                    yPos++
                    answerList[xPos][yPos] = num
                    addCount++
                }

                "up" -> {
                    xPos--
                    yPos--
                    answerList[xPos][yPos] = num
                    addCount++
                }
            }

            if (addCount == count){
                count--
                addCount = 0
                modPos++
                if (modPos >= mode.size){
                    modPos = 0
                }
            }

            num++
        }
        val answer = mutableListOf<Int>()

        for (k in 0 until answerList.size){
            for (l in 0 until answerList[k].size){
                answer.add(answerList[k][l])
            }
        }

        return answer.toIntArray()
    }
}

fun main() {
    val solution = Level2_TriangularSnail()
    println(solution.solution(4).toList()) // [1,2,9,3,10,8,4,5,6,7]
    println(solution.solution(5).toList()) // [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
    println(solution.solution(6).toList()) // [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
}