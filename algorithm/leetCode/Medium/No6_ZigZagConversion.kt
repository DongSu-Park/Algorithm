/**
 * Problems : ZigZag Conversion
 * Difficulty : Medium
 * Url : https://leetcode.com/problems/zigzag-conversion/
 *
 * 문제 설명
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *      P   A   H   N
 *      A P L S I I G
 *      Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *  -> 문자열이 주어지고 numRows 정수가 주어질 때 지그제그 형식의 문자열을 만들고 배열을 순환참조하여 문자열을 만드시오
 * */

class No6_ZigZagConversion {
    fun solution(s: String, numRows: Int): String{
        var answer = ""
        // 1) 배열의 열의 개수를 구함 (대각선이 있을 경우 한정)
        val diagonalLine = numRows - 2 // 만약 numRow가 2이상 이면 대각선일때 해당 행에 단독으로 쓰이는 개수
        var stringSizeCheck = s.length
        var columnSize = 0

        if (numRows > 2){
            while (stringSizeCheck != 0){
                stringSizeCheck -= numRows

                // 하단으로 내려가는 열의 개수 체크
                if (stringSizeCheck > 0){
                    columnSize++
                } else { // 남은 글자수가 같거나 작다면
                    columnSize++
                    break
                }

                // 대각선으로 가는 열의 개수 체크
                if (stringSizeCheck > diagonalLine){
                    stringSizeCheck -= diagonalLine
                    columnSize += diagonalLine
                } else {
                    columnSize += stringSizeCheck
                    break
                }
            }
        }


        // 2) 이중 배열 초기화
        val zigzagArray : Array<CharArray>
        if (numRows > 2){ // 대각선 입력시 단독 열이 생길 수 있는 경우
            zigzagArray = Array<CharArray>(numRows, {CharArray(columnSize)})
        } else { // 대각선 입력시 단독 열이 생길수 없는 경우
            zigzagArray = Array<CharArray>(numRows, {CharArray((s.length / numRows) + (s.length % numRows))})
        }

        // 3) 배열에 넣기 (대각선 넣을 때는 numRows가 2 이상)
        var count = numRows - 1
        var addCount = 0
        var isDiagonalMode = false

        if (numRows > 2){ // 대각선에 넣을 때 열에 단독으로 글자가 들어가는 경우
            zigzagArray[0][0] = s[0] // 무조건 첫 글자는 (0,0)에
            addCount++
            var posX = 0
            var posY = 0

            if (s.length != addCount){
                while (true){
                    if (s.length == addCount){
                        break
                    }

                    while (!isDiagonalMode){ // 행에 넣기 시작
                        posX++
                        zigzagArray[posX][posY] = s[addCount]
                        addCount++
                        count--

                        if (s.length == addCount){
                            break
                        }

                        if (count == 0){
                            count = numRows - 1
                            isDiagonalMode = true
                            break
                        }
                    }

                    while (isDiagonalMode){
                        posX--
                        posY++
                        zigzagArray[posX][posY] = s[addCount]
                        addCount++
                        count--

                        if (s.length == addCount){
                            break
                        }

                        if (count == 0){
                            count = numRows - 1
                            isDiagonalMode = false
                            break
                        }
                    }
                }

            }

        } else if (numRows == 2){ // 대각선에 넣을 때 열에 단독으로 넣을 수 없는 구조인 경우
            for (i in 0 until zigzagArray[0].size){
                for (j in 0 until zigzagArray.size){
                    if (s.length != addCount){
                        zigzagArray[j][i] = s[addCount]
                        addCount++
                    }
                }
            }
        } else if (numRows == 1){ // 대각선 자체가 없는 상황인 경우
            return s
        }

        // 4) 문자열 출력
        for (i in 0 until zigzagArray.size){
            for (j in 0 until zigzagArray[0].size){
                if (zigzagArray[i][j] != '\u0000'){
                    answer += zigzagArray[i][j]
                }
            }
        }

        return answer
    }
}

fun main() {
    val solution = No6_ZigZagConversion()
    println(solution.solution("PAYPALISHIRING", 3)) // "PAHNAPLSIIGYIR"
    println(solution.solution("PAYPALISHIRING", 4)) // "PINALSIGYAHRPI"
    println(solution.solution("A", 1)) // "A"
}