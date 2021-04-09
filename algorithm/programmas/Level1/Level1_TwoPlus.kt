/**
 * 정수 배열 numbers가 주어집니다.
 * numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서
 * 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * */

class Level1_TwoPlus {
    fun solution(numbers: IntArray): IntArray{
        val list = arrayListOf<Int>()

        for (i in 0 until numbers.size){
            for (j in i+1 until numbers.size) {
                val plus = numbers[i] + numbers[j]
                if (!list.contains(plus)){ // contains는 해당 배열에 추출된 값이 있는지 확
                    list.add(plus) // 없다면 추가
                }
            }
        }

        list.sort() // 정렬

        val answer = IntArray(list.size)

        for (k in 0 until list.size){
            answer[k] = list[k]
        }

        return answer
    }
}

fun main() {
    val solution = Level1_TwoPlus()

    val input : IntArray = intArrayOf(2,1,3,4,1)
    val output = solution.solution(input)
    for (i in 0 until output.size){
        print("${output[i]}") // 2,3,4,5,6,7
    }

    print("\n")

    val input2 : IntArray = intArrayOf(5,0,2,7)
    val output2 = solution.solution(input2)
    for (i in 0 until output2.size){
        print("${output2[i]}") // 2,5,7,9,2
    }
}