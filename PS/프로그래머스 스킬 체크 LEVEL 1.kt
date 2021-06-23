// 문제 1
class Solution {
    fun solution(s: String): String {
        var answer = ""
        val l = s.length
        val start = l / 2

        if(l % 2 == 1){
            answer = s.substring(start, start+1)
        }else{
            answer = s.substring(start-1, start+1)
        }

        return answer
    }
}

// 문제 2
class Solution {
    fun solution(n: Int): Int {
        var answer: Double = 0.0
        var list = mutableListOf<Int>()
        var N = n

        while(N > 0){
            if(N < 3){
                list.add(N)
                break
            }
            var a = N / 3
            var b = N % 3
            N = a
            list.add(b)
        }
        val pow_num = list.size-1

        for(i in pow_num downTo 0){
            var num = list[i]
            answer += num * 3.0.pow(pow_num- i)
        }
        return answer.toInt()
    }
}
