# CHAPTER 8. 예외처리

## 1. 예외처리(exception handling)    
### 1.1 프로그램 오류

* 종류
```
1. 컴파일 에러 : 컴파일 시 발생하는 에러
2. 런타임 에러 : 컴파일은 OK, 실행 시 발생하는 에러 (프로그램 종료)
   ㅇ 에러 : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
   ㅇ 예외 : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류 ☞ 예외처리 필요
    - Exception과 자손 : checked 예외(예외처리 필수)
    - RuntimeException과 자손 : unchecked 예외(예외처리 선택)
3. 논리적 에러 : 작성의도와 다르게 동작하는 에러 (프로그램 종료 X)
```
* 예외처리의 정의와 목적
```
ㅇ 정의: 프로그램 실행 시 발생가능한 예외 발생에 대비해 코드를 작성
ㅇ 목적 : 프로그램의 비정상적 종료를 막고 정상적인 실행상태를 유지하는 것
```

### 1.2 예외 클래스의 계층구조

![계층구조]()

* 예외 클래스의 종류
```
ㅇ Exception 클래스와 자손들
  - 사용자의 실수와 같은 외적요인에 의해 발생하는 예외 
ㅇ RuntimeException  클래스와 자손들
  - 프로그래머의 실수로 발생하는 예외
``` 

### 1.3 예외 처리하기(try-catch문)
* 예외처리 방법

![예외처리]()

### 1.4 try-catch문에서의 흐름
* 예외처리 흐름

![예외처리 흐름]()

### 1.5 예외발생과 catch 블럭
#### 1.5.1 catch 블럭 사용
* catch 블럭 
  - 어떤 종류의 예외가 발생할지 모르므로 마지막에 최고조상인 Exception을 추가하면 좋음

![catch 블럭]()

#### 1.5.2 printStack Trace()와 getMessage()
* 의미
  - 예외 발생 시 예외객체가 생성되면 발생한 예외 정보 및 메서드가 담기게 됨
  - catch블럭 괄호()에 선언된 참조변수를 통해 접근 가능

* 자주 사용되는 메서드  
```
ㅇ printStack Trace(): 예외발생 당시의 호출스택에 있던 메서드 정보와 예외메시지를 화면에 출력
ㅇ getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지 얻을 수 있음
```
#### 1.5.3 멀티 catch블럭
- 의미: 내용이 같은 catch 블럭을 하나로 합친 것(코드의 중복 제외)
- 주의사항
 
   ㅇ 멀티 catch블럭 내 부모/자식을 동시에 사용 X
   - 부모타입의 참조변수가 선언된 catch 블럭만 사용하면 되므로)

    ㅇ 멀티 catch블럭 내 부모/자식을 동시에 사용 X
   - 하나의 참조변수가 어느것을 가리키는지 모르므로 선언된 예외 클래스들의 공통멤버만 사용가능
   - 필요시 instanceof 연산자를 통해 형변환 가능할 경우 해당 클래스에 선언된 메서드 호출가능 => 이럴 경우 굳이 멀티 catch 블럭보다는 따로 쓰는게 나음

### 1.6 예외 발생시키기
#### 1.6.1 기본

![예외발생시키기]()

#### 1.6.2 checked 예외, unchecked 예외
```
ㅇ checked 예외: 컴파일러가 예외처리 여부를 체크(예외처리 필수)
  - Exception과 자손
  - try-catch문이 없으면 컴파일 에러
ㅇ unchecked 예외 : 컴파일러가 예외처리 여부 체크 안함(예외처리 선택)
  - RuntimeException과 자손
  - try-catch문이 없어도 컴파일 에러는 X
```

``` java
class Ex8_7 {
	public static void main(String[] args) {
		throw new Exception();		// Exception을 고의로 발생시킨다. 에러 발생!
	}
}
```
``` java
class Ex8_8 {
	public static void main(String[] args) {
		throw new RuntimeException();	// RuntimeException을 고의로 발생시킨다.
	}
}
```
> Q. RuntimeException은 왜 예외처리를 선택으로 할까?
>> A. 산술계산, 형변환, null 포인트 등 프로그래머가 체크해야하는 부분을 전부 확인하려면 거의 모든 클래스마다 try-catch문을 넣어야하므로

### 1.7 메서드에 예외 선언하기
* 의미: try-catch문 외에 예외를 처리하는 또 다른 방법 
```
예외처리 방법의 종류
1. try-catch문(직접처리)
2. 예외 선언하기(떠넘기기)
3. 은폐(덮기) : catch 블럭에 아무것도 선언하지 X
4. 예외 되던지기(양쪽에서 처리)
```
![예외선언]()

### 1.8 finally 블럭
* 의미: try-catch문 외에 예외를 처리
* 의미: 예외 발생여부에 상관없이 실행되는 코드를 포함
* 작성: try-catch문 끝에 선택적으로 추가
* 비고: 예외발생시 try -> catch -> finally 순으로 실행, 미발생시 try -> finally 순으로 실행

![finally]()

<!-- ### 1.9 자동 자원 반환: try-with-resources문
* 의미: try-catch문의 변형
* 비고: 입출력과 관련된 클래스 사용 시 유용 -->

### 1.10 사용자 정의 예외 만들기
* 의미: 사용자가 직접 예외 클래스를 정의
* 특징: 조상은 Exception 과 RuntimeException 중에서 선택
> Q1. 어떤 클래스를 조상으로 선택 해야할까?
> > A1. 되도록 예외처리가 선택인 RuntimeException를 사용(프로그래머의 실수로 발생된 예외를 선택적으로 처리)
> >> Q2. 내용은 어떤걸 정의하면 될까?
> >>> A2. 보통 매개변수로 String msg를 받는 생성자를 통해 에러메시지를 추가

![사용자정의예외]()

### 1.11 예외 되던지기
* 의미: 예외처리 후 다시 예외를 발생시키는 것
  - 필요시 호출한 메서드와 호출된 메서드 양쪽에서 모두 예외처리하도록 분담

![예외되던지기]()

### 1.12 연결된 예외
* 의미: 하나의 예외가 다른 예외를 발생
  - 예외A 가 예외B를 발생 => A는 B의 원인예외
```
 Throwable initCause(Throwable cause)   지정한 예외를 원인예외로 등록
 Throwable getCasue()                   원인예외를 반환
```

``` java
public calss Throwable implements erializable {
  ...
  private Throwable cause = this; //객체자신(this)을 원인예외로 등록
  ...
  private synchronized Throwable initCause(Throwable cause) {
    ...
    this.cause = cause; //cause를 원인예외로 등록
    return this;
  }
  ...
}
```
* 사용이유
  1. 여러 예외를 하나로 묶어서 다루기 위해
  2. checked 예외(Exception과 자손)를 unchecked 예외(RuntimeException과 자손)로 변경하기 위해