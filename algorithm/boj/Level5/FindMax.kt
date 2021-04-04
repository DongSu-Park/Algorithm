fun main() {
    val inputArray = arrayListOf<Int>()

    var i = 1
    while(i <= 9){ // 9개 입력
        val input = readLine()!!.toInt()
        if (input < 100){
            inputArray.add(input)
            i++
        } else {
            break // 100 이상 입력하면 그냥 brake
        }
    }

    var max = 0 // 최대값 변수
    var few = 0 // 최대값 위치 변수

    if (inputArray.size == 9){ // 배열의 길이가 9개가 아니면 조건문 만족하지 못함
        for (i in 0 until inputArray.size){
            if (max <= inputArray[i]){
                max = inputArray[i]
                few = i+1
            }
        }

        println(max)
        println(few)
    }
}