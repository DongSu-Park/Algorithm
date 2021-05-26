/**
 * 메뉴 리뉴얼 (2021 카카오 블라인드 채용)
 *
 * ## 해당 문제는 해설 동영상을 참고하여 풀이한 코드
 * ## 참고 링크 : https://www.youtube.com/watch?v=22tBC3YXVPA
 *
 * ## 문제 설명
 * 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
 * 기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다.
 * 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
 * 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.
 *
 * 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때,
 * "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
 *
 * */
class Level2_MenuRenewal {
    val foodList = mutableListOf<MutableMap<String, Int>>()
    var maxCnt = Array<Int>(11){0}

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        initialize() // 전역변수 초기화

        for (i in 0..10){ // 각 개수 구성에 맞는 HashMap 구성
            foodList.add(HashMap<String, Int>())
        }

        for (i in 0 until orders.size){
            val menuList = orders[i].toList().sorted()
            combin(menuList, 0, "") // 재귀함수를 이용한 조합 시작
        }

        val answerList = mutableListOf<String>()

        for (j in 0 until course.size){
            // foodList hashmap 에서 value 값이 course 조합 개수 (ex. 2,3,4)에 대한 많이 주문한 key와 그 value 중 2번 이상 주문한 map 만 filter
            val filter = foodList[course[j]].filter { it.value == maxCnt[course[j]] && it.value >= 2 }
            if (filter.isNotEmpty()){
                // 키의 이름만 가져옴.
                val keys = filter.keys.iterator()
                while (keys.hasNext()){
                    val name = keys.next()
                    answerList.add(name)
                }
            }
        }

        return answerList.sorted().toTypedArray() // 사전 오름차순으로 정렬하고 리턴
    }

    private fun initialize() { // 전역변수 초기화
        foodList.clear()
        maxCnt = Array<Int>(11){0}
    }

    fun combin(menuList: List<Char>, pos: Int, s: String) {
        if (pos >= menuList.size){ // 종료 시점
            val len = s.length
            if (len >= 2){ // 문자 길이가 2개 이상일 때 조합이 완성됨
                val cnt : Int
                if (foodList.get(len).get(s) != null){ // 이미 리스트 안에 해당 조합이 있는 경우
                   cnt = foodList[len].get(s)!! + 1 // 카운트 값을 증가 시켜 줌
                } else {
                   cnt = 1
                }

                foodList[len].put(s, cnt) // key, value 를 새로 넣거나 갱신 시켜줌
                maxCnt[len] = Math.max(maxCnt[len], cnt) // Math.max() 함수 이용하여 이전 값과 현재 cnt 를 비교하여 더 큰 쪽을 갱신
            }
            return // 재귀 종료
        }

        combin(menuList, pos+1, s+menuList[pos]) // 선택한 경우
        combin(menuList, pos+1, s) // 선택 안한것
    }
}

fun main() {
    val solution = Level2_MenuRenewal()

    println(solution.solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2,3,4)).toList()) // ["AC", "ACDE", "BCFG", "CDE"]
    println(solution.solution(arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"), intArrayOf(2,3,5)).toList()) // ["ACD", "AD", "ADE", "CD", "XYZ"]
    println(solution.solution(arrayOf("XYZ", "XWY", "WXA"), intArrayOf(2,3,4)).toList()) // ["WX", "XY"]
}