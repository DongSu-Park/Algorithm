/**
 * Problems : String to Integer (atoi)
 * Difficulty : Medium
 * Url : https://leetcode.com/problems/string-to-integer-atoi/
 *
 * 문제 설명
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 *  1. Read in and ignore any leading whitespace.
 *  2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either.
 *      This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 *  3. Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 *  4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
 *      If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 *  5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range.
 *      Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 *  6. Return the integer as the final result.
 *   => atoi 알고리즘 처럼 프로그램을 만드시오. 단 32비트 정수열을 넘는 숫자인 경우 그 부호에 맞춰 32비트 정수의 최대값을 리턴하고,
 *      해당 문자열을 정수열로 변환 할 수 없는 경우 0으로 리턴하시오.
 * */

class No8_StrToIntSimilarAtoi {
    fun solution(s: String): Int{
        var answer = ""
        var isVoid = false
        var isNumberSign = false
        for (i in 0 until s.length){
            if (s[i] == ' '){
                // 공백인 경우 넘김
                if (isVoid){ // 만약 해당 공백 문자 들어온 시점이 부호 이후인 경우 정지
                    break
                }
            } else if ((s[i] == '-')||(s[i] == '+')){
                // 해당 글자가 부호인 경우 넣기
                if (isNumberSign){ // 만약 해당 부호 문자가 들어온 시점이 숫자 문자 이후인 경우 정지
                    break
                }
                answer += s[i]
                isVoid = true
            } else if (s[i] >= '0' && s[i] <= '9'){
                // 해당 글자가 숫자인 경우 이후의 문자가 공백이나 부호가 들어오면 정지해야 함
                answer += s[i]
                isVoid = true
                isNumberSign = true
            } else { // 숫자, 공백, 부호가 아닌 다른 문자열이 들어온 경우 그냥 정지
                break
            }
        }

        try {
            // 해당 숫자가 32비트 숫자를 넘은 경우 부호에 맞춰 32비트 정수의 최대값을 리턴
            if (answer.toDouble() > 2147483647){
                return 2147483647
            } else if (answer.toDouble() < -2147483648){
                return -2147483648
            }

            return Integer.parseInt(answer)
        } catch (e : NumberFormatException){
            // Integer 로 변환 할 수 없는 문자열만 남은 경우 Exception 발생되고 0으로 리턴
            return 0
        }
    }
}

fun main() {
    val solution = No8_StrToIntSimilarAtoi()

    println(solution.solution("42")) // 42
    println(solution.solution("   -42")) // -42
    println(solution.solution("4193 with words")) // 4193
    println(solution.solution("words and 987")) // 987
    println(solution.solution("+")) // 0
    println(solution.solution("-5-"))
}