class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val answer = StringBuilder()
        
        var keypad = mutableMapOf(
            1 to Pair(0,0),
            2 to Pair(0,1),
            3 to Pair(0,2),
            4 to Pair(1,0),
            5 to Pair(1,1),
            6 to Pair(1,2),
            7 to Pair(2,0),
            8 to Pair(2,1),
            9 to Pair(2,2),
            "*" to Pair(3,0),
            0 to Pair(3,1),            
            "#" to Pair(3,2)
        )
        
        var left :Any = "*"
        var right : Any = "#"        
                
        for(i in numbers){
            when(i) {
                1, 4, 7 -> {
                    answer.append("L")
                    left = i
                }
                3, 6, 9 -> {
                    answer.append("R")
                    right = i
                }
                else -> {
                    val next = keypad[i]!!
                    val curLeft = keypad[left]!!
                    val curRight = keypad[right]!!
                    
                    val lengthLeft = distance(next, curLeft)
                    val lengthRight = distance(next, curRight)
                    
                    if(lengthLeft > lengthRight){
                        answer.append("R")
                        right = i
                    }else if(lengthLeft < lengthRight){
                        answer.append("L")
                        left = i
                    }else {
                        if(hand == "right"){
                            answer.append("R")
                            right = i
                        }else {
                            answer.append("L")
                            left = i
                        }
                    }
                }
            }
        }
        return answer.toString()
    }
    
    private fun distance(next: Pair<Int,Int>, current: Pair<Int,Int>): Int{
      return kotlin.math.abs(next.first - current.first) + kotlin.math.abs(next.second - current.second)  
      
    }
}
