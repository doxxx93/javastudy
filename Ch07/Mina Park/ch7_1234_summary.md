# CHAPTER 7. 객체지향 프로그래밍 2

## 1. 상속(inheritance)   
<br>     

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
> Q. 클래스 간의 관계 종류는? 
> > 1. 상속  2. 포함(90%)

* 의미: 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것
* 장점: 하나의 거대 클래스를 작성하기보다 단위별로 여러 개의 클래스 작성 ☞ 재사용성, 이해도 제고, 코드 관리 용이 

### 1.3 클래스 간의 관계 결정
```
1. A is B ☞ 상속관계
2. A has B ☞ 포함관계
```

