// 이 풀이는 내풀이가 아니고 다른사람의 풀이를 참조하였다.
// 아직 재귀를 다루는게 익숙하지 않아서
// 공부가 많이 필요하다.

class Solution {
    val set = mutableSetOf<Int>()
    
    fun solution(numbers: String): Int {
        getCombination(numbers, "")  
        
        return set.filter{ isPrime(it) }.count()
    }
    
    private fun getCombination(numbers: String, result: String) {
        if (result.isNotEmpty()) {
            set.add(result.toInt())
        }
        if (numbers.isEmpty()) {
            return
        }
        numbers.forEachIndexed { index, c ->
            getCombination(numbers.removeRange(index..index), c.plus(result))
        }
    }
    
    private fun isPrime(number: Int): Boolean {
        if (number == 1 || number == 0) {
            return false
        }
        for (i in (2..(number / 2))) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }    
    
}
