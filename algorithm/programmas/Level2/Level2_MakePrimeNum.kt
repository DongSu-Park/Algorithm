/**
 * 소수 찾기 (완전 탐색 연습문제)
 *
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * */
class Level2_MakePrimeNum {
    lateinit var permNum : MutableList<Int>
    fun solution(numbers: String): Int {
        val list = numbers.toList()
        permNum = mutableListOf<Int>()
        // 순열 리스트 만들기
        for (i in 1..list.size){
            val visited = Array<Boolean>(list.size){false}
            val output = Array<String>(list.size){""}
            perm(list, visited, output, 0, list.size, i)
        }

        // 소수 판별
        if (permNum.isNotEmpty()){
            var count = 0
            for (i in 0 until permNum.size){
                if (permNum[i] > 1){
                    var isPrime = true
                    for (j in 2 until permNum[i]){
                        if (permNum[i] % j == 0){
                            isPrime = false
                            break
                        }
                    }

                    if (isPrime){
                        count++
                    }
                }
            }

            permNum.clear()
            return count
        } else {
            permNum.clear()
            return 0
        }
    }

    private fun perm(list: List<Char>, visited: Array<Boolean>, output: Array<String>, depth: Int, size: Int, r: Int) {
        if (depth == r){
            var num = ""
            for (i in 0 until output.size){
               num += output[i]
            }

            if (!permNum.contains(Integer.parseInt(num))){ // 해당 숫자가 리스트에 없으면 넣기. (이미 있으면 넣지 않아도 됨)
                permNum.add(Integer.parseInt(num))
            }
            return
        }

        for (i in 0 until size){
            if (!visited[i]){
                visited[i] = true
                output[depth] = list[i].toString()
                perm(list, visited, output, depth+1, size, r)
                visited[i] = false
            }
        }
    }
}

fun main() {
    val solution = Level2_MakePrimeNum()

    println(solution.solution("17")) // 3
    println(solution.solution("011")) // 2
}