/**
 * 직업군 추천하기 (프로그래머스 위클리 챌린지 4주차)
 *
 * 문제 설명
 * 개발자가 사용하는 언어와 언어 선호도를 입력하면 그에 맞는 직업군을 추천해주는 알고리즘을 개발하려고 합니다.
 * 아래 표는 5개 직업군 별로 많이 사용하는 5개 언어에 직업군 언어 점수를 부여한 표입니다.
 *  링크 : https://programmers.co.kr/learn/courses/30/lessons/84325
 *
 * 예를 들면, SQL의 SI 직업군 언어 점수는 3점이지만 CONTENTS 직업군 언어 점수는 2점입니다.
 * SQL의 HARDWARE, PORTAL, GAME 직업군 언어 점수는 0점입니다.
 *
 * 직업군 언어 점수를 정리한 문자열 배열 table, 개발자가 사용하는 언어를 담은 문자열 배열 languages,
 * 언어 선호도를 담은 정수 배열 preference가 매개변수로 주어집니다.
 * 개발자가 사용하는 언어의 언어 선호도 x 직업군 언어 점수의 총합이 가장 높은 직업군을 return 하도록 solution 함수를 완성해주세요.
 * 총합이 같은 직업군이 여러 개일 경우, 이름이 사전 순으로 가장 빠른 직업군을 return 해주세요.
 * */

class Weekly_4th {
    fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {
        var answer: String = ""

        // Map 세팅 (SI, CONTENTS, HARDWARE, PORTAL, GAME)
        val siMap : HashMap<Int, String> = hashMapOf()
        val contentsMap : HashMap<Int, String> = hashMapOf()
        val hardwareMap : HashMap<Int, String> = hashMapOf()
        val portalMap : HashMap<Int, String> = hashMapOf()
        val gameMap : HashMap<Int, String> = hashMapOf()

        // 테이블을 각 직업군 map에 넣기
        for (i in 0 until table.size){
            val splitTable = table[i].split(" ")
            when(splitTable[0]){
                "SI" -> inputMap(splitTable, siMap)
                "CONTENTS" -> inputMap(splitTable, contentsMap)
                "HARDWARE" -> inputMap(splitTable, hardwareMap)
                "PORTAL" -> inputMap(splitTable, portalMap)
                "GAME" -> inputMap(splitTable, gameMap)
            }
        }

        // 언어선호도 * 직업군언어 점수를 나타내는 테이블 설정 후 계산
        val totalMap = mutableMapOf<String, Int>("SI" to 0, "CONTENTS" to 0, "HARDWARE" to 0, "PORTAL" to 0, "GAME" to 0)
        addSiScore(siMap, totalMap, languages, preference)
        addContentsScore(contentsMap, totalMap, languages, preference)
        addHardwareScore(hardwareMap, totalMap, languages, preference)
        addPortalScore(portalMap, totalMap, languages, preference)
        addGameScore(gameMap, totalMap, languages, preference)

        // 가장 높은 직업군을 리턴
        answer = findHighJobs(totalMap)

        return answer
    }

    private fun findHighJobs(totalMap: MutableMap<String, Int>): String {
        var highJob : String = ""
        var highScore = 0
        val set = totalMap.entries
        val iterator = set.iterator()

        while(iterator.hasNext()){
            val entry = iterator.next()
            if (totalMap.getValue(entry.key) > highScore){
                highJob = entry.key
                highScore = entry.value
            } else if (totalMap.getValue(entry.key) == highScore){
                // 같을 경우 사전 순서 체크 (첫 글자로)
                if (highJob.isNotEmpty()){
                    if (highJob.first() > entry.key.first()){
                        highJob = entry.key
                        highScore = entry.value
                    }
                } else {
                    highJob = entry.key
                    highScore = entry.value
                }
            }
        }

        return highJob
    }

    private fun addGameScore(gameMap: HashMap<Int, String>, totalMap: MutableMap<String, Int>, languages: Array<String>, preference: IntArray) {
        for (i in 0 until languages.size){
            for (j in 5 downTo 1){
                if (gameMap.getValue(j) == languages[i]){
                    val calc = totalMap.getValue("GAME") + (j * preference[i])
                    totalMap.put("GAME", calc)
                    break
                }
            }
        }
    }

    private fun addPortalScore(portalMap: HashMap<Int, String>, totalMap: MutableMap<String, Int>, languages: Array<String>, preference: IntArray) {
        for (i in 0 until languages.size){
            for (j in 5 downTo 1){
                if (portalMap.getValue(j) == languages[i]){
                    val calc = totalMap.getValue("PORTAL") + (j * preference[i])
                    totalMap.put("PORTAL", calc)
                    break
                }
            }
        }
    }

    private fun addHardwareScore(hardwareMap: HashMap<Int, String>, totalMap: MutableMap<String, Int>, languages: Array<String>, preference: IntArray) {
        for (i in 0 until languages.size){
            for (j in 5 downTo 1){
                if (hardwareMap.getValue(j) == languages[i]){
                    val calc = totalMap.getValue("HARDWARE") + (j * preference[i])
                    totalMap.put("HARDWARE", calc)
                    break
                }
            }
        }
    }

    private fun addContentsScore(contentsMap: HashMap<Int, String>, totalMap: MutableMap<String, Int>, languages: Array<String>, preference: IntArray) {
        for (i in 0 until languages.size){
            for (j in 5 downTo 1){
                if (contentsMap.getValue(j) == languages[i]){
                    val calc = totalMap.getValue("CONTENTS") + (j * preference[i])
                    totalMap.put("CONTENTS", calc)
                    break
                }
            }
        }
    }

    private fun addSiScore(siMap: HashMap<Int, String>, totalMap: MutableMap<String, Int>, languages: Array<String>, preference: IntArray) {
        for (i in 0 until languages.size){
            for (j in 5 downTo 1){
                if (siMap.getValue(j) == languages[i]){
                    val calc = totalMap.getValue("SI") + (j * preference[i])
                    totalMap.put("SI", calc)
                    break
                }
            }
        }
    }

    // 각 직업군 map에 점수와 언어 넣기
    private fun inputMap(splitTable: List<String>, jobMap: HashMap<Int, String>) {
        for (i in 1 until splitTable.size){
            // 5 ~ 1 까지
            jobMap.put(6 - i, splitTable[i])
        }
    }

}

fun main() {
    val solution = Weekly_4th()
    val tableCaseOne = arrayOf("SI JAVA JAVASCRIPT SQL PYTHON C#",
        "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
        "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
        "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
        "GAME C++ C# JAVASCRIPT C JAVA")
    val langCaseOne = arrayOf("PYTHON", "C++", "SQL")
    val preferCaseOne = intArrayOf(7,5,5)

    val tableCaseTwo = arrayOf("SI JAVA JAVASCRIPT SQL PYTHON C#",
        "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
        "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
        "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
        "GAME C++ C# JAVASCRIPT C JAVA")
    val langCaseTwo = arrayOf("JAVA", "JAVASCRIPT")
    val preferCaseTwo = intArrayOf(7,5)


    println(solution.solution(tableCaseOne, langCaseOne, preferCaseOne)) // "HARDWARE"
    println(solution.solution(tableCaseTwo, langCaseTwo, preferCaseTwo)) // "PORTAL"

}