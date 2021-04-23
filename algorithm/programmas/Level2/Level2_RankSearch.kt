class Level2_RankSearch {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        val answerList = mutableListOf<Int>()
        // 지원자의 표 리스트 객체
        val peopleHashMap = hashMapOf<Int, Array<String>>()

        // info 리스트 내용을 지원자의 표 리스트 객체로 저장
        for (i in 0 until info.size){
            val infoList = info[i].split(" ")

            if (!infoList.isNullOrEmpty()){
                peopleHashMap.set(i, arrayOf(infoList[0], infoList[1], infoList[2], infoList[3], infoList[4]))
            }
        }

        // 쿼리대로 select 시작
        for (i in 0 until query.size){
            val queryList = query[i].split(" ")

            val language = queryList[0]
            val position = queryList[2]
            val career = queryList[4]
            val soulFood = queryList[6]
            val score = Integer.parseInt(queryList[7])

            var count = 0

            for (j in 0 until peopleHashMap.size){
                if ((language == "-" || peopleHashMap[j]!![0].equals(language)) &&
                    (position == "-" || peopleHashMap[j]!![1].equals(position)) &&
                    (career == "-" || peopleHashMap[j]!![2].equals(career)) &&
                    (soulFood == "-" || peopleHashMap[j]!![3].equals(soulFood))){

                    if (Integer.parseInt(peopleHashMap[j]!![4]) >= score){
                        count++
                    }
                }
            }

            answerList.add(count)
        }

        answer = answerList.toIntArray()

        return answer
    }
}

fun main() {
    val solution = Level2_RankSearch()

    val inputInfo = arrayOf("java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50")

    val inputQuery = arrayOf("java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150",
        "- and - and - and chicken 100",
        "- and - and - and - 150")
    println(solution.solution(inputInfo,inputQuery).toList())
}
