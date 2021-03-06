/**
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. -> 4번 배열 x -> 3 or 5 가 있는지 체크 두단계로
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 전체 학생의 수는 2명 이상 30명 이하입니다. -> if 문으로 2 이상 30 이하
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다. -> 체육복 없는 학생 = 1<=x<=n
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다. -> 체육복 가지고 있는 학생 = 1<=x<=n
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
 * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 *
 * 입출력 예시 1
 * n = 5 / lost(잃어버린 학생) = 2,4 / reserve (여유분 가지고 있는 학생) = 1,3,5 / 결과 = 5
 * 1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있다.
 *
 * 입출력 예시 2
 * n = 5 / lost(잃어버린 학생) = 2,4 / reserve (여유분 가지고 있는 학생) = 3 / 결과 4
 * 3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있음.
 *
 * 생각나는것 -> key value 로 일단 체크?
 * */

class Level1_GymSuit {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        if (n in 2..30 && (lost.size in 1..n) && (reserve.size in 1..n)){
            var people = arrayListOf<Int>()

            for (i in 1..n){
                people.add(i)
            }

            val gymSuit = HashMap<Int, String>() // 해쉬맵으로 일단 체크
            for (i in 1..n){
                if (reserve.contains(i) && lost.contains(i)){
                    gymSuit.set(i, "c") // 여유분이 2개가 원래 있었는데 한개가 잃어버렸으니 그냥 가지고 있는거
                } else if (lost.contains(i)){
                    gymSuit.set(i, "l") // 그냥 완전히 잃어버린거
                } else if (reserve.contains(i)){
                    gymSuit.set(i, "r") // 여유분이 있는거 (한 개)
                } else {
                    gymSuit.set(i, "c") // 그냥 가지고 있는거
                }
            }

            // 잃어버린 사람 주변에서 빌리기 시작
            for (i in 0 until gymSuit.size){
                if (gymSuit[i] == "l"){
                    if (gymSuit[i-1] == "r" && i-1 >= 0){
                        gymSuit[i-1] = "c"
                        gymSuit[i] = "c"
                    } else if (gymSuit[i+1] == "r" && i+1 <= gymSuit.size){
                        gymSuit[i+1] = "c"
                        gymSuit[i] = "c"
                    }
                }
            }

            // 최종 결과
            for (i in 0..gymSuit.size) {
                if (gymSuit[i] == "c" || gymSuit[i] == "r") {
                    answer += 1
                }
            }
        }
        return answer
    }
}

fun main(args: Array<String>) {
    val solution = Level1_GymSuit()

    val people = 7
    val lost = intArrayOf(1,2,3,4,5,6,7)
    val reserve = intArrayOf(1,2,3)

    val output = solution.solution(people, lost, reserve)

    println(output)
}