/**
 * 키패드 누르기 (2020 카카오 인턴십)
 *
 * 이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
 * 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
 *
 * 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
 * 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
 * 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
 * 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
 *  4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
 *
 * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
 * 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers 배열의 크기는 1 이상 1,000 이하입니다.
 * numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
 * hand는 "left" 또는 "right" 입니다.
 * "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
 * 왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
 *
 * 입출력 예
 * numbers	                             hand	    result
 * [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
 * [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	    "right"	"LLRLLRLLRL"
 * */


class Level1_PushKeyPad {
    // 초기값 변수 및 상수 설정
    var leftHandPos = "*"
    var rightHandPos = "#"
    var myHand = ""
    val answerArr = arrayListOf<String>()

    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        myHand = hand // 오른손 또는 왼손 잡이 설정

        val keyPosition = HashMap<String, IntArray>().apply { // 해당 키에 대한 포지션 설정
            put("1", intArrayOf(0,0))
            put("2", intArrayOf(0,1))
            put("3", intArrayOf(0,2))
            put("4", intArrayOf(1,0))
            put("5", intArrayOf(1,1))
            put("6", intArrayOf(1,2))
            put("7", intArrayOf(2,0))
            put("8", intArrayOf(2,1))
            put("9", intArrayOf(2,2))
            put("*", intArrayOf(3,0))
            put("0", intArrayOf(3,1))
            put("#", intArrayOf(3,2))
        }


        for (i in 0 until numbers.size){ // 예시로 하면 size는 11
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ){ // 왼손을 누르는 것이면
                answerArr.add("L")
                leftHandPos = numbers[i].toString()
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){ // 오른손을 누르는 것이면
                answerArr.add("R")
                rightHandPos = numbers[i].toString()
            } else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0){ // 오른손과 왼손의 차이 계산
                when (numbers[i]){
                    2 -> subKeyPosition(numbers[i], keyPosition[leftHandPos], keyPosition[rightHandPos], keyPosition[numbers[i].toString()])
                    5 -> subKeyPosition(numbers[i], keyPosition[leftHandPos], keyPosition[rightHandPos], keyPosition[numbers[i].toString()])
                    8 -> subKeyPosition(numbers[i], keyPosition[leftHandPos], keyPosition[rightHandPos], keyPosition[numbers[i].toString()])
                    0 -> subKeyPosition(numbers[i], keyPosition[leftHandPos], keyPosition[rightHandPos], keyPosition[numbers[i].toString()])
                }
            }
        }

        answer = answerArr.joinToString(separator = "") // 리스트를 String으로 변환

        return answer
    }

    fun subKeyPosition(number: Int, leftPos: IntArray?, rightPos: IntArray?, inputPos: IntArray?){
        val leftValueX = leftPos?.get(0) // 왼손 위치 버튼의 x 포지션
        val leftValueY = leftPos?.get(1) // 왼손 위치 버튼의 y 포지션
        val rightValueX = rightPos?.get(0) // 오른손 위치 버튼의 x 포지션
        val rightValueY = rightPos?.get(1) // 오른손 위치 버튼의 y 포지션

        val inputValueX = inputPos?.get(0) // 눌러야 할 버튼 위치의 x 포지션
        val inputValueY = inputPos?.get(1) // 눌러야 할 버튼 위치의 y 포지션

        // 계산 변수 초기화
        var leftDiff = 0
        var rightDiff = 0
        var leftDiffX = 0
        var leftDiffY = 0
        var rightDiffX = 0
        var rightDiffY = 0

        // 눌러야 할 번호 위치와 왼손 위치의 차이 값 계신
        leftDiffX = if (inputValueX!! - leftValueX!! >= 0){
            inputValueX - leftValueX
        } else {
            leftValueX - inputValueX
        }

        leftDiffY = if (inputValueY!! - leftValueY!! >= 0){
            inputValueY - leftValueY
        } else {
            leftValueY - inputValueY
        }
        leftDiff = leftDiffX + leftDiffY

        // 눌러야 할 번호 위치와 오른손 위치의 차이 값 계산
        rightDiffX = if (inputValueX - rightValueX!! >= 0){
            inputValueX - rightValueX
        } else {
            rightValueX - inputValueX
        }

        rightDiffY = if (inputValueY - rightValueY!! >= 0){
            inputValueY - rightValueY
        } else {
            rightValueY - inputValueY
        }
        rightDiff = rightDiffX + rightDiffY

        // 차이값에 대한 결과 계산하여 배열에 추가
        if (leftDiff > rightDiff){
            answerArr.add("R")
            rightHandPos = number.toString()
        } else if (rightDiff > leftDiff){
            answerArr.add("L")
            leftHandPos = number.toString()
        } else { // 왼손과 오른손의 위치차이가 같을 경우
            when (myHand){ // 오른손 잡이와 왼손잡이를 확인하여 배열에 추가
                "left" -> {
                    answerArr.add("L")
                    leftHandPos = number.toString()
                }
                "right" -> {
                    answerArr.add("R")
                    rightHandPos = number.toString()
                }
            }
        }
    }
}

fun main() {
    val solution = Level1_PushKeyPad()
    val inputNumber = intArrayOf(1,2,3,4,5,6,7,8,9,0)
    val inputHand = "right"

    println(solution.solution(inputNumber, inputHand))
}