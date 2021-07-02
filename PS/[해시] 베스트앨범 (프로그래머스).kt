// 나의 첫번째 풀이
// 테스트케이스 일부를 통과하지 못한다.
// 도데체 어디가 틀린건지 아직도 못 찾는즁,,

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val map = mutableMapOf<String, Int>()
        val index_list = mutableListOf<Int>()
        val value_list = mutableListOf<Int>()
        var result_map = mutableMapOf<Int, Int>()
        
        for(i in 0..genres.size-1){
            map.put(genres[i], map.getOrDefault(genres[i], plays[i]) + plays[i])
        }
        
        val check_map = map.toList().sortedByDescending{it.second}.toMap()
        
        for(i in check_map.keys){
            for(j in 0..genres.size-1){
                if(genres[j].equals(i)){
                    index_list.add(j)
                    value_list.add(plays[j])
                }
            }
            
            for(l in 0..index_list.size-1){
                result_map.put(index_list[l], value_list[l])    
            }
            
            result_map = result_map.toList()
                .sortedBy{it.first}
                .sortedByDescending{it.second}.take(2)
                .toMap().toMutableMap()
                            
            for(m in result_map.keys){
                answer.add(m)
            }
            
            index_list.clear()
            value_list.clear()
            result_map.clear()
        }
        
        return answer.toIntArray()
    }
}

// 다른사람 풀이
// 미쳣다 이렇게 간단해질 수 있다니..
// groupBy, sumBy, take, flatten 등 다른데서도 활용할 부분이 많아보인다.

class Solution { 
    fun solution(genres: Array<String>, plays: IntArray): IntArray { 
        return genres.indices.groupBy { genres[it] } // {classic=[0,2,3], pop=[1,4]} Type : Map 
          .toList() // [(classic, [0,2,3]),(pop,[1,4])] Type : List 
          .sortedByDescending { it.second.sumBy { plays[it] } } // [(pop, [1,4]), (classic, [0,2,3])] Type : List 
          .map { it.second.sortedByDescending { plays[it] }.take(2) } // [[4,1],[3,0]] Type : List 
          .flatten() // [4, 1, 3, 0] Type : List 
          .toIntArray() // [4, 1, 3, 0] Type : IntArray 
    } 
}
