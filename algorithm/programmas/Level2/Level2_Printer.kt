/**
 * 프린터 (스택, 큐)
 *
 * 문제 설명
 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다.
 * 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
 * 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
 * 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
 *  1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 *  2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 *  3. 그렇지 않으면 J를 인쇄합니다.
 *
 * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
 * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
 * 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 * */

class Level2_Printer {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        // priorites 순서대로 문서의 이름 등록 (1,2,3,4 ...)
        val docMutableList = mutableListOf<Int>()
        for (i in 0 until priorities.size){
            docMutableList.add(i + 1)
        }
        val rankMutableList = priorities.toMutableList() // 랭크 리스트

        val targetDoc = docMutableList[location] // 예로 location이 2면 targetDoc는 3(C) -> 뽑고 싶은 문서

        var selectDoc = 0
        var selectRank = 0
        var printDoc = mutableListOf<Int>()

        while (docMutableList.size > 0){
            selectDoc = docMutableList[0] // 맨 앞의 문서를 선택
            selectRank = rankMutableList[0] // 맨 앞의 문서의 랭크를 선택

            if (docMutableList.size == 1){
              printDoc.add(selectDoc)
              break
            }

            docMutableList.removeAt(0) // 맨 앞의 인덱스 삭제
            rankMutableList.removeAt(0) // 맨 앞의 인덱스 삭제

            var i = 0
            while (i < rankMutableList.size){
                if (selectRank < rankMutableList[i]){ // 만약 선택된 문서 랭크보다 남은 문서의 중요도가 높은 문서가 한개라도 존재하면
                    docMutableList.add(selectDoc) // 다시 문서 스택에 넣기
                    rankMutableList.add(selectRank) // 다시 문서 랭크 스택에 넣기
                    break
                }

                if (i == rankMutableList.size - 1){ // 다 탐색을 했는데 자신보다 중요도가 높은 문서가 없다면
                    printDoc.add(selectDoc)
                    break
                }

                i++
            }
        }

        answer = printDoc.indexOf(targetDoc) + 1

        return answer
    }
}

fun main() {
    val solution = Level2_Printer()
    println(solution.solution(intArrayOf(2,1,3,2), 2)) // 1
    println(solution.solution(intArrayOf(1,1,9,1,1,1),0)) // 5
    println(solution.solution(intArrayOf(3,3,4,2),3)) // 4
}