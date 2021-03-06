/**
 * 타겟 넘버 (DFS/BFS 우선탐색 연습문제)
 *
 * 문제 설명
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *  -1+1+1+1+1 = 3
 *  +1-1+1+1+1 = 3
 *  +1+1-1+1+1 = 3
 *  +1+1+1-1+1 = 3
 *  +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 * */
class Level2_TargetNum {
    fun solution(numbers: IntArray, target: Int): Int{
        val firstAdd = bfs(numbers, target, numbers[0], 1)
        val firstMinus = bfs(numbers, target, -numbers[0], 1)

        return firstAdd + firstMinus
    }

    private fun bfs(numbers: IntArray, target: Int, num: Int, depth: Int): Int{
        if (depth == numbers.size){
            if (num == target) return 1
            else return 0
        }

        var result = 0
        result += bfs(numbers, target, num+numbers[depth], depth + 1)
        result += bfs(numbers, target, num-numbers[depth], depth + 1)
        return result
    }
}

fun main() {
    val solution = Level2_TargetNum()
    println(solution.solution(intArrayOf(1,1,1,1,1), 3)) // 5
}