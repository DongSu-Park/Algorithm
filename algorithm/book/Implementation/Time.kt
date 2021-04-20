/**
 * 시각
 *
 * 정수 N이 입력되면 00시 00분 00초 부터 N시 59분 59초까지 모든 시각 중에서
 * 3이 하나라도 포함된 모든 경우의 수를 구하시오 (제한시간 2초)
 * */
class Time {
    fun solution(n : Int) : Int{
        var answer = 0
        for (i in 0..n){ // 0부터 n까지
            for (j in 0 until 60){ // 0부터 59까지
                for (k in 0 until 60){ // 0부터 59까지
                    val time = "${String.format("%02d", i)}${String.format("%02d",j)}${String.format("%02d",k)}" // 00시00분00초 형태로 String을 맞춤
                    val timeList = time.toList() // 리스트로 변환
                    if (timeList.contains('3')){ // 3을 포함하면 answer++
                        answer++
                    }
                }
            }

        }
        return answer
    }
}

fun main() {
    val solution = Time()
    println(solution.solution(5)) // 11475

}