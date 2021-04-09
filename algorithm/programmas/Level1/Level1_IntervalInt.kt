/**
 * x만큼 간격이 있는 n개의 숫자
 *
 * 문제 설명
 * 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
 * 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * x는 -10000000 이상, 10000000 이하인 정수입니다.
 * n은 1000 이하인 자연수입니다.
 * */

class Level1_IntervalInt {
    fun solution(x: Int, n: Int): ArrayList<Long>{
        var answer = arrayListOf<Long>()

        if (x in -10000000..10000000 && n in 0..1000){
            for (i in 1..n){
                answer.add(x*i.toLong())
            }
        }
        return answer
    }
}

fun main() {
    val solution = Level1_IntervalInt()

    println(solution.solution(2,5))
    println(solution.solution(4,3))
    println(solution.solution(-4,2))
}
