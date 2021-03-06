# CHAPTER 12. 지네릭스, 열거형, 애너테이션

## 1. 지네릭스(Generics)    
### 1.1 개념

* 의미: 다양한 타입의 객체를 다루는 메서드, 컬렉션 클래스에 **컴파일 시 타입체크 해주는 기능** 
* 장점
  - 객체의 타입 안정성을 높여줌
  - 타입체크와 형변환 생략 가능 => 코드의 간결화

### 1.2 지네릭 클래스의 선언
* 작성방법
  - 일반클래스를 지네릭 클래스로 변경하려면 클래스 옆에 <T> 작성
  - 타입변수의 경우 상황에 맞게 의미있는 문자 선택하여 작성
   
![선언](https://github.com/doxxx93/javastudy/blob/main/Ch12/Mina%20Park/summary/capture/ch12_1.2_%EC%84%A0%EC%96%B8.JPG)

* 지네릭스의 용어

![용어](https://github.com/doxxx93/javastudy/blob/main/Ch12/Mina%20Park/summary/capture/ch12_1.2_%EC%9A%A9%EC%96%B4.JPG)

* 지네릭스의 제한
  1. static 멤버에는 타입변수 T 사용불가 
   > static 멤버는 인스턴스 변수를 참조할 수 없기 때문
   >> 타입변수 T는 인스턴스 변수로 참조됨 
   >>> 지네릭스는 인스턴스별로 다르게 동작하도록 만들어진 기능(객체별로 다른 타입 지정)
  2. 지네릭 타입의 배열 생성 불가
   > new 연산자는 컴파일 시점에 타입 T를 정확히 알아야함
   >> 지네릭 타입의 경우 컴파일 시점에서는 T가 어떤 타입이 될지 전혀 알 수 없음

   ![제한](https://github.com/doxxx93/javastudy/blob/main/Ch12/Mina%20Park/summary/capture/ch12_1.2_%EC%A0%9C%ED%95%9C.JPG)


### 1.3 지네릭 클래스의 객체생성과 사용 

  ![객체생성과사용](https://github.com/doxxx93/javastudy/blob/main/Ch12/Mina%20Park/summary/capture/ch12_1.3_%EA%B0%9D%EC%B2%B4%EC%83%9D%EC%83%9D%EA%B3%BC%EC%82%AC%EC%9A%A9.JPG)

### 1.4 제한된 지네릭 클래스 

* 타입 매개변수 T에 지정할 수 있는 타입종류 제한 방법
  - 지네릭 타입에 extends 사용 => 특정타입의 자손들만 대입되도록 제한 \
  
 ![extends](https://github.com/doxxx93/javastudy/blob/main/Ch12/Mina%20Park/summary/capture/ch12_1.4_extends.JPG)

 ### 1.5 와일드 카드

![와일드 카드](https://github.com/doxxx93/javastudy/blob/main/Ch12/Mina%20Park/summary/capture/ch12_1.5_%EC%99%80%EC%9D%BC%EB%93%9C%20%EC%B9%B4%EB%93%9C.JPG)

 ### 1.6 지네릭 메서드

 ![지네릭 메서드](https://github.com/doxxx93/javastudy/blob/main/Ch12/Mina%20Park/summary/capture/ch12_1.6_%EC%A7%80%EB%84%A4%EB%A6%AD%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

 ### 1.7 지네릭 타입의 형변환

 ![형변환](https://github.com/doxxx93/javastudy/blob/main/Ch12/Mina%20Park/summary/capture/ch12_1.7_%ED%98%95%EB%B3%80%ED%99%98.JPG) 