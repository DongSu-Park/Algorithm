/**
 * Problems : Roman to Integer
 * Difficulty : Easy
 * Url : https://leetcode.com/problems/roman-to-integer/
 *
 * 문제 설명
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Given a roman numeral, convert it to an integer.
 *  -> 로마 숫자 (String)을 일반 숫자형으로 변환하시오 (12번 문제와 반대의 상황)
 * */

class No13_RomanToInteger {
    fun solution(s: String): Int {
        var answer = 0
        val stringList = s.toList()

        var i = 0

        while (i < stringList.size) {
            when (stringList[i]) {
                'I' -> {
                    answer += 1
                    i++

                    if (i != stringList.size) {
                        if (stringList[i] == 'V') {
                            answer += 3
                            i++
                        } else if (stringList[i] == 'X') {
                            answer += 8
                            i++
                        }
                    }

                }

                'V' -> {
                    answer += 5
                    i++
                }

                'X' -> {
                    answer += 10
                    i++

                    if (i != stringList.size) {
                        if (stringList[i] == 'L') {
                            answer += 30
                            i++
                        } else if (stringList[i] == 'C') {
                            answer += 80
                            i++
                        }
                    }
                }

                'L' -> {
                    answer += 50
                    i++
                }

                'C' -> {
                    answer += 100
                    i++

                    if (i != stringList.size) {
                        if (stringList[i] == 'D') {
                            answer += 300
                            i++
                        } else if (stringList[i] == 'M') {
                            answer += 800
                            i++
                        }
                    }
                }

                'D' -> {
                    answer += 500
                    i++
                }

                'M' -> {
                    answer += 1000
                    i++
                }
            }
        }

        return answer
    }
}

fun main() {
    val solution = No13_RomanToInteger()

    println(solution.solution("III")) // 3
    println(solution.solution("IV")) // 4
    println(solution.solution("IX")) // 9
    println(solution.solution("LVIII")) // 58
}
