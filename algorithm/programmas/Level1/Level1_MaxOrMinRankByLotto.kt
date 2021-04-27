/**
 * 로또의 최고 순위와 최저 순위 (2021 상반기 데브 매칭 : 웹 백엔드 개발자)
 * */
class Level1_MaxOrMinRankByLotto {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray{
        var unknownNum = 0 // 알수 없는 번호의 개수 (0)
        var containNum = 0 // 로또 번호와 일치한 개수
        for (i in 0 until lottos.size){
           if (lottos[i] == 0){
               unknownNum++
           } else if (win_nums.contains(lottos[i])){
               containNum++
           }
        }

        val rankList = intArrayOf(containNum + unknownNum, containNum) // 최대 순위, 최소 순위 변경 전

        for (i in 0 until rankList.size){
            when(rankList[i]){
                6 -> rankList[i] = 1
                5 -> rankList[i] = 2
                4 -> rankList[i] = 3
                3 -> rankList[i] = 4
                2 -> rankList[i] = 5
                else -> rankList[i] = 6
            }
        }

        return rankList
    }
}

fun main() {
    val solution = Level1_MaxOrMinRankByLotto()

    println(solution.solution(intArrayOf(44,1,0,0,31,25), intArrayOf(31,10,45,1,6,9)).toList()) // [3,5]
    println(solution.solution(intArrayOf(0,0,0,0,0,0), intArrayOf(38,19,20,40,15,25)).toList()) // [1,6]
    println(solution.solution(intArrayOf(45,4,35,20,3,9), intArrayOf(20,9,3,45,4,35)).toList()) // [1,1]
}