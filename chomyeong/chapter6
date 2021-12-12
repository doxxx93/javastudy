## 객체지향 프로그래밍1

## 주의

- 하나의 소스 파일에 여러 클래스 작성- 원래는 하나의 소스 파일에 하나의 클래스를 작성하는 것이 국룰이나... **여러 개**도 가능
    1. 규칙 1. **public이 붙은 클래스(아니면 public 메서드가 포함된 클래스)는 하나만** 있어야하고, 소스파일의 이름(Hello2.java 같은)과 public 클래스의 이름이 같아야한다. 그렇지 않다면 함수를 호출해도 제대로 호출이 안된다. 만약 그래도 실행하고 싶다면  run figuration 에서 해당 메소드를 찾아서 실행한다. (원래는 소스파일의 이름과 같은 메서드로 자동 설정된다)
    2. 규칙 2. public이 없다면 소스파일의 이름은 클래스의 이름 중 하나면 된다. 
    3. 규칙 3. 파일이름 대소문자 구분해야한다.
- 객체를 만드는 클래스와 실행하는 클래스 분리
- 속성과 메서드를 포함한 클래스, 그리고 iv와 cv를 포함한 클래스가 나중에 작성되어있다===> **JVM이 먼저 static 부분을 메모리에 올리고 그 다음에 Class들을 올리고 Main 메서드를 수행**하는 것으로 알고 있습니다. 이는 자바는 객체지향이기에 앞뒤 선언 상관 없다.
- 연습을 여러 번 해서 그림 안 보고 코드만 보고 저처럼 단계별로 스택 그림을 그릴 수 있어야! ## 플래쉬 동영상 꼭 보기
- 같은 클래스 내에서 선언된 메서드를 같은 클래스 내에서 호출할 때는 클래스이름.메서드이름이 아니라 메서드 이름만!!
- 인스턴스 멤버(메서드, 변수)를 사용하기위해 객채 생성 팁

```java
MemeberCall c = new MemberCall(); 
int result = c.instanceMethod1();

// 를 다음과 같이 한 줄로 할 수 있다.

int result = new MemberCall().instanceMethod1();

// 대신 참조변수를 선언하지않아기에 생성된 MemberCall 인스턴스는 더 이상 사용 불가!
```

## 1.1 객체지향 언어

- **설계**와 관련된 언어이다. **객체는 속성만 갖고 있는게 아니라 기능을 가질 수도!**
- **코드의 재사용성이 높고,유지보수 용이, 중복 코드 제거 ⇒ 이를 중점으로 학습!**
- 서로 관련된 값들을 묶을 수 있다는 장점. 또한, 제어자와 메서드를 이용해서 데이터 보호 및 올바른 값 유지.

```java
ex) class Time {
		int hour; int minute; int second;
		} 
// int 타입 빈 상자 3개를 갖고 있는 Time이라는 객체 생성하게끔 하는 설계도
// 객체 그 자체는 아니다. 즉, 객체를 만들어야 사용 가능하다. 

		Time t = new Time(); 
// Time t 라는 빈 상자(객체 주소값 있다)를 만들고, 이는 객체를 가리키는 리모컨이 된다. 그래서 자연스럽게 int 타입 빈 상자 3개도 사용하게 된다.
		t.hour =12;
		t.minut = 34;
		t.second = 56;
```

- 객체지향 언어= 프로그래밍 언어+ 객체지향 개념(규칙)

-> **규칙 외우기(외우지 않으면 에러가 나와도 무슨 말인지 모른다. 이해 못해도 일단은 외우기부터.  요약하고 깜지로 공부할것**)

- ## 깃허브에서 자바의정석 마스터 예제 다운받기!!
    
    여기 플래쉬를 보면서 콘솔과 메모리가 어떻게 변하는지 볼 수 있다. 나중에 코드를 보면서 메모리 그림을 그릴 줄 알아야!!
    
    - 핵심개념 1. 캡슐화 2. 상속 3. 추상화  4. 다형성(가장 중요)
    - 공부법: 6장 2-3번 반복. 7장은 다형성까지만 반복 공부하고, 추상화. 인터페이스는 다형성 이해 후 공부할 것. ⇒ 중요한 것은 얼른 만들어보는 것이 중요. 객체지향을 마스터하면 디자인패턴 등의 이론서 혹은 JSP, Spring 등의 실습.

## 2. 클래스와 객체

- **클래스**: 객체를 정의한 것. 객체를 생성하는데 사용하는 설계도

// JDK에서는 프로그래밍을 위해 많은 수의 유용한 클래스(Java API)를 기본 제공

ex)  붕어빵 기계**객체**: 실제로 존재하는 것. 사물 또는 개념. 객체가 가지고 있는 기능과 속성에 따라 다르다. 객체를 사용하기위해 필요(이는 객체가 가진 속성과 메서드를 활용한다는 뜻) ex) 제품, 붕어빵

![// void power() 는 매개변수 없고, power를 게속 !power로 정의하면서 Tv를 킬 때는, power = false; 인데, !power가 true 여서 이를 power 속성에 저장하고 tv를 키게 되는 것. 끌 때는 그 반대.](https://blog.kakaocdn.net/dn/Y6Yzz/btrc2o9lan1/GJTpoRo0MAXGYefOnbjCF1/img.png)

// void power() 는 매개변수 없고, power를 게속 !power로 정의하면서 Tv를 킬 때는, power = false; 인데, !power가 true 여서 이를 power 속성에 저장하고 tv를 키게 되는 것. 끌 때는 그 반대.

## 2.2 객체와 인스턴스

 - 객체: 클래스에 정의된 내용대로 메모리에 생성된 것을 뜻한다.

 - 클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화, 이렇게 만들어진 객체를 클래스의 인스턴스라고 한다. 

 - 객체는 모든 인스턴스를 대표하는 포괄적 의미, 인스턴스는 보다 구체적인 의미

ex) 책상은 객체다. 그리고 책상은 책상 클래스의 인스턴스다. 

- 객체의 구성요소: 속성과 기능

- 예를 들어, TV라는 객체가 있다면 **객체 = 속성(변수) + 기능(메서드)**로 나누면 된다고 생각했다.  즉, 객체는 속성과 기능의 **집합**. 속성과 기능은 해당 객체의 **멤버**다.

```java
ex) class tv{
        String color; //색깔
        boolean power; //전원상태
        int channel; //채널   ----- 속성(변수) = 멤버변수 // 또한, 자료형
										 //이 때, 멤버션수들은 자료형에 맞게 기본값으로 **초기화**

        void power() {power= !power;} // 이를 통해 굳이 if문 사용x
        void channedUp() { channel++;}
                                   -----기능(메서드)
```

이렇게 속성과 메서드를 만들면 하나의 클래스가 만들어진다. = 설계도

![https://blog.kakaocdn.net/dn/bflR8m/btrc6QYkFrO/eld9F9kMIEXWfYoyTFPpM1/img.png](https://blog.kakaocdn.net/dn/bflR8m/btrc6QYkFrO/eld9F9kMIEXWfYoyTFPpM1/img.png)

## 2.4 객체의 생성과 사용 (클래스[설계도] 작성), 객체배열

### **1. 객체의 생성**

- 클래스명 변수명; // 클래스의 객체를 참조하기 위한 참조변수를 선언 

 - 인스턴스는 참조변수를 통해서만 다룰 수 있고, 참조변수와 인스턴스의 타입은 =   

ex)

```java
Tv t= new Tv(); 
// TV 클래스 타입의 참조변수 t 선언과 Tv 인스턴스를 생성
// **Tv t 는 아직 아무런 값도 없는 빈 상자이기에 메모리 주소도 없다.** 
// 생성된 Tv인스턴스의 주소를 참조변수 t에 저장
// (오른쪽부터 읽어나가자)==>> 이 부분 되게 중요!!
```

- Tv t;  의 의미
    
    //  t 변수를 선언한 순간, TV클래스의 객체(기능과 메서드)가 메모리에 만들어진다. 참조변수를 선언하는 건이 곧 리모컨과 같은데, 이것이 없다면 객체를 사용할 수 없다. 쉽게 말해서, Tv t를 선언한 순간, Tv 타입에 맞는 리모컨이 만들어지고, new Tv()로 Tv인스턴스를 생성한 후, 이를 사용하기위해 알맞는 타입의 리모컨 t로 연결한다고 생각하자.
    

![t 변수 선언과 TV인스턴스 생성되고나서 어떤 형태로 연결되는지](https://blog.kakaocdn.net/dn/bkwmUE/btrcVjuNSOI/7pm6DLFdcQSEMuZLb5ePy1/img.png)

t 변수 선언과 TV인스턴스 생성되고나서 어떤 형태로 연결되는지

### **2. 객체의 사용**

ex) t1.channel = 7; 인 경우, Tv t1과 Tv t2의 .channel 은 이름만 같지, 다른 변수이다.

- 객체의 생성과 사용

 - Tv2 객체 사용 불가. 사용할 수 없는 객체는 가비지 컬렉터(청소부)로 간다.

 - 하나의 인스턴스를 여러 개의 참조변수가 가리키는 것은 가능하나, 여러 인스턴스를 하나의 참조변수가 가리킬 수 없다.  

![https://blog.kakaocdn.net/dn/tGJq0/btrcUllSVnE/9ewE0tvDh8ViVJtehX8Ka1/img.png](https://blog.kakaocdn.net/dn/tGJq0/btrcUllSVnE/9ewE0tvDh8ViVJtehX8Ka1/img.png)

Tv2 객체 사용 불가

<aside>
🔥 Tv타입 객체를 참조한 t1, t2이 있는데, t2 = t1; 을 하게 되면 t2 리모컨이 t1 리모컨과 같아져, t1리모컨이 가리키는 객체를 참조하게 된다.

</aside>

- 과정
    
    ![https://blog.kakaocdn.net/dn/tGJq0/btrcUllSVnE/9ewE0tvDh8ViVJtehX8Ka1/img.png](https://blog.kakaocdn.net/dn/tGJq0/btrcUllSVnE/9ewE0tvDh8ViVJtehX8Ka1/img.png)
    

## 2.5 객체 배열

// 많은 수의 객체를 다뤄야할 떄, 배열로 다루면 편리. 

// 객체 배열 안에 객체의 주소 저장. 즉, 참조변수들을 하나로 묶은 배열이다.

- 객체 배열 === 참조변수 배열

```java
Tv tv1, tv2, tv3;  ---> Tv[] tvArr =new Tv[3]; 
//길이가 3인 Tv타입의 참조변수 배열
// tvArr[0] = new Tv(); //tvArr[1] ....... 처럼 
객체를 생성해서 배열의 각 요소에 저장하는 것이다. 

=== Tv[] tvArr = { new Tv(), new Tv(), new Tv() }; 와 같다.

```

- 객체 배열의 초기화
    

    
    //참조 변수 3개를 배열로 만든 것과 같다고 하여 객체배열을 참조변수 배열
    //그렇기 때문에 참조변수 배열을 만들고나서, 
    //참조변수를 채워줘야 제대로 작동한다. 즉, 객체를 생성해서 각 요소에 저장해야!
    //Tv[] tvArr = new Tv[3]; 만 작성하지말라! ⇒ tvArr[0] = new Tv();... 도 해야한다.
    
    ⇒ 이를 한 줄로 줄이면, Tv [] tvArr = {new Tv(), new Tv(), new Tv()}; 
    

- 다뤄야할 객체의 수가 많으면 for문 활용

```java
Tv [] tvArr = new Tv[100];

for (int i=0; i<tvArr.length; i++){
		tvArr[i] = new Tv();
}

// tvArr.length를 잘 활용할 것!
```

- 일반 객체와 객체 배열의 차이. tvArr에 3칸
    
    ![https://blog.kakaocdn.net/dn/bhDnF6/btrcVjuMMHQ/LdqikmNxF7UOMai8e914WK/img.png](https://blog.kakaocdn.net/dn/bhDnF6/btrcVjuMMHQ/LdqikmNxF7UOMai8e914WK/img.png)
    

## 2.6 클래스의 정의

// 설계도는 객체지향이론의 관점에서의 정의이다.

- 프로그래밍 관점에서의 정의
    
    ![https://blog.kakaocdn.net/dn/b2bY0c/btrcORyiAxg/hkKHxs0deOKr6ITMFTCR71/img.png](https://blog.kakaocdn.net/dn/b2bY0c/btrcORyiAxg/hkKHxs0deOKr6ITMFTCR71/img.png)
    

 -  클래스 == 데이터 + 함수

 - 구조체: 배열은 같은 종류의 데이터밖에 못 다루나, 구조체는 서로 관련된 여러 데이터(종류 상관x) 를 하나로 저장한다. 데이터가 곧 변수. 

  - 클래스: 데이터를 다루지않는 경우도 있지만, **변수(데이터)를 다루는 함수(메서드)와 묶어** 작업 계산하기위한 묶음이다. (데이터와 함수가 서로 관련있다고 할 수 있다)

- 클래스는 사용자 정의 타입: 기본형 외 원하는 타입을 직접 만들 수 있다.

- 여러 데이터에 있는 시간과 분, 초를 다루기 위해 배열을 사용하는 경우, 시간끼리 묶이기 문제 때문에하나의 클래스로 시간과 분, 초를 묶는다.

```
ex) class Time{
     int hour;
     int minute;
     float second;
}
Time t = new Time();

// 관련 변수의 타입이 서로 다르거나 하는 이유 때문에 뒤섞여서 올바르지않은 데이터가 될 수 있다. 그래서 

```

- 객체지향코드vs비객체지향코드
    
    
    

## 3. 변수와 메서드

## 3.1 선언 위치에 따른 변수의 종류


- **클래스 영역에서 static이 붙은 cv**(=static 변수, 모든 인스턴스에 공유되는 변수)

 - iv와 달리, 인스턴스 생성없이도 언제라도 바로 사용 가능. public이 붙으면 전역변수가 된다. (전역변수 = 같은 프로그램 내에서 어디서나 접근 가능 변수)

- ex)
    
    ```java
    class Variables{// 클래스 시작
         int iv; // 인스턴스 변수(클래스 전체에서 사용가능), 
    						//인스턴스가 생성될 때 생성된다. 
    ex) class Time{ int hour; int minute; int second;}  
    //일 때, hour, minute, second 다 iv에 해당한다. 
    //객체는 iv를 묶어놓은 것이라고 생각하면 이해하기 쉽다.  
         static int cv; 
    // 클래스 변수 (클래스 전체에서 사용가능), 클래스이름.클래스 변수 가능
    //클래스가 메모리에 올라갈 때 생성된다. 
    // (=객체를 만들기 전 설계도 시기) 하드에 저장된 파일을 읽기위해 
    // RAM(메모리)에 올리는 시기. 그래야 CPU에서 읽을 수 있다.
    // (RAM하고만 일할 수 있다) cv는 iv와 달리, 객체 생성이 따로 필요 없다. 
    // 선언문만 가능. y=x+3; sop; 같은 문장은 못들어온다.  
         void method()
    { // 메서드 시작
         int lv=0; 
    //지역변수. 이 지역변수는 메서드 영역에서만 유효(메서드 종료시 자동제거),
    // 변수 선언문이 수행될 때 생성된다.         
    } ---메서드 끝
    }-- 클래스 끝
    ```
    

## 3.2 클래스 변수와 인스턴스 변수

<aside>
🔥 **객체는 iv를 묶어놓은 것**

</aside>

<aside>
🔥 중요!! iv는 객체마다 만들어지지만, cv는 별도의 공간에 1개만 만들어지기에 메모리 절약을 한다.

</aside>

- cv와 iv의 차이

 - iv: 개별속성(객체마다 다르게 유지되어야하는 값(속성))

 - cv: 공통 속성(모든 객체가 공통적으로 갖는 값(속성)) 

// 모든 인스턴스가 같은 저장공간을 참조하는 것이다. 그러니, **클래스변수.cv**

⇒ 각 인스턴스 이름.cv 를 사용해도 상관없지만 iv로 오해할 수도....

=> iv와 cv를 포함한 클래스 생성하고나서 **이를 활용하려면,** 객체를 생성한다.

- 그림으로 보는 cv와 iv의 차이
    
    ![https://blog.kakaocdn.net/dn/QhzTY/btrc1T9D5qs/JBUDURycYpUFoMZRVRPzJK/img.png](https://blog.kakaocdn.net/dn/QhzTY/btrc1T9D5qs/JBUDURycYpUFoMZRVRPzJK/img.png)
