### android:  / app:  / tools: 

xml을 그릴때 위와같이 버튼이나 레이아웃 등에 속성을 주곤한다. 별 생각 없이 사용하곤 했었는데 문득 갑자기 궁금해져서 정리해본다.  
최대한 간단히 표현하자면 다음과 같다.  

+ android: 는 기본적으로 안드로이드스튜디오에 내장되어있는 기능들을 사용하는것이다.  
+ app: 은 따로 추가한 라이브러리에서의 기능을 사용하는 것이다.(        app:layout_constraintTop_toTopOf="@id/addButton" 과 같이 constraintlayout을implementation했기 때문에 app: 사용)  
+ tools: 는 xml디자인의 preview에만 보여지는것이다.(visibility속성들을 사용하는경우 매번 바꿔가며 레이아웃을 확인할 수 없기에)
