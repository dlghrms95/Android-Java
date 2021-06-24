class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<Array<Int>> {
        val arr1_row = arr1.size
        val arr1_colum = arr1[0].size
        val arr2_colum = arr2[0].size
        
        val answer = Array(arr1_row, {Array(arr2_colum,{0})})
                
        for(i in 0 until arr1_row){ // i = 0,1,2
            var sum = 0
            for(j in 0 until arr2_colum){ // j = 0,1,2
                var sum = 0
                for(k in 0 until arr1_colum){ // k = 0,1
                    sum += arr1[i][k] * arr2[k][j]
                }
                answer[i][j] = sum
            }
            
        }
        
        return answer
    }
}

// 이문제에서 내가 수정한 내용은 solution 의 반환타입을 
// Array<IntArray> 에서 Array<Array<Int>> 로 바꿨다는 사실
// 코틀린에서는 기본 타입의 요소를 저장하는 배열을 별도의 클래스로 가지고 있는데
// IntArray 를 포함해 LongArray, CharArray(StringArray는 없음!) 등이 그것이다.
// 반면에 Array<T>() 는 제네릭 타입을 기준으로 컴파일하는것으로 객체가 생성되는 것이다.
// 그러므로 둘간에 타입이 다르다는것을 잘 알아두자!
// 참고로 Array<>()를 사용하여 배열을 만들면 메모리 낭비와 성능 저하의 이슈가 발생할 수도 있다.

------------------------------------------------------------------------------

// 다른사람 풀이 1
class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        var answer2 = Array(arr1.size, {IntArray(arr2[0].size, {0})})

        var sum : Int = 0

        for(i in 0..arr1.size-1 step 1){
            for(j in 0..arr2[0].size-1 step 1){

                for(k in 0..arr1[0].size-1)
                {
                    sum += arr1[i][k] * arr2[k][j]
                }
                answer2[i][j] = sum
                sum = 0
            }
        }
        answer = answer2

        return answer
    }
}

// 다른사람 풀이 2
class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array<IntArray>(arr1.size) { i -> 
                Array<Int>(arr2[0].size) { j ->
                        var value = 0
                        for(n in 0 until arr1[i].size) {
                            value += (arr1[i][n] * arr2[n][j])
                        }
                        value
                }.toIntArray()
        }

        return answer
    }
}

