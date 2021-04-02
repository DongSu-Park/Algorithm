class Level1_TwoPlus {
    fun solution(numbers: IntArray): IntArray{
        val list = arrayListOf<Int>()


        for (i in 0 until numbers.size){
            for (j in i+1 until numbers.size) {
                val plus = numbers[i] + numbers[j]
                if (!list.contains(plus)){ // contains는 해당 배열에 추출된 값이 있는지 확
                    list.add(plus)
                }
            }
        }

        list.sort()

        val answer = IntArray(list.size)

        for (k in 0 until list.size){
            answer[k] = list.get(k)
        }

        return answer
    }
}