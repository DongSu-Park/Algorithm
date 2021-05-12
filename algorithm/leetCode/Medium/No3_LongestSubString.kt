/**
 * Problems : Longest Substring Without Repeating Characters
 * Difficulty : Medium
 * Url : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 문제 설명
 * Given a string s, find the length of the longest substring without repeating characters.
 *  -> 문자열 s가 주어질 때 문자열에서 반복되는 문자가 없는 가장 긴 문자열 s의 길이를 리턴하시오
 *  -> 예를 들어 abcabcbb 문자열인 경우
 *      문자열에서 반복되는 문자가 없는 문자열은 "abc", "bca", "cab", "abc", "bc", "cb", "b", "b"가 나오는데
 *      여기서 가장 긴 문자열은 "abc", "bca", "cab", "abc" 이므로 문자열의 길이 3을 리턴
 * */


class No3_LongestSubString {
    fun solution(s: String): Int{
        val sizeList = mutableListOf<Int>()
        val stringList = s.toList()
        for (i in 0 until stringList.size){
            var temp = "${stringList[i]}"
            if (stringList.size == 1){
                sizeList.add(temp.length)
                break
            }

            for (j in i+1 until stringList.size){
                if (!temp.contains(stringList[j])){
                    temp += stringList[j]
                } else if (temp.contains(stringList[j])){
                    sizeList.add(temp.length)
                    break
                }
            }

            sizeList.add(temp.length)
        }

        return if (sizeList.isEmpty()){
            0
        } else {
            sizeList.max()!!
        }
    }
}

fun main() {
    val solution = No3_LongestSubString()

    println(solution.solution("abcabcbb")) // 3
    println(solution.solution("bbbbb")) // 1
    println(solution.solution("pwwkew")) // 3
    println(solution.solution("")) // 0
    println(solution.solution(" ")) // 1
    println(solution.solution("au")) // 2
}