/**
 * 문자열 내 마음대로 정렬하기
 *
 * 문제 설명
 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
 *
 * 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면
 * 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
 *
 * 단 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
 * */

class Level1_CustomSort {
    fun solution(strings : Array<String>, n: Int): Array<String>{
        var answer = arrayOf<String>()

        // sort의 커스텀 조건을 설정하는 sortedWith 함수 이용
        val listString = strings.sortedWith(Comparator<String>{ a, b -> // 자기 자신과 그 다음꺼를 비교할 때
            if(a[n] == b[n]) a.compareTo(b) // n번째 자리를 비교해서 같다면 a와 b는 그냥 사전순으로 정렬
            else a[n].compareTo(b[n]) // 다른 경우 a와 b의 n번째 자리를 비교해서 사전순으로 정렬
        })

        answer = listString.toTypedArray()

        return answer
    }
}

fun main() {
    val solution = Level1_CustomSort()
    println(solution.solution(arrayOf("sun", "bed", "car"), 1))
    println(solution.solution(arrayOf("abce", "abcd", "cdx"), 2))
}