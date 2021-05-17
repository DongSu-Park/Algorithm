/**
 * Problems : Valid Parentheses
 * Difficulty : Easy
 * Url : https://leetcode.com/problems/valid-parentheses/
 *
 * 문제 설명
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *  -> 문자열의 열림과 닫힘이 정확한 문자열이면 true, 그렇지 않으면 false를 리턴하시오.
 *      ex. true => "()", "([])" / false => "(]", "[(]}"
 * */
class No20_ValidParentheses {
    fun solution (s: String): Boolean{
        var isValid = false

        val list = s.toList()
        val stack = mutableListOf<Char>()

        for (i in 0 until list.size){
            if (list[i] == ')' || list[i] == ']' || list[i] == '}'){
                stack.add(list[i])
                val lastIndex = stack.lastIndex
                if (stack.size >= 2 && (stack[lastIndex - 1] == list[i] - 1 || stack[lastIndex - 1] == list[i] - 2)){
                    stack.removeAt(stack.size- 1)
                    stack.removeAt(stack.size -1)
                }
            } else {
                stack.add(list[i])
            }
        }

        if (stack.isEmpty()){
            isValid = true
        }

        return isValid
    }
}

fun main() {
    val solution = No20_ValidParentheses()

    println(solution.solution("()")) // t
    println(solution.solution("()[]{}")) // t
    println(solution.solution("([)]")) // f
    println(solution.solution("(]")) // f
    println(solution.solution("{[]}")) // t
}