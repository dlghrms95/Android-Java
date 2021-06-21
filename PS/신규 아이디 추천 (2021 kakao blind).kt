class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""
        var regex1 = Regex("[^a-z0-9-_.]")
        var regex2 = Regex("[.]{2,}")
        answer = new_id.toLowerCase() // 1
        answer = regex1.replace(answer, "") //2
        answer = regex2.replace(answer,".") //3
        
        if(!answer.isEmpty() && answer.first() == '.') answer = answer.removeRange(0,1)
        if(!answer.isEmpty() && answer.last() == '.') answer = answer.removeRange(answer.length-1, answer.length)  //4   
        if(answer.isEmpty()) answer = "a" //5
        if(answer.length >=16) answer = answer.removeRange(15, answer.length) //6 
        if(answer.last() == '.') answer = answer.removeRange(answer.length-1, answer.length) //6
        
        while(answer.length <=2) {
            answer += answer[answer.length-1] 
        } //7
        
        return answer
    }
}
