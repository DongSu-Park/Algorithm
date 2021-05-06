/**
 * 가장 큰 수 문제 풀이 (순열 방식, 테스트케이스 통과, 체점 실패)
 * => 해당 결과에서 테스트케이스는 통과가 되었지만 런타임 및 시간 초과 발생
 * => 테스트 케이스에서 numbers 배열의 개수가 엄청 많을 경우 재귀 함수를 여러 번 부르기 때문에 시간 초과 오류 발생
 * => 배열의 개수가 한정적인 경우 dfs를 이용한 순열을 구현하여 문제푸는 방식도 괜찮음
 * */

class Level2_CombinMax {
    val totalNum = mutableListOf<Int>()

    fun solution(numbers : IntArray): String{
        // dfs를 이용한 순열 구현
        val visited = Array(numbers.size){i -> false}
        val output = Array(numbers.size){i -> 0}

        permutation(numbers, output, visited, 0, numbers.size, numbers.size)

        val answer = totalNum.max().toString()
        totalNum.clear()
        return answer
    }

    private fun permutation(arr: IntArray, output: Array<Int>, visited: Array<Boolean>, depth: Int, n: Int, r: Int){
        if (depth == r) { // 모든 r개를 골랐으면
            var stringNum = ""
            for (i in 0 until r){
                stringNum += output[i].toString()
            }
            totalNum.add(Integer.parseInt(stringNum))
            return
        }

        for (i in 0 until n){
            if(visited[i] != true){ // 방문하지 않았으면
                visited[i] = true
                output[depth] = arr[i]
                permutation(arr, output, visited, depth + 1, n, r) // 깊이를 증가하여 재귀
                visited[i] = false
            }
        }
    }
}

fun main() {
    val solution = Level2_CombinMax()
    println(solution.solution(intArrayOf(6,2,10))) // 6210
    println(solution.solution(intArrayOf(3,30,34,5,9))) // 9534330
}