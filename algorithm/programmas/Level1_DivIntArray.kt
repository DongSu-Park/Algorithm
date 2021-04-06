/**
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 *
 * 제한사항
 * arr은 자연수를 담은 배열입니다.
 * 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
 * divisor는 자연수입니다.
 * array는 길이 1 이상인 배열입니다.
 *
 * 입출력 예#1
 * arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.
 *
 * 입출력 예#2
 * arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.
 *
 * 입출력 예#3
 * 3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
 * */
class Level1_DivIntArray {
    fun solution(arr: IntArray, divisor: Int): ArrayList<Int>{
        val outputArray = arrayListOf<Int>()

        for (i in 0 until arr.size){
            if (arr[i] % divisor == 0){
                outputArray.add(arr[i])
            }
        }

        if (outputArray.isEmpty()){
            outputArray.add(-1)
        }

        outputArray.sort()

        return outputArray
    }
}

fun main() {
    val solution = Level1_DivIntArray()
    val inputArr1 : IntArray = intArrayOf(5,9,7,10)
    val inputDiv1 = 5

    val output1 = solution.solution(inputArr1, inputDiv1)
    println(output1)

    val inputArr2 = intArrayOf(1,2,3,36)
    val inputDiv2 = 1

    val output2 = solution.solution(inputArr2, inputDiv2)
    println(output2)


    val inputArr3 = intArrayOf(3,2,6)
    val inputDiv3 = 10

    val output3 = solution.solution(inputArr3, inputDiv3)
    println(output3)
}