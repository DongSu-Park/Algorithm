/**
 * Problems : Add Two Numbers
 * Difficulty : Medium
 * Url : https://leetcode.com/problems/add-two-numbers/
 *
 * 문제 설명
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *  -> ListNode 의 클래스가 주어지고 (단일 연결 리스트 구조) 리스트 순서대로 숫자가 역순으로 저장됨
 *      예를 들어 2 -> 4 -> 3의 경우 저장 될 때 342가 됨
 *     두개의 ListNode 가 주어질 때 각 자리수의 숫자를 더해서 나온 결과를 ListNode로 리턴하시오
 *
 * */

class ListNode(var `val`: Int?) {
    var next: ListNode? = null
}

class No2_AddTwoNumbers {
    fun solution(l1: ListNode?, l2: ListNode?): ListNode? {
        var listNode1 = l1 // l1의 처음 노드를 삽입
        var listNode2 = l2 // l2의 처음 노드를 삽입
        val resultNode = ListNode(0) // 처음에는 더미 헤드를 넣음
        var curr = resultNode

        var carry = 0 // 더했을 때 10의 자리인 경우 10자리 수를 옮김
        while (listNode1 != null || listNode2 != null){
            val x = listNode1?.`val` ?: 0
            val y = listNode2?.`val` ?: 0
            val sum = carry + x + y
            carry = sum / 10
            curr.next = ListNode(sum % 10) // 계산된 숫자를 다음 노드에 넣음
            curr = curr.next!!

            if (listNode1 != null) listNode1 = listNode1.next
            if (listNode2 != null) listNode2 = listNode2.next
        }
        if (carry > 0){ // 모든 계산이 마치고 carry 숫자가 남아 있는 경우
            curr.next = ListNode(carry)
        }

        return resultNode.next
    }
}

fun main() {
    val solution = No2_AddTwoNumbers()

    val ln1 = ListNode(2).apply {
        next = ListNode(4)
        next?.next = ListNode(3)
    }

    val ln2 = ListNode(5).apply {
        next = ListNode(6)
        next?.next = ListNode(4)
    }

    println(solution.solution(ln1, ln2))
}