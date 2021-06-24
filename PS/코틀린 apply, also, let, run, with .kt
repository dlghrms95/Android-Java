// 이외에도 filter, map 등 코틀린의 강력한 기능들을 아직 잘 다루지 못하고 있음

// 문자열 내 마음대로 정렬하기 - 프로그래머스
class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.also {
            it.sort()
            it.sortBy { it[n] }
        }
    }
}
