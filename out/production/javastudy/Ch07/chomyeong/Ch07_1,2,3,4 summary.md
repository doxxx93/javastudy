# 7장 객체지향2

## 1. 상속

- 기존의 클래스로 새로운 클래스를 작성하는 것(코드의 재사용, 유지보수 용이)
- 두 클래스를 부모와 자식으로 관계를 맺어주는 것(extends를 통해)

```java
ex) class 부모클래스 {}
class 자식클래스 **extends** 부모클래스 {
}
```

- 자손은 조상의 모든 멤버를 상속받는다. (**생성자, 초기화블럭 제외**)

=> 자손의 멤버 개수는 조상보다 적을 수 없다(같거나 많다)

 - 자손의 변경은 조상에 영향을 미치지 않는다.  

![자손은 자기멤버는 0개지만, 상속받은 멤버가 1개있기에 1개의 멤버를 갖고 있는 것이다.](https://blog.kakaocdn.net/dn/bgRZaz/btrdJ4hH1QN/hHK8wylBkfCznldY21LiMK/img.png)

자손은 자기멤버는 0개지만, 상속받은 멤버가 1개있기에 1개의 멤버를 갖고 있는 것이다.

- 상속을 받지않는 경우와 받는 경우의 차이

 -  하단 왼쪽이 상속받지않고 point 클래스와 관계없이 작성한 경우(point클래스가 달라져도 상관 x), 오른쪽은 상속받는 경우(point클래스가 달라지면 영향 받는다)

![https://blog.kakaocdn.net/dn/bxzkel/btrdFnQmkK7/TEurRu2XfZnBdR1WWNkLP0/img.png](https://blog.kakaocdn.net/dn/bxzkel/btrdFnQmkK7/TEurRu2XfZnBdR1WWNkLP0/img.png)

- 상속계층도 // parent는 grandchild의 간접 조상, child는 grandchild의 직접 조상이다.

![20211025_093222.jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/901df64f-0ef2-459a-88cb-4bfbe07df03f/20211025_093222.jpg)

## 1.2 클래스 간의 관계, 상속과 포함

- 포함: 클래스의 멤버로 **참조변수를 선언**하는 것 ex) car 클래스 안에 Engine 객체, 기능 객체 생성

![https://blog.kakaocdn.net/dn/wH1cG/btrdEksN9Ej/BnsRZEIF0mxIN2ZuyztkG1/img.png](https://blog.kakaocdn.net/dn/wH1cG/btrdEksN9Ej/BnsRZEIF0mxIN2ZuyztkG1/img.png)

- 왼쪽으로 만들면, point 클래스와 관계x 오른쪽으로 만들면 관계o(Circle이 Point를 포함 관계) => 복잡도 감소

- 1번과 2번은 구조적인 차이가 있다. 2번은 객체에 c와 z가 있고, 참조변수 c가 x,y를 가리킨다

- 1번은 circle의 x 라면, 2번은 circle의 c 객체의 x 이다. 

- 이후, 값을 부여해주려면 객체 만들고 c.x = 1 식으로

- 작은 단위의 클래스를 만들고, 이들을 조합해서 클래스를 만든다. 단위별로 여러 클래스!

![https://blog.kakaocdn.net/dn/bskjv3/btrdEkM8uJu/4gGtmFoi3lku1EbbSek271/img.png](https://blog.kakaocdn.net/dn/bskjv3/btrdEkM8uJu/4gGtmFoi3lku1EbbSek271/img.png)

- 클래스 간의 관계 결정 // 상속을 해야할지, 포함을 해야할지 고민될 때... 참고!

<aside>
💡 - **대부분의 경우가 포함 관계이다. 상속은 제약 많다**

</aside>

// 상속은 int 멤버 3개로 한 것과 구조가 같다. int x, y, z 는 다 공집합 0

// point c = new Point();를 **참조변수의 초기화**라고 한다.

// 되도록 상속은 Car 클래스와 SportsCar 클래스, 포함은 Car클래스와 engine 클래스 같이.....

- 단일상속

 - 여러 클래스를 상속해야한다면, 하나 상속하고 다른 건 포함관계로! 그리고 포함한 클래스의 메서드를 호출하여 사용하기위해 같은 선언부의 이름을 가진 메서드를 작성하면 된다. 

=> 다중 상속을 대체하는 방법은 비중이 높은 클래스 하나만 상속, 나머지는 포함관계로 한다.

ex)

```java
class aa extends Tv{
          Dvd dvd = new Dvd();// Tv와 겹치는 메서드는 빼고void play(){
                dvd.play();
           }
```

// dvd 객체 만들어서 이 객체의 기능들을 호출해서 사용하는 것. 객체는 그냥 껍데기

## 1.5 object 클래스

‧ Object 클래스

- 모든 클래스의 조상(부모가 없는(상속받지않는)클래스는 자동적으로 이 클래스 상속받는다)

ex) class Tv {} 와 같은 클래스를 컴파일하면 class Tv extends Object{} 로 자동 추가해준다.

- 모든 클래스는 Object 클래스에 정의된 11개의 메서드를 상속받는다.

ex) **toString(), equals(Object obj)**, hashCode(),.... ==> 상속을 차례대로 그린 상속계층도를 보면 결국 끝에는 Object 클래스가 있다.

- toString() 는 객체 이름.tostring()을 했을 때, 결과는 **“class이름@객체의주소값”**

= print할 때 toString 없이 그냥 객체이름만 들어가도 결과는 똑같이 나온다.!!

## 2. 오버라이딩

- 상속받은 **조상의 메서드를 자신에 맞게 변경**하는 것(덮어쓰다)
- 구현부(내용)만 변경가능, 선언문은 불가능

ex)

```java
class MyPoint {
         int x;
         int y;
         String getlocation(){
               return "x: "+x, "y: "+ y;
         }
}

class MyPoint3D extends MyPoint {
        int z;
        String getlocation(){
               return "x: "+x, "y: "+ y;, "z: "+z;
                         }// 이게 오버라이딩이다.
}

public class OverrideTest {
        public static void main(String[] args) {
            My point3D p = new MyPoint3D();
            p.x = 3;
            p.y = 5;
            p.z = 7;
            sop(p.getloaction());
          }
}

// 결과는 오버라이딩된 getlocation 이 호출된다. 첫 번째 getlocation이 상속이 안 된 것은 아니다.
// 추가적인 부분: public String toString() { return "x: "+x, "y: "+y; } 이면
                  sop(p) 혹은 sop(t.string)으로 출력된다.
```

- 오버라이딩의 조건

1. 선언부가 조상 클래스의 메서드와 일치해야한다. (반환 타입, 메서드이름, 매개변수 목록)

2. 접근 제어자를 조상 클래스의 메서드보다 **좁은 범위로 변경할 수 없다**. (일단, 그냥 이런게 있다만 알자) ⇒ 조상클래스 메서드의 접근제어자가 protected 라면, 자손은 protected나 public이어야! 

3. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.

ex) class Parent { void parentMethod () throws aaaException, bbException (...)}처럼.. 자손이 ..Exception의 수보다 많이 선언될 수 없다는 뜻!!

1. 인스턴스메서드를 static 메서드로 또는 그 반대로 변경 불가. 클래스이름.메서드이름으로 호출!

## 2.4 참조변수 super, 생성자 super()

- 참조 변수 super (this와 비슷)

 - 객체 자신을 가리키는 참조변수. 인스턴스 메서드(생성자)내에만 존재(static 불가)

 - 조상의 멤버를 자신의 멤버와 구별할 때 사용(this는 iv, lv 구별 때 사용), **메서드**도 가능!

ex) Child에서 Parent를 상속받을 때 각각 int x를 멤버로 가질 수 있다. 다만, 상속받은 건 super.x로, 자기 멤버는 this.x를 붙인다. 조상클래스로부터 상속받은 멤버도 자손 클래스 자신의 멤버이므로 super대신 this사용 가능 but 조상클래스의 멤버와 자손클래스의 멤버가 중복 정의되어 서로 구별해야하는 경우네는 super를 사용! //메서드.getLocation();

// **super와 this는 모두 참조변수고, 같은 주소**를 가리킨다.

![자손에 x가 따로 없는 경우, super, this.x 는 다 부모의 x값을 가리킨다. 그리고 객체에 변수와 메서드를 멤버로 갖고있으면 저 그림처럼 변수 칸, 메서드 칸이 생기는 것](https://blog.kakaocdn.net/dn/LUCAe/btrdMKptPpa/zWjAOKr6ILFkvx66Y6lO91/img.png)

자손에 x가 따로 없는 경우, super, this.x 는 다 부모의 x값을 가리킨다. 그리고 객체에 변수와 메서드를 멤버로 갖고있으면 저 그림처럼 변수 칸, 메서드 칸이 생기는 것

```java
class SuperTest2{
	public static void main(String args[]) {
		Child c = new Child();
		c.method();
	}
}

class Parent{
	int x=10;
}

class Child extends Parent{
	int x=20;
	
	void method(){
		sop("x=" +x);
		sop("this.x="+this.x);
		sop("super.x="+super.x);
	}
}

// 결과
// x=20;
// this.x=20; // 자손 클래스에 선언된 멤버변수
// super.x=10; //조상클래스로부터 상속받은 멤버변수 x
```

- super() - 조상의 생성자 // 참조변수 super 와 상관x // this () 와 비슷

 - 자손클래스에서 조상의 생성자를 호출할 때 사용 

=> 호출해서 조상의 생성자가 조상 멤버들 초기화하게끔

 - 조상의 멤버는 조상의 생성자를 호출해서 초기화 vs 상속은 **생성자. 초기화블록이 상속 안된다.**

ex) class point(int x, int y){ this.x = x; this.y = y; } } 가 초기화블록

![조상의 멤버를 저렇게 초기화해도 에러는 아니지만, 아래와 같은 super()방식으로 초기화해야한다. 자손 멤버가 조상 멤버를 사용할 수도 있으니 첫 줄에 호출](https://blog.kakaocdn.net/dn/ybdDA/btrdImpSidq/v87vDysmhocNC3M2k9fbB0/img.png)

조상의 멤버를 저렇게 초기화해도 에러는 아니지만, 아래와 같은 super()방식으로 초기화해야한다. 자손 멤버가 조상 멤버를 사용할 수도 있으니 첫 줄에 호출

- 생성자의 추가 조건

<aside>
💡  모든 **생성자의 첫 줄에 반드시 다른 생성자를 호출해야한다**. 그렇지 않으면 컴파일러가 생성자의 첫 줄에 super();를 삽입. super아니면 this를 호출해야한다.

</aside>

// 클래스: 어떤 클래스의 인스턴스를 생성? 생성자: 선택한 클래스의 어떤 생성자를 이용해서 인스턴스 생성?

//조상의 기본생성자를 작성해야 자손에서 super()로 호출해도 에러가 x

![첫줄에 반드시 생성자 호출. 아니면 object를 조상으로 삼아서 super();가 자동추가](https://blog.kakaocdn.net/dn/bSS6QU/btrdCGpf4rK/lo7P84lUbbTK8L20L8DZXk/img.png)

첫줄에 반드시 생성자 호출. 아니면 object를 조상으로 삼아서 super();가 자동추가

*** 아직 생성자에 대해 익숙하지 않음. 

1. 생성자()가 원래는 있어야하는거. 생략이 가능할 떄는 point(int x, int y) 같은 게 없을 때
2. super(x,y) 같은 걸 불러야할 때


## 3. package와 import

- 패키지

 - 서로 관련된 클래스의 묶음

 - 클래스는 클래스 파일(*.class), 패키지는 폴더, 하위 패키지는 하위 폴더

 - 클래스의 실제이름은 패키지를 포함(ex) java.lang.String)

 - rt.jar는 자바 프로그램이 실행하는 데 필요한 클래스들을 압축한 파일(JDK 설치경료\jre\lib에 위치)

(java 9부터는 없어졌고, module 개념으로 바뀌었다) // jar.exe 를 통해 압축 풀 수 있다.

- 패키지 선언 package 패키지명;

 - 패키지는 소스파일의 첫 번째 문장으로 단 한번 선언

 - **같은 소스 파일의 클래스**들은 모두 같은 패키지에 속하게 된다. (**같은 패키지 폴더**에 속한다)

 - 패키지 선언이 없으면 이름없는 패키지에 속하게 된다(default package 폴더에 들어간다)

// package가 제대로 안보이면 package presentation 가서 보여주는 방식을 바꾸면 된다. (플랫, 계층구조)

// 폴더 위치를 보고 싶다면 우클릭해서 show in을 통해 파일 탐색기가 열린다

 - 이클립스 도움 없이 패키지 테스트 클래스 파일을 열기 by **cmd**

 - class root: 넓은 공간에서 클래스 파일을 찾을 수 없기에 이 클래스 파일이 있는 위치로 이동해야한다. ==> 패키지를 갖고 있는 상위폴더 경로를 넣어준다. 그리고나서 패키지 파일경로 입력하면 호출된다.

- **클래스 패스(classpath)**: 클래스파일의 위치를 알려주는 경로

 

 - 클래스루트와 같이 매번 특정폴더로 이동한 다음 실행하는게 불편해서 클래스 패스를 이용한다.

 ⇒ 이 디렉토리를 클래스패스에 포함해야 JVM이 해당 클래스 파일을 찾을 수 있다.

- 환경변수 classpath로 관리하며, 경로간의 구분자는 “;”를 사용. 환경변수에 패키지의 루트를 등록!!

=> 명령창에서 실행할 때 현재폴더에서 못 찾으면 이 classpath에 등록된 경로들을 순서대로 보면서 찾는다.

 -  환경변수는 os에서 관리하는 것이기에 제어판에서 환경변수를 검색해서 시스템환경변수 편집에서, 새로 만들기! 

- 과정 p.336~339 참고
    
     - 상위폴더 경로를 집어넣는 것이다!!
    
     - cmd에서 환경변수 설정 값을 확인하는 방법은 set classpath를 친다.
    
     - cmd에서 환경변수 값을 추가하려면 set classpath = 기존값; 새로운 값을 치면 된다!
    

## 3.3 import문, static import문

 - 소스코드 작성 시, **다른 패키지의 클래스**를 사용하려면 패키지명이 포함된 클래스 이름 사용. 

- 클래스를 사용할 때 패키지이름을 생략할 수 있다. ex) import java.util.Date;를 쓰면 뒤에 나오는 Date 클래스를 쓸 때 java.util 생략가능 // 컴파일러에게 클래스가 속한 패키지를 알려준다.

 - 이클립스는 단축키(ctrl+shitft+o)를 활용하여 import문을 추가해준다.

// 만약 Date class를 썼는데, 빨간 줄이 그어지면 이는 Date 클래스가 어느 패키지 것인지 알 수 없다는 뜻. 똑같은 이름의 클래스가 여러 개 있으면 선택하는 창이 나온다.

 - java.lang 패키지의 클래스는 import하지 않고도 사용할 수 있다. (자바 언어의 기본 패키지라서)

ex) String, Object, System, Thread.....

- import문 선언

 - import문을 선언하는 방법은 import 패키지명.클래스명; 또는 import 패키지명.*; (패키지에 속한 모든 클래스)

 - import문은 패키지문과 클래스 선언의 사이에 선언한다.

![https://blog.kakaocdn.net/dn/kVhxE/btrdFohqig8/XJSAREbbYSKCReWTqzrVNk/img.png](https://blog.kakaocdn.net/dn/kVhxE/btrdFohqig8/XJSAREbbYSKCReWTqzrVNk/img.png)

 - *은 import java.util. 다음에 나오는 모든 클래스를 말한다. 느려지거나 하진 않는데, 나누면 어떤 클래스인지는 알 수 있다. 프로그램 개발할 때는 주로 *를 많이 쓰고, 라이브러리, api 개발은 어느 클래스인지 주로 명시한다.

 -  import java.util.*와 import java.text.* 은 의미가 다르다. 이 둘을 다 포함하는 게 import java.*; (자바 패키지의 모든 클래스, 패키지는 포함 안 됨)

 - 주의: 같은 클래스 이름이 여러 개 나오면 어느 패키지에 속하는지 적어줘야한다

- static import문

 - static 멤버를 사용할 때 클래스 이름을 생략할 수 있게 해준다.

![https://blog.kakaocdn.net/dn/bOdIzs/btrdJi1ywVi/cMmfCr4tAhkexo7wtbfjmk/img.png](https://blog.kakaocdn.net/dn/bOdIzs/btrdJi1ywVi/cMmfCr4tAhkexo7wtbfjmk/img.png)

 - static import문. 위와 같이 작성하면, 아래와 같이 생략이 가능하다. 

import static java.lang.integer.*;는 integer 클래스의 static멤버(변수, 메서드) 모두 포함. 즉, java.util별표와 같은 것. 아래는 특정 클래스들

=> 클래스 이름 붙이면 너무 코드가 길어진다. 물론, 어느 클래스에 포함되는지 알 수 있다는 점.....

## 4. 제어자, static, final, abstract

- 제어자(modifier) // 제어자를 사용할 때는 대상도 잘 봐야한다.
- 클래스와 클래스의 멤버에 부가적인 의미 부여(**형용사 같은**)
    
    (1) 접근 제어자: public, protected, (default), private 4개 중에 하나만 붙일 수 있고, default는 안 붙이는 경우
    
    (2) 그 외: static, final, abstract, native, translent, synchronized, volatile, strict
    
    - 하나의 대상에 여러 제어자를 같이 사용가능(접근 제어자는 하나만), 접근제어자는 보통 제일 왼쪽에
    

![제어자 붙이기](https://blog.kakaocdn.net/dn/cBmnTv/btrdJ25eC57/kpa0jMspx8FQpPR9eUNBw1/img.png)

제어자 붙이기

### Static 클래스의, 공통적인

 - 하나의 변수를 모든 인스턴스가 공유한다.

![static 정리](https://blog.kakaocdn.net/dn/ddQw8z/btrdJkkMMjR/qOKeyFa4uHm43ivFoKcK00/img.png)

static 정리

### final 마지막의, 변경될 수 없는

- 클래스를 대상으로 하는 경우, 보안 문제 때문에 하는 것.
    
     - Stirng, Math 같은 경우 상속이 가능하면 조상 멤버에 접근할 수 있기에 막으려고.... 변수에 붙으면 JS의 const처럼 된다.
    
    // 어떤 대상에 붙느냐에 따라서 조금씩 의미가 다르다.
    

![final 정리](https://blog.kakaocdn.net/dn/IM2Us/btrdEkl5p3G/omsORUBnyWckmn2mG0UrS1/img.png)

final 정리

- 생성자를 이용한 final 멤버 변수의 초기화
    
     - 한번 생성되면 값을 변경하지 못하게
    
     - 클래스 내에 매개변수를 갖는 생성자를 선언하여, 인스턴스 생성 시 final이 붙은 멤버변수 초기화 값을 생성자의 매개변수로부터 제공받기
    
    ```java
    class Card {
    	final int NUMBER;
    	final String KIND;
    	
    	Card(String kind, int num){
    		KIND = kind;
    		NUMBER = num;
    	} // 매개변수를 받아서 final 멤버 초기화
    
    	Card() {
    		this("HEART, 1); // 객채 생성 시 default
    	
    main 메서드에서
    	Card c = new Card("HEART", 10);
    	c.NUMBER = 5; /// 에러 발생!
    ```
    

### abstract - 추상의, 미완성의

- 클래스와 메서드에만 붙는데, 메서드에 abstract이 붙으면 클래스에도 붙는다. (미완성이라는 뜻이기에)
    
    ==> 미완성 클래스니까 객체를 만들 수 없다. (추상 클래스의 인스턴스 생성불가)
    

![https://blog.kakaocdn.net/dn/Z0ZHn/btrdJ4B0jYp/c9hLM0VbOdl9NNuBiTwoMk/img.png](https://blog.kakaocdn.net/dn/Z0ZHn/btrdJ4B0jYp/c9hLM0VbOdl9NNuBiTwoMk/img.png)

abstract 정리

=> 이 클래스를 사용하려면 상속을 통해 추상 메서드를 완성해줘야한다. 완전한 클래스(구상 클래스)를 만들고나서 객체 생성 가능

## 4.5 접근제어자

‧ 접근제어자(순서대로 범위가 넓어진다), 외부에서 접근하지 못하게

- private 같은 클래스 내에서만 접근 가능 // 메서드와 멤버변수에만
- (default) 같은 패키지 내에서만 접근 가능(같은 클래스 내에서도 가능한다는 뜻)
- protected(잘 안 쓴다) 같은 패키지 내에서만 접근 가능(같은 클래스 내도 가능) + 다른 패키지의 자손 클래스에서 접근 가능.
    
    // 메서드와 멤버변수에만
    
- public 접근 제한이 없다.

![접근제어자 붙일 수 있는 예제](https://blog.kakaocdn.net/dn/zwsXg/btrdEjUXXCa/xMPKUKX2F0tBk1Oo1zgu61/img.png)

접근제어자 붙일 수 있는 예제

**// 클래스 앞에서는 public 과 default 만 가능**

![접근제어자 예제](https://blog.kakaocdn.net/dn/b05mIF/btrdMJD7oqJ/6L3Pkwqt4IdgvLom6NgEX0/img.png)

접근제어자 예제

- 또한, class Myparent는 default를 붙였기에 다른 패키지에서 사용 불가. 사용하려면 public을 붙여야한다. 그리고 public 클래스 이름과 소스파일 이름 일치시키는 것도 잊지 말기!!
- 해당 클래스 이름 못 찾겠다 싶으면, ctrl + shift + o를 누르면 해당하는 import문이 자동 추가!

![접근제어자 예제2(다른 패키지 등장)](https://blog.kakaocdn.net/dn/cxaaMa/btrdKXidFzQ/hYb0Qvb12eWVbFH5l3uba1/img.png)

접근제어자 예제2(다른 패키지 등장)

## 캡슐화와 접근 제어자

- 캡슐화: 직접 접근을 막고 메서드를 통한 간접 접근을 허용하는 것

 ⇒ 실생활 예시: TV 소리를 줄이려고하는데 TV로 조절하는게 아니라 리모컨이라는 참조변수와 메서드를 거쳐야하게끔(간접접근) 그리고 이 메서드에 조건을 주면 엉뚱한 값이 설정되지않게함!

### 접근 제어자를 사용하는 이유:

**(1) 외부로부터 데이터를 보호하기 위해서.(이를 캡슐화라고 한다)**

ex) 시간 객체 안에 int hour; 멤버가 있는데, 이를 0~23범위로 변수 값을 유지해야하는데, 객체 t를 만들고 t.hour = 25; 이렇게 대입연산자로 접근할 수 있는 문제!!!  

- hour는 int타입이니까 +-20억 내에서만 에러가 안 난다. (다만 우리가 원치 않는 데이터가 될 수 있는)

![접근제어자로 보호. hour에 25같은 걸 넣으면 if문으로 거르고, 21이면 유효한 값이니까 저장되게 한다. 직접 접근은 참조변수.hour 로 하는 거고, 간접 접근은 메서드를 통해 접근하는 것!](https://blog.kakaocdn.net/dn/nLbju/btrdK7SOhUM/OkC0QeSO2ar1zkiOKydsKK/img.png)

접근제어자로 보호. hour에 25같은 걸 넣으면 if문으로 거르고, 21이면 유효한 값이니까 저장되게 한다. 직접 접근은 참조변수.hour 로 하는 거고, 간접 접근은 메서드를 통해 접근하는 것!

- private를 통해 외부에서 직접 접근하지 못하도록 한다. 외부에서 메서드로 접근하는 건 괜찮은데, 이 메서드를 통해 iv에 접근하게 하는 건 ok(간접 접근 허용) ⇒ 만약 자손클래스에서 접근하는 것을 가능하게 하려면 private 대신 protected를 사용한다.

<aside>
🔥 **값을 보호한다는 것은 데이터가 우리가 원치 않는 엉뚱한 값이 되지 않도록 막는 것**이다.

</aside>

**(2) 외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위해서**

- 접근 제어자의 범위는 좁을수록 좋다. 필요하면 넓히는 식 => 코드 수정시, public 으로 써놓으면 클래스 외부도 다 뒤져야하는데, private은 클래스 내에서만 확인되면 되기 때문에!!

![캡슐화 예제. if문을 통해 유효한 값만 저장하게끔 한다. 21은 되는데, 100이 출력 안 되는 이유](https://blog.kakaocdn.net/dn/5X28H/btrdK6sOIPR/Yefp7YQBcLvsAc1eGkdim1/img.png)

캡슐화 예제. if문을 통해 유효한 값만 저장하게끔 한다. 21은 되는데, 100이 출력 안 되는 이유

- 생성자의 접근 제어자
    
     - 생성자에 접근 제어자를 사용하면 인스턴스의 생성 제한 가능(클래스 내부에서는 가능)
    
     - 대신 인스턴스를 생성해서 반환해주는 public 메서드를 제공함으로써 외부에서 이 클래스의 인스턴스를 사용하게끔 할 수 있다. public이자, 동시에 static이어야한다. 
    
    ```java
    class Singleton {
    // getInstance()에서 사용될 수 있도록 인스턴스가 미리 생성
    	private static Singleton s = new Singleton();
    	private Singleton () {
         ----
    	}
    
    // 인스턴스를 생서하지 않고도 호출할 수 있어야하므로 static
    	public static Singleton getInstance () {
    		return s;
    	}
    } ---
    ```
    
    ![제어자의 조합](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d131b40e-4308-41a5-9c3c-51e682ddb66b/KakaoTalk_20211026_142712384.jpg)
    
    제어자의 조합
