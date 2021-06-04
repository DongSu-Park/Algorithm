/**
 * 다리를 지나는 트럭 (스택/큐 연습 문제)
 *
 * - 문제 설명
 * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
 * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
 *
 * 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
 * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 * ## 참고 : https://programmers.co.kr/learn/courses/30/lessons/42583
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 *
 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 * */
class Level2_Truck {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        // 1) 변수 지정
        val runCount = bridge_length
        val waitingStack = mutableListOf<IntArray>()
        val runningStack = mutableListOf<IntArray>()
        val doneStack = mutableListOf<Int>()
        for (i in 0 until truck_weights.size){
            waitingStack.add(intArrayOf(truck_weights[i], 0))
        }

        // 2) 다리 건너기
        var allTimeCount = 0
        while (true){
            // 현재 시간 증가
            allTimeCount++

            // 건너고 있는 스택에 있는 트럭의 시간을 증가
            if (runningStack.isNotEmpty()){
                for (i in 0 until runningStack.size){
                    runningStack[i][1]++ // 건너는 시간 증가
                }
            }

            // 모두 건넌 트럭을 스택에서 제거
            val isDone = runningStack.filter { it[1] > runCount }
            if (isDone.isNotEmpty()){ // 존재하면
                for (i in 0 until isDone.size){
                    doneStack.add(isDone[i][0])
                    runningStack.remove(isDone[i])
                }
            }

            // 다 건넌경우 루프 종료
            if (doneStack.size == truck_weights.size){
                break
            }

            // 스택 쌓기
            if (runningStack.isEmpty()){
                // 건너는 스택이 비여 있는 경우
                runningStack.add(intArrayOf(waitingStack[0][0], waitingStack[0][1] + 1))
                waitingStack.removeAt(0)
            } else if (runningStack.isNotEmpty() && waitingStack.isNotEmpty() &&
                runningStack.sumBy { it[0] } + waitingStack[0][0] <= weight){
                // 건너고 있는 트럭 스택의 무게 전체 합과 기다리고 있는 스택의 맨 앞의 트럭 무게를 합한 것이 다리의 weight 보다 작은 경우
                runningStack.add(intArrayOf(waitingStack[0][0], waitingStack[0][1] + 1))
                waitingStack.removeAt(0)
            }
        }


        return allTimeCount
    }
}

fun main() {
    val solution = Level2_Truck()

    println(solution.solution(2,10, intArrayOf(7,4,5,6))) // 8
    println(solution.solution(100,100, intArrayOf(10))) // 101
    println(solution.solution(100,100, intArrayOf(10,10,10,10,10,10,10,10,10,10))) // 110
}