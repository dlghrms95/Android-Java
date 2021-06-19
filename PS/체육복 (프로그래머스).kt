// 내 풀이

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size
        
        for(i in 0 until lost.size){
            for(j in 0 until reserve.size){
                if(lost[i] == reserve[j]){
                    answer++ 
                    reserve[j] = -1
                    lost[i] = -3
                    break
                }
            }
        }
        
        for(i in 0 until lost.size){
            for(j in 0 until reserve.size){                
                if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1){
                    answer++
                    reserve[j] = -1
                    break
                }
            }
        }
        
        return answer
    }
}

// 다른풀이 : 직관적으로 잘 해석되서 가져옴
// 근데 애초에 n의 크기가 2~30 이라 아래의 풀이는 내 풀이보다 시간이 훨씬 많이 걸리긴함

class Solution {
        fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

            var answer = n
            var lostSet = lost.toSet() - reserve.toSet()
            var reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

            for (i in lostSet) {
                when {
                    i + 1 in reserveSet -> reserveSet.remove(i + 1)
                    i - 1 in reserveSet -> reserveSet.remove(i - 1)
                    else -> answer--
                }
            }
            return answer
        }
}

