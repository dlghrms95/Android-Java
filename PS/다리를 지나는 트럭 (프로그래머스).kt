class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0 //경과시간
        val waiting = truck_weights.toMutableList() // 대기트럭
        val passing = MutableList<Int>(bridge_length, {i -> 0}) // 다리를 건너는 트럭
       
        while(!passing.isEmpty()){
            answer++
            passing.removeAt(0)
            
            if(!waiting.isEmpty()){
                if(waiting[0] + passing.sum() <= weight){
                    passing.add(waiting[0])                
                    waiting.removeAt(0)
                }else{
                    passing.add(0)
                }
            }
        }
        
        return answer
    }
}
