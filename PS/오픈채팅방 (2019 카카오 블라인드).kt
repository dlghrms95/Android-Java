// 내풀이
class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        val user_list = mutableListOf<List<String>>()
        val user_map = mutableMapOf<String, String>()
        val name = StringBuilder()
        
        for(i in 0..record.size-1){
            var list = record[i].split(" ")
            user_list.add(i,list)
            if(list[0].equals("Enter") || list[0].equals("Change")){
                var user_id = list[1]
                var user_nickname = list[2]
                user_map.put(user_id, user_nickname)    
            }else{
                continue
            }
        }
    
        for(j in 0..record.size-1){
            var who = user_list[j][1]
            if(user_list[j][0].equals("Enter")){
                name.append(user_map[who]).append("님이 들어왔습니다.")
                answer.add(name.toString())
            }else if(user_list[j][0].equals("Leave")){
                name.append(user_map[who]).append("님이 나갔습니다.")
                answer.add(name.toString())
            }else{
                continue
            }
            name.delete(0, name.length)
        }
        
        return answer.toTypedArray()
    }
}

// 다른사람 풀이 
// 접근방식은 동일한데 보다더 간결하게 짰다.
class Solution {
    fun solution(record: Array<String>): Array<String> {
        val names = mutableMapOf<String, String>()
        for (r in record) {
            val s = r.split(" ")
            if (s[0] == "Enter" || s[0] == "Change") {
                names[s[1]] = s[2]
            }
        }

        val answer = mutableListOf<String>()
        for (r in record) {
            val s = r.split(" ")
            if (s[0] == "Enter") {
                answer.add("${names[s[1]]}님이 들어왔습니다.")
            } else if (s[0] == "Leave") {
                answer.add("${names[s[1]]}님이 나갔습니다.")
            }
        }
        return answer.toTypedArray();
    }
}
