/**
 * 문제 1 - 모험가 길드 (그리디 문제)
 *
 * - 문제 설명
 * 모험가 길드에서는 N명의 모험가를 대상으로 '공포도'를 측정했는데 공포도가 높은 모험가는 쉽게 공포를 느껴 위험한 상황에 제대로 대처할 능력이 떨어진다.
 * 모험가 그룹을 안전하게 구성하고자 공포도 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있도록 규정했다.
 * 동빈이는 최대 몇개의 모험가 그룹을 만들 수 있는지 출력하시오.
 *
 * - 핵심 문장
 *  1. 공포도 X인 모험가는 반드시 X명 이상으로 구성해야 함. (그룹 조건)
 *  2. 최대 몇개의 모험가 그룹을 만들수 있는가? (해당 리스트 중에 조건에 맞지 않아 포함되지 않는 인원도 있을 수 있음)
 *
 * */
class Q1_Greedy {
    fun solution(nums: IntArray): Int{
        val list = nums.toList().sorted()
        var result = 0
        var count = 0

        for (i in 0 until list.size){
            count++ // 그룹내 인원 추가
            if (count >= i){ // 그룹내 인원이 해당 모험가의 공포도 지수보다 같거나 높을 경우
                result++ // 그룹 증가
                count = 0 // 인원 카운트 초기화
            }
        }
        
        return result
    }
}

fun main() {
    val solution = Q1_Greedy()
    println(solution.solution(intArrayOf(2,3,1,2,2)))
}