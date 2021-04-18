이미 알고있는 내용이지만 정리차원에서 작성해보자

### inflate
사전적인 의미는 부풀게 하다라는 뜻. 안드로이드에서 inflate는 xml에 표기된 레이아웃들을 메모리에 객체화 시키는 행동이다. 쉽게 말해서 XML코드를 객체화 해서 코드에서 사용하기 위함이다.

기본적으로, 안드로이드에서는 화면(Activity)를 하나 만들면 java파일하나와 xml파일하나 해서 총 2개가 생성된다. 안드로이드 java코드에서 onCreate()메서드에 있는 setContentView(R.layout.activity_main)이 xml을 객체화 시키는 inflate동작이다. 그렇기 때문에 우리는 setContentView()함수 밑에서 xml에 배치했던 UI요소들을 끌어와 쓸수 있는 것이다.(메모리에 올라가 객체화 되었기 때문)

### LayoutInflater
만약, 다른 화면을 구성하는 XML을 불러오고 싶다면? 이런 경우 액티비티 생성시에 자동으로 생성된 XML이 아닌 개발자가 추가적으로 만든 XML을 객체화 시켜야하기 때문에 일련의 과정이 필요하다. 여러방법들이 있겠지만 대표적인 방법이 바로 LayoutInflater이다. 
LayoutInflater는 XML에 정의된 Resource를 View 객체로 반환해주는 역할을 한다.  

LayoutInflater는 안드로이드에서 View를 만드는 가장 기본적인 방법이며, Fragment의 View를 만들거나 RecyclerView에서 ViewHolder를 만들 때, CustomView에서 xml로 정의된 view를 merge할 때 등 여러곳에서 사용된다.

### LayoutInflater 생성방법
LayoutInflate 객체는 시스템 서비스 객체로 제공되기 때문에 getSystemService 메소드를 이용해 참조할 수 있다.
```JAVA
getSystemService(Context.LAYOUT_INFLATER_SERVICE)
```
그리고 뷰 객체가 있으면 그 뷰 객체에 인플레이션한 결과물을 설정하게 된다. 예를들어 FrameLayout객체 이거나 FrameLayout을 상속한 뷰 객체가 container라는 이름으로 만들어져 있다면, 아래와 같은 코드처럼 레이아웃 인플레이션을 진행할 수 있다.
```JAVA
FrameLayout container = (FrameLayout) findViewById(R.id.container);

LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
inflater.inflate(R.layout.sub1, container, true);
```
즉, LayoutInflater을 사용하기 위한 조건은 다음과 같다.  
1. 객체화하고자 하는 xml파일(sub1.xml)을 작성한다.  
2. LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); 라는 코드를 사용해서 LayoutInflater 객체 사용할 준비를 완료한다.  
3. inflater.inflate(R.layout.sub1, container, true); 라는 코드를 통해서 사전에 미리 선언해뒀던 container라는 레이아웃에 작성했던 xml의 메모리객체가 삽입되게 된다.

매개변수 설명 : inflate( 1.객체화하고픈 xml파일, 2.객체화한 뷰를 넣을 부모 레이아웃/컨테이너, 3.true(바로 인플레이션 하고자 하는지))

### 풀 예제
```JAVA
// activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical" >

    <FrameLayout
        android:id="@+id/container"
        android:layout_width="300dp"
        android:layout_height="300dp">

    </FrameLayout>

</LinearLayout>
```
```JAVA
// sub1.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/design_default_color_primary">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView"
        android:textColor="#FFFFFF"
        android:textSize="40sp" />

</LinearLayout>
```
```JAVA
// MainActivity

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout container = findViewById(R.id.container);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sub1, container, true);

        TextView textView = container.findViewById(R.id.textView);
        textView.setText("부분 화면");

    }

}
```
### 참조
[1️⃣](https://soo0100.tistory.com/1017)  
[2️⃣](https://www.crocus.co.kr/1584)  
