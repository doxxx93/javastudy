# CHAPTER 9. java.lang 패키지와 유용한 클래스

## 1. java.lang 패키지

### 1.1 개념

* 의미: 모든 클래스의 최고 조상
  - 오직 11개의 메서드를 가짐
 
  ![메서드]()

### 1.2 equals()
* 의미: 객체 자신(this)과 주어진 객체(obj)를 비교
* 특징: Object 클래스의 equals()는 객체의 주소를 비교(참조변수값 비교)

### 1.3 equals()의 오버라이딩
* 의미: 인스턴스 변수의 값을 비교하기 위해서는 equals()를 오버라이딩 필요
  
  ![오버라이딩예시]()

### 1.4 hashCode()
* 의미: 객체의 해시코드를 반환하는 메서드
```
[참고] 11장 컬렉션 프레임워크
``` 

* 특징: Object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환
* 사용방법
  - equals()를 오버라이딩하면 hashCode()도 오버라이딩 필요
  - equals()의 결과가 true인 두 객체의 해시코드 또한 같아야하기 때문

### 1.5~6 toString(), toString()의 오버라이딩
* 의미: 객체(iv 집합)를 문자열로 변환하기 위한 메서드
  
  ![toString예시]()


### 1.7 String 클래스
* 의미: 문자열을 다루기 위한 클래스
  - 데이터(char[]) + 메서드(문자열 관련)
* 특징
  - 내용을 변경할 수 없는 불변 클래스 => 문자열 변경시마다 새로운 클래스가 생성됨
  - 문자열의 결합/변경이 잦을 경우, 내용변경이 가능한 StringBuffer 사용
  
  ![String클래스]()

### 1.8 문자열의 비교
* 방식 비교
 ```
1. String str = "abc"; //하나의 객체를 생성
2. String str = new String("abc"); //새로운 객체를 계속 생성

=> 2번의 경우처럼 같은 내용의 문자열을 여러번 new 연산자로 생성할 필요 없이, 하나의 객체를 생성해놓고 여러 변수로 해당 객체를 가리키는 방식이 효율적
```  

### 1.9 문자열 리터럴
* 의미: 프로그램 실행시 자동으로 생성(constant pool, 상수 저장소)에 저장
* 특징: 같은 내용의 문자열 리터럴은 하나만 생성

``` java
String s1 = "aaa";
String s2 = "aaa";
String s3 = "aaa"; //모두 동일한 하나의 상소 저장소에 저장
``` 

### 1.10 빈 문자열("", empty string)
* 의미: 내용이 없는 문자열, 크기가 0인 char형 배열을 저장하는 문자열
``` java
STring str = "";
``` 
* 특징: 크기가 0인 배열을 생성하는 것은 어느 타입이나 가능
``` java
  Char[] chArr = new Charp[0];
  int[] iArr = {};
```
* 문자와 문자열을 초기화
``` java
  String s = ""; //빈 문자열로 초기화
  Char c = ''; //공백으로 초기화
```
![빈문자열]()


### 1.11 String클래스의 생성자와 메서드

![메서드1]()

![메서드2]()

![메서드3]()

### 1.12 join()과 StringJoiner

* 의미: join()은 여러 문자열 사이에 구분자를 넣어서 결합

``` java
  String animals = "dog,cat,bear";
  String[] arr = animals.split(",");
  String str = String.join("-", arr); //배열의 문자열을 "-"로 구분해서 결합
  System.out.println(str); //dog-cat-bear 출력
```

  ### 1.13 문자열과 기본형 간 결합
  * 숫자를 문자열로 바꾸는 방법
  
``` java
  int i = 100;
  String str1 = i + ""; //100을 "100" 으로 변환 방법1
  String str2 = String.valueOf(i); //100을 "100" 으로 변환 방법2(속도가 더 빠름)
```

  * 문자열을 숫자로 바꾸는 방법
 ``` java
  int i = Integer.paresInt("100"); //"100"을 100으로 변환 방법1
  int i2 = Integer.valueOf("100"); //"100"을 100으로 변환 방법2(새로운 방법)
  ```

### 1.15 StringBuffer 클래스

* 의미: 문자열을 저장하고 다루기 위한 클래스
  - String처럼 문자열 배열(char[])을 내부적으로 가지고 있음 
* 특징
  - String과 달리 내용 변경 가능하므로 아래와 같은 메서드를 지니고 있음
    - append(); //끝에 문자열 추가
    - insert(); //삽입
    - delete(); //삭제
  - but, 길이 변경은 불가
    - 공간 부족 시 새로운 배열 생성 필요하므로, 최초 생성 시 적절한 크기로 생성
  - equals()가 오버라이딩 되어 있지 않음
    - 즉, 값이 아닌 주소를 비교한다는 의미
    - 값 비교를 할 경우, StringBuffer를 String으로 변환 후 equals()로 비교

![stringBuffer]()

