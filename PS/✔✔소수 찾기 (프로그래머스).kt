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

// 다시 풀어본 내 풀이
// 거의 혼자 했지만 permutaion 부분에서 조합 forEachIndexed 는 또 참조했다.
class Solution {
    val result_set = mutableSetOf<Int>()
    
    fun solution(numbers: String): Int {
        var answer = 0
        
        permutation(numbers, "")
        
        for(i in result_set){
            answer += sosu(i)
        }
        
        return answer
    }
    
    fun permutation(numbers: String, result: String){
        if(!result.isEmpty()) {
            result_set.add(result.toInt())
        }
        if(numbers.isEmpty()) {
            return
        }
        
        numbers.forEachIndexed { index, value ->
            permutation(numbers.removeRange(index..index) , value + result)           
        }
    }
    
    fun sosu(num: Int): Int{        
        if(num == 1 || num == 0){
            return 0
        }
        
        for(i in 2..num-1){
            if(num % i != 0){
                continue
            }else{
                return 0
            }
        }
        return 1        
    }
    
}
