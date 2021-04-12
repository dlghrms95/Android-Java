### lateinit와 lazy를 통한 지연초기화

### 장점
클래스를 생성하고 변수가 초기화되는 것보다 지연 초기화를 통해 메모리의 이득을 볼 수 있고, 초기화 시에 null로 할 필요가 없을 때 사용할 수 있다. 무조건 적으로 사용하는 객체가 아니라면, 필수 사용 변수가 아니라면 초기화를 나중해 하는것이다. 근데 사실 요정도 메모리 아끼자고 이렇게 까지 해야하나 싶긴하다. 그래도 좋은게 좋은거니..

### lateinit
전역변수로 선언 후 null값을 지정하지 않고 초기화하는 것이다. 변경가능한 var 키워드를 사용하여 선언한 경우에만 lateinit를 사용할 수 있고, 원시타입(privitive type)에 적용 할 수 없으며, getter/setter를 정의할 수 없다. null로 초기화를 할 수 없다.  
접근시에슨 :: (콜론2개)를 통해서만 접근이 가능하다.
```KOTLIN
class User { 
  lateinit var lateData: String 
} 

fun main(args: Array<String>) { 
  val user = User() 
  user.lateData = "hello world" 
  println(user.lateData) 
} 

// 실행결과 hello world
```
#### 사용규칙  
1. var로 선언한 프로퍼티에서만 사용할 수 있다.  
2. 클래스 몸체에 선언한 프로퍼티에서만 사용할 수 있다.(주 생성자에서는 사용 불가)  
3. 사용자 정의 getter/setter 를 사용하지 않는 프로퍼티에만 사용할 수 있다.  
4. null 허용 프로퍼티에는 사용할 수 없다.  
5. 기초타입 프로퍼티에는 사용할 수 없다.  
### by lazy
초기화를 늦게하는 Delegated 프로퍼티. Delegated 프로퍼티란, 프로퍼티에 대한 getter/setter를 위임하여 위임받은 객체로 명령을 수행하는 것을 말한다. 호출 시점의 by lazy에서 미리 정의한 내용에 의해 초기화되며, 변경 불가능한 val에서만 사용이 가능하다. 호출시점에서 최초 1회 초기화가 된다. lateinit와 다르게 변수선언과 동시에 초기화를 해야하지만, 호출 시점에서 초기화가 이루어짐으로 늦은 초기화라고 한다.
```KOTLIN
class User { 
  val name: String by lazy { 
    println("return name lazy") 
    "Lazy" 
  } 

  val age: Int by lazy { 
    println("return age lazy") 
    27 
  } 

  init { 
    println("user init") 
  }
  constructor() { 
    println("user sub constructor") 
  } 
} 

fun main(args: Array<String>) { 
  val user = User() 
  println("name : ${user.name}") 
  println("age : ${user.age}") 
} 

//실행결과 
//user init 
//user sub constructor 
//return name lazy 
//name : Lazy 
//return age lazy 
//age : 27
```

#### 사용규칙  
1. 호출 시점에 초기화 진행  
2. val로 선언한 프로퍼티에서만 사용가능  
3. 클래스 몸체 이외에 최상위 레벨에서 사용 가능  
4. 기초 타입에도 사용 가능  
