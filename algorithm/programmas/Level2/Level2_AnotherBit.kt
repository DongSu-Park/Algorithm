/**
 * 2개 이하로 다른 비트 (월간 코드 챌린지 시즌 2)
 *
 * 문제 설명 : x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수를 리턴하시오.
 * 조건 : 1 ≤ numbers의 길이 ≤ 100,000 / 0 ≤ numbers의 모든 수 ≤ 1015
 * */

class Level2_AnotherBit {
    fun solution(numbers: LongArray): LongArray {
        val answer = arrayListOf<Long>()

        for (i in 0 until numbers.size){
            if (numbers[i].toInt() == 0){
                // 숫자가 0안 경우 그냥 +1을 하면 됨
                answer.add(numbers[i].plus(1))
            } else {
                // 그 외의 경우 홀수와 짝수에 따라 계산이 다름
                if ((numbers[i] % 2).toInt() == 0){
                    answer.add(numToBit(numbers[i], true))
                } else {
                    answer.add(numToBit(numbers[i], false))
                }
            }
        }

        return answer.toLongArray()
    }

    private fun numToBit(number: Long, isEven: Boolean): Long {
        val bitArray = arrayListOf<Int>()

        // Long을 Binary으로 변경
        var num = number
        while (true){
            if (num == 1L){
                bitArray.add(num.toInt())
                break
            }

            bitArray.add((num % 2).toInt())
            num /= 2
        }

        // 비트 개수 맞추기
        if (bitArray[bitArray.size -1] == 1){
            bitArray.add(0)
        }

        val bit = bitArray.reversed().toMutableList()

        // 짝수의 경우 마지막 인덱스의 비트를 1로 변경
        // 홀수의 경우 맨 오른쪽부터 0을 찾고 그 위치에 1을 넣고 그 위치의 오른쪽에 1로 변경
        if (isEven){
            bit[bit.lastIndex] = 1
        } else {
            for (i in bit.size - 1 downTo 0){
                if (bit[i] == 0){
                    bit[i] = 1
                    bit[i + 1] = 0
                    break
                }
            }
        }

        // binary를 Long으로 변환
        var answerNum :Long = 0
        var pow = 0
        for (i in bit.size - 1 downTo 0){
            if (bit[i] == 1){
                answerNum += Math.pow(2.0, pow.toDouble()).toLong()
            }
            pow++
        }
        
        return answerNum
    }
}

fun main() {
    val solution = Level2_AnotherBit()

    println(solution.solution(longArrayOf(2,7)).toList()) // [3,11]
    println(solution.solution(longArrayOf(1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100)).toList())
}