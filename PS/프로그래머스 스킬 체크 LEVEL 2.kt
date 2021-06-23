// 문제 1
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val find_num = priorities[location]
        var index_num = location
        val list = priorities.toMutableList()

        while(list.size > 0){

            var max = list.max()!!
            var first_num = list[0]

            if(first_num < max){
                list.add(list.removeAt(0))
            }else{                
                answer++
                list.removeAt(0)
                if(index_num == 0){
                    break
                }
            }
            index_num--
            if(index_num < 0){
                index_num = list.size-1
            }
        }

        return answer
    }
}

// 문제 2
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0 // 경과시간
        val passing = MutableList<Int>(bridge_length, {0}) // 다리를 건너는 트럭
        val waiting = truck_weights.toMutableList() // 대기 트럭

        while(!passing.isEmpty()){
            passing.removeAt(0)
            answer++

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
