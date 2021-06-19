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
// 추가적으로 set을 그저 중복이없는것으로 사용했는데 차집합 교집합 합집합 등의 방식으로 활용한것이
// 흥미있다.

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


// 즉, 아래처럼 합집합 교집합 차집합을 활용하는것이 가능하다.
// 이를 활용하기위해 list, set, map 관 변환과 관련된 함수들을 찾아보자

fun main(args : Array<String>) {

    val ms = mutableSetOf(1, 2, 3, 4)
    val ms2 = mutableSetOf(3, 4, 5, 6)

    println("=============집 합================")
    println("ms : ${ms.toString()}")
    println("ms2 : ${ms2.toString()}")

    val plus = ms + ms2 // or  ms.union(ms2)
    println("합집합 : ${plus.toString()}")

    val minus = ms - ms2 // or  ms.subtract(ms2)
    println("차집합 : ${minus.toString()}")

    val equal = ms.intersect(ms2)
    println("교집합 : ${equal.toString()}")
}

// =============집 합================
// ms : [1, 2, 3, 4]
// ms2 : [3, 4, 5, 6]
// 합집합 : [1, 2, 3, 4, 5, 6]
// 차집합 : [1, 2]
// 교집합 : [3, 4]
