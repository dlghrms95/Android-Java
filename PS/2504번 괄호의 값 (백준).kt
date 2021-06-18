// 실버 2 문제인데 내기준으로 상당히 어려웠음
// 다른사람 풀이 참조

풀이1

import java.util.*

fun main() {
    val n = readLine()!!

    var temp = 1
    var check = false
    var sum = 0

    val stack = Stack<Char>()

    for(i in n.indices) {
        when(n[i]) {
            '(' -> {
                temp *= 2
                stack.push('(')
            }
            '[' -> {
                temp *= 3
                stack.push('[')
            }
            ')' -> {
                if(stack.empty() || stack.last() != '(') {
                    check = true
                    break
                }
                if(n[i - 1] == '(') sum += temp
                stack.pop()
                temp /= 2
            }
            ']' -> {
                if(stack.empty() || stack.last() != '[') {
                    check = true
                    break
                }
                if(n[i - 1] == '[') sum += temp
                stack.pop()
                temp /= 3
            }
        }
    }

    if(check || stack.isNotEmpty()) println(0) else println(sum)
}


풀이2
import java.lang.StringBuilder
import java.util.*

/**
 * 1. 여는 괄호가 나오면 스택에 추가
 * 2. 닫는 괄호가 나왔을 때
 * 2-1. 스택이 비어있으면 올바르지 않는 괄호 쌍
 * 2-2. 스택의 top이 짝이 맞지 안흔ㄴ 괄호일 경우 올바르지 않는 괄호 쌍
 * 2-3. 스택의 top이 짝이 맞는 괄호일 경우 pop
 * 3. 이 과정을 전부 거치고 괄호가 남아있으면 올바르지 않는 괄호 쌍 남아있지 않으면 올바른 괄호 쌍쌍 */
class BOJ2504 {
    fun solve() {
        val input = readLine()!!
        val stack = Stack<String>()
        var result = 0
        var check = 0

        for(i in input.indices){
            if(input.toCharArray()[i] == '(' || input.toCharArray()[i] == '[')
                stack.push(input.toCharArray()[i].toString())
            else{
                if(stack.isEmpty()){
                    println(0)
                    return
                }
                if(input.toCharArray()[i] == ')'){
                    if(stack.peek() == "(") {
                        stack.pop()
                        stack.push("2")
                    } else {
                        check = stackInnerLoop(stack,"[","(",2)
                    }
                }else {
                    if(stack.peek() == "["){
                        stack.pop()
                        stack.push("3")
                    }else {
                        check = stackInnerLoop(stack,"(","[",3)
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek() == "(" || stack.peek() == ")" || stack.peek() == "[" || stack.peek() == "]"){
                println(0)
                return
            }
            result += stack.pop().toInt()
        }
        println(result)
    }

    private fun stackInnerLoop(stack : Stack<String>,c1 : String , c2 : String ,value : Int) : Int{
        var result = 0

        while(!stack.isEmpty()){
            val top = stack.peek()

            if(top == c1){
                return -1
            }else if(top == c2){
                stack.pop()
                result *= value
                stack.push(result.toString())
                break
            }else{
                result += Integer.parseInt(stack.pop())
            }
        }
        return result
    }

}

fun main() {
    val test = BOJ2504()
    test.solve()
}
