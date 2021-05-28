/**
 * DFS 스택 과정 (재귀 방식)
 * 1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
 * 2. 스택의 최상단 노드에 방문하지 않은 인접노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다.
 *    방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
 * 3. 2번 과정을 더이상 수행할 수 없을 때까지 반복한다.
 * */
class DFSTutorial_Stack {
    fun dfsStack(){
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

        dfs(graph, 1, visited)
    }

    private fun dfs(graph: Array<Array<Int>>, v: Int, visited: Array<Boolean>) {
        // 현재 노드를 방문 처리하고 스택에 넣기 (여기선 출력)
        visited[v] = true
        print("$v ")

        for (i in 0 until graph[v].size){
            if (!visited[graph[v][i]]){ // 방문하지 않았으면 dfs 재귀
                dfs(graph, graph[v][i], visited)
            }
        }
    }
}

fun main() {
    val solution = DFSTutorial_Stack()
    solution.dfsStack()
}