## 간단히 알고 넘어가기
인텐트는 컴포넌트에 액션, 데이터 등을 전달하는 메시지 객체이다. 인텐트는 암시적 인텐트와 명시적 인텐트로 보통 구분 짓는데, 사전적 의미 그대로 해석하자면 Implicit Intent(암시적인텐트)는 인텐트의 의미가 불명확하다는 것이고, Explicit Intent(명시적인텐트)는 인텐트의 의미가 명확하다는 것이다.  
<detail><summary>Intent 객체의 구성요소</summary>  
  1. Action(액션): 수행할 액션 이름(ACTION_DIAL)  
  2. Data(데이터): 수행할 데이터의 URI(tel:)  
  3. Category(카테고리): 수행할 액션에 대한 추가적인 정보  
  4. Type(타입): 수행할 인텐트 데이터의 명시적인 타입(MIME 타입)(video/mpeg)  
  5. Component name(컴포넌트 이름): 대상 컴포넌트의 완전한 클래스 이름  
  6. Extras(추가 정보): 인텐트를 다루는 컴포넌트에 추가적으로 전달할 한 쌍의 키/값  
  상세한 내용은 아래에 첨부링크 함께보기1️⃣ 에서 확인하자<detail>

+ 예를들어 MainActivity에서 SubActivity를 실행할 때 다음과 같이 표현이 가능하다.
  ```KOTLIN
  val intent = Intent(this, SubActivity::class.java)
  startActivity(intent)
  ```
  여기서 인텐트는 명시적 인텐트이다. 인텐트에 SubActivity::class.java를 인자로 넣어, SubActivity를 실행하라고 명확하게 의미를 전달했다.(ActivityManager는 이 인텐트를 해석하여 SubActivity를 실행한다)  

+ 반면에 암시적 인텐트는 클래스명이나 패키지명을 넣어주지 않는다. 아래의 코드는 암시적 인텐트로, 디바이스에 설치된 앱들 중 액션이 ACTION_DIAL, Uri가 tel:5551212인 인텐트를 처리할 수 있는 액티비티를 찾아서 실행해 준다.
  ```KOTLIN
  val intent = Intent(Intent.ACTION_DIAL)
  val TEST_DIAL_NUMBER = Uri.fromParts("tel", "5551212", null)
  intent.setData(TEST_DIAL_NUMBER)
  startActivity(intent)
  ```
  디바이스에 설치된 전화앱이 실행되고, Uri에 입력된 번호 5551212가 자동으로 입력된다. (전화앱에서 액티비티가 실행되면서 주어진 Uri를 읽어 번호를 입력하도록 구현이 되었을 것)

## Explicit Intent - 명시적 인텐트


## Implicit Intent - 암시적 인텐트

## Intent Filter
intent는 명시적 인텐트와 암시적 인텐트로 나뉜다. 그중 암시적 인텐트를 통해 사용자로 하여금 어느 앱을 사용할지 선택하도록 하고자 할 때 Intent Filter가 필요하다.  
인텐트 필터는 특정 인텐트를 받을지 말지를 정의하는 역할을 수행하며, 이를 통해 컴포넌트의 특징이 정해진다. 안드로이드 프로젝트내 Manifest파일에서 <intent-filter></intent-filter> 에 다양하게 정의 할 수 있다. 

## 암시적 인텐트 수신하기
안드로이드 프로젝트에서 Menifest

## 참조
(1️⃣)[https://codechacha.com/ko/android-explicit-implicit-intent/]  
(2️⃣)[https://www.charlezz.com/?p=859]  
(3️⃣)[]

## 함께보기
(1️⃣Intent 를 통한 다양한 액션들 및 상세내용)[https://kairo96.gitbooks.io/android/content/ch2.8.html]  
(2️⃣)[]
