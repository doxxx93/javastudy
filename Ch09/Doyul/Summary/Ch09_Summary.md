# Ch09. Java.lang 패키지와 유용한 클래스
---

## 1. Java.lang 패키지

### 1.1 Object클래스
* 모든 클래스의 최고 조상. 오직 11개의 메서드만을 가지고 있다.
* notify(),wait() 등은 쓰레드와 관련된 메서드이다.

#### equals(Object obj)
* 객체 자신(this)과 주어진 객체(obj)를 비교한다. 같으면 true, 다르면 false.(반환타입 boolean)
* Object클래스의 equals()는 객체의 주소를 비교(참조변수 값 비교)

#### equals(Object obj)의 오버라이딩
* 인스턴스 변수(iv)의 값을 비교하도록 equals()를 오버라이딩해야 한다.
* cv는 객체마다 공통, iv는 객체마다 다르다. -> 객체는 iv를 통해 비교

