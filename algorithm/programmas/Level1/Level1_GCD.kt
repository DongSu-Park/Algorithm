/**
 * 최대공약수와 최소공배수
 *
 * 유클리드 호제법을 재귀함수로 만들어서 표현
 * */

class Level1_GCD {
    fun solution(n: Int , m: Int): IntArray{
        var answser = intArrayOf(0,0)
        val gcd = gcd(n, m) // 최대공약수
        answser.set(0, gcd)
        answser.set(1, (n * m / gcd)) // 최소공배수

        return answser
    }

    fun gcd(n : Int, m: Int): Int{
        if(m == 0) return n
        else return gcd(m, n % m)
    }
}

fun main() {
    val solution = Level1_GCD()
    println(solution.solution(3,12))
    println(solution.solution(2,5))
}

