class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        val days = arrayOf("THU","FRI","SAT","SUN","MON","TUE","WED")
        var month = arrayOf(31,29,31,30,31,30,31,31,30,31,30,31)
        var sum = 0
        
        if(a == 1){
            sum += b
        }else{
            for(i in 0..(a-2)){
                sum += month[i]
            }
            sum += b
        }    
        
        var count = sum % 7        
        answer = days[count]
        
        return answer
    }
}
