class Solution {
    fun solution(numbers: IntArray): String {
        var answer: String = ""
        val arr = arrayOfNulls<String>(numbers.size)

        for (i in numbers.indices) {
            arr[i] = numbers[i].toString()
        }
        
        arr.sortWith(kotlin.Comparator { 
            str1, str2 -> (str2 + str1).compareTo(str1 + str2)})

        if (arr[0] == "0") {
            answer = "0"
            return answer
        }

        for (i in arr.indices) {
            answer += arr[i] 
        }

        return answer 
    }
}
