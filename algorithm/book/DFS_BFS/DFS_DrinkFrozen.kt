/**
 * 음료수 얼려 먹기 (DFS 활용 문제)
 *
 * 문제 설명
 * N X M 크기의 얼음 틀이 있다.
 * 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
 * 구멍이 뚫려 있는 부분끼리 상,하,좌,우로 붙혀있는 경우 서로 연결되어 있는 것으로 간주한다.
 * 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
 *
 * */
class DFS_DrinkFrozen {
    fun solution (map: Array<IntArray>): Int{
        var answer = 0
        val visited = Array<Array<Boolean>>(map.size){Array<Boolean>(map[0].size){false} }

        // 2차원 리스트의 맵 정보 입력 받기
        for (i in 0 until map.size){
            for (j in 0 until map[i].size){
                if (dfs(i, j, visited, map)){
                    answer++
                }
            }
        }
        
        return answer
    }

    private fun dfs(x: Int, y: Int, visited: Array<Array<Boolean>>, map: Array<IntArray>): Boolean {
        // 주어진 범위를 벗어나는 경우 즉시 종료
        if (x <= -1 || x >= map.size || y <= -1 || y >= map[0].size)
            return false

        // 현재 노드를 아직 방문하지 않았고, 해당 지점이 비여 있다면
        if (!visited[x][y] && map[x][y] == 0){
            visited[x][y] = true

            // 상하좌우를 재귀 처리
            dfs(x - 1, y, visited, map) // 상
            dfs(x + 1, y, visited, map) // 하
            dfs(x, y - 1, visited, map) // 좌
            dfs(x, y + 1, visited, map) // 우
            return true
        }
        return false
    }

}

fun main() {
    val solution = DFS_DrinkFrozen()
    println(solution.solution(arrayOf(intArrayOf(0,0,1), intArrayOf(0,1,0), intArrayOf(1,0,1))))

}