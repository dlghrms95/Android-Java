class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map = HashMap<String, Int>() 
        for (i in clothes.indices) { 
            map.put( clothes[i][1] , map.getOrDefault(clothes[i][1], 0)+1 )
        }
        for (key in map.keys) {
            answer *= map[key]!! + 1
        }
        answer -= 1
        return answer
    }
}
