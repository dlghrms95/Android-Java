import java.io.*

fun main() = with(System.`in`.bufferedReader()){
	val N = readLine().toInt()
	val input = readLine().split(' ').map{it.toInt()}.toMutableList()
	
	val list = input.reversed()	
	val answer = MutableList<Int>(list.size,{0})
	
	list.forEachIndexed { index, value ->
		for(i in index+1 until list.size){
			if(value < list[i]){
				answer[list.size - 1 - index] = list.size - i
				break
			}
		}		
	}
	
	var str = StringBuilder()
	for(i in 0 until answer.size){
		str.append(answer[i].toString()).append(' ')
	}
	print(str)	
	
}

// 시간초과..
// 백준은 유형별로 굉장히 다양한 문제들이 많은건 좋은데
// 굳이 입출력을 따로 입력하고 받아야해서 프로그래머스보다 불필요한 소모가 생김
