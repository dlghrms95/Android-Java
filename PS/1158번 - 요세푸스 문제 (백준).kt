import java.io.*

fun main() = with(System.`in`.bufferedReader()){
	val (N, K) = readLine().split(' ').map{it.toInt()}
	val list = MutableList(N,{i -> i+1})
	val answer = StringBuilder()
	var size = list.size
	var count = K-1
	
	while(!list.isEmpty()){
		answer.append(list[count]).append(", ")
		list.removeAt(count)
		size--
		
		if(size == 0){
			answer.insert(0,'<')
			answer.deleteCharAt(answer.length -1)
			answer.deleteCharAt(answer.length -1)
			answer.insert(answer.length,'>')
			break
		}		
		count += K-1
		count %= size
	}
	print(answer.toString())
}

// 분류: 자료구조, 큐
