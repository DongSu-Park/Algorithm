/**
 * 큰 수 만들기 (탐욕법 연습문제)
 *
 * 문제 설명
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
 * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * (9번 10번 테스트케이스에서만 타임아웃이 일어났기 때문에 기존의 String 대신 StringBuilder 를 사용하여 속도 처리를 빠르게 처리)
 * (문제 처리과정에서 시간복잡도가 O(n^2) 이므로 다른 방식의 해결방안도 생각해봐야 함)
 * */
class Level2_BigNums {
    fun solution(number: String, k: Int): String {
        val answer = StringBuilder("") // 9번 10번의 타임아웃으로 인한 StringBuilder 사용
        var pos = 0 // 기준점
        if (number[0] != '0'){
            for (i in 0 until number.length - k){
                var max ='0'
                for (j in pos..k+i){
                    // 탐색의 범위
                    if (max < number[j]){
                        max = number[j]
                        pos = j + 1 // 기준점을 탐색의 범위 중 최고값의 다음 번째로 갱신
                    }
                }

                answer.append(max)
            }
        } else {
            answer.append('0')
        }

        return answer.toString()
    }
}

fun main() {
    val solution = Level2_BigNums()

    println(solution.solution("4177252841", 4)) // "775841"
}