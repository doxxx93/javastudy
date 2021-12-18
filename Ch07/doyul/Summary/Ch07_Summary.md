# Ch07. 객체지향 프로그래밍 II
-----------------

## 1. 상속(inheritance)

### 1.1 상속의 정의와 장점 // 그림 도 그릴 수 있어야함

* 기존의 클래스로 새로운 클래스를 작성(코드의 재사용)
* 두 클래스를 부모와 자식으로 관계를 맺어주는 것
* 자손은 조상의 모든 멤버를 상속 받는다.(생성자, 초기화 블럭 제외)
* 자손의 멤버 개수는 조상보다 적을 수 없다.(같거나 많다)
* 자손의 변경은 조상에 영향을 미치지 않는다.

```java
class Parent {                  //부모클래스 : 멤버 1개
    int age;
}                               //상속 관계

class Child extends Parent {    //자식클래스 : 멤버 2개
    void play() {               //자신의 멤버 1 개
        System.out.println("Let's play~!")
    }                           //상속받은 멤버 1개 (int age;)
}
```

### 1.2 클래스간의 관계 - 포함관계

* 클래스의 멤버로 참조변수를 선언하는 것
* 작은 단위의 클래스를 만들고, 이 들을 조합해서 클래스를 만든다.
* 저장 공간은 같으나 구조적 차이 발생 // * 그림 추가하기

### 1.3 클래스 간의 관계 결정하기

* 대부분 포함으로 진행
* 상속관계 : '~은 ~이다.(is - a)'
    - 원은 점이다.
* 포함관계 : '~은 ~을 가지고 있다.(has -a)'
    - 원은 점을 가지고 있다. 더 자연스러움.

### 1.4 단일 상속(Single Inheritance)

* Java는 단일상속만을 허용 : 하나의 부모만 상속
* 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 한다.

### 1.5 Object클래스 - 모든 클래스의 조상

* 부모가 없는 클래스는 자동적으로 Object클래스를 상속받게 된다.
* 모든 클래스는 Object클래스에 정의된 11개의 메서드를 상속받는다.
    - toString(), equals(Object obj), hashCode(), ...등
      ![Object클래스의 메서드](1.jpg)

## 2. 오버라이딩(overriding)

### 2.1 오버라이딩이란?

* 상속받은 조상의 메서드를 자신에 맞게 변경하는 것 (overide : 덮어쓰다)

```java
class Point {
    int x;
    int y;

    String getLocation() {
        return "x:" + x + ", y:" + y;
    }
}

class Point3D extends Point {
    int z;

    String getLocation() {
        return "x:" + x + ", y:" + y + ", z:" + z;
    }
}

public class OverrideTest {
    public static void main(String[] args) {
        Point3D p = new Point3D();
        p.x = 3;
        p.y = 5;
        p.z = 7;
        System.out.println(p.getLocation());    // x:3, y:5, z:7 출력
    }
}
```

```java
//class Point extends Object { // 명시적으로 extends 하다는 알람이 뜸
class Point {
    int x;
    int y;

    /*
    생성자를 통해 더 간결하고 직관적인 코드 작성이 가능
    Point(int x, int y) {
        this.x = x;
        this.y = y;
  }    
*/

    // Object 클래스의 toString()을 오버라이딩
    public String toString() {
        return "x:" + x + ", y:" + y;
    }
}

public class OverrideTest {
    public static void main(String[] args) {
/*
        생성자 통해 작성했을 때
        Point p = new Point(3,5);
        System.out.println(p);  
*/

        Point p = new Point();
        p.x = 3;
        p.y = 5;
//      System.out.println(p.toString()); // x:3, y:5 출력 toString이 불필요함
        System.out.println(p);            // x:3, y:5 출력 
    }
}
```

### 2.2 오버라이딩의 조건

* 선언부가 조상 클래스의 메서드와 일치해야 한다
    - 선언부(반환타입, 메서드이름, 매개변수목록)
* 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다
    - public, protected, private
* 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다

### 2.3 오버로딩 vs. 오버라이딩

* 오버로딩(overloading) : 기존에 없는 새로운 메서드를 정의하는 것(new)
    - 같은 이름의 메서드, 상속과 연관이 없음
* 오버라이딩(overriding) : 상속받은 메서드의 내용을 변경하는 것(change, modify)

```java
class Parent {
    void parentMethod() {
    }
}

class Child extends Parent {
    void parentMethod() {           //조상의 메서드를 자손클래스에서 변경
    }                               //오버라이딩

    void parentMethod(int i) {      //이름이 같은 메서드를 매개변수만 다르게 정의
    }                               //오버로딩

    void childMethod() {            //메서드 정의
    }

    void childMethod(int i) {       //이름이 같은 메서드를 매개변수만 다르게 정의
    }                               //오버로딩

    void childMethod() {            //중복정의
    }                               //에러
}

```
