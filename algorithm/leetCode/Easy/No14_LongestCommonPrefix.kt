/**
 * Problems : Longest Common Prefix
 * Difficulty : Easy
 * Url : https://leetcode.com/problems/longest-common-prefix/
 *
 * 문제 설명
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *  -> 문자열 배열 중에 가장 긴 공통의 접두사 문자열을 리턴하시오
 *      만약 아무것도 없다면 빈 문자열을 리턴하시오.
 * */
class No14_LongestCommonPrefix {
    fun solution(strs: Array<String>): String {
        val strsList = strs.toList()

        var answer = ""
        var lastPos = strsList[0].length
        var isContain = true

        // 접두어 중 길이가 가장 작은 단어의 마지막 포지션을 갱신
        for (i in 1 until strsList.size){
            if (lastPos >= strsList[i].length){
                lastPos = strsList[i].length
            }
        }

        // 모든 배열의 한정된 접두어끼리 비교햐여 다 같다면 answer에 갱신
        // 기준이 되는 배열은 첫번째 배열 문자
        // (ex. lastPos = 4 -> 0~1, 0~2, 0~3, 0~4 까지 substring으로 문자열을 자르고 모든 배열하고 비교)
        var pos = 1
        while (pos <= lastPos){
            for (i in 1 until strsList.size){
                if (strsList[0].substring(0, pos) != strsList[i].substring(0, pos)){
                    isContain = false
                }
            }

            if (!isContain){
                break
            } else{
                answer = strsList[0].substring(0, pos)
            }

            pos++
        }


        return answer
    }
}

fun main() {
    val solution = No14_LongestCommonPrefix()

    println(solution.solution(arrayOf("flower", "flow", "flight"))) // "fl"
    println(solution.solution(arrayOf("dog", "racecar", "car"))) // ""
    println(solution.solution(arrayOf("aaa","aa","aaa"))) // "aa"

}