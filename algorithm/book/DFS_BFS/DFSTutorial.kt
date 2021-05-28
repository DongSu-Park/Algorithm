/**
 * DFS
 * - 깊이 우선 탐색이라고 부르며, 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
 * - 노드(Node)와 간선(Edge)로 표현되며 이때 노드를 정점(Vertex)이라고도 말함.
 * - 쉽게 말해 노드(원자) = 도시, 간선(선) = 도로
 *
 * DFS 그래프 표현 방식
 *  1) 인접 행렬 - 2차원 배열로 그래프의 연결관계를 표현하는 방식
 *  2) 인접 리스트 - 리스트로 그래프의 연결관계를 표현하는 방식
 *
 *  => 두 방식의 차이
 *      메모리 측면 : 인접 행렬 방식은 모든 관계를 저장 하므로 (null 까지) 노드 개수가 많을 수록 메모리가 불필요하게 낭비
 *                 인접 리스트 방식은 연결된 정보만을 이용해 사용하기 때문에 메모리를 효율적으로 사용
 *      속도 측면 : 인접 리스트 방식은 인접 행렬 방식에 비해 특정한 두 노드가 연결되어 있는지에 대한 정보를 얻는 속도가 느림
 *                (연결된 데이터를 하나씩 확인해야 하기 때문)
 *      즉 코테 제한사항에 대한 속도 측면에서는 인접 행렬, 메모리 측면에서는 인접 리스트를 사용하는게 좋음.
 * */
class DFSTutorial {
    fun dfsTutorialPrint(){
        // 노드는 총 3개 (0,1,2)로 구성되어 있으며, 간선은 (0-1 = 7), (0-2 = 5)로 표현되어 있음

        // 1) 인접 행렬 표현 방식
        val adjArray = Array<Array<Int?>>(3){Array<Int?>(3){null} }
        adjArray[0] = arrayOf(0,7,5)
        adjArray[1] = arrayOf(7,0,null)
        adjArray[2] = arrayOf(5, null, 0)

        for (i in 0 until adjArray.size){
            println(adjArray[i].toList())
        }

        // 2) 인접 리스트 표현 방식
        val linkedList = MutableList<MutableList<IntArray>>(3){ mutableListOf<IntArray>()}
        linkedList[0].add(intArrayOf(1,7)) // 0 -> 1(7)
        linkedList[0].add(intArrayOf(2,5)) // 0 -> 2(5)
        linkedList[1].add(intArrayOf(0,7)) // 1 -> 0(7)
        linkedList[2].add(intArrayOf(0,5)) // 2 -> 0(5)

        for (j in 0 until linkedList.size){
            for (k in 0 until linkedList[j].size){
                print(linkedList[j][k].toList())
            }
            println()
        }
    }
}

fun main() {
    val solution = DFSTutorial()
    solution.dfsTutorialPrint()
}