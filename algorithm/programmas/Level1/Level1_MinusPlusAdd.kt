/**
 * 음양 더하기
 *
 * 입출력 예 #1
 * signs가 [true,false,true] 이므로, 실제 수들의 값은 각각 4, -7, 12입니다.
 * 따라서 세 수의 합인 9를 return 해야 합니다.
 *
 * 입출력 예 #2
 * signs가 [false,false,true] 이므로, 실제 수들의 값은 각각 -1, -2, 3입니다.
 * 따라서 세 수의 합인 0을 return 해야 합니다.
 * */

class Level1_MinusPlusAdd {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int{
        var answer = 0

        for (i in 0 until signs.size){
            if (!signs[i]){
                answer += -1 * absolutes[i]
            } else answer += absolutes[i]
        }

        return answer
    }
}

fun main() {
    val solution = Level1_MinusPlusAdd()
    println(solution.solution(intArrayOf(4,7,12), booleanArrayOf(true,false,true)))
    println(solution.solution(intArrayOf(1,2,3), booleanArrayOf(false,false,true)))
}