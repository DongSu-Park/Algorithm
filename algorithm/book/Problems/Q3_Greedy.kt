/**
 * 문제 3 - 문자열 뒤집기 (그리디 문제, 백준 기출 문제 1439)
 *
 * 문제 설명
 *  다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다.
 *  다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다.
 *  뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
 *  예를 들어 S=0001100 일 때, 전체를 뒤집으면 1110011이 된다.
 *  4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
 *  하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
 *  문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.
 *
 * 풀이 과정
 *  - 연속된 하나 이상의 숫자를 잡는다는것은 0끼리 묶인 문자와 1끼리 묶인 문자를 각각 그룹핑해서 리스트로 만들어야 함.
 *  - 0이 포함된 그룹핑 문자열과 1이 포함된 그룹핑 문자열을 각각 몇개인지 비교하여 가장 작은 문자열 그룹핑을 가진 개수를 리턴 함.
 * */
class Q3_Greedy {
    fun solution(nums : String): Int{
        var mode = nums[0]
        var group = "${nums[0]}"
        val groupList = mutableListOf<String>()

        for (i in 1 until nums.length){
            if (mode != nums[i]){ // 다른 숫자가 온 경우
                mode = nums[i]
                groupList.add(group)
                group = "${nums[i]}"
            } else {
                group += nums[i]
            }

            if (i == nums.length - 1){
                groupList.add(group)
                break
            }
        }
        val filterZero = groupList.filter { it.contains('0') } // 0으로 묶인 문자열 필터
        val filterOne = groupList.filter { it.contains('1') } // 1로 묶인 문자열 필터

        // 필터된 문자열 그룹핑 중 개수가 작은 곳을 리턴
        if (filterZero.size > filterOne.size) {
            return filterOne.size
        } else return filterZero.size
    }
}

fun main() {
    val solution = Q3_Greedy()
    println(solution.solution("0001100")) // 1
    println(solution.solution("1011001")) // 2
}