class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val list = mutableListOf<Int>()
        val copy = mutableListOf<Int>()
        
        for(i in progresses.indices){
            var count = 0
            while(progresses[i] < 100){
                count++
                progresses[i] += speeds[i]                
            }
            list.add(count)
            copy.add(count)
        }
        
        while(!list.isEmpty()){
            var result = 1
        
            for(i in 1..list.size-1){
                if(list[0] >= list[i]){
                    result++
                }else{
                    break
                }
            }
            answer.add(result)       
            for(i in 0 until result){
                for(j in 1..list.size-1){
                    list[j] -= copy[0]
                }
                list.removeAt(0)
                copy.removeAt(0)
            }
        }
        
        return answer.toIntArray() 
    }
}
