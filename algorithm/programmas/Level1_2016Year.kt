class Level1_2016Year {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        val yearMonth = arrayListOf(31,29,31,30,31,30,31,31,30,31,30,31) // 2016년 월마다의 일자 수

        // 기준은 2016년 1월 1일 금요일
        var dayWeek = 6
        val monthDef = a - 1 // 4
        val dayDef = b - 1 // 23

        var calc = 0

        for (i in 0 until monthDef){
            calc += yearMonth[i]
        }

        calc += dayDef

        dayWeek += calc % 7 // 7로 나누고 기준요일에 더하기

        if (dayWeek > 7){ // 만약 7보다 크면 7의 나머지로 요일 계산
            dayWeek %= 7
        }

        when (dayWeek){
            1 -> answer = "SUN"
            2 -> answer = "MON"
            3 -> answer = "TUE"
            4 -> answer = "WED"
            5 -> answer = "THU"
            6 -> answer = "FRI"
            7 -> answer = "SAT"
        }

        return answer
    }
}

fun main() {
    val a = 5
    val b = 24
    val solution = Level1_2016Year()
    print(solution.solution(a,b))
}