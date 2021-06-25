// 이외에도 filter, map, all 등 코틀린의 강력한 기능들을 아직 잘 다루지 못하고 있음
// 조금더 난이도 있는 문제들에 활용할 수 있는 여러 개념들은 프로그래머스 연습문제에 잘 나와있는 것 같음
// 프로그래머스 연습문제에서 기존 내 풀이랑 다른사람 풀이 참조하며 익힐것!

// 문자열 내 마음대로 정렬하기 - 프로그래머스(연숩문제)
// also 활용함
class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.also {
            it.sort()
            it.sortBy { it[n] }
        }
    }
}

--------------------------------------------------------------------------
    
// 문자열 다루기 기본 - 프로그래머스(연습문제)
// 각각 filter, all , toIntOrNull 활용함
class Solution {
    fun solution(s: String): Boolean 
    {
        val length = s.filter { it.isDigit() }.length
        return (length == 4 || length == 6) && length == s.length
    }
}


class Solution {
    fun solution(s: String): Boolean {
        return s.all {
            it.isDigit() 
        } && ((s.length == 4) || (s.length == 6))
    }
}

class Solution {
    fun solution(s: String) = (s.length == 4 || s.length == 6) && s.toIntOrNull() != null
}

--------------------------------------------------------------------------
    
// 시저 암호 - 프로그래머스(연습문제)
// joinToString, when 등
class Solution {
    fun solution(s: String, n: Int): String {
        return s.toList().joinToString(separator = "") {
            when (it) {
                in 'A'..'Z' -> ('A'.toInt() + (it.toInt() - 'A'.toInt() + n) % ('Z' - 'A' + 1)).toChar()
                in 'a'..'z' -> ('a'.toInt() + (it.toInt() - 'a'.toInt() + n) % ('z' - 'a' + 1)).toChar()
                else -> it
            }.toString()
        }
    }
}

--------------------------------------------------------------------------
    
// 약수의 합 - 프로그래머스(연습문제)
// filter

// 기존 내 풀이
class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        for (i in 1..n) {
            if (n % i == 0) {
                answer += i
            }
        }
        return answer
    }
}

// 다른사람풀이
class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        answer = (1..n).filter {
            n % it == 0
        }.sum()
        return answer
    }
}

--------------------------------------------------------------------------
 
// 이상한 문자 만들기 - 프로그래머스(연습문제)
// joinToString, mapIndexed
class Solution {
    fun solution(s: String) =
        s.split(" ").joinToString(" ") { word ->
            word
                .mapIndexed{ index, char ->
                    if ( index % 2 == 0) char.toUpperCase() else char.toLowerCase()
                }
                .joinToString("")
        }
}

--------------------------------------------------------------------------

// 아직 정리할거 많이 남으무
    
    
