class Solution {
    fun solution(s: String): String {
        var answer = s.toLowerCase().toCharArray()
        answer[0] = answer[0].toUpperCase() 
        
        for(i in 1..answer.size-2){
            if(answer[i] == ' '){
                answer[i+1] = answer[i+1].toUpperCase()
            }
        }
        
        return String(answer)
    }
}
