import java.util.regex.Pattern

/**
 *  1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다. -> lowercase
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다. -> 정규식 제거
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다. -> 여기서 배열로 바꾸고 같은 아스키 연속으로 들어오면 빼라는 건가?
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. -> first 와 last 배열을 추출해 해당 아스키 체크
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다. -> nullofempty??
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. -> 배열로 size 체크?? 아니면 토큰나이저?
만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. -> 마지막 위치 아스키 체크?
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다. -> 마지막 문자를 그냥 한번 더 붙이면 될거 같음
 => 뭔 단계가....
 */

class Level1_NewIdRecommand {
    fun solution(new_id: String): String {
        var answer: String = new_id

        if (!answer.isNullOrEmpty()) {
            answer = phaseOne(answer) // 1단계 정처리 시작
            answer = phaseTwo(answer) // 2단계 정처리 시작
            answer = phaseThree(answer) // 3단계 정처리 시작
            answer = phaseFour(answer) // 4단계 정처리 시작
            answer = phaseFive(answer) // 5단계 정처리 시작
            answer = phaseSix(answer) // 6단계 정처리 시작
            answer = phaseSeven(answer) // 7단계 정처리 시

        }

        return answer
    }

    fun phaseOne(new_id: String): String {
        val lowerCase = new_id.toLowerCase()
        return lowerCase
    }

    fun phaseTwo(new_id: String): String {
        var id = ""

        for (i in 0 until new_id.length) {
            val char = new_id[i]

            if (char in 'a'..'z') {
                id += char.toString()
            } else if (char in '0'..'9') {
                id += char.toString()
            } else if (char == '-' || char == '_' || char == '.') {
                id += char.toString()
            }
        }

        return id
    }

    fun phaseThree(new_id: String): String {
        var id = new_id.replace("..",".")

        while (id.contains("..")){
            id = id.replace("..",".")
        }
        // .bat.y.abcdefghijklm

        return id
    }

    fun phaseFour(new_id: String): String {
        var id = new_id

        if (new_id.first() == '.'){
            id = id.substring(1, id.length) // 1 부터 id length 끝까지
        } else if (new_id.last() == '.'){
            id = id.substring(0, id.length-1) // 0 부터 id length-1 까지
        }

        return id
    }

    fun phaseFive(new_id: String): String{
        var id = new_id
        if (id.isNullOrEmpty()){
            id = "a"
        }

        return id
    }

    fun phaseSix(new_id: String): String{
        var id = new_id
        if (id.length >= 16){
            id = id.substring(0, 15)
        }

        if (id.last() == '.'){
            id = id.substring(0, id.length-1)
        }

        return id
    }

    fun phaseSeven(new_id: String): String{
        var id = new_id

        if (id.length == 2){
            id += id.last()
        } else if (id.length == 1){
            id = id + id.last() + id.last()
        }

        return id
    }
}

fun main(args: Array<String>) {
    val solution = Level1_NewIdRecommand()

    val output1 = solution.solution("...!@BaT#*..y.abcdefghijklm")
    println(output1)

    val output2 = solution.solution("z-+.^.")
    println(output2)

    val output3 = solution.solution("=.=")
    println(output3)

    val output4 = solution.solution("123_.def")
    println(output4)

    val output5 = solution.solution("abcdefghijklmn.p")
    println(output5)
}