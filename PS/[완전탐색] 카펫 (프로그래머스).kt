// 너무나도 간단한 문제인데 너무나도 꼬아서 생각했다.
// 완전탐색이라 컴퓨터의 성능을 믿고 1억번연산 아래이면 for문은 돌리면서
// 해당하는 경우를 마주쳤을 때 가 값을 가져오면 되는 정말 간단한 문제인데
// 쓸데없이 규칙을 찾는 등 시간낭비를 너무 하였다.

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf(0,0)
        val sum = brown + yellow
        
        for(i in 1..sum){
            var x = i
            var y = sum / x
            
            if((x-2) * (y-2) == yellow){
                answer[0] = y
                answer[1] = x
                break
            }
        }
        
        return answer
    }
}
