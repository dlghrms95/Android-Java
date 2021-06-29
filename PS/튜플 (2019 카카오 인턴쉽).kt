// 처음에 주어진 테스트케이스만 고려해서 풀었더니, 제출시에 런타임 에러가 발생하는 테스트케이스가 있어서  
// 새로운 테스트케이스를 추가하고 코드를 수정하여 풀이완료
// 기존에 풀이는 
// 문자열 : "{{2},{2,1},{2,1,3},{2,1,3,4}}"
// 리턴값 : [2, 1, 3, 4]
// 에서 replace로 { 랑 , 를 전부 제거하고  >> 2}21}213}2134
// substring으로 맨뒤에 }}를 빼고 추출한다음 } 으로 split 하였다 >> [2, 21, 213, 2134]
// 여기서 순서를 길이가 작은순으로 정렬하고 첫번째 인덱스를 제외하고 
// 1. 1~3 인덱스에 대해서 2를 제거
// 2. 2~3 인덱스에서 1을 제거
// 3. 3~3 인덱스에서 3을 제거 하는 방식을 사용하여 최종적으로 [2, 1, 3, 4] 를 반환하였다.
// 위 풀이의 문제점은 주어지는 문자열에 두자리 이상 자연수가 들어갔을 때 , 를 전부 제거 하였기 때문에
// 기존 정보가 123 인지 12,3 인지 1,2,3 인지 구분이 불가하다 때문에 2차원 배열에 담아서 새로운 풀이를 완성했다.

class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()
        val str = s.substring(0, s.length-2).replace("{" , "").replace(",", " ")
        val list = str.split("} ")
            .map{it.split(" ").toMutableList()}
            .toMutableList()
            .sortedBy{it.size}
            
        answer.add(list[0][0].toInt())
                
        for(i in 1..list.size-1){
            var remove_char = list[i-1][0]
            var range_start = i
            var range_end = list.size - 1
                        
            for(j in range_start..range_end){
                list[j].remove(remove_char)
            }
            
            answer.add(list[i][0].toInt())
        }
            
        return answer.toIntArray()
    }
}

// 다른사람 풀이 1
class Solution {
    fun solution(s: String): IntArray {
        return s.substring(2 until s.length-2)
            .split("},{")
            .asSequence()
            .map { it.split(",").map { num -> num.toInt() } }
            .toList()
            .sortedBy { it.size }
            .fold(setOf<Int>()) { acc, list -> acc.union(list) }
            .toIntArray()
    }
}
