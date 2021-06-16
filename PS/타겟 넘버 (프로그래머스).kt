class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        var list = mutableListOf<Int>(0)

        if((numbers.sum()-target)%2 != 0){
            return 0
        }

        numbers.forEach { i ->            
            var check = mutableListOf<Int>()
            list.forEach { j ->
                check.add(j+i)
                check.add(j-i)
            }
            list = check
        }
        answer = list.filter{it == target}.count()

        return answer
    }
}


// 나는 위방식으로 풀었는데 다른사람들풀이보니 
// 직관적으로 DFS재귀를 돌린경우 or 
// 간결하게 코틀린 함수 fold, run 등 이용한 경우도 있어서
// 다른 풀이방식들 많이 참고해봐야 할듯

[1]
class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        fun dfs(sum: Int,idx: Int){
            if(idx<numbers.size-1){
                dfs(sum+numbers[idx],idx+1)
                dfs(sum-numbers[idx],idx+1)
            }
            else{
                if(sum+numbers[idx] == target) {answer++}
                if(sum-numbers[idx] == target) {answer++}
            }
        }
        dfs(0,0)
        return answer
    }
}

[2]
class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { list, i ->
            list.run {
            map { it + i } + map { it - i }
            }
        }.count { it == target }
    }
}


// 성능은 [1] > [2] > 내풀이 순 ㅜㅜ
