## ViewBinding & DataBinding

the 'kotlin-android-extensions' gradle plugin is deprecated.  
please use this migration guide (~ )  
to start working with view binding (~ )  
and the 'kotlin-parcelize' plugin.

코틀린 프로젝트를 진행하며 마주친 문제이다. ViewBinding 사용을 권장한다는 것인데, 기존에 findViewById에 익숙해져있어서 당황스럽지만 차근차근 익숙해지기위해 기록한다. 일단 익숙하지 않아서 그렇지 굉장히 편하다! 코드길이가 짧아지기도하고 가독성이 더 좋다. 자세한 내용은 공식문서를 참조하는 편이 좋을듯 하고 여기서는 간략히 해당 내용을 정리하고자 한다.

### ViewBinding 사용
findViewById를 쓰지않고, xml의 view component에 접근하는 object를 반환받아 view에 접근하는 방식이다. object는 자동으로 만들어진다.  
예를들어 Activity에서 사용하는 xml에 아래와 같은 항목이 있다고 가정하자
  + activity_hokeun.xml
  + id가 title인 TextView
  + id가 click인 Button
위 view들은 Activity에서 다음과 같이 사용이 가능하다.(디테일한 부분은 공식문서를 참조하자)
```JAVA
override fun onCreate(savedInstanceState: Bundle?) { 
    super.onCreate(savedInstanceState) 
    val binding = ActivityHokeunBinding.inflate(layoutInflater) 
    
    binding.title.text = "Hello" 
    binding.button.setOnClickListener { /* ... */ } 
    
    setContentView(binding.root) 
}
```
### findViewById와 비교햇을 때 viewBinding이 갖는 이점
+ Null-safe : 여러 설정이 존재하는 layout의 경우 해당 설정에 맞는 view만 찾아 낸다. 그리고 그렇지 않은경우 @Nullable 속성으로 만든다.
+ Type-safe : view binding은 layout 내부에 정확한 view 타입을 찾아 mapping하므로 해당 view의 속성으로 접근할때 해당 view에 맞는 속성값을 노출시킨다. 즉 예를들어 TextView라면 TextView의 속성에 맞는 properties만 노출된다.(불일치 문제가 없다) 


### DataBinding

### ViewBinding vs DataBinding
뷰 바인딩과 데이터 바인딩 라이브러리 둘다 뷰를 직접 참조하는 바인딩 클래스를 생성한다. 하지만 뷰 바인딩은 보다 단순한 사용 사례를 처리하기 위한 것이다.  

💡 뷰 바인딩은 데이터 바인딩과 비교해 다음과 같은 이점을 제공한다.  
  + 더 빠른 컴파일 : 뷰 바인딩에는 주석처리가 필요하지 않으므로 컴파일 시간이 더 짧다.
  + 사용 편의성 : 뷰 바인딩에는 특별히 태그된 XML레이아웃 파일이 필요하지 않으므로 앱에서 더 신속하게 채택할 수 있다. 모듈에서 뷰 바인딩을 사용설정하면 모듈의 모든 레이아웃에 뷰 바인딩이 자동으로 적용된다.  

💡 뷰 바인딩은 데이터 바인딩과 비교해 다음과 같은 제한사항이 있다.  
  + 뷰 바인딩은 레이아웃 변수 또는 레이아웃 표현식을 지원하지 않으므로 XML 레이아웃 파일에서 직접 동적 UI 콘텐츠를 선언하는 데 사용할 수 없다.
  + 뷰 바인딩은 양방향 데이터 결합을 지원하지 않는다.

💡 주목할만한 차이점은 다음과 같다.
  + 데이터 바인딩 라이브러리는 <layout> 태그를 사용하여 만든 레이아웃만 처리
  + 뷰 바인딩은 레이아웃 변수 또는 레이아웃 표현식을 지원하지 않으므로 XML의 데이터와 레이아웃을 바인딩하는 데 사용할 수 없다.
  + 내부적으로 데이터 바인딩 클래스를 생성할때 루트뷰에 tag를 삽입하는데 뷰바인딩은 그런 작업이 없다.
  + 뷰바인딩은 데이터바인딩보다 어노테이션 프로세싱의 일부를 사용하기 때문에 더 빠르게 바인딩 클래스를 생성한다

💡 결론 : 위 사항을 고려할 때 일부 사례에서 프로젝트에 뷰 바인딩과 데이터 바인딩을 모두 사용하는 것이 가장 좋다. 고급 기능이 필요한 레이아웃에는 데이터 바인딩을, 고급 기능이 필요 없는 레이아웃에는 뷰 바인징을 사용할 수 있다.
  
  
### 참조
[ViewBinding 공식문서](https://developer.android.com/topic/libraries/view-binding)  
[코틀린 익스텐션 대체를 위한 ViewBinding 처리](https://flow9.net/bbs/board.php?bo_table=android&wr_id=27)  
[view binding](https://tourspace.tistory.com/314)
[ViewBinding vs DataBinding](https://velog.io/@jaeyunn_15/AndroidViewBinding-vs-DataBinding)
