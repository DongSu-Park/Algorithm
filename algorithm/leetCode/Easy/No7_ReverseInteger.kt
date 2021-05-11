import kotlin.math.pow

/**
 * Problems : Reverse Integer
 * Difficulty : Easy
 * Url : https://leetcode.com/problems/reverse-integer/
 *
 * 문제 설명
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *  -> 32비트 정수가 주어졌을 때 해당 정수를 뒤집어서 표현하시오
 *     예를 들어 123 인 경우 321, -123 인경우 -321
 *     단 결과물이 32bit 정수를 넘는다면 0으로 리턴하시오 (32Bit 경계: -231 <= x <= 231 - 1)
 * */

class No7_ReverseInteger {
    fun solution(x: Int): Int{
        var num = x.toLong()
        var isNumMinus = false

        if (num < 0){
            num *= -1
            isNumMinus = true
        }

        var numCheck = num.toString().toList().reversed().joinToString(separator = "").toLong()

        if (isNumMinus){
            numCheck *= -1
        }
 
        if ((numCheck >= ((2.0).pow(31) - 1).toLong()) || (numCheck <= (((2.0).pow(31) * - 1).toLong()))){
            return 0
        } else {
            return numCheck.toInt()
        }
    }
}

fun main() {
    val solution = No7_ReverseInteger()

    println(solution.solution(1534236469))
    println(solution.solution(123))
    println(solution.solution(-123))
    println(solution.solution(120))
    println(solution.solution(0))
    println(solution.solution(-2147483648))
}