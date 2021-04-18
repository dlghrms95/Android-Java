### 들어가기 앞서
안드로이드 프로젝트를 진행하며 context라는 글자를 많이 접했다. 하지만 그 의미와 쓰임새에 대해선 제대로 알고있지 않았는데 이번기회에에 정리해보고자 한다.  

+ 안드로이드 개발자 사이트의 Context클래스 오버뷰 내용은 다음과 같다.  
  : 글로벌 정보를 접근하기 위한 인터페이스. Abstract 클래스이며 실제 구현은 안드로이드 시스템에 의해 제공된다. Context 를 통해, 어플리케이션에 특화된 리소스나 클래스에 접근할 수 있을 뿐만 아니라, 추가적으로, 어플리케이션 레벨의 작업 - Activity 실행, Intent 브로드캐스팅, Intent 수신 등, 을 수행하기 위한 API 를 호출 할 수도 있다. 
  
때문에 Context를 이용해서 getPackagerName(), getResource(), startActivity(), startService(), getSystemService() 와같은 시스템 레벨의 정보를 얻을수 있는 메소드를 쓸수 있게 된다. Contect는 안드로이드 개발에잇어서 모든 곳에서 이루어지며, 가장 중요한 부분이므로 올바로 사용해서 메모리 누수를 막아야 할것이다.

#### 💡 즉, Context는 크게 두가지 역할을 수행하는 추상 클래스이다.
1. 어플리케이션에 관하여 시스템이 관리하고 있는 정보에 접근하기
2. 안드로이드 시스템 서비스에서 제공하는 API를 호출 할 수 있는 기능  

### Context
영어그대로 해석하면 '문맥','맥락' 정도의 뜻을 지닌다. 안드로이드 프로젝트단위에서 선택한 폴더에 따라 어떤것을 고른 것인지 그 상황에 맞는 맥락을 나타내 준다고 생각하면 된다. 쉽게말해 애플리케이션이나 객체의 현재 상태를 나타내주는 것이라 생각하면 된다.  
예를 들어보자, 액티비티 내에서 막 객체를 생성하였다면 생성된 객체는 자신이 위차한 환경(액티비티 / 애플리케이션)이 어떤 곳인지 대략적으로 알 필요가 있다.("나는 지금 어디에있고 나는 다른 객체들과 어떻게 소통하지?") 이럴 때 context가 필요하고 보통 this.~ 으로 많이 사용해 왔다.  

안드로이드 App을 구성하는 Activity는 Context를 상속 받는다. 여러개의 Activity가 있다고 생각해보자 A, B, C 액티비티가 있다고 하면 각 액티비티에 맞게 Context정보는 각자 다르다. 즉, 어떤 Activity 혹은 어떤 application 인가에 대해서 구별하는 정보가 context라고 이해하면 코드를 작성하는데 큰 어려움이 없을 것이다. (Context자리에 this를 쓰는 경우가 많이 있는데 이역시 지금 작성하는 액티비티를 구별해 지칭해주는것이라 볼수 있을것이다.)

#### 💡 정리하자면 Context는
1. Application의 현재 상태에 대한 맥락이다.
2. Application/Activity에 관련된 정보를 얻을 수 있다.
3. Resource/DB/SharedPreferences에 접근할 때 사용되기도 한다.
4. Application/Activity의 부모 클래스이다.

### Context는 Activity, Application, Service 등의 base class 이다
context는 TV를 조종하는 리모컨이고, TV의 다양한 채널들은 어플리케이션의 자원들이다. 이 때 context(리모컨)의 역할은 다양한 자원(채널)들에 접근할 수 있게 해준다.

### Context를 얻는 방법
+ getApplicationContext()
+ getContext()
+ getBaseContext()
+ this : context를 확장한 class의 경우
+ ...

### 참조
[1️⃣](https://zxcv5500.tistory.com/258)  
[2️⃣](https://velog.io/@allocproc/android-Context%EB%9E%80)  
[3️⃣](https://velog.io/@l2hyunwoo/Context-In-Android)  

### 함께 보면 좋은 글
[1️⃣ Application Context vs Activity Context](https://www.charlezz.com/?p=1080)  
