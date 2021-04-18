## 간단히 알고 넘어가기
인텐트는 컴포넌트에 액션, 데이터 등을 전달하는 메시지 객체이다. 인텐트는 암시적 인텐트와 명시적 인텐트로 보통 구분 짓는데, 사전적 의미 그대로 해석하자면 Implicit Intent(암시적인텐트)는 인텐트의 의미가 불명확하다는 것이고, Explicit Intent(명시적인텐트)는 인텐트의 의미가 명확하다는 것이다.  
<details><summary>Intent 객체의 구성요소</summary>  
  
  1. Action(액션): 수행할 액션 이름(ACTION_DIAL)  
  2. Data(데이터): 수행할 데이터의 URI(tel:)  
  3. Category(카테고리): 수행할 액션에 대한 추가적인 정보  
  4. Type(타입): 수행할 인텐트 데이터의 명시적인 타입(MIME 타입)(video/mpeg)  
  5. Component name(컴포넌트 이름): 대상 컴포넌트의 완전한 클래스 이름  
  6. Extras(추가 정보): 인텐트를 다루는 컴포넌트에 추가적으로 전달할 한 쌍의 키/값 
    
  상세한 내용은 아래에 첨부링크 함께보기1️⃣ 에서 확인하자</details>

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

## Implicit Intent - 암시적 인텐트
암시적 인텐트는 명시적 인텐트와는 다르게 어떤 의도만으로 원하는 컴포넌트를 실행할 수 있다. 예를 들어 앱에서 구글을 실행하고자 하는 경우 웹 페이지를 보여주는 기능이 앱 안에 구현되어있거나 다른 외부 앱을 실행하여 구글을 실행해야 한다. 이때 인텐트 객체에 '구글 페이지를 띄우고 싶다'라는 정보만 담아 startActivity() 함수를 호출하게 되면 시스템(액티비티 매니저)은 해당 의도를 적절히 처리할 수 있는 컴포넌트를 찾아 처리 결과를 사용자에게 제공한다. 
  1. 액션(Action)  
    동작을 실행하는 미리 정의된 문자열을 의미한다. Intent 클래스에 미리 정의되어있다. (함께보기에서 확인)  
  2. 카테고리(Category)  
    해당 액티비티의 분류에 해당한다. 액션과 마찬가지로 Intent클래스에 미리 정의되어 있다.  
  3. 데이터(Data)  
    실행하고자 하는 컴포넌트가 특정 데이터를 필요로할 때 지정한다. (예를들어 구글 페이지를 띄울때 URL정보)
    
관련된 내용은 참조1️⃣에서 확인하자

## Intent Filter
intent는 명시적 인텐트와 암시적 인텐트로 나뉜다. 그중 암시적 인텐트를 통해 사용자로 하여금 어느 앱을 사용할지 선택하도록 하고자 할 때 Intent Filter가 필요하다.  
인텐트 필터는 특정 인텐트를 받을지 말지를 정의하는 역할을 수행하며, 이를 통해 컴포넌트의 특징이 정해진다. 안드로이드 프로젝트내 Manifest파일에서 <intent-filter></intent-filter> 안에서 다양하게 정의 할 수 있다. 상세 내용은 아래 함께보기 링크를 통해 확인

## 참조
[1️⃣](https://codechacha.com/ko/android-explicit-implicit-intent/)  
[2️⃣](https://www.charlezz.com/?p=859)  
[3️⃣](https://lktprogrammer.tistory.com/160)

## 함께보기
[1️⃣Intent 를 통한 다양한 액션들 및 상세내용](https://kairo96.gitbooks.io/android/content/ch2.8.html)  
[2️⃣intent-filter](https://siadaddy-cordinglife.tistory.com/23)
