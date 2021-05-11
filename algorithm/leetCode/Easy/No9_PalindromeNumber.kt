/**
 *
 * Problems : Palindrome Number
 * Difficulty : Easy
 * Url : https://leetcode.com/problems/palindrome-number/
 *
 * 문제 설명
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 *   -> 회문 번호라고 하는데 예를 들어 121 인 경우 거꾸로 해도 121 이므로 참이지만, -121이 거꾸로 하면 121-이므로 회문이 아님
 * */

class No9_PalindromeNumber {
    fun solution(x : Int): Boolean{
        val before = x.toString()
        val after = before.toList().reversed().joinToString(separator = "")

        return before == after
    }
}

fun main() {
    val solution = No9_PalindromeNumber()

    println(solution.solution(121)) // true
    println(solution.solution(-121)) // false
    println(solution.solution(10)) // false
    println(solution.solution(-101)) // false
}