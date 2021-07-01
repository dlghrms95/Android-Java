// 내 풀이
class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val list = mutableListOf<Int>()
        
        val person_1 = arrayOf(5,1,2,3,4)
        val person_2 = arrayOf(5,2,1,2,3,2,4,2)
        val person_3 = arrayOf(5,3,3,1,1,2,2,4,4,5)
        
        val size_1 = person_1.size // 5
        val size_2 = person_2.size // 8
        val size_3 = person_3.size // 10
        var count_1 = 0
        var count_2 = 0
        var count_3 = 0
        
        for(i in 1..answers.size){
            val a = i % size_1 // a = 0~4
            val b = i % size_2 // b = 0~7
            val c = i % size_3 // c = 0~9
            
            if(person_1[a] == answers[i-1]) {
                count_1++
            }            
            if(person_2[b] == answers[i-1]) {
                count_2++
            }
            if(person_3[c] == answers[i-1]) {
                count_3++
            }
        }
        
        list.add(count_1)
        list.add(count_2)
        list.add(count_3)
        
        val check = list.max()
        
        for(i in 1..list.size){
            if(list[i-1] == check){
                answer.add(i)
            }
        }
        
        return answer.toIntArray()
    }
}

// 다른사람 풀이
// 더 짧지만 속도는 더 느림

class Solution {
    fun solution(answers: IntArray): IntArray {
        var supo1 = intArrayOf(1,2,3,4,5)
        var supo2 = intArrayOf(2,1,2,3,2,4,2,5)
        var supo3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var x = 0; var y = 0; var z = 0

        var map = mutableMapOf<Int,Int>(Pair(1,0),Pair(2,0),Pair(3,0))
        for(i in answers) {
            if(i == supo1[x]) map.put(1,map[1]!! + 1)
            if(i == supo2[y]) map.put(2,map[2]!! + 1)
            if(i == supo3[z]) map.put(3,map[3]!! + 1)
            x = if(x < 4) x + 1 else 0
            y = if(y < 7) y + 1 else 0
            z = if(z < 9) z + 1 else 0
        }

        var max = map.maxBy({it.value})?.value
        for(i in 1..map.size) if(map[i] != max) map.remove(i)
        var answer = map.toList().sortedWith(compareBy({it.second})).toMap().keys.toIntArray()

        return answer
    }
}
