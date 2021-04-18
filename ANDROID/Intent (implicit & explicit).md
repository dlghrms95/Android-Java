## 간단히 알고 넘어가기
사전적 의미 그대로 해석하자면 Implicit Intent(암시적인텐트)는 인텐트의 의미가 불명확하다는 것이고, Explicit Intent(명시적인텐트)는 인텐트의 의미가 명확하다는 것이다.  

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

## Implicit Intent

## Explicit Intent

## Intent Filter

## 참조
(1️⃣)[https://codechacha.com/ko/android-explicit-implicit-intent/]  
(2️⃣)[]  
(3️⃣)[]

## 함께보기
(1️⃣)[]  
(2️⃣)[]
