import java.util.*

/**
 * 미로 탈출 (BFS 큐 사용)
 *
 * 문제 설명
 * 동빈이는 N X M 크기의 직사각형 형태의 미로에 갇혀있다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
 * 동빈이의 위치는 (1,1)이고 미로의 출구는 (N,M)의 위치에 존재하며 한번에 한 칸씩 이동할 수 있다.
 * 이때 괴물이 있는 부분은 0이며, 괴물이 없는 부분은 1로 표시되어 있다.
 * 미로는 반드시 탈출 할 수 있는 형태로 제시된다.
 * 이 때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하시오.
 * 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.
 * ## 배열 참조에서는 위치는 (0,0) 부터 시작이며, 미로 출구는 주어진 배열의 마지막 인덱스
 *
 * 문제 풀이 방식
 * 1) 시작 지점 (0,0)부터 상, 하, 좌, 우로 탐색을 진행하면서 괴물이 없는 1 값을 찾는다. 바로 옆 노드인 (0,1) 위치의 노드를 방문하게 되며
 *    새롭게 방문하는 (0,1) 노드의 값을 2로 바꾸게 된다.
 * 2) 이러한 방식으로 BFS를 계속 수행하면 결과적으로 최단 경로의 값들이 1씩 증가하는 형태로 변경된다.
 * 3) 최종 배열의 마지막 인덱스를 참조하여 해당 값을 출력한다.
 * */
class BFS_MazeExit {
    lateinit var queue : Queue<Array<Int>>
    fun solution(maps: Array<IntArray>): Int {
        val find = arrayOf(arrayOf(-1,0), arrayOf(1,0), arrayOf(0,-1), arrayOf(0,1)) // 상, 하, 좌, 우 움직일 때 인덱스 변경
        val visited = Array<Array<Boolean>>(maps.size){Array<Boolean>(maps[0].size){false} }

        return bfs(0,0,maps, find, visited)
    }

    private fun bfs(x: Int, y: Int, maps: Array<IntArray>, find: Array<Array<Int>>, visited: Array<Array<Boolean>>): Int {
        var xPos = x
        var yPos = y
        queue = LinkedList()
        queue.add(arrayOf(xPos,yPos))
        visited[xPos][yPos] = true // 방문 처리

        while (!queue.isEmpty()){
            val pop = queue.poll()
            xPos = pop[0]
            yPos = pop[1]

            // 현재 위치에서 네 방향으로 위치 확인
            for (i in 0 until 4){
                val nx = xPos + find[i][0]
                val ny = yPos + find[i][1]

                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || ny < 0 || nx >= maps.size || ny >= maps[0].size)
                    continue

                // 괴물이 있는 공간인 경우 무시
                if (maps[nx][ny] == 0)
                    continue

                // 해당 노드를 처음 방문하고 해당 구역이 지나갈 수 있는 공간이라면 큐에 추가
                if (maps[nx][ny] == 1 && !visited[nx][ny]){
                    maps[nx][ny] = maps[xPos][yPos] + 1
                    queue.add(arrayOf(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }

        return maps[maps.size -1][maps[0].size - 1] // 출구까지의 최단 거리 반환
    }
}

fun main() {
    val solution = BFS_MazeExit()
    println(
        solution.solution(
            arrayOf(
                intArrayOf(1,0,1,0,1,0),
                intArrayOf(1,1,1,1,1,1),
                intArrayOf(0,0,0,0,0,1),
                intArrayOf(1,1,1,1,1,1),
                intArrayOf(1,1,1,1,1,1)
            )
        )
    ) // 10
}