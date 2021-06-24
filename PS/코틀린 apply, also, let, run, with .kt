// 문자열 내 마음대로 정렬하기 - 프로그래머스
class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.also {
            it.sort()
            it.sortBy { it[n] }
        }
    }
}
