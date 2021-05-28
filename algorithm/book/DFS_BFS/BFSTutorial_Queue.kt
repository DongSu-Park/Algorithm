import java.util.*

/**
 * BFS
 * - 너비 우선 탐색 방식
 * - 가까운 노드부터 탐색하는 알고리즘
 * - 큐 자료구조를 사용
 * 
 *  1) 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
 *  2) 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리
 *  3) 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
 * */
class BFSTutorial_Queue {
    lateinit var queue : Queue<Int>
    fun bfsQueue() {
        val graph = arrayOf(
            arrayOf(), // 노드 0
            arrayOf(2,3,8), // 노드 1
            arrayOf(1,7), // 노드 2
            arrayOf(1,4,5), // 노드 3
            arrayOf(3,5), // 노드 4
            arrayOf(3,4), // 노드 5
            arrayOf(7), // 노드 6
            arrayOf(2,6,8), // 노드 7
            arrayOf(1,7) // 노드 8
        )

        val visited = Array<Boolean>(9){false}

        bfs(graph, 1, visited)
    }

    private fun bfs(graph: Array<Array<Int>>, start: Int, visited: Array<Boolean>) {
        queue = LinkedList()
        queue.add(start) // 시작 노드(1)를 먼저 넣기
        visited[start] = true

        while (!queue.isEmpty()){ // 큐가 빌 때까지 반복
            val v = queue.poll() // 큐에서 하나의 원소를 뽑아 출력
            print("$v ")

            for (i in 0 until graph[v].size){
                if (!visited[graph[v][i]]){ // 방문하지 않았으면
                    queue.add(graph[v][i])
                    visited[graph[v][i]] = true
                }
            }
        }
    }
}

fun main() {
    val solution = BFSTutorial_Queue()
    solution.bfsQueue()
}