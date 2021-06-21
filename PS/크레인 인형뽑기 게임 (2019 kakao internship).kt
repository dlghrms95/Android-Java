class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var list = mutableListOf<Int>()
        
        moves.forEach{ i ->
            for(j in 0.. board.size-1){
                if(board[j][i-1] != 0){
                    if(!list.isEmpty() && list[list.size-1] == board[j][i-1]){
                        answer += 2
                        list.removeAt(list.size-1)
                    }else{
                        list.add(board[j][i-1])
                    }
                    board[j][i-1] = 0
                    break
                }
            }
        }
        
        return answer
    }
}
