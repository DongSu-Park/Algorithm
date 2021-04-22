/**
 * 수식 최대화 (2020 카카오 인턴십 문제)
 *
 * 문제 설명
 * IT 벤처 회사를 운영하고 있는 라이언은 매년 사내 해커톤 대회를 개최하여 우승자에게 상금을 지급하고 있습니다.
 * 이번 대회에서는 우승자에게 지급되는 상금을 이전 대회와는 다르게 다음과 같은 방식으로 결정하려고 합니다.
 * 해커톤 대회에 참가하는 모든 참가자들에게는 숫자들과 3가지의 연산문자(+, -, *) 만으로 이루어진 연산 수식이 전달되며,
 * 참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출하는 것입니다.
 * 단, 연산자의 우선순위를 새로 정의할 때, 같은 순위의 연산자는 없어야 합니다.
 * 즉, + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,-처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
 * 수식에 포함된 연산자가 2개라면 정의할 수 있는 연산자 우선순위 조합은 2! = 2가지이며, 연산자가 3개라면 3! = 6가지 조합이 가능합니다.
 * 만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출하며 제출한 숫자가 가장 큰 참가자를 우승자로 선정하며, 우승자가 제출한 숫자를 우승상금으로 지급하게 됩니다.
 *
 * 예를 들어, 참가자 중 네오가 아래와 같은 수식을 전달받았다고 가정합니다.
 *  "100-200*300-500+20"
 * 일반적으로 수학 및 전산학에서 약속된 연산자 우선순위에 따르면 더하기와 빼기는 서로 동등하며 곱하기는 더하기, 빼기에 비해 우선순위가 높아 * > +,- 로 우선순위가 정의되어 있습니다.
 * 대회 규칙에 따라 + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,- 처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
 * 수식에 연산자가 3개 주어졌으므로 가능한 연산자 우선순위 조합은 3! = 6가지이며, 그 중 + > - > * 로 연산자 우선순위를 정한다면 결괏값은 22,000원이 됩니다.
 * 반면에 * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60,420 이지만, 규칙에 따라 우승 시 상금은 절댓값인 60,420원이 됩니다.
 * 참가자에게 주어진 연산 수식이 담긴 문자열 expression이 매개변수로 주어질 때, 우승 시 받을 수 있는 가장 큰 상금 금액을 return 하도록 solution 함수를 완성해주세요.
 *
 * 문제 해결 과정 중 테스트 케이스 오류 사항
 * 1) 입력한 숫자가 Long형 일 수 있으니 처음부터 숫자와 연산자를 나눌 때 자료형을 Long형으로 맞춰야 함.
 * 2) 갱신이 되고 나서 처리한 연산자와 숫자를 삭제해주고 while 연산자의 증감 연산의 배열 위치도 -1을 해줘야 함.
 *
 * */

class Level2_NumMax {
    fun solution(expression: String): Long {
        // 숫자와 연산자를 따로 저장
        val numberList = mutableListOf<Long>()
        val exOperatorList = mutableListOf<String>()
        var num = ""
        for (i in 0 until expression.length){
            if (expression[i] !in '0'..'9'){
                numberList.add(num.toLong()) // 숫자를 숫자 리스트에 저장 (순서대로)
                exOperatorList.add(expression[i].toString()) // 연산자를 연산자 리스트에 저장 (순서대로)
                num = ""
            } else {
                num += expression[i]
            }

            if (i == expression.length - 1){ // 문자열의 끝에 도달
                numberList.add(num.toLong())
            }
        }

        val allOperatorList = arrayListOf<String>("123","132","213","231","312","321") // 연산자의 경우의 수 6개 (-+*, +-*, *-+ ...)
        val answerList = mutableListOf<Long>() // 모든 연산자 경우의 수를 숫자 연산한 값 리스트

        // 완전 탐색
        for(i in 0 until allOperatorList.size){
            val targetNumList = numberList.toMutableList() // 반복 할 때마다 계속 갱신 (숫자 순서 리스트)
            val targetExOperList = exOperatorList.toMutableList() // 반복 할 때마다 계속 갱신 (연산자 순서 리스트)

            for (j in 0 until allOperatorList[i].length){
                when(allOperatorList[i][j]){ // ex. 1, 2, 3 -> - > + > *
                    '1' -> { // -
                        var k = 0
                        while (k < targetExOperList.size){
                            if (targetExOperList[k] == "-"){
                                targetNumList[k] = targetNumList[k] - targetNumList[k+1] // 갱신
                                targetNumList.removeAt(k+1) // 숫자 지우기
                                targetExOperList.removeAt(k) // 계산식 지우기
                                k-- // 지웠으니 1번 되돌아 가야함.
                            }
                            k++
                        }
                    }
                    '2' -> { // +
                        var k = 0
                        while (k < targetExOperList.size){
                            if (targetExOperList[k] == "+"){
                                targetNumList[k] = targetNumList[k] + targetNumList[k+1] // 갱신
                                targetNumList.removeAt(k+1)
                                targetExOperList.removeAt(k)
                                k--
                            }
                            k++
                        }
                    }
                    '3' -> { // *
                        var k = 0
                        while (k < targetExOperList.size){
                            if (targetExOperList[k] == "*"){
                                targetNumList[k] = targetNumList[k] * targetNumList[k+1] // 갱신
                                targetNumList.removeAt(k+1)
                                targetExOperList.removeAt(k)
                                k--
                            }
                            k++
                        }
                    }
                }
            }

            if (targetNumList.size == 1){
                if (targetNumList[0] < 0){ // 해당 값이 - 부호 값이면
                    targetNumList[0] = Math.abs(targetNumList[0]) // abs로 절댓값 처리
                    answerList.add(targetNumList[0])
                } else {
                    answerList.add(targetNumList[0])
                }
            }
        }

        return answerList.maxOrNull()!!
    }

}

fun main() {
    val solution = Level2_NumMax()
    println(solution.solution("100-200*300-500+20")) // -60420 -> 60420
    println(solution.solution("50*6-3*2")) // 300
    println(solution.solution("2-990-5+2")) // 995
    println(solution.solution("300*300*300+20"))
    println(solution.solution("100*200+300-500"))
}