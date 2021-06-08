class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var n = citations.size

        for(i in 0..citations.size-1){
            var up = 0
            for(j in 0..citations.size-1){
                if(citations[j] >= n){
                    up++
                }else{
                    continue
                }
            }
            if(up >= n){
                answer = n
                break
            }else{
                n--
            }
        }

        return answer
    }
}
