// 내풀이
// 조건문이 너무 덕지덕지한 느낌이 없지않아 있다. 
// 이게 최선인가?? 싶기도하고 실제 코테에 나왔으면 시간내에 못 풀었을듯 하다.
// 그래도 시간효율은 나쁘지 않은 편!
class Solution {
    fun solution(s: String): Int {
        var answer = 0
        val length = s.length
        val max_cut_size = length / 2
        val result = StringBuilder()
        val list = mutableListOf<Int>()
        
        if(max_cut_size == 0) return 1
        
        for(i in 1..max_cut_size){
            var count = 1
            var repeat = length / i
            var left_item = length % i
            var check = s.substring(0 , i)
                        
            for(j in 1..repeat-1){
                var cur_position = s.substring(i*j, i*(j+1))
                
                if(cur_position.equals(check)){
                    count++
                }else{
                    if(count == 1){
                        result.append(check)
                        check = cur_position
                    }else{
                        result.append("$count").append(check)
                        check = cur_position
                        count = 1
                    }
                }
            }
            
            if(left_item != 0){
                var none_group_item = s.substring(length-left_item, length)
                if(count != 1){
                    result.append("$count").append(check).append(none_group_item)
                }else{
                    result.append(check).append(none_group_item)
                }
            }else{
                if(count != 1){
                    result.append("$count").append(check)
                }else{
                    result.append(check)
                }    
            }
            
            list.add(result.length)
            result.delete(0, result.length)
        }
        
        answer = list.min()!!
        return answer
    }
}

// 다른사람 풀이
// 시간효율은 내풀이보다 15ms 정도 너 나왔지만, 다른 풀이 코드들과 비교했을 때 가장 정갈하고 깔끔하다.
import kotlin.math.min
class Solution {
    fun count(t:String, s:String, cur:Int, sum:Int) : Int {
        var len = cur.toString().length + t.length
        if(cur == 1)
            --len
        if(s.length < t.length)
            return sum + len + s.length
        return if(s.startsWith(t)) {
            count(t, s.substring(t.length),cur+1, sum)
        } else {
            count(s.substring(0, t.length), s, 0, sum + len)
        }
    }

    fun solution(s: String): Int {
        var answer = s.length
        val len = s.length / 2
        for(i in 1..len) {
            val t = s.substring(0 until i)
            answer = min(answer, count(t, s, 0, 0))
        }

        return answer
    }
}
