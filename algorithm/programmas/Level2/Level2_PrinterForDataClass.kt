/**
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 * */
data class Doc(val name : Char, val priorities: Int)
class test {
    fun solution(priorities: IntArray, location: Int): Int {
        val waitList = mutableListOf<Doc>()
        for (i in 0 until priorities.size){
           waitList.add(Doc('A' + i, priorities[i]))
        }

        val targetDoc = waitList[location]

        val printList = mutableListOf<Doc>()
        while (waitList.isNotEmpty()){
            // 인쇄 대기목록의 가장 앞에 있는 문서 대기목록에서 꺼냄
            val popDoc = waitList[0]
            waitList.removeAt(0)

            if (waitList.isEmpty()){
                printList.add(popDoc)
                break
            }

            // 나머지 인쇄 대기목록에 꺼낸 문서보다 중요도가 높은게 있는지 확인
            val filterList = waitList.filter { it -> it.priorities > popDoc.priorities }

            // 중요도 높은것이 있다면 대기 문서의 맨 뒤로 넣고 아닐 경우 프린터 스택에 넣음.
            if (filterList.isNotEmpty()){
                waitList.add(popDoc)
            } else {
                printList.add(popDoc)
            }
        }

        return printList.indexOf(targetDoc) + 1
    }
}

fun main() {
    val solution = test()
    println(solution.solution(intArrayOf(2,1,3,2),2))
    println(solution.solution(intArrayOf(1,1,9,1,1,1), 0)) // 5
}