package Level2

import kotlin.math.max

class Level2_Matches {
    fun solution(n: Int, a: Int, b: Int): Int {
        val groupList = mutableListOf<Array<Int>>()
        for (i in 1..n / 2) {
            groupList.add(arrayOf(2 * i - 1, i * 2))
        }

        val aGroupPos: Int
        val bGroupPos: Int
        if (a % 2 == 0) {
            val filter = groupList.filter { it.contentEquals(arrayOf(a-1, a)) }
            aGroupPos = groupList.indices.find({ i -> groupList[i].contentEquals(arrayOf(a-1, a)) })!!
            println()
        } else {
            aGroupPos = groupList.indexOf(arrayOf(a, a + 1))
        }

        if (b % 2 == 0) {
            bGroupPos = groupList.indexOf(arrayOf(b - 1, b))
        } else {
            bGroupPos = groupList.indexOf(arrayOf(b, b + 1))
        }

        var firstGroup = 1
        var lastGroup = n / 2
        var maxRound = 0
        var pow = n
        while (true){
           if (pow % 2 == 0){
               maxRound++
               pow /= 2
           } else break
        }

        while (true) {
            if (aGroupPos <= (firstGroup + lastGroup) / 2 && bGroupPos <= (firstGroup + lastGroup) / 2) {
                // 둘다 왼쪽에 위치 되어 있다면
                lastGroup /= 2
                maxRound--
            } else if (aGroupPos > (firstGroup + lastGroup) / 2 && bGroupPos > (firstGroup + lastGroup) / 2) {
                // 둘다 오른쪽에 위치되어 있다면
                firstGroup = lastGroup / 2 + 1
                maxRound--
            } else if (aGroupPos <= (firstGroup + lastGroup) / 2 && bGroupPos > (firstGroup + lastGroup) / 2){
                // 둘다 다른 그룹에 위치되어 있다면
                break
            }
        }

        return maxRound
    }
}

fun main() {
    val solution = Level2_Matches()

    println(solution.solution(8, 4, 7)) // 3
}