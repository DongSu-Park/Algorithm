/**
 * 기능개발 (스택/큐)
 *
 * 문제 설명
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
 * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 * */

class Level2_Progresses {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray{
        val answerList = mutableListOf<Int>()

        val progressesDayList = mutableListOf<IntArray>()
        var max = 0
        for (i in 0 until progresses.size){
            var num = (100 - progresses[i]) / speeds[i]
            if ((100 - progresses[i]) % speeds[i] > 0){ // 나머지가 있는 경우 +1
                num++
            }

            if (max <= num){
                max = num
            }
            progressesDayList.add(intArrayOf(num, 0))
        }

        var day = 1
        var dayDone = 0
        var targetIndex : Int? = null
        while (day <= max){
            for (i in 0 until progressesDayList.size){
                if (progressesDayList[i].contentEquals(intArrayOf(day, 0))){ // 해당 요일이 도달 했을 때
                    targetIndex = i // 해당 인덱스 가져오기
                    progressesDayList[targetIndex] = intArrayOf(day, 1) // 완료로 변경
                }
            }

            if (targetIndex == 0){
                if (progressesDayList.size > 1){
                    loop@ while (true){
                        if (progressesDayList.isEmpty()){
                            answerList.add(dayDone)
                            break@loop
                        }

                        if (progressesDayList[0].contains(1)){
                            dayDone++
                            progressesDayList.removeAt(0)
                        } else if (progressesDayList[0].contains(0)){
                            answerList.add(dayDone)
                            break@loop
                        }
                    }

                    dayDone = 0
                    targetIndex = null
                } else if (progressesDayList.size == 1){
                    answerList.add(1)
                    progressesDayList.removeAt(0)
                    break
                }
            } else if (targetIndex != null && targetIndex > 0){
                if (progressesDayList.size > 1){
                    loop@ while (true){
                        if (progressesDayList.isEmpty()){
                            answerList.add(dayDone)
                            break@loop
                        }

                        if (progressesDayList[0].contains(1)){
                            dayDone++
                            progressesDayList.removeAt(0)
                        } else if (progressesDayList[0].contains(0)){
                            if (dayDone == 0){
                                break@loop
                            }
                            answerList.add(dayDone)
                            break@loop
                        }
                    }

                    if (progressesDayList.isEmpty()){
                        break
                    } else {
                        dayDone = 0
                        targetIndex = null
                    }
                }
            }

            day++
        }

        return answerList.toIntArray()
    }
}

fun main() {
    val solution = Level2_Progresses()
    println(solution.solution(intArrayOf(93,30,55), intArrayOf(1,30,5)).toList()) // 2,1
    println(solution.solution(intArrayOf(95,90,99,99,80,99), intArrayOf(1,1,1,1,1,1)).toList()) // [1,3,2]
    println(solution.solution(intArrayOf(99,99,99), intArrayOf(1,1,1)).toList()) // 3
    println(solution.solution(intArrayOf(96,99,98,97), intArrayOf(1,1,1,1)).toList()) // 4
    println(solution.solution(intArrayOf(95,95,95,95), intArrayOf(4,3,2,1)).toList()) // 2,1,1
}