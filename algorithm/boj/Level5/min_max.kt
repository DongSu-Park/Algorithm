fun main() {
    val inputNum = readLine()!!.toInt() // 숫자 n 입력
    val inputString = readLine()!!.toString() // 입력한 n개의 숫자 입력

    val token = inputString.split(' ') // 공백 토큰 자르기

    if (token.size == inputNum){ // 숫자 n개 입력과 자른 토큰의 갯수와 일치하면

        val inputArray  = arrayListOf<Int>()
        for (i in 0 until inputNum){
            inputArray.add(token[i].toInt()) // 배열에 저장
        }

        inputArray.sort() // 정렬

        print("${inputArray.first()} ${inputArray.last()}") // 최소 최대 숫자 결과값 표시
    } else {
        print("일치하지 않음")
    }


}