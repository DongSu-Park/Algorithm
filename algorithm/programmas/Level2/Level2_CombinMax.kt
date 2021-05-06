/**
 * 레벨2 - 가장 큰 수
 * */

class Level2_CombinMax {
    fun solution(numbers: IntArray): String{
        var answer = ""
        var stringArr = arrayOf<String>()

        for (i in 0 until numbers.size){ // Int -> String
            stringArr += numbers[i].toString()
        }

        stringArr.sortWith(Comparator<String>{a, b -> // 정렬 조건 설정
            when{
                a.length == b.length -> b.compareTo(a) // 문자열의 길이가 같다면 둘을 비교 (아스키코드 10진수 값으로)
                else -> (b+a).compareTo(a+b) // 두개의 스트링을 합친 후 비교
            }
        })

        if (stringArr[0] == "0"){ // 00000 인 경우를 0으로 표현
            return "0"
        }

        for (i in 0 until numbers.size){
            answer += stringArr[i]
        }

        return answer
    }
}

fun main() {
    val solution = Level2_CombinMax()

    println(solution.solution(intArrayOf(6,10,2)))
    println(solution.solution(intArrayOf(3,30,34,5,9)))
}