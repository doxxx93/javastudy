# CHAPTER 7. 객체지향 프로그래밍 2

## 1. 상속(inheritance)    
### 1.1 정의 및 장점

* 의미: 기존의 클래스를 재사용하여 새로운 클래서를 작성하는 것
* 장점: 코드이 재사용성 제고, 프로그램 생산성 및 유지보수에 기여
  - **_조상클래스_** : 부모/상위/기반 클래스
  - **_자손클래스_** : 자식/하위/파생 클래스 
* 작성방법

```java
class Child extends Parent {
  //...
}
```
 
* 특징
```
1. 상속관계 클래스 간 영향관계
  - 조상 클래스 변경 ☞ 자손 클래스 영향(O)
  - 자손 클래스 변경 ☞ 조상 클래스 영향(X)
2. 상속대상
  - 클래스 멤버(O)
  - 생성자, 초기화 블럭(X)
3. 자손 클래스 멤버 개수 >= 조상 클래스 멤버 개수
4. 공통부분은 조상에서 관리, 개별부분은 자손에서 관리 
```
* 예시
```java
class Tv {
	boolean power; 
	int channel;
	void power()       {   power = !power; }
	void channelUp()   {   ++channel;      }
	void channelDown() {   --channel;      }
}

class SmartTv extends Tv {  
	boolean caption;    
	void displayCaption(String text) {
		if (caption) {   
			System.out.println(text);
		}
	}
}
```
> Q. TV 클래스의 멤버 개수는? 5개
>> Q. SmartTv 클래스의 멤버 개수는? 7개

<br>

### 1.2 클래스 간의 관계 - 포함관계

* 의미: 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것
* 장점: 하나의 거대 클래스를 작성하기보다 단위별로 여러 개의 클래스 작성 ☞ 재사용성, 이해도 제고, 코드 관리 용이 
> Q. 클래스 간의 관계 종류는? 
> > 1. 상속  2. 포함(90%)

### 1.3 클래스 간의 관계 결정
```
1. A is B ☞ 상속관계
2. A has B ☞ 포함관계
```
![상속 vs 포함](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_1.3_%EC%83%81%EC%86%8D%ED%8F%AC%ED%95%A8.JPG)
### 1.4 단일 상속
![단일상속](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_1.4_%EB%8B%A8%EC%9D%BC%EC%83%81%EC%86%8D.JPG)

### 1.5 Object 클래스 - 모든 클래스의 조상
* 모든 클래스는 자동적으로 Object 클래스로부터 상속
* Object 클래스는 결국 마지막 최상위 조상 
> Q. 최상위 조상인 Object 클래스로부터 어떤 멤버를 사용할 수 있는가?
> > Object 클래스에 정의된 11개 메서드는 별도 정의 없이 사용 가능 
![Objcet 클래스의 메서드](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_1.5_Object%20%ED%81%B4%EB%9E%98%EC%8A%A4.JPG)

-------------------
## 2. 오버라이딩(overriding)    
### 2.1 기본개념
* 의미: 조상 클래스로부터 상속 받은 메서드의 내용을 변경하는 것
* 방법: 자손 클래스 자신에 맞게 구현부만 변경 
  
![오버라이딩](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_2.1_%EC%98%A4%EB%B2%84%EB%9D%BC%EC%9D%B4%EB%94%A9.JPG)

### 2.2 성립조건
`★THINGS TO REMEMBER`

**1. 자손 클래스 메서드는 조상 클래스 메서드와**

```
1. 이름이 같아야 한다
2. 매개변수가 같아야 한다
3. 반환타입이 같아야 한다
☞ 즉, 선언부가 일치해야 한다
```
**2. 조상 클래스의 메서드를 자손 클래스에서 오버라이딩 할 때**
```
1. 접근 제어자: 조상 클래스의 메서드보다 좁은 범위로 변경 X (대부분 같은 범위로 사용)
2. 예외: 조상 클래스의 메서드보다 많이 선언 X
3. 인스턴스 메서드: static 메서드 또는 그 반대로 변경 X
```

### 2.3 오버로딩 vs 오버라이딩
```
* 오버로딩 : 새로운 메서드 정의 (new)
* 오버라이딩 : 상속받은 메서드의 내용을 변경 (change, modify)
```
![오버로딩vs오버라이딩](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_2.3_%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9vs%EC%98%A4%EB%B2%84%EB%9D%BC%EC%9D%B4%EB%94%A9.JPG)
### 2.4 super
* 의미: 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 잠조하는 데 사용되는 참조변수
* 참조변수 this와 기본적으로 같음
```
* super: 참조변수(조상멤버 vs 자손멤버)
* this: 참조변수(지역변수 vs 인스턴스변수)
```
* 특징: 인스턴스 메서드에서만 사용 가능(static 메서드에서는 사용 불가)
 ☞ 모든 인스턴스 메서드에는 자신이 속한 인스턴스의 주소가 지역변수로 저장 
 ![super 예시](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_2.4_super.JPG)

### 2.5 super() - 조상 클래스의 생성자
* 의미: 조상 클래스의 생성자를 호출하는 데 사용되는 생성자
`★THINGS TO REMEMBER`
* 특징: 모든 클래스의 생성자는 첫 줄에 반드시 자신의 다른 생성자 this() or 조상의 생성자 super()를 호출해야 한다
  - 그렇지 않으면 컴파일러는 생성자 첫 줄에 super() 자동 추가 
 
 ![super() 예시](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_2.5_super().JPG)
> Q1. 컴파일 에러가 발생한 이유는?
> > A1. Point3d(inx x, int y, int x) 호출 시 컴파일러가 자동으로 super() 추가
> > <br> ☞ super()은 조상 Point 클래스의 기본생성자인 Point()를 의미
> > <br> ☞ 해당 클래스에 기본생성자 Point() 가 정의되어 있지 않음
> >> Q2. 에러를 수정하려면?
> >>> A2. Opt1) Point 클래스 내 기본생성자 Point() 추가
> >>> <br> Opt2) 생성자 Point3d(inx x, int y, int x) 첫줄에 Point(int x, int y) 호출
-------------------
## 3. package 와 import    
### 3.1 패키지
* 의미: 관련된 클래스 및 인터페이스 묶음
  
 ![패키지](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_3.1_%ED%8C%A8%ED%82%A4%EC%A7%80.JPG)
### 3.2 패키지의 선언
* 방식: package 패키지명;
  
 ![패키지의 선언](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_3.2_%ED%8C%A8%ED%82%A4%EC%A7%80%EC%9D%98%EC%84%A0%EC%96%B8.JPG)

 
### 3.3 import문
* 의미: 소스파일에 사용된 클래스의 패키지에 대한 정보를 컴파일러에게 제공
* 장점: 다른 패키지 클래스 사용 시 매번 패키지명을 작성할 필요 없이 패키지명 생략 가능
* 방법: 단축키(ctrl+shift+o) 입력 시 자동으로 import문 추가
  
  
### 3.4 import문의 선언
  
 ![import문의 선언](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_3.4_import%EB%AC%B8%EC%9D%98%EC%84%A0%EC%96%B8.JPG)
 
 ![import문의 선언2](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_3.4_import%EB%AC%B8%EC%9D%98%EC%84%A0%EC%96%B82.JPG)
 
 ---------------------
## 4. 제어자(modifier)
### 4.1 기본개념
* 의미: 클래스, 변수, 메서드 선언부에 함께 사용되어 부가적인 의미를 부여(like 형+명)
* 종류
```
* 접근 제어자: public, protected, (default), private
* 기타: static, final, abstract, native, transient, synchronized, volitile, strictfp
```
* 특징
  - 중복사용: 접근 제어자는 4가지 중 택1만 가능
  - 배치: 접근 제어자는 보통 가장 왼쪽

### 4.2 static - 클래스의, 공통적인
![static](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_4.2_static.JPG)
### 4.3 final - 마지막의, 변경될 수 없는
![final](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_4.3_final.JPG)
### 4.4 abstract - 추상의, 미완성의
![abstract](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_4.4_abstract.JPG)
### 4.5 접근 제어자
* 의미: 멤버 또는 클래스에 사용되어 외부에서 접근하지 못하도록 제한하는 역할
* 종류
  
![접근 제어자](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_4.5_%EC%A0%91%EA%B7%BC%EC%A0%9C%EC%96%B4%EC%9E%90.JPG)
* 대상에 따른 사용
  
| 대상 | 사용가능 접근 제어자 |
|:---:|:---:|
| 클래스 | public, default |
| 메서드 | public, protected, default, private |
| 멤버변수 | public, protected, default, private |
| 지역변수 | 없음 |
* 접근 제어자를 이용한 캡슐화
  - 외부로부터의 데이터 감추기 ☞ 객체지향개념의 캡슐화
> Q. 접근 제어자의 사용 이유는?
>>  외부로부터 데이터 보호 + 외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위해

### 4.6 제어자의 조합 
* 대상에 따른 사용
  
| 대상 | 접근 제어자 | 기타|
|:---:|:---:|:---:|
| 클래스 | public, default | final, abstract|
| 메서드 | public, protected, default, private | final, abstract, static|
| 멤버변수 | public, protected, default, private |final, static|
| 지역변수 | 없음 | final|

* 유의사항
  
![유의사항](https://github.com/doxxx93/javastudy/blob/main/Ch07/Mina%20Park/ch7_4.6_%EC%A0%9C%EC%96%B4%EC%9E%90%EC%A1%B0%ED%95%A9.JPG)
