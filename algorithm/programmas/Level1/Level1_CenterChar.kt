class Level1_CenterChar {
    fun solution(s: String): String{
        var answer = ""
        val input = s
        var position = 0
        if (s.length % 2 == 1){
            position = (input.length / 2) + (input.length % 2)
            answer = input.toList()[position-1].toString()
        } else if (s.length % 2 == 0){
            position = input.length / 2
            answer = "${input.toList()[position-1]}${input.toList()[position]}"
        }

        return answer
    }
}

fun main() {
    val solution = Level1_CenterChar()

    val inputOne = "qwer"
    val outputOne = solution.solution(inputOne)

    println(outputOne)
}