/**
 * 행렬 테두리 회전하기 (2021 데브 매칭 - 웹 백엔드 개발자 상반기)
 *
 * 문제 설명
 * rows x columns 크기인 행렬이 있습니다. 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다.
 * 이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다.
 * 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.
 *  - x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
 *
 * 행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가 주어질 때,
 * 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 테스트 케이스 예시 : https://programmers.co.kr/learn/courses/30/lessons/77485
 * */

class Level2_ArraySideRotate {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray{
        // 행렬 만들기
        val array = Array<Array<Int>>(rows){Array<Int>(columns){it -> it} }
        var num = 1
        for (i in 0 until array.size){
            for (j in 0 until array[i].size){
                array[i][j] = num
                num++
            }
        }

        // 회전
        var answerList = mutableListOf<Int>()
        val stackList = mutableListOf<Int>()
        for (i in 0 until queries.size){
            val rowsStart = queries[i][0] - 1 // 열 꼭지점 처음 1
            val rowsEnd = queries[i][2] - 1 // 열 꼭지점 마지막 4
            val columnsStart = queries[i][1] - 1 // 행 꼭지점 처음 1
            val columnsEnd = queries[i][3] - 1 // 행 꼭지점 마지막 3


            // 회전 하기 전 리스트에 먼저 저장 하고 해당 배열에 0 값을 넣기
            // 22 -> 23 -> 24 -> 34 -> 44 -> 54 -> 53 -> 52 -> 42 -> 32
            // 11 -> 12 -> 13 -> 23 -> 33 -> 43 -> 42 -> 41 -> 31 -> 21 (행렬)
            var rotateRows = rowsStart // 1
            var rotateColumns = columnsStart // 1

            // 첫번째만 먼저 추가
            stackList.add(array[rotateRows][rotateColumns]) // 스택 리스트에 추가
            array[rotateRows][rotateColumns] = 0

            var mode = "upColumns" // upColumns, upRows, downColumns, downRows

            loop@ while (true){
                if (rotateRows == rowsStart && rotateColumns == columnsEnd){ // 1시 꼭지점으로 이동되었을 경우
                    mode = "upRows"
                } else if (rotateRows == rowsEnd && rotateColumns == columnsEnd){ // 5시 꼭지점으로 이동되었을 경우
                    mode = "downColumns"
                } else if (rotateRows == rowsEnd && rotateColumns == columnsStart){ // 7시 꼭지점으로 이동되었을 경우
                    mode = "downRows"
                } else if (rotateRows == rowsStart && rotateColumns == columnsStart){ // 11시 꼭지점으로 이동되었을 경우 (첫 부분으로 이동)
                    mode = "upColumns"
                }

                when(mode){
                    "upColumns" ->{
                        rotateColumns++
                        stackList.add(array[rotateRows][rotateColumns])
                        array[rotateRows][rotateColumns] = 0

                        // 해당 위치에 스택의 마지막 이전꺼 추가
                        array[rotateRows][rotateColumns] = stackList[stackList.lastIndex - 1]
                    }

                    "upRows" -> {
                        rotateRows++
                        stackList.add(array[rotateRows][rotateColumns])
                        array[rotateRows][rotateColumns] = 0

                        // 해당 위치에 스택의 마지막 이전꺼 추가
                        array[rotateRows][rotateColumns] = stackList[stackList.lastIndex - 1]
                    }

                    "downColumns" -> {
                        rotateColumns--

                        stackList.add(array[rotateRows][rotateColumns])
                        array[rotateRows][rotateColumns] = 0

                        // 해당 위치에 스택의 마지막 이전꺼 추가
                        array[rotateRows][rotateColumns] = stackList[stackList.lastIndex -1]
                    }

                    "downRows" -> {
                        rotateRows--

                        if (rotateRows == rowsStart && rotateColumns == columnsStart){
                            // 맨 처음으로 이동 됬을 경우 스택의 맨 마지막꺼만 추가하고 break
                            array[rotateRows][rotateColumns] = stackList[stackList.lastIndex]
                            answerList.add(stackList.min()!!) // answerList에 스택에 있는 것 중 가장 작은 숫자 넣기
                            stackList.clear()
                            break@loop
                        }

                        stackList.add(array[rotateRows][rotateColumns])
                        array[rotateRows][rotateColumns] = 0

                        // 해당 위치에 스택의 마지막 이전꺼 추가
                        array[rotateRows][rotateColumns] = stackList[stackList.lastIndex -1]
                    }
                }
            }
        }


        return answerList.toIntArray()
    }
}

fun main() {
    val solution = Level2_ArraySideRotate()

    println(solution.solution(6,6, arrayOf(intArrayOf(2,2,5,4), intArrayOf(3,3,6,6), intArrayOf(5,1,6,3))).toList()) // [8,10,25]
    println(solution.solution(3,3, arrayOf(intArrayOf(1,1,2,2), intArrayOf(1,2,2,3), intArrayOf(2,1,3,2), intArrayOf(2,2,3,3))).toList()) // [1,1,5,3]
    println(solution.solution(100, 97, arrayOf(intArrayOf(1,1,100,97))).toList()) // [1]
}