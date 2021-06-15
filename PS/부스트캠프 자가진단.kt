fun main() {
    val arr = arrayOf(1,4,2,3,3,3,3,4,2,4,1,2,1)
    
    val list = mutableListOf<Int>()
    val map = LinkedHashMap<Int,Int>()
    
    arr.forEach{ i ->
        map.put(i, map.getOrDefault(i,0)+1)
    }       
  
    for(i in map.values){
        if(i != 1) list.add(i)
    }
    
    if(list.isEmpty()){
        print(-1)
    }else{
        for(i in 0..list.size-1) {
     		println(list[i])  
    	}
    }          
}
