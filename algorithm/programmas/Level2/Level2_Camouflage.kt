/**
 * 위장 (해시 연습문제)
 *
 * 문제 설명
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
 * 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 *
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 * */
class Level2_Camouflage {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map : HashMap<String, Int> = HashMap<String, Int>()

        for (i in 0 until clothes.size){
            if (!map.containsKey(clothes[i][1])){
                // 착용하지 않는 경우까지 추가된 값을 추가
                map[clothes[i][1]] = 2
            } else {
                map[clothes[i][1]] = map.getValue(clothes[i][1]) + 1
            }
        }

        for (i in map.values){
            answer *= i
        }

        // 모두 다 안입는 경우를 제외 함.
        return answer - 1
    }
}

fun main() {
    val solution = Level2_Camouflage()

    println(solution.solution(arrayOf(arrayOf("yellowhat", "headgear"),
        arrayOf("bluesunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")))) // 5
}