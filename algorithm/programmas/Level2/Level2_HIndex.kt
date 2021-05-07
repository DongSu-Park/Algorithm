/**
 * H-Index
 *
 * 문제 설명
 *  $$ 프로그래머스 문제 설명이 너무 미흡해서 링크로 대체
 *  H-Index에 대한 뉴스 기사 : [https://www.ibric.org/myboard/read.php?Board=news&id=270333]
 *  H-Index 위키피디아 : [https://en.wikipedia.org/wiki/H-index]
 *
 * 입출력 예
 *  [3,0,6,1,5] => 3
 *  이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다.
 *  그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3 입니다.
 * */

class Level2_HIndex {
    fun solution(citations: IntArray): Int{
        var answer = 0

        // 정렬을 사용하지 않고 단순 배열 참조로 구현한 풀이
        /*
        for (i in 0 until citations.size){
            var j = 0
            var count = 0

            while(j <= citations.size-1){
                if (citations[j] >= i+1){
                    count++
                }
                j++
            }

            if (count >= i+1){
                answer = i+1
            }
        }
        */

        // 정렬을 사용한 풀이
        val array = citations.sortedArrayDescending() // 인용된 순으로 내림차순 정렬

        for (i in 0 until array.size){
            if (array[i] >= i + 1){ // 피인용수가 논문수와 같거나 작아지는 순간 전까지 계속 갱신
                answer = i + 1
            }
        }

        return answer
    }
}

fun main() {
    val solution = Level2_HIndex()

    println(solution.solution(intArrayOf(3,0,6,1,5))) // 3
}