/**
 * Problems : Longest Palindromic Substring
 * Difficulty : Medium
 * Url : https://leetcode.com/problems/longest-palindromic-substring/
 *
 * 문제 설명
 * Given a string s, return the longest palindromic substring in s.
 *  -> 문자열 s가 주어질 때 문자열 안에서 나올 수 있는 회문 중 가장 길이가 큰 회문 문자열을 리턴하시오
 *      단 길이가 큰 회문이 여러 개 인 경우 (ex. 나올 수 있는 최대의 길이는 3이지만 문자열은 aba, bab가 나올 수 있음)
 *      어느 한 회문 문자열을 리턴해도 상관 없음 (aba, bab 중 하나를 리턴해도 정답으로 인정)
 * */
class No5_LongestPalindromicSubString {
    fun solution(s : String): String{
        val stringList = s.toList()

        val answerList = mutableListOf<String>()

        if (stringList.size > 1){
            var findSize = stringList.size
            var findMax = false

            // 리스트에 넣기
            while (findSize > 0){
                for (i in 0 until stringList.size - findSize + 1){
                    val temp = s.substring(i, i + findSize)

                    if (temp == temp.toList().reversed().joinToString(separator = "")){
                        if (answerList.isEmpty()){
                            answerList.add(temp)
                        } else {
                            if (answerList[0].length > temp.length){
                                findMax = true
                                break
                            }
                        }
                    }
                }
                if (findMax){
                    break
                } else {
                    findSize--
                }
            }

        } else if (stringList.size == 1){
            answerList.add(stringList[0].toString())
        }

        return if (answerList.isNotEmpty()){
            answerList[0]
        } else {
            ""
        }
    }

}

fun main() {
    val solution = No5_LongestPalindromicSubString()

    println(solution.solution("babad")) // bab
    println(solution.solution("cbbd")) // bb
    println(solution.solution("a")) // a
    println(solution.solution("ac")) // a
    println(solution.solution("ccc")) // ccc
    println(solution.solution("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"))
}