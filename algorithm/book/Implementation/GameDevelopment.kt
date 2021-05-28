/**
 * 게임 개발자
 *
 * 0 - 북쪽 / 1 - 동쪽 / 2 - 남쪽 / 3 - 서쪽
 * 유저는 이동할 때 시계 반대방향으로 회전하면서 체크한다.
 *
 * $$ 배열 contain 체크는 mutableList 객체의 any 함수를 이용해서 it.contentEquals()로 배열이 있는지 확인 $$
 * */

class GameDevelopment {
    fun solution (userPosition : IntArray, map: Array<IntArray>):Int{
        val walkStack = mutableListOf<Array<Int>>()

        // 처음의 포지션을 일단 walkStack에 넣기
        walkStack.add(arrayOf(userPosition[0], userPosition[1])) // (1,1)을 먼저 넣기

        // 바라보고 있는 방향과 현재 포지션 설정
        var userCompass = userPosition[2] // 0이니 북쪽을 봄
        val userPos = intArrayOf(userPosition[0], userPosition[1])
        var rotateCount = 0

        while (true){
            when(userCompass){
                0 -> { // 북쪽을 보고 있는 경우
                    if ((map[userPos[0]][userPos[1] - 1] == 0) && !walkStack.any{ it.contentEquals(arrayOf(userPos[0], userPos[1] - 1)) }){ // 탐색 시 갈 수 있는 위치라면
                        // 북 -> 서쪽 바라보고 위치값 갱신
                        rotateCount = 0
                        userCompass = 3
                        userPos[0] = userPos[0]
                        userPos[1] = userPos[1] - 1

                        // 옮긴 뒤 현재 포지션을 walkStack에 넣기
                        walkStack.add(arrayOf(userPos[0], userPos[1]))
                    } else if ((map[userPos[0]][userPos[1] - 1] == 1) || walkStack.any { it.contentEquals(arrayOf(userPos[0], userPos[1] -1)) }){
                        // 그 위치가 바다이거나 가본 칸인 경우 회전만 함
                        userCompass = 3
                        rotateCount++

                        if (rotateCount == 4){ // 모든 구역이 다 막힌 경우 뒤로 가기
                            // 뒤로 갈때 그 위치가 바다인 경우 break
                            if (map[userPos[0] + 1][userPos[1]] == 1){
                                break
                            } else { // 갈 수 있는 공간이라면
                                userPos[0] = userPos[0] + 1
                                userPos[1] = userPos[1]
                            }
                        }
                    }
                }

                1 -> { // 동쪽을 보고 있는 경우
                    if ((map[userPos[0] - 1][userPos[1]] == 0) && !walkStack.any { it.contentEquals(arrayOf(userPos[0] - 1 , userPos[1])) }){ // 탐색 시 갈수 있는 위치라면
                        // 동 -> 북쪽 바라보고 위치값 갱신
                        rotateCount = 0
                        userCompass = 0
                        userPos[0] = userPos[0] - 1
                        userPos[1] = userPos[1]

                        // 옮긴 뒤 현재 포지션을 walkStack에 넣기
                        walkStack.add(arrayOf(userPos[0], userPos[1]))
                    } else if ((map[userPos[0] - 1][userPos[1]] == 1) || walkStack.any { it.contentEquals(arrayOf(userPos[0] - 1, userPos[1])) }){
                        // 그 위치가 바다이거나 가본 칸인 경우 회전만 함
                        userCompass = 0
                        rotateCount++

                        if (rotateCount == 4){ // 모든 구역이 다 막힌 경우 뒤로 가기
                            // 뒤로 갈때 그 위치가 바다인 경우 break
                            if (map[userPos[0]][userPos[1] - 1] == 1){
                                break
                            } else { // 갈 수 있는 공간이라면
                                userPos[0] = userPos[0]
                                userPos[1] = userPos[1] - 1
                            }
                        }
                    }
                }

                2 -> { // 남쪽을 보고 있는 경우
                    if ((map[userPos[0]][userPos[1] + 1] == 0) && !walkStack.any { it.contentEquals(arrayOf(userPos[0], userPos[1] + 1)) }){ // 탐색 시 갈수 있는 위치라면
                        // 남 -> 동쪽 바라보고 위치값 갱신
                        rotateCount = 0
                        userCompass = 1
                        userPos[0] = userPos[0]
                        userPos[1] = userPos[1] + 1

                        // 옮긴 뒤 현재 포지션을 walkStack에 넣기
                        walkStack.add(arrayOf(userPos[0], userPos[1]))
                    } else if ((map[userPos[0]][userPos[1] + 1] == 1) || walkStack.any { it.contentEquals(arrayOf(userPos[0], userPos[1] + 1)) }){
                        // 그 위치가 바다이거나 가본 칸인 경우 회전만 함
                        userCompass = 1
                        rotateCount++

                        if (rotateCount == 4){ // 모든 구역이 다 막힌 경우 뒤로 가기
                            // 뒤로 갈때 그 위치가 바다인 경우 종료
                            if (map[userPos[0] - 1][userPos[1]] == 1){
                                break
                            } else { // 갈 수 있는 공간이라면
                                userPos[0] = userPos[0] - 1
                                userPos[1] = userPos[1]
                            }
                        }
                    }
                }

                3 -> { // 서쪽을 보고 있는 경우
                    if ((map[userPos[0] + 1][userPos[1]] == 0) && !walkStack.any { it.contentEquals(arrayOf(userPos[0] + 1, userPos[1])) }){ // 탐색 시 갈수 있는 위치라면
                        // 서 -> 남쪽 바라보고 위치값 갱신
                        rotateCount = 0
                        userCompass = 2
                        userPos[0] = userPos[0] + 1
                        userPos[1] = userPos[1]

                        // 옮긴 뒤 현재 포지션을 walkStack에 넣기
                        walkStack.add(arrayOf(userPos[0], userPos[1]))
                    } else if ((map[userPos[0] + 1][userPos[1]] == 1) || walkStack.any { it.contentEquals(arrayOf(userPos[0] + 1, userPos[1])) }){
                        // 그 위치가 바다이거나 가본 칸인 경우 회전만 함
                        userCompass = 2
                        rotateCount++

                        if (rotateCount == 4){ // 모든 구역이 다 막힌 경우 뒤로 가기
                            // 뒤로 갈때 그 위치가 바다인 경우 break
                            if (map[userPos[0]][userPos[1] + 1] == 1){
                                break
                            } else { // 갈 수 있는 공간이라면
                                userPos[0] = userPos[0]
                                userPos[1] = userPos[1] + 1
                            }
                        }
                    }
                }
            }
        }


        return walkStack.size
    }
}

fun main() {
    val solution = GameDevelopment()
    val inputUserPosition = intArrayOf(1,1,0) // 1,1에 위치 0은 북쪽을 바라보고 있음
    val inputMap = arrayOf(intArrayOf(1,1,1,1), intArrayOf(1,0,0,1), intArrayOf(1,1,0,1), intArrayOf(1,1,1,1))

    println(solution.solution(inputUserPosition, inputMap)) // 3
}