package Level1

class Level1_subStringNum {
    fun solution(s: String): Int {
        var sNum = s

        for (i in 0..9){
            if (sNum.contains(findNum(i))){
                sNum = sNum.replace(findNum(i), "$i")
            }
        }

        return Integer.parseInt(sNum)
    }

    private fun findNum(i: Int): String {
        var numString = ""
        when (i) {
            0 -> numString = "zero"
            1 -> numString = "one"
            2 -> numString = "two"
            3 -> numString = "three"
            4 -> numString = "four"
            5 -> numString = "five"
            6 -> numString = "six"
            7 -> numString = "seven"
            8 -> numString = "eight"
            9 -> numString = "nine"
        }
        return numString
    }
}

fun main() {
    val solution = Level1_subStringNum()

    println(solution.solution("one4seveneight"))
}