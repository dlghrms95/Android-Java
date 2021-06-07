class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = IntArray(commands.size)
        val list: ArrayList<Int> = ArrayList()
        for (i in commands.indices) {
            for (j in commands[i][0] until commands[i][1] + 1) {
                list.add(array[j - 1])
            }
            list.sort()
            answer[i] = list[commands[i][2] - 1]
            list.clear()
        }
        return answer
    }
}
