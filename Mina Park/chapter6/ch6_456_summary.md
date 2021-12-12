# CHAPTER 6. 객체지향 프로그래밍 1

## 4. 오버로딩(Overlaoding)   
<br>     

### 4.1 기본개념

* 용어: 메서드 오버로딩 or 오버로딩
* 의미: 한 클래스 내에 같은 이름의 메서드를 여러개 정의하는것
<br><br>
### 4.2 성립조건

```
1. 메서드 이름이 같아야 한다
2. 매개변수의 개수 or 타입이 달라야 한다
3. 반환타입은 아무런 영향을 주지 못한다
```

### 4.3 사용예시
* 보기1 != 오버로딩 ☞ 성립조건2 준수 X
```
int add(int a, int b) {return a+b;}
int add(int x, int y) {return x+y;}
```
* 보기2 != 오버로딩 ☞ 성립조건3 

```
int add(int a, int b) {return a+b;}
long add(int x, int y) {return (long)(x+y);}
```
* 보기3 == 오버로딩  

```
long add(int a, long b) {return a+b;}
long add(long a, int b) {return a+b;}
```
> Q. 매개변수의 순서만 다른 오버로딩의 경우, 단점은 없을까?
>> Exam. add(3,3) 호출 시 어느 메서드가 호출되었는지가 모호하므로  컴파일 에러 발생 (ambiguous) 

### 4.4 오버로딩의 장점
* 같은 기능을 가진 메서드들에 대해 하나의 이름으로 정의 => 기억 용이, 오류 가능성 감소, 메서드 이름을 통한 기능 예측, 메서드 네이밍 절약성

### 4.5 가변인자(varargs)와 오버로딩
> Q. 가변인자(variable arguments)란?
>> 매개변수의 개수가 동적으로 지정되는 경우(갯수의 제한이 없는 인자)
>>> 선언: 타입...변수명   
>>> 예시: int... nums, object... args 
* 보기1
  + 가변인자 외 매개변수가 더 있을 경우 가변인자는 가장 마지막에 선언
```
public PrintStream printf(String format, Integer num, Object... args) {...}
```
* 보기2
  + 인자의 개수 가변적으로 세팅가능
  + 예시:  (), ("a"), ("a", "b"), (new String[] {"A","B"}) 
  + 가변인자는 내부적으로 배열을 이용하므로 가변인자가 선언된 메서드 호출시마다 배열이 새로 생성
```
String  concat(string... str) {...}
``` 
> Q. 매개변수의 타입을 배열로 지정하는 것과 어떤 차이가 있을까?
>> 매개변수의 타입을 배열로 지정할 경우, 반드시 인자를 지정해줘야하므로 인자 생략 불가(null이나 길이가 0인 배열을 직접 지정 필요)
```
String  concat(String[] str) {...}

String res = concat(new String[0]);
String res = concat(null);
String res = concat();  <= 컴파일 에러(인자 지정 필요)
``` 
* 주의사항
  + 가변인자를 사용한 메서드는 되도록 오버로딩 X (메서드 구분이 모호한 경우 발생)

------------------------
## 5. 생성자(Constructor)   
<br>  

### 5.1 기본개념
* 의미: 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드(iv 초기화)'
  + 인스턴스 초기화:  인스턴스 변수에 적절한 값을 저장하는 것
* 조건
```
1. 생성자 이름 = 클래스 이름
2. 리턴값 없음(void는 생략)
3. 모든 클래스는 반드시 생성자를 가져야 한다
``` 
* 생성자의 오버로딩
```
calss Card {
    card() { //매개변수가 없는 생성자
        ...
    }

    card(int a, String b) { //매개변수가 있는 생성자
        ...
    }
}
``` 
  > Q. 생성자는 인스터를 생성하는 것이다?
  >> 용어 때문에 오해하기 쉽지만, 생성자는 iv 초기화에 사용되는 특별한 메서드
  >>> 인스턴스를 생성하는 역할은 연산자 new

![인스턴스 생성과정](https://github.com/doxxx93/javastudy/blob/main/Mina%20Park/chapter6/ch6_5.1_%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4%20%EC%83%9D%EC%84%B1%EA%B3%BC%EC%A0%95.JPG)


### 5.2 기본생성자
* 의미: 매개변수가 없는 생성자
* 특징: 클래스에 생성자가 하나도 정의되지 않은 경우 컴파일러가 자동적으로 기본생성자 추가
``` 
클래스이름() {}
``` 
* 유의사항: **_모든 클래스에는 반드시 하나 이상의 생성자가 있어야 한다_**
  
![기본생성자](https://github.com/doxxx93/javastudy/blob/main/Mina%20Park/chapter6/ch6_5.2_%EA%B8%B0%EB%B3%B8%EC%83%9D%EC%84%B1%EC%9E%90.JPG)
> Q. 컴파일 에러 발생 원인은?
>> Data2 클래스의 경우 기본생성자가 X => 이미 생성자가 존재하므로 컴파일러가 기본생성자 자동추가 X
>>> Data1의 경우 정의된 생성자 X => 컴파일러가 기본생성자 자동추가 O
>>>> Q. 컴파일 에러 해결하려면?
>>>>> Data2의 기본생성자를 직접 추가 => Data2() {};
>>>>>> **_클래스에 정의된 생성자가 하나도 없을 때만 컴파일러가 기본생성자 자동 추가_**

### 5.3 매개변수가 있는 생성자
* 생성자도 메서드처럼 매개변수 선언하여 호출 시 값을 넘겨받아 인스턴스 초기화 작업에 사용 가능
* 인스턴스 생성 후 변수 값 변경하는 방식보다 간결하고 직관적인 코드 작성 가능 
  
![매개변수가 있는 생성자](https://github.com/doxxx93/javastudy/blob/main/Mina%20Park/chapter6/ch6_5.2_%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%98%EA%B0%80%EC%9E%88%EB%8A%94%EC%83%9D%EC%84%B1%EC%9E%90.JPG)


