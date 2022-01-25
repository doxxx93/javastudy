## 1. java.lang 패키지

- 자바 프로그래밍에 가장 기본이 되는 클래스들을 포함하고있어서 import없이도 사용 가능
- 그냥 필요할 때 활용하자.
- Object 클래스의 메서드를 오버라이딩할 때, public으로 되어있으면 **똑같이 public을 적어줘야**!!

## 1.1 object 클래스

![20211104_103127.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ec204961-76e4-48e9-80eb-d7d3214360d0/20211104_103127.png)

- java.lang.Object 클래스는 모든 클래스의 최고 조상, 오직 11개의 메서드만을 가지고 있다.
    
    // notify(),wait() 등은 쓰레드 관련 메서드라 나중에 알면 된다.
    
- `**clone**`: 복사본 만들기, **`eqauls`**는 객체비교, **`toString()`** 객체 정보 문자열 반환, **`getClass()`** 객체 설계도(클래스 정보) class 인스턴스 반환 (이를 통해 객체 생성, 객체 정보 얻을 수 있다)
- **protected 같은 것은 오버라이딩해서 public으로 변경**해야한다. 안 그러면 여기 있는 메서드들을 못 쓴다. 그러니 여기있는 것들은 대부분 오버라이딩해야한다.
    
    ⇒ 모든 클래스는 Object 클래스의 메소드를 사용할 수 있고 일부 메소드를 override해서 사용할수도 있습니다.
    

### **`boolean equals(object obj)`**

- 객체 자신(this)과 주어진 객체(obj)를 비교한다. 같으면 true
- object클래스의 equals()는 객체의 주소를 비교(참조변수 값 비교)
    - 서로 다른 두 객체는 항상 주소가 다르기에
    - v2 = v1; 하지 않는 이상 내용이 같다고 true가 나오지 않는다.
    
- **`equals(object obj)의 오버라이딩`**
    
    인스턴스 변수(iv)의 값을 비교하도록 오버라이딩한다.
    
    ## 오버라이딩은 선언부가 일치해야하기에, obj에 Object 붙여줘야한다.
    

![https://blog.kakaocdn.net/dn/bQCARM/btrfIX1vgTN/qHCYgTJ2qkKi5xkl2s6NwK/img.png](https://blog.kakaocdn.net/dn/bQCARM/btrfIX1vgTN/qHCYgTJ2qkKi5xkl2s6NwK/img.png)

- 오버라이딩하는 목적:  물리적으로 다른 메모리에 위치하는 객체여도 논리적으로 동일함을 구현하기 위해!  '**`물리적 동일함`**'은 객체가 메모리에서 같은 주소를 갖는 것을, '논리적 동일함'은 물리적으로 다른 위치에 있지만 같은 id의 회원 객체, 같은 id의 주문 객체와 같이 도메인을 구분할 수 있는 고유한 값 등에 의해 동일한 것을 의미합니다.
- 자식클래스에서 Object클래스로부터 상속받은 equals 메서드를 오버라이딩해서 원래 객체 주소 비교로 기본 설정되어있는 걸, return (값 비교) 로 바꾸라, 그럼 이 기준으로 true/false를 판가름

![ boolean equals 메서드. 주소값 비교가 아니라 내용 비교를 하고싶다면, eqauls를 오버라이딩해줘야한다. equals()의 기본 동작은 _==_ 연산이기 때문에 서로 다른 인스턴스를 가리키는 참조변수를 equals()로 비교하면 false가 리턴된다. (갖고 있는 값이 같더라도, 객체 주소가 다르다)](https://blog.kakaocdn.net/dn/4OxQm/btrfqhVawpA/EJQUoku0qSWM3OkwktV680/img.png)

 boolean equals 메서드. 주소값 비교가 아니라 내용 비교를 하고싶다면, eqauls를 오버라이딩해줘야한다. equals()의 기본 동작은 _==_ 연산이기 때문에 서로 다른 인스턴스를 가리키는 참조변수를 equals()로 비교하면 false가 리턴된다. (갖고 있는 값이 같더라도, 객체 주소가 다르다)

- 예제
    - 참조변수 형변환 하기전에 instanceof를 해줘야하는데, object는 모든 타입 다 들어올 수 있기에 꼭 해줘야한다. ## 타입 형변환과 오버라이딩 확실히
    
    ```java
    class EX9_1 {
        public static void main(String[]args){
        Value v1 = new Value(10);
        Value v2 = new Value(10);
    
        if (v1.equals(v2))
            System.out.println("v1과 v2는 같습니다.");
        else
            System.out.println("v1과 v2는 다릅니다.");
        v2 = v1;
        if (v1.equals(v2))
            System.out.println("v1과 v2는 같습니다.");
        else
            System.out.println("v1과 v2는 다릅니다.");
            }
    }
    
    class Value {
        int value;
    
        public boolean equals(Object obj){ //오버라이딩해준다.
            if (obj!=null && obj instanceof Value)  // 다형성 이용하기전 형변환 검사
    					// instanceof 할 때 타입인 것이다!! // null이어도 안 되게끔!
                return value(객체가 가진 값) == ((Value)obj).value;
    // Value v= (Value) obj; 아니면 그냥 바로 (Value) obj.value 이런식으로 해줘도 된다. 
            else
                return false;
        }
    
        Value(int value){
            this.value = value;
        } //타입 설정
    }
    
    // Object obj가 Value 클래스 안에 있는 value 멤버를 쓸 수 있도록(value 값을 참조할 수 있도록) **obj를 Value로 형변환** + 객체 형성 Value v= (Value) obj; Value 타입으로 변환해주자. ## 값 비교를 위해 형변환 // Object 클래스에는 value 같은 멤버가 없기에!
    ```
    

### `hashcode()` // 핵심 알고리즘, 11장 컬렉션 프레임워크에서

// eclipse에 hashcode 와 equals를 **자동으로 오버라이딩**해주는 기능이 있다.

- 객체의 해시코드(hash code)를 반환하는 메서드
- object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환
    
    => 이미 작성되어있는 객체주소를 자바 언어처럼 사용
    
- 인스턴스 변수 값으로 객체의 같고 다름을 판단해야한다면: equals()를 오버라이딩하면(iv를 갖고), hashCode()도 오버라이딩해야한다(얘도 iv를 갖고).
    
    // equals()의 결과가 true인 두 객체의 해시코드는 같아야하기 때문이다.
    

- System.identityHashCode(Object obj)는 Object클래스의 hashCode()와 동일
- **String 클래스안에 있는 equals라는 메서드를 사용하면** 두 비교대상의 주소 값이 아닌 데이터값을 비교하기 때문에 어떻게 String을 생성하느냐에 따라 결과가 달라지지 않고 정확한 비교를 할 수 있습니다.

- System.identityHashCode(Object obj)와 String.equals 비교

```java
String str1 = new String("abc");
String str2 = new String("abc");
// **String 클래스는 문자열의 내용이 같으면, 동일한 해시코드를 반환**하도록 
// hashCode메서드가 오버라이딩되어있다.

str1.equals(str2); 
str1.hashcode(); // 96354
str2.hashcode(); // 96354
System.identityHashCode(str1); //125352 
System.identityHashCode(str2); //4354363
// 이 메서드는 Object hashCode()와 동일하기에 항상 다른 해시코드값 반환
```

### **`toString()`**

- toString() : 객체를 문자열로 변환하기위한 메서드

![https://blog.kakaocdn.net/dn/rQcna/btrfG1QB5n7/rixsVGKOl1MzKHSb5ssyk0/img.png](https://blog.kakaocdn.net/dn/rQcna/btrfG1QB5n7/rixsVGKOl1MzKHSb5ssyk0/img.png)

=>object의 toString()을 사용하면 Card@139a55 이런 식으로 나오기 때문에 바꿔줄 필요가 있다.

```java
ex)
class Card{
	String kind;
	int number;

        Card() {
             this("Spade", 1);  //이것의 매개변수는 이렇다는 뜻이다. default 
        }

        Card(String kind, int number){
             this.kind = kind;
             this.number = number;
        }
        public String toString() {
				     return "kind : " + kind + ", number : " +number;
}

}
// 이런식으로 오버라이딩해서 kind, number 와 같은 iv를 출력하게끔 만든다.

결과
kind : Spade, number : 1
```

- 객체 == iv 집합 이기에 객체를 문자열로 변환한다는 것은 iv의 값을 문자열로 변환한다는 것과 같다.
- toString()은 일반적으로 **인스턴스나 클래스에 대한 정보 또는 인스턴스 변수들의 값**을 문자열로 변환하여 반환하도록 오버라이딩되는 것이 보통이다.
    
    ex) String클래스의 toString()은 String인스턴스가 갖고 있는 문자열을 반환하도록 자동 오버라이딩되어있다.
    
    ex) Date 클래스의 경우,Date인스턴스가 갖고있는 날짜와 시간을 문자열로 변환하여 반환하도록 자동 오버라이딩되어있다.
    

### **`Clone()` // 일단은 대충...**

- 자신을 복제하여 새로운 인스턴스 생성
- 참조변수도 똑같이 복제하기 때문에, 복사본도 같은 주소값을 가리키게되는 문제
- try-catch문 반드시 해줘야한다.
- cloneable를 구현한 클래스의 인스턴스 멤버만 clone()으로 복제가능. 그래서 super.clone()  사용
- 얕은 복사 vs 깊은 복사

### **`getclass()` // 일단은 대충...**

- 자신이 속한 클래스의 "Class" 객체를 반환하는 메서드
- Class 객체는 클래스의 모든 정보를 담고 있으며, 클래스 당 1개만 존재.
- 클래스로더: 실행 시에 필요한 클래스를 동적으로 메모리에 로드. 먼저 기존에 생성된 클래스 객체가 메모리에 존재하는 지 확인하고, 있으면 객체의 참조를 반환 없으면 클래스 패스에 지정된 경로를 따라서 클래스 파일을 찾는다. 못 찾으면 ClassNotFound 예외 발생
    
    ⇒ 즉, 클래스 파일을 읽어서 사용하기 편한 형태로 저장해놓은 것이 클래스 객체다. 
    

## 1.2 Stirng 클래스 //문자열을 다루기 위한 클래스

- String 클래스 = 데이터(char[]) + 메서드(문자열 관련) //문자열 데이터를 다룰 메서드
    
    ex) 데이터: private char[] value;
    
- 내용을 변경할 수 없는 불변(immutable) 클래스

![String 클래스 immutable 예시. ab가 원래 a와 b를 변경하는 것이 아니라 그냥 읽어와서 새로운 값이 만들어지는 것. 그리고 이를 a에 저장하면 a의 객체주소(0x100)가 ab의 객체주소(0x300)로 바뀌는 것이다. 그리고 a는 ab와 같은 객체주소로 변해서 ab를 가리키게된다.](https://blog.kakaocdn.net/dn/clEmvT/btrfBrbu6AB/U2ierVxkkexHCeiNsTCcZK/img.png)

String 클래스 immutable 예시. ab가 원래 a와 b를 변경하는 것이 아니라 그냥 읽어와서 새로운 값이 만들어지는 것. 그리고 이를 a에 저장하면 a의 객체주소(0x100)가 ab의 객체주소(0x300)로 바뀌는 것이다. 그리고 a는 ab와 같은 객체주소로 변해서 ab를 가리키게된다.

- 덧셈 연산자를 이용한 문자열 결합은 성능이 떨어진다(계속 새 값을 만들기에)
    
    => 문자열의 결합, 변경이 잦다면 내용을 변경가능한 **`StringBuffer`** 사용할 것!
    

- 문자열의 비교
    - String str = "abc" 와 String str = new String("abc")의 비교
        
        ![string 문자열의 비교 예시](https://blog.kakaocdn.net/dn/OOdFp/btrfsdFBrg3/Wvv3mxExWdL0rhVBhDD291/img.png)
        
        string 문자열의 비교 예시
        
    - **하나의 리터럴에는 하나의 주소만 만들어진다.** 그리고 new를 쓰면 리터럴 값이 같아도 항상 새로운 객체 만들어진다. new 생성자이기 때문에!!
        
        (그러니 같은 리터럴을 여러 번 초기화할 때 new 보다는 그냥 리러털 활용)
        
    - 문자열은 내용 변경 불가하기에 여러 참조변수가 공유해도 문제없다.
    - 문자열의 내용 비교는 대입연산자 ==를 사용하지말고 equals를 사용해야한다. (갖고있는 값이 같아도 객체 주소가 다르면 false가 나오기에) + == 대입연산자는 주소 비교이다! equals는 내용비교

### 헷갈리는 부분!!

```java
상수풀의 문자열

자바는 문자열도 객체로 표현하기 때문에 String 클래스의 객체를 생성해야만 문자열이 표현됩니다
(new 연산자로 말이죠) 사용이 빈번한 이런 문자열을 매번 new 연산자를 사용해서 객체를 만들기엔
번거로운 부분이 있어서 " " 로 표현하면 자동으로 String 객체가 생성되도록 문법을 제공.
또 다른 문제점으로는 빈번히 사용되기 때문에 "" 로 표현할때마다 객체를 생성하면 
메모리적인 부분에서 문제가 생길 수 있습니다
그래서 어짜피 String 객체는 그 내용을 변경할 수 없는 상수성격이 강한 객체이기 때문에 
여러곳에서 공유하더라도 문제가 되지 않으므로 "" 로 표현함에 한해서 이미 같은 내용을 가진 
String 객체가 존재한다면, 새로운 객체를 생성하지 않고 이미 만들어진 객체의 참조값을 반환.
따라서 str1에서 이미 "abc" 라는 내용을 가지는 객체가 생성되었으므로 str2는 
새로운 객체를 생성하지 않고 str1이 참조하는 객체의 참조값이 저장되죠. 결국 물리적주소는 같다.

String 클래스의 hashCode

Object클래스에 정의된 hashcode()는 **주소값**을 가지고 해시코드를 생성합니다. 
그러나 string은 문자열의 내용을 가지고 해시코드를 생성합니다. 1~4번 모두 내용이 같으니 같다.
string 클래스의 hashcode는 값을 기반으로 계산되는 결과이므로 물리적 위치와는 상관없다
=> str3 == str4 는 false 이나, hashcode는 동일하고, equals로는 true가 나온다.

문자열 리터럴과 문자열을 new로 생성한거의 차이
총생성되는 객체는 상수풀의 "abc" 객체 하나, str3,str4 객체
```

- 문자열 리터럴
    - 문자열 리터럴은 프로그램 실행 시 자동으로 생성된다(constant pool에 저장)
        
        // 우리가 String s1 = "AAA"; 해도 되는 이유. 원래라면 new String("AAA");해야하는데
        
    - 같은 내용의 문자열 리터럴은 하나의 String 객체로만 만들어진다. + 내용 변경불가, 여러 참조변수가 공유가능.

- 빈 문자열 “” (empty string) // 여러 유용한 점이 있다. ex) “”+5 -> "5"
    - 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열(그러니 아무것도 저장할 수 없다) String str = ""; // str을 빈 문자열로 초기화
    - 크기가 0인 배열을 생성하는 것은 어느 타입이나 가능
        
        char [] chArr = new char [0]; int [] iArr = {}; 둘 다 길이가 0
        
        // 배열의 크기는 타입별 크기 x 길이다. new int [10]는 40 byte
        
        // 자바에서는 메모리 별로 안 다루기에 신경 x. 여기서 길이 = 크기라고 대충 생각하자
        
    - 문자와 문자열의 초기화
        
        String s= ""; //빈 문자열로 초기화 ⇒ 숫자 같은 것들을 문자열화시키려고 주로 활용!
        
        char c = ''; //공백으로 초기화
        
        => 각각 null과 \u0000(유니코드 첫 번째 문자) 으로 초기화하는 것보다 이게 낫다.
        

### String 클래스의 생성자와 메서드

- 용도별 메서드 정리
    - 문자열을 갖는 String 인스턴스 생성
        - String(String s) 과 String(char [] value), String(Stringbuffer x)
    - 문자열과 사전 순서로 비교
        - int compareTo(String str) ex) "aaa".compareTo("bbb")
    - 문자열을 뒤에 붙인다.
        - String concat(String str)  ex) "a".concat("b") ⇒ "ab"
    - 특정 문자열이 내용에 있는지
        - boolean contains(CharSequence x)
    - 문자열 비교(매개변수로 입력받은 Object 객체와 String인스턴스 내용 비교)
        - boolean equals(Object obj)
    - 매개변수인 데이터의 인덱스 찾기
        - indexOf, lastindexOf
    - 문자열을 String 배열로 분리
        - String [] split(String regex) // regex는 분리자 ex) a.split(",") 는 a를 , 기준으로 분리
    - 문자열 중 일부만 담기
        - String substring(int begin,  int end) // **`end는 담기지 않는다`**!!
    - 대소문자화
        - String toUpperCase(), String toLowerCase();
    - 양쪽 공백 없애기
        - String trim()
    - 해당 값 문자열화
        - String valueOf( );
    - 여러 문자열 사이(문자열 배열에 있는 여러 값)에 구분자를 넣어서 하나의 문자열로 결합
        - String.join();

# 자주 쓰이기 때문에 메서드들을 다 봐야한다.

- String(char[] value) 는 char []를 String 인스턴스를 생성하며 바꿀 때. 그 반대는 **tocharArray();**
- String(StringBuffer --) 는 StringBuffer를 String으로 바꾸는 것(내용 변경 가능)이다. 그 반대는 반대로 하면 된다.
- char charAt(int index) 는 문자 1개 반환
- int compareTo(String str) 는 문자열 str 과 사전(dictionary) 순서로 비교한다. 그리고 세 가지 값을 반환한다. 주로 문자열을 정렬할 때 많이 사용한다.

![반환되는 타입도 잘 살펴볼 것!!](https://blog.kakaocdn.net/dn/z5lKg/btrfuOyxGTu/OuJ9XpuIr6ciGxkNfTc98k/img.png)

반환되는 타입도 잘 살펴볼 것!!

- String concat(String str) 은 문자열 str을 뒤에 붙인다.
- **boolean contains(CharSequence s)**
    
    ==> 문자열을 갖고 있는 String 객체가 ()를 갖고 있는지 boolean
    
    // CharSequence 는 interface로서 CharBuffer, Segment, String, StringBuffer,StringBuilder의 공통 조상이다. **다 문자열 배열**을 다루는 것들이다. 공통조상이 있으니 매개변수로 사용하고, 이들이 구현하는 클래스들이다. (다형성)
    
- **int indexOf(int ch)**: 문자를 주면 문자열에 존재하는 지 확인하여 위치를 알려준다.
    - 못 찾으면 -1을 반환한다.

![https://blog.kakaocdn.net/dn/dPK7OM/btrfFGspOht/CPcvTKC1XyO6rFGLmaCFk0/img.png](https://blog.kakaocdn.net/dn/dPK7OM/btrfFGspOht/CPcvTKC1XyO6rFGLmaCFk0/img.png)

- int lastIndexOf(int ch) 는 찾는 것은 **뒤에서부터** **`하나 반환`**되는 index(리턴 값은)는 앞에서 센 위치이다. 즉, 뒤에서부터 찾아서 첫번째 나오는 것을 반환하고, 이것의 주소값(앞에서)을 리턴한다.
    
    ++ String str 이 매개변수라면 위치는 시작위치이다.
    

![https://blog.kakaocdn.net/dn/bAymRW/btrftn2gLPE/tEKLs1Kp3jLaUwhRyHleYK/img.png](https://blog.kakaocdn.net/dn/bAymRW/btrftn2gLPE/tEKLs1Kp3jLaUwhRyHleYK/img.png)

- String [] split(String regex): 문자열을 지정된 분리자로 나누어 문자열 배열에 담아 반환한다. regex를 기준으로 분리 // regex는 정규식(Regular Expression)
    
    ++ int limit 은 지정된 수까지만 자르는 것. 2라면 2부분으로 나눈다는 소리다.
    

![https://blog.kakaocdn.net/dn/bcPMbH/btrftnHYyUw/5os67NUSASKNqTKkB8yJg0/img.png](https://blog.kakaocdn.net/dn/bcPMbH/btrftnHYyUw/5os67NUSASKNqTKkB8yJg0/img.png)

- String trim(): **`양쪽 끝에 있는 공백`**만 없애고 결과를 반환한다. 새로운 문자열을 만드는 것이다.
- static String valueof(--) : **`--를 String 화`**로 바꾼다는 소리다.

![https://blog.kakaocdn.net/dn/bCJnVQ/btrfBqRcg7j/fIxK7RKVxJYkFBg0KtNJ00/img.png](https://blog.kakaocdn.net/dn/bCJnVQ/btrfBqRcg7j/fIxK7RKVxJYkFBg0KtNJ00/img.png)

String 클래스의 생성자와 메서드들 5에 해당하는 것 + toString은 객체를 문자열로 변환. 즉, Date 타입 객체의 경우, 객체가 갖고있는 정보를 문자열로 변환

### StringJoiner 문자열과 기본형 변환

● join() 과 StringJoiner

- join()은 여러 문자열 사이에 구분자를 넣어서 결합한다. // join()은 static메서드이다.
- String [] arr = s.split(“,”) 앞에서 배웠던 것과 비슷. 대신 이건 문자열을 구분자로 나눠서 배열에 저장하는 것이라면, String str = String.join(“-”, arr) 은 배열의 문자열을 구분자로 나누고 결합
    
    ex) “dog-cat-bear”
    
    ex) String.join(“”, strVal, “+”, strVal2, “=”)+sum); 은 strVal+“+”+strVal2+“=”+sum2 와 같다.
    
    ```java
    public static void main(String[] args) {	
    	
    		String strVal2 = "200.0";
    		String strval1 = "100";
    		System.out.println(String.join("-",strval1, "+", strVal2, "=")+300);
    	}
    }  // 맨 앞에 있는 구분자를 뒤에 나올 각각의 데이터 오른쪽에 계속 붙인다. 
    결과
    100-+-200.0-=300
    ```
    
    // 여러 문자열을 결합해야할 때 string.join을 사용하는 것이 낫다.
    
    ```java
    String a = "dog, cat, bear";
    String b [] = a.split(",");
    String str = String.join("-",b);
    System.out.println(Arrays.toString(b));
    System.out.println(str);
    
    결과
    [dog,  cat,  bear]
    dog- cat- bear
    ```
    

- String.format()
    - format()은 형식화된 문자열을 만들어내는 방법. printf와 비슷하나, 이거는 변수에 저장할 수 있다는 장점! String str = String.format(%d 더하기 %d는 %d입니다. ", 3, 5, 3+5);

- 문자열과 기본형 간의 변환
    - 숫자를 문자열로 바꾸는 방법 int i = 100;
        1. String str1 = i + “”; // 편리하고 간단하다. // 특별히 속도 높일꺼 아니면 이렇게 쓰자.
        2. String str2 = String.valueof(i); // 처리 속도가 빠르다.
    - 문자열을 숫자로 바꾸는 방법
        1. int I = Integer.parseInt(“100”); // 옛 방법 // 실수형은 Double.parseDouble("100.0")이다.
        2. int 12 = Integer.valueof(“100”); //새 방법 // 뭘 사용해도 상관없다.
        3. Integer 12 = Integer.valueof(“100”); // 오토박싱: Integer-> Int로 자동적으로 변환한다

예제 9-19(Stringbuffer 연습예제)

## 1.3 Stringbuffer **`클래스`**: 문자열을 저장하고 다루기위한 클래스

- String처럼 문자열 배열(char [])을 내부적으로 가지고 있다.
- 그러나, String(내용 변경 불가)과 달리 내용을 변경할 수 있다. (mutable = 가변)
- String은 변경하면 새 주소값에서, Stringbuffer는 같은 주소값에서!

![기본적으로 문자열을 다룰 때는 String을 사용하되, 문자열을 저장하고 다루고 변경할 떄는Stringbuffer 사용.](https://blog.kakaocdn.net/dn/bQgI4b/btrfuPxr9nL/rgMzTnvUTxBfYEGbN9hkw0/img.png)

기본적으로 문자열을 다룰 때는 String을 사용하되, 문자열을 저장하고 다루고 변경할 떄는Stringbuffer 사용.

### StringBuffer의 생성자

- 배열은 길이 변경 불가, 공간이 부족하면 새로운 배열 생성해야.
    - 세 가지 과정: 새로운 배열 생성, 내용 복사, 참조변경 (arr = tmp;를 해서 arr가 가리키는 것이 tmp가 되도록(arr의 주소도 tmp의 주소로 변한다))
    
    => 이런 일들이 자꾸 생기면 성능이 떨어지니, StringBuffer는 저장할 문자열의 길이를 고려해서 적절한 크기로 생성해야한다. 공간이 부족한 일이 없도록....
    

![길이를 매개변수로 주면, 문자열의 길이는 부여. 문자열을 매개변수로 주면 기본 16자리에서 문자열의 길이만큼 버퍼를 늘린다.](https://blog.kakaocdn.net/dn/bT2FRs/btrfFEBnXFk/wpLKuwJA4E9Ac4zDcKJ1IK/img.png)

길이를 매개변수로 주면, 문자열의 길이는 부여. 문자열을 매개변수로 주면 기본 16자리에서 문자열의 길이만큼 버퍼를 늘린다.

### StringBuffer의 변경

- StringBuffer는 String과 달리 내용 변경이 가능하다.

```java
ex)

StringBuffer sb = new StringBuffer(“abc”);
sb.append(“123”); // sb 내용 뒤에 “123”추가

// 추가 메서드  append() 끝에 문자열, delete() 삭제, insert() 삽입
```

- append()는 지정된 내용을 StringBuffer에 추가 후, StringBuffer의 참조를 반환
    
    (밑 예제에서 sb 자체가 변하는 것이기 때문에 sb2도 결국은 sb를 가리키는 것을 의미한다)
    

```java
ex)

StringBuffer sb = new StringBuffer(“abc”);
sb.append(“123”);

StringBuffer sb2 = sb.append(“zz”);  //sb.append(“123”).append(“zz”); 도 가능하다!
sop(sb); 결과: abc123ZZ
sop(sb2); 결과: abc123ZZ
```

### StringBuffer의 비교

StringBuffer는 equals()가 오버라이딩되어있지 않다.(equals도 주소 비교를 한다는 뜻이다 ) 

=> this == obj  // string은 자동 오버라이딩 되어있기 때문에 내용비교를 하는데...

![StringBuffer의 비교는 주소 비교다. 그러니, 내용비교를 하려면 String으로 변환해야한다.](https://blog.kakaocdn.net/dn/vC0RE/btrfIX1vsMI/To7MyJtVwt0Nls9B9MdfO0/img.png)

StringBuffer의 비교는 주소 비교다. 그러니, 내용비교를 하려면 String으로 변환해야한다.

### StringBuffer의 생성자와 메서드

![https://blog.kakaocdn.net/dn/pmzNd/btrfuOZChUP/2eOrttZ8tQMH0gQzlbAhK1/img.png](https://blog.kakaocdn.net/dn/pmzNd/btrfuOZChUP/2eOrttZ8tQMH0gQzlbAhK1/img.png)

StringBuffer 생성자와 메서드

- 왠만하면 Stringbuffer(int length)를 사용해서 지정된 개수를 정해주는 것이 좋다.
- StringBuffer는 char 타입 배열이기떄문에 append(true)를 하면, t,r,u,e 로 저장된다.

![길이, 반환, 삭제](https://blog.kakaocdn.net/dn/bfKjWN/btrfw48XxCt/gTQbpW4ZPgCNY3tQ8qYKMk/img.png)

길이, 반환, 삭제

// 이 모든 메서드들은 StringBuffer를 반환하는 것이다.

![삽입, 문자열의 길이, 치환, 문자열 뒤집기](https://blog.kakaocdn.net/dn/bijyD4/btrfzkwUrS5/mRCJyAF1RG1lrVpHs610f1/img.png)

삽입, 문자열의 길이, 치환, 문자열 뒤집기

![해당 인덱스 치환, 길이 변경, String 타입으로 변경, 뽑아서 반환](https://blog.kakaocdn.net/dn/bdLzA4/btrfIYMS2fq/AqkyKGS3HX7aKPCiUnKnUK/img.png)

해당 인덱스 치환, 길이 변경, String 타입으로 변경, 뽑아서 반환

// trim(); 양끝의 빈공백을 제거한다.

// 자바에서는 시작 범위는 포함하되, **`끝 범위는 포함 안되는 경우가 많다`**.

# 메서드체이닝: 메서드.메서드 이렇게 메서드를 연속적으로 호출하는 것

## StringBuffer sb2 = sb.append(--); 이면 sb와 sb2 는 같은 **객체주소**!

## 1.4 StringBuilder, Math클래스

### StringBuilder

- StringBuffer는 **`동기화`**되어있으나 StringBuilder는 비동기화다. 멀티쓰레드에 안전
    - 지금까지 했던 것은 한번에 1개 작업하는 싱글 쓰레드이다.
    
    ex) 파일 다운로드 시 문자를 보낼 수 없는 상황
    
    - 13장부터 멀티쓰레드가 나온다. 멀티쓰레드의 단점은 데이터를 공유하는데 어려움이 잇을 수 있다. (A가 하는 도중에 B가 건드리면....) => 이를 해결하기위한 것이 동기화이다.
- 멀티쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능저하 => StringBuilder 사용
    
    다른 건 Stringbuffer와 동일하다. 동기화 여부의 차이일뿐이다. 바꿔줄 때도 StringBuffer -> StringBuilder로 바꾸면 되는 것
    

### Math클래스

- 수학관련 static 메서드의 집합 //메서드밖에 없어서 iv가 없으니 static이다. + 생성자도 private
- 종류: Math.round() (소수점 아래 첫 자리에서 반올림), Math.random()
- 반올림(**`int형`**): 원하는 값을 얻기위해서는 10의 n제곱으로 곱해주고 반올림 후 다시 나눔!
    - ex) 90.7552를 소수 둘째자리까지 반올림 ⇒ 100을 곱해주고 **Math.round(9075.52)→9076**
- Math클래스의 메서드

// 반올림의 종류: round, rint(round even, 잘 안쓴다), even, half_up, half_down 등

![절대값, 올림, 버림, 최댓값 반환](https://blog.kakaocdn.net/dn/nzOqP/btrfuKWEj8j/J6HPxLYTtwI1lpMuRz6rK1/img.png)

절대값, 올림, 버림, 최댓값 반환

![최소값 반환, 랜덤 반환, 가장 가까운 정수값 반환, 반올림](https://blog.kakaocdn.net/dn/cYoE51/btrfuOZCiFF/20hzX2MzB2eiQoYS1gTXqK/img.png)

최소값 반환, 랜덤 반환, 가장 가까운 정수값 반환, 반올림

### 기타

- 예외를 발생시키는 메서드
    - 메서드 이름에 Exact를 붙인다. 그러면 정수형 간의 연산에서 발생하는 오버플로우 감지
- 삼각함수와 지수, 로그

## 래퍼(wrapper) 클래스: 기본형 값을 감싸는 클래스

- 8개의 기본형(객체x)을 객체로 다뤄야할 때 사용하는 클래스
- 자바는 객체지향언어이기에 모든 것이 객체여야한다. 그러나 기본형은 객체가 아니기에... 이는 성능을 위해서다. **`기본형까지 참조형처럼 객체가 되버리면 참조변수를 읽고 객체로 향하기에 2단계과정, 기본형은 바로 메모리를 만들고 거기에 저장하기에 1단계.`**
- 생성자의 매개변수는 무조건 기본형 클래스 타입에 맞는 걸 집어넣어야한다. 안 그러면 **`NumberFormatException`** 발생
- String 타입처럼 equals 가 값 비교하는 오버라이딩이 자동적으로 ++ toString도 자동!

![생성자 부분 확인!!!](https://blog.kakaocdn.net/dn/PsZsW/btrfBqRcm4u/mrZ76OOIhxNDoC2VvuVKJK/img.png)

생성자 부분 확인!!!

![https://blog.kakaocdn.net/dn/dkclBe/btrfxPJ5pxe/ClKCKrFCvACRIrHH3FX0pk/img.png](https://blog.kakaocdn.net/dn/dkclBe/btrfxPJ5pxe/ClKCKrFCvACRIrHH3FX0pk/img.png)

### Number 클래스

- 모든 숫자 래퍼 클래스의 조상 : Byte, Short, Integer, Long, Float, Double, Biginteger, BigDecimal

### 문자열과 숫자변환 오토박싱 & 언박싱

![이제는 오토박싱 기능 때문에 반환값이 기본형일 때와 래퍼클래스 일때의 차이가 없어졌다. 즉, 그냥 구별없이 valueOf()를 써도 된다. 물론 성능은 조금 느리다.](https://blog.kakaocdn.net/dn/coTpKK/btrfA0q3TRc/KkNKoSMfDera1A4XEvN93k/img.png)

이제는 오토박싱 기능 때문에 반환값이 기본형일 때와 래퍼클래스 일때의 차이가 없어졌다. 즉, 그냥 구별없이 valueOf()를 써도 된다. 물론 성능은 조금 느리다.

- 문자열을 숫자로 변환하기
    
    래퍼객체(new Integer(100))에서 기본형 100 으로 바꾸고 싶다면, intValue();를 하면 된다. Integer에서 int로 바뀐다.
    
    1. int I = new Integer("100").intValue();
    2. int 12 = Integer.parseInt("100") // 주로 이 방법 많이 사용한다.
    3. Integer(int가능) 13 = Integer.valueOf("100");
        
        // 래퍼클래스 -> 문자열은 toString()을 이용한다.
        
    
- n진법의 문자열을 숫자로 변환하는 방법
    
    ex) int i4 = Integer.parseInt("100",2); //100을 2진수로. default는 10진수이다.
    
    ex) 16진법에서는 A~F문자도 허용. int i8 = Integer.parseInt("FF", 16); 허용!
    

### 오토박싱 & 언박싱

- 오토박싱: int(기본형의 값)->Integer(객체)로 자동 변환. 언박싱은 그 반대. 박싱은 랩핑과 같다고 할 수 있다.
- JDK 1.5 이전에는 기본형과 참조형 간의 연산이 불가능
    
    ex) int I = 5; Integer 10bj = new Integer(7); int sum = I+10bj; // 에러
    
    - 1.5버전 이후부터 컴파일 후의 코드:
        
        int I = 5; Integer 10bj = new Integer(7); int sum = I+10bj.intValue;
        
        (컴파일이 알아서 기본형으로 변환)
        
        ===> 편리한 기능을 사용하되, 이게 왜 되는지를 알고 있어야한다.
        
        ```java
        public class A99_class_java {
        	public static void main(String[] args) {
        	
        		int i = 10; // 기본형 값
         		Integer intg = new Integer(10); // 참조형 값
        		
        		System.out.println(i+intg); //기본형과 참조형 간의 연산
        															  // 컴파일러에서 자동적으로 기본형으로 변환.
        																// 컴파일러가 알아서 intg.intValue()를 붙여준다.
        		}
        }
        ```
        

=⇒ **오토박싱과 언박싱으로 인해 컴파일러가 기본형과 참조형 간의 자동변환을 해줘서 우리가 편하게 사용하게되었다**를 알라!

![https://blog.kakaocdn.net/dn/2bAOp/btrfIYe2ras/zTocufVy8X6npfQuojEAdK/img.png](https://blog.kakaocdn.net/dn/2bAOp/btrfIYe2ras/zTocufVy8X6npfQuojEAdK/img.png)

- **`주의`**: Integer intg는 참조형이고, (Integer) I는 기본형이다. ()은 타입이라는 소리

## 2. 유용한 클래스 (나중에 필요해지면 그 떄 다시...)

## 2.1 java.util.Objects 클래스

- isNull(Object obj): 해당 객체가 null인지 확인해서 null이면 true반환
- nonNull(Object obj): isNull()의 반대
- requireNonNull(name, "에러 메시지"): 객체가 널이 아니어야하는 경우(유효성 검사)
- eqauls(Object a, Object b) : null 검사를 하지않아도 두 객체 모두 null 검사를 자동적으로
- compare(Object a, Object b): 두 객체를 비교해서 같으면 0, 크면 양수, 작으면 음수 반환

## 2.2 java.util.Random 클래스

- int [] fillRand(int[] arr, int[] data): 배열 arr을 배열 data의 값들로 랜덤하게 채워서 반환

## 2.3 java.util.Regex 클래스

- 정규식 표현을 위한 클래스
    - 정규식: 텍스트 데이터 중에서 원하는 조건(pattern)과 일치하는 문자열을 찾아내기위해 사용하는 것으로 미리 정의된 기호와 문자를 이용해서 작성한 문자열


## 2.4 java.util.Scanner 클래스

## 2.5 java.util.StringTokenizer 클래스

- StringTokenizer는 긴 문자열을 지정된 구분자를 기준으로 토큰이라는 여러 개의 묹자열로 잘라낸다. "100,200,300"이라는 문자열을 "100", "200", "300"이라는 3개의 문자열로 자른다.
    
    ex) StringTokenizer st = new StringTokenizer(문자열, "구분자")
    

## 2.6 java.util.BigInteger 클래스

- 가장 큰 정수형 타입인 long으로 표현할 수 있는 값보다 더 큰 값을 다뤄야할 때 사용!

## 2.7 java.util.BigDecimal 클래스

- BigDecimal은 실수형과 달리 정수를 이용해서 실수를 표현한다. 정수와 10의 제곱의 곱으로 표현. 그리고 실수형의 정밀도 문제를 해결하기위해.......





