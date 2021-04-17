### Why Custom View?
간단하다. UI를 더 이쁘게 만들기 위함이다. 그냥 안드로이드에서 제공하는 API를 사용하여 화면을 구성한다면 참 좋겠지만, 현실은 그렇지 않다. 사용자의 요구사항에 맞게 디자이너가 구성한대로 화면을 구성해주어야 한다. 이때 화면을 구성할 적절한 뷰가 없을 때 개발자는 커스텀 뷰를 만들어 사용한다. 예를들면, 원형 썸네일을 표현하기 위한 뷰를 만들기 위해서 ImageView를 상속할 수있고, 텍스트의 일부 내용만 보여주고 원할 때 펼쳐 모든 내용을 보여줄 수 있는 뷰를 만들기 위해서는 TextView를 상속할 수도 있다. 

### 커스텀 뷰를 만드는 3가지 방법
1. API에서 제공하는 뷰를 그대로 이용하면서 약간만 변형시킨 뷰
2. 여러 뷰를 합쳐서 한번에 출력하기 위한 뷰
3. 기존 API에 전혀 존재하지 않는 뷰

### 커스텀 뷰의 KEY POINT
1. 생성자는 3개를 만든다.
2. onDraw 함수를 통해서 그래픽을 그린다.
3. onMeasure 함수를 통해서 뷰의 크기를 결정한다.
4. 커스텀 속성을 attrs파일을 통해서 정의한다.  

```JAVA
// 1. 생성자는 3개로 만든다.

public MyView(Context context) {
    super(context);
    this.context = context;
    init(null);
}
 
public MyView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    this.context= context;
    init(attrs);
}
 
public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.context= context;
    init(attrs);
}
```
+ 생성자는 무조건 3개로 오버라이딩을 해야된다. 자바코드로만 커스텀뷰를 사용한다면 생성자를 1개만 만들어도 상관이 없지만, 보통은 xml파일을 통해서 커스텀뷰를 사용한다. xml파일로 커스텀 뷰를 만들경우 어떤 생성자를 사용할 지 모르기 때문에 생성자를 3개씩 만들어서 안드로이드가 어떤 생성자를 참조해야 하는지 명확하게 할 필요가 있다.

```JAVA
// 2. onDraw 함수를 통해서 그래픽을 그린다.

@Override
  protected void onDraw(Canvas canvas){
  ...
  }
```
+ onDraw()를 오버라이딩 해서 커스텀뷰의 표현을 꾸밀 수 있다. 여기 매개변수에 canvas변수가 있는데 이 객체를 통해 그래픽을 그린다.

```JAVA
// 3. onMeasure 함수를 통해서 뷰의 크기를 결정한다.

@Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
  ...
  }
```
+ onMeasure 함수를 통해서 xml에서 설정한 모드 및 크기를 받아서 멋스로운 커스텀 뷰를 만들 수 있다. 자칫 뷰의 크기를 자바 코드에서 결정을 해주지 않는다면 xml에서 wrap_content, match_parent, ?dp 처럼 지정해도 절대로 원하는 크기대로 표현할 수가 없다.

```JAVA
// 4. 커스텀 속성을 attrs파일을 통해서 정의한다.
                
                --attr.xml--
<resources>
  <declare-styleable name="MyView">
    <attr name="customTextColor" format="color"/>
  </declare-styleable>
</resources>

                --커스텀 속성을 값으로 받는 자바코드--
if(attrs != null){
  TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyView);
  textColor = a.getColor(R.styleable.MyView_customTextColor, Color.RED);
}
```
### 커스텀 뷰 만드는 기본적인 원리
1. 기존에 존재하는 View 클래스를 상속한다.
2. onDraw(), onMeasure(), onKeyDown()과 같이 시작하는 키워드가 'on'인 슈퍼 클래스 메서드를 오버라이드 한다.
3. 새로 만든 커스텀 뷰를 사용한다. 기존에 사용하던 방식과 같이 xml레이아웃 등에 사용한다.

### onDraw()
onDraw()에서는 개발자가 원하는대로 구현할 수 있는 Canvas를 제공한다. onDraw()를 오버라이드 하고, Canvas를 이용하여 그리고 싶은 내용을 화면에 그리면 된다.(3D 그래픽에는 적용되지 않으며 View대신 SurfaceView를 상속하여 별도의 쓰레드에서 그려야한다.[Open GL])

### onMeasure()
뷰와 뷰에 포함된 컨텐츠를 측정하여 측정된 width와 height를 결정한다. onMeasure()는 measure(int, int)에 의해 호출이되며, measure 메소드 에서는 뷰의 사이즈를 측정하고 실제 측정된 사이즈가 수행되는 곳이 onMeasure()이다. onMeasure()를 오버라이드 하는 경우 setMeasuredDimension(int, int)를 호출해서 측정된 사이즈를 저장할 수 있도록 해야한다. super.onMeasure()를 호출하는게 방법이 될수 있다.(onMeasure내에서 이미 한번 호출하고 있기 때문에)  

프레임워크가 호출하는 다른 View 메소드 / 이미 존재하는 View 커스텀하기 [📌](https://www.charlezz.com/?p=1035)


### customView는 이론보다 실습이 매우 중요해 보인다.


### 참고
[Custom View Components 공식](https://developer.android.com/guide/topics/ui/custom-components)  
[Creating a View Class 공식](https://developer.android.com/training/custom-views/create-view?hl=ko)  
[1️⃣](https://www.charlezz.com/?p=1035)  
[2️⃣](https://hongbeomi.medium.com/custom-view-%EB%A7%8C%EB%93%A4%EA%B8%B0-java-cfdda9aea202)  
[3️⃣](https://polyglot-programming.tistory.com/12)  

### 함께 보면 좋을 사이트
https://gun0912.tistory.com/38

