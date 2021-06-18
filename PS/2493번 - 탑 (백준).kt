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
