# ViewBinding & DataBinding

the 'kotlin-android-extensions' gradle plugin is deprecated.  
please use this migration guide (~ )  
to start working with view binding (~ )  
and the 'kotlin-parcelize' plugin.

코틀린 프로젝트를 진행하며 마주친 문제이다. ViewBinding 사용을 권장한다는 것인데, 기존에 findViewById에 익숙해져있어서 당황스럽지만 차근차근 익숙해지기위해 기록한다. 일단 익숙하지 않아서 그렇지 굉장히 편하다! 코드길이가 짧아지기도하고 가독성이 더 좋다. 자세한 내용은 공식문서를 참조하는 편이 좋을듯 하고 여기서는 간략히 해당 내용을 정리하고자 한다.

## ViewBinding 사용
findViewById를 쓰지않고, xml의 view component에 접근하는 object를 반환받아 view에 접근하는 방식이다. object는 자동으로 만들어진다.  
예를들어 Activity에서 사용하는 xml에 아래와 같은 항목이 있다고 가정하자
  + activity_hokeun.xml
  + id가 title인 TextView
  + id가 click인 Button  
위 view들은 Activity에서 다음과 같이 사용이 가능하다. (디테일한 부분은 공식문서를 참조하자)
```KOTLIN
override fun onCreate(savedInstanceState: Bundle?) { 
    super.onCreate(savedInstanceState) 
    val binding = ActivityHokeunBinding.inflate(layoutInflater) 
    
    binding.title.text = "Hello" 
    binding.button.setOnClickListener { /* ... */ } 
    
    setContentView(binding.root) 
}
```

## 왜 findViewById 보다 viewBinding??
+ Null-safe : 여러 설정이 존재하는 layout의 경우 해당 설정에 맞는 view만 찾아 낸다. 그리고 그렇지 않은경우 @Nullable 속성으로 만든다.
+ Type-safe : view binding은 layout 내부에 정확한 view 타입을 찾아 mapping하므로 해당 view의 속성으로 접근할때 해당 view에 맞는 속성값을 노출시킨다. 즉 예를들어 TextView라면 TextView의 속성에 맞는 properties만 노출된다.(불일치 문제가 없다) 
+ 코드가 간결해짐 : 매번 findViewById를 추가할 필요가 없음


## DataBinding
데이터 결합 라이브러리는 프로그래매틱 방식이 아니라 선언적 형식으로 레이아웃의 UI 구성요소를 앱의 데이터 소스와 결합할 수 있는 지원 라이브러리이다. 레이아웃은 흔히 UI 프레임워크 메서드를 호출하는 코드가 포함된 활동에서 정의된다. 예를 들어 아래 코드는 findViewById()를 호출하여 TextView 위젯을 찾아 viewModel 변수의 userName 속성에 결합한다.
```KOTLIN
    findViewById<TextView>(R.id.sample_text).apply {
        text = viewModel.userName
    }
```
다음 예는 데이터 결합 라이브러리를 사용하여 레이아웃 파일에서 직접 위젯에 텍스트를 할당하는 방법이다. 이 방법을 사용하면 위의 자바 코드를 호출할 필요가 없다. 할당 표현식에 사용되는 @{} 구문에 집중하자.
```KOTLIN
<TextView
        android:text="@{viewmodel.userName}" />       
```

#### 💡 왜 사용할까?  
레이아웃 파일에서 구성요소를 결합하면 엑티비티에서 UI프레임워크 호출을 삭제할 수 있어 파일이 더욱 단순화되고 유지관리가 편해진다. 덕분에 앱 성능이 향항되고 메모리누수 및 Null포인터 예외를 방지할 수 있다. xml파일에 data를 binding(연결)해서 사용가능!  
📍 MVVM 패턴을 구현 할 때 "LiveData" 와 함께 거의 필수적으로 사용한다!
 
#### 💡 레이아웃 및 바인딩 할당 표현식  
데이터바인딩 라이브러리는 레이아웃의 뷰를 데이터 개체와 결합하는 데 필요한 클래스를 자동으로 생성한다. 라이브러리는 imports(가져오기), variables(변수) 및 includes(포함)과 같이 레이아웃에서 사용할 수 있는 기능을 제공한다. 라이브러리의 이러한 기능은 기존 레이아웃과 원활하게 공존한다. 예를 들어 표현식에서 사용할 수 있는 결합 변수는 UI 레이아웃 루트 요소의 동위 요소인 data 요소 내에서 정의된다. 아래 예에 나와 있는 것처럼 두 요소는 모두 layout 태그로 래핑된다.
```KOTLIN
<layout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto">
        <data>
            <variable
                name="viewmodel"
                type="com.myapp.data.ViewModel" />
        </data>
        <ConstraintLayout... /> <!-- UI layout's root element -->
</layout>
```
#### 💡 식별 가능한 데이터 객체(가장 큰 장점같다)  
데이터바인딩 라이브러리는 데이터 변경을 쉽게 식별하기 위한 클래스 및 메서드를 제공합니다. 기본 데이터 소스가 변경될 때 UI 새로고침에 관해 신경쓰지 않아도 됩니다. 변수 또는 속성을 식별 가능하게 만들 수 있습니다. 라이브러리를 통해 객체, 필드 또는 컬렉션을 식별 가능하게 만들 수 있습니다.

#### 💡 BindingAdapter  
모든 레이아웃 표현식에는 속성 또는 리스너를 설정하는 데 필요한 프레임워크를 호출하는 BindingAdapter가 있다. 예를 들어 BindingAdapter는 setText() 메서드를 호출하여 텍스트 속성을 설정하거나 setOnClickListener() 메서드를 호출하여 리스너를 클릭 이벤트에 추가할 수 있다. 위에 언급한 android:text 속성의 어댑터와 같은 가장 일반적인 BindingAdapter는 android.databinding.adapters 패키지에서 사용할 수 있다.

#### 💡 Architecture Components 에 layout views 연결(이것도 큰 장점)  
Android 지원 라이브러리에는 성능이 뛰어나고 테스트와 유지관리가 쉬운 앱을 디자인하는 데 사용할 수 있는 아키텍처 구성요소가 포함되어 있다. 아키텍처 구성요소를 데이터 결합 라이브러리와 함께 사용하여 UI 개발을 한층 단순화할 수 있다.

#### 💡 양방향 데이터바인딩  
속성의 데이터 변경사항을 받는 동시에 속성의 사용자 업데이트를 수신 대기하는 기능을 지원한다.

#### 💡 결론  
예제에선 단순하게 하나의 TextView를 사용하여 Text를 바인딩 하기 때문에 크게 좋아보이지 않을 수 있으나 xml에 DTO 또는 데이터 집합 클래스를 Bind 해서 해당 클래스가 변경되면 연결된 여러개의 View가 한번에 변경되기 때문에 엄청나게 편해진다. 또한 Databinding과 같이 BindingAdapter를 이용해 ImageView에 Glide, Fresco 같은 이미지 로딩 라이브러리를 이용해서 이미지를 출력을 쉽게 할 수 있고 Databinding과 찰떡궁합인 LiveData를 사용하면 Data가 실시간으로 변경될 때 View도 같이 변경되니 MVVM 패턴 구현 시 엄청나게 편리해진다.  
  1. Databinding을 사용하면 findViewById(), 버터나이프를 쓰지 않아도 xml에 만든 View들을 자동으로 만들어 준다.  
  2. Data가 바뀌면 알아서 바뀐 Data로 View를 변경하게 할수도 있다. (옵저블 사용시)  
  3. RecyclerView에서 각각의 item을 세팅 해주는 작업도 xml에서 다 써주면 알아서 척척 값이 들어간다. (요거 엄청 편리합니다.)  
  4. JakeWharton의 Butterknife가 Deprecated 되었고 구글에서 권장하므로 앞으로는 Databinding을 사용 해야한다.

## ViewBinding vs DataBinding
뷰 바인딩과 데이터 바인딩 라이브러리 둘다 뷰를 직접 참조하는 바인딩 클래스를 생성한다. 하지만 뷰 바인딩은 보다 단순한 처리의 경우 적합하다.  

#### 💡 뷰 바인딩은 데이터 바인딩과 비교해 다음과 같은 이점을 제공한다  
  + 더 빠른 컴파일 : 뷰 바인딩에는 주석처리가 필요하지 않으므로 컴파일 시간이 더 짧다.
  + 사용 편의성 : 뷰 바인딩에는 특별히 태그된 XML레이아웃 파일이 필요하지 않으므로 앱에서 더 신속하게 채택할 수 있다. 모듈에서 뷰 바인딩을 사용설정하면 모듈의 모든 레이아웃에 뷰 바인딩이 자동으로 적용된다.  

#### 💡 뷰 바인딩은 데이터 바인딩과 비교해 다음과 같은 제한사항이 있다  
  + 뷰 바인딩은 레이아웃 변수 또는 레이아웃 표현식을 지원하지 않으므로 XML 레이아웃 파일에서 직접 동적 UI 콘텐츠를 선언하는 데 사용할 수 없다.
  + 뷰 바인딩은 양방향 데이터 결합을 지원하지 않는다.(ex. bindingAdapter)

#### 💡 주목할만한 차이점
  + 데이터 바인딩 라이브러리는 <layout> 태그를 사용하여 만든 레이아웃만 처리
  + 뷰 바인딩은 레이아웃 변수 또는 레이아웃 표현식을 지원하지 않으므로 XML의 데이터와 레이아웃을 바인딩하는 데 사용할 수 없다.
  + 내부적으로 데이터 바인딩 클래스를 생성할때 루트뷰에 tag를 삽입하는데 뷰바인딩은 그런 작업이 없다.
  + 뷰바인딩은 데이터바인딩보다 어노테이션 프로세싱의 일부를 사용하기 때문에 더 빠르게 바인딩 클래스를 생성한다

#### 💡 결론  
위 사항을 고려할 때 일부 사례에서 프로젝트에 뷰 바인딩과 데이터 바인딩을 모두 사용하는 것이 가장 좋다. 고급 기능이 필요한 레이아웃에는 데이터 바인딩을, 고급 기능이 필요 없는 레이아웃에는 뷰 바인징을 사용할 수 있다.
  
<img src="https://user-images.githubusercontent.com/63087903/113968206-9abf0800-986d-11eb-9eca-7fc48b27f6e7.png" width="550" height="250">
  
### 참조(공식문서는 영어로 읽자 한글버전을 최신화가 느리다)
[ViewBinding 공식문서](https://developer.android.com/topic/libraries/view-binding)  
[코틀린 익스텐션 대체를 위한 ViewBinding 처리](https://flow9.net/bbs/board.php?bo_table=android&wr_id=27)  
[view binding](https://tourspace.tistory.com/314)
[ViewBinding vs DataBinding](https://velog.io/@jaeyunn_15/AndroidViewBinding-vs-DataBinding)
[DataBinding 공식문서](https://developer.android.com/topic/libraries/data-binding)
[DataBinding 사용 공식문서](https://developer.android.com/topic/libraries/data-binding/start)
[DataBinding을 ](https://velog.io/@jojo_devstory/Android-Databinding%EC%9D%84-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90)
