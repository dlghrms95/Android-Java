class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        var map = mutableMapOf<Int,Double>()
        var users = stages.size
        
        for(i in 1..N){
            var count = 0
            stages.forEach{ j ->
                if(i == j) count++              
            }
            
            if(count != 0){
                var rating = count.toDouble() / users.toDouble()
                map.put(i, rating)
                users -= count 
            }else{
                map.put(i, 0.0)
            }          
        }
        
        val mapDes = map.toList().sortedByDescending{it.second}.toMap().toMutableMap()
        for(i in mapDes.keys){
            answer.add(i)
        }
        return answer.toIntArray()
    }
}
