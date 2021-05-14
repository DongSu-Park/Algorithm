/**
 * Problems : Integer to Roman
 * Difficulty : Medium
 * Url : https://leetcode.com/problems/integer-to-roman/
 *
 * 문제 설명
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *  -> 주어진 숫자를 로마숫자로 변경하시오.
 *  -> 숫자 num은 1 <= num <= 3999임
 * */
class No12_IntegerToRoman {
    fun solution(num: Int): String{
        var answer = ""

        var number = num

        while (number > 0){
            when {
                number in 1000..3999 -> { // 1000의 자리
                    val count = number / 1000
                    for (i in 0 until count){
                        answer += 'M'
                    }
                    number %= 1000
                }

                number in 100..999 -> { // 100의 자리
                    var count = number / 100
                    when {
                        count == 9 -> {
                            answer += "CM"
                            number %= 100
                        }
                        count == 4 -> {
                            answer += "CD"
                            number %= 100
                        }
                        count < 4 -> {
                            for (i in 0 until count){
                                answer += 'C'
                            }
                            number %= 100
                        }
                        count in 5..8 -> {
                            answer += 'D'
                            count -= 5
                            for (i in 0 until count){
                                answer += 'C'
                            }
                            number %= 100
                        }
                    }
                }
                number in 10..99 -> { // 10의 자리
                    var count = number / 10
                    when{
                        count == 9 -> {
                            answer += "XC"
                            number %= 10
                        }

                        count == 4 -> {
                            answer += "XL"
                            number %= 10
                        }

                        count < 4 -> {
                            for (i in 0 until count){
                                answer += 'X'
                            }
                            number %= 10
                        }

                        count in 5..8 ->{
                            answer += 'L'
                            count -= 5
                            for (i in 0 until count){
                                answer += 'X'
                            }
                            number %= 10
                        }
                    }
                }
                number in 1..9 -> { // 1의 자리
                    var count = number

                    when {
                        count == 9 ->{
                            answer += "IX"
                            number = 0
                        }

                        count == 4 -> {
                            answer += "IV"
                            number = 0
                        }

                        count < 4 -> {
                            for (i in 0 until count){
                                answer += 'I'
                            }
                            number = 0
                        }

                        count in 5..8 ->{
                            answer += 'V'
                            count -= 5
                            for (i in 0 until count){
                                answer += 'I'
                            }
                            number = 0
                        }
                    }
                }
            }
        }

        return answer
    }
}

fun main() {
    val solution = No12_IntegerToRoman()
    println(solution.solution(3)) // III
    println(solution.solution(4)) // IV
    println(solution.solution(9)) // IX
    println(solution.solution(58)) // LVIII -> L = 50, V = 5, III = 3
    println(solution.solution(1994)) // MCMXCIV
}