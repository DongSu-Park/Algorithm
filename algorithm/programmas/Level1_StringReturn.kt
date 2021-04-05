/**
 * 수박수박수박수박수박수??
 * */

class Level1_StringReturn {
    fun solution(n: Int) : String{
        var answer = ""

        if (n <= 10000){
            for (i in 1 until n+1){
                if (i % 2 == 1){
                    answer += "수"
                } else if (i % 2 == 0){
                    answer += "박"
                }
            }
        }
        return answer
    }
}

fun main() {
    val solution = Level1_StringReturn()
    val number = 4

    val output = solution.solution(number)
    println(output)
}