// 내풀이
// 조건문만 너무 덕지덕지한 느낌이 없지않아 있다. 
// 이게 최선인가?? 싶기도하고 실제 코테에 나왔으면 시간내에 못 풀었을듯 하다.
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

// 다른 풀이중에서 정갈하고 깔끔해 개인적으로 마음에 드는 코드
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

// 시간효율이 좋은 풀이
import java.util.*
class Solution {
    data class Word(
        val word : String,
        var count : Int = 1
    )
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE
        for(space in 1..s.length) {
            val compressedWordList = LinkedList<Word>()
            var startIndex = 0
            var endIndex = 0
            while(endIndex != s.length) {
                endIndex = (startIndex + space).let {
                    if(it > s.length) s.length
                    else it
                }
                val currentWord = s.substring(startIndex, endIndex)
                if(compressedWordList.isEmpty() || compressedWordList.peekLast().word != currentWord) compressedWordList.add(Word(currentWord))
                else compressedWordList.peekLast().count++
                startIndex = endIndex
            }
            val length = compressedWordList.fold(0) {
                acc, word ->
                acc + word.word.length + if(word.count == 1) 0 else {
                    word.count.toString().length
                }
            }
            if(length < answer) answer = length
        }
        return answer
    }
}
