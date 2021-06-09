class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val list = priorities.toCollection(mutableListOf())
        var findIndex = location    
        
        if(findIndex == list.max()){
            return 1
        }
        
        while(!list.isEmpty()){
            if(findIndex < 0){
                findIndex = list.size-1
            }
            
            if(list[0] != list.max()){
                list.add(list[0])
                list.removeAt(0) 
                findIndex-- 
            }else{
                if(findIndex == 0){
                    answer++
                    break
                }else{
                    answer++
                    list.removeAt(0) 
                    findIndex-- 
                }                
            }            
        }
        return answer 
    }
}
