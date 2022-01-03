## 8장 예외처리

## 1. 예외처리

## 1.1 프로그램 오류

- **`발생시점`**에 따라 컴파일 에러(컴파일할 때)와 런타임 에러(실행할 때, 의도한 것과 다르게 동작)
    
    ++ 논리적 에러(컴파일, 실행 잘 되지만 의도한 것과 다르게 동작)
    
- 컴파일 에러 과정
    - 소스코드를 컴파일하면 컴파일러가 소스코드(.java)에 대해 오타, 잘못된 구문, 자료형 체크 등의 기본적인 검사를 수행하여 오류가 있는지 알려준다. 컴파일을 성공적으로 마치면 클래스파일(.class)이 생성되어 실행. 처리되지못한 예외는 JVM의 예외처리기가 받아서 원인을 화면에 출력한다.

- Java의 런타임 에러
    
    에러: 프로그램 zem에 의해서 수습될 수 없는 **`심각`**한 오류 ex) 메모리 부족, 스택오버플로우
    
    예외(exception): 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
    
    => 에러는 어쩔 수 없지만, 예외는 처리해야한다.
    
- 예외처리: **`예외 발생에 대비`**하는 코드 작성
    
    <aside>
    💡 **목적: 프로그램의 비정상 종료 막고 정상적인 실행상태 유지**
    
    </aside>
    

> 예외클래스의 계층구조
> 

![자바에서는 실행 시 발생할 수 있는 오류를 클래스로 정의하였다. 그래서 이들도 Object클래스의 자손. 모든 예예외의 최고조상은 Exception 클래스.]

자바에서는 실행 시 발생할 수 있는 오류를 클래스로 정의하였다. 그래서 이들도 Object클래스의 자손. 모든 예예외의 최고조상은 Exception 클래스.

- Exception 클래스와 조손들 / RuntimeException 클래스와 자손들 2그룹 구성
    
    ![https://blog.kakaocdn.net/dn/bfGRmb/btrfhloGQ7Z/5Mz9SVmj9Ix8c34uPqufO1/img.png](https://blog.kakaocdn.net/dn/bfGRmb/btrfhloGQ7Z/5Mz9SVmj9Ix8c34uPqufO1/img.png)
    
    - RuntimeException 예시
        - 배열 범위 벗어남(ArrayIndexOutOfBoundsException),
        - null 참조변수 멤버 호출(Nullpointer),
        - 클래스간 형변환 실수(ClassCastException),
        - 정수를 0으로 나누려는(ArithmeticException) 등
    - Exception 예시
        - 존재하지않는 파일의 이름 입력(FileNotFoundException)
        - 실수로 클래스 이름 실수(ClassNotFoundException)
        - 입력한 데이터형식 실수(DataFormatException)

![https://blog.kakaocdn.net/dn/NX7PU/btrfhJbJoy4/0lY7dip56V0O6sJ5DqBB81/img.png](https://blog.kakaocdn.net/dn/NX7PU/btrfhJbJoy4/0lY7dip56V0O6sJ5DqBB81/img.png)

## 1.3 예외처리하기 try-catch문

● 예외처리구문 try-catch (catch의 변수는 Exception e로 해주는 것이 좋다)

![https://blog.kakaocdn.net/dn/r43h8/btrfgGz6rrR/1Y1tnBOecOpoTgbhHCutVK/img.png](https://blog.kakaocdn.net/dn/r43h8/btrfgGz6rrR/1Y1tnBOecOpoTgbhHCutVK/img.png)

 -  try블럭 또는 catch블럭에 또다른 try-catch문 포함 가능. 

 - catch블록의 괄호 내에 선언된 변수 e는 catch 블럭 내에서만 유효하기에 모든 catch블럭에 e 사용해도 된다.

- 그리고 catch블록 내에 또 하나의 try-catch문이 포함된 경우, 같은 이름의 참조변수 사용 불가(서로 구별)

- 예외처리 기본 구조
    
    ```java
    public class Ex8_2와3예외처리구문추가 {
        public static void main(String[] args) {
            int number = 100;
            int result = 0;
    
    //        for (int i=0; i<10; i++){
    //            result = number/(int)(Math.random()*10);
    //          System.out.println(result);
    
    //        }
    //    }
    
    // }  //원래 코드
    
            for (int i = 0; i < 10; i++) {
                try {
                    result = number / (int) (Math.random() * 10);
                    System.out.println(result);
                } catch (ArithmeticException e) {
                    System.out.println("0");
                }
            }
        }
    }
    
    // java.lang.ArithmeticException: / by zero 에러
    //Exception in thread "main" java.lang.ArithmeticException 산술연산과정에서 오류가 있을 떄 발생하는 예외
    ```
    

**`예외 해결 과정`**

 먼저 예외가 발생하는 장소를 보고, 어떤 예외인지 파악. 그리고 해결방법을 찾고나서 try-catch문 작성한다.

- try-catch문에서의 흐름

![https://blog.kakaocdn.net/dn/T9ihK/btrfhIw8l0Y/X8jxSWadBwRUGy48UgnVSK/img.png](https://blog.kakaocdn.net/dn/T9ihK/btrfhIw8l0Y/X8jxSWadBwRUGy48UgnVSK/img.png)

 - try에 진입하고나서 쭉 진행하다가 예외가 없으면 **catch문 쌩까고** 그냥 다음 문장으로.

 - 만약 예외 발생하면 try에서 벗어나서 해당하는 catch문으로 들어가서 수행하고 그 다음문장 수행

- **예외가 발생하지않는 경우 try문만 실행하고 catch문을 실행x**
    
    ```java
    // 예외가 발생하지않는 경우 try문만 실행하고 catch문을 실행x
    
    public class A99_class_java {
    
    	public static void main(String[] args) {	
    
    	System.out.println("a");
    	System.out.println("b");
    	
    	try {
    	System.out.println("c");
    	System.out.println("d"); // 에러가 없으면 이렇게 실행하라. 
    	} catch(Exception e) {	
    	System.out.println("e"); // 에러가 없으면 실행되지않는다. 
    	   
    	}
    	System.out.println("f");
    	}
    }
    
    결과
    a
    b
    c
    d
    f
    ```
    

- **try문을 실행하다가 도중에 에러가 발생하면 try를 벗어나서 catch문 수행 후, 다음 문장으로 감.**
    
    ```java
    // try문을 실행하다가 도중에 에러가 발생하면 try를 벗어나서 catch문 수행 후, 다음 문장으로 간다.
    
    public class A99_class_java {
    
    	public static void main(String[] args) {	
    
    	System.out.println("a");
    	System.out.println("b");
    	
    	try {
    	System.out.println("c");
    	System.out.println(3/0);
    	System.out.println("d"); // 에러가 발생해서 수행되지않는다. 
    	} catch(ArithmeticException e) { 
    		//예외가 발생해서 ArithmeticException 타입의 e 인스턴스 생성
    		// Exception 클래스를 사용해도 된다. 															
    		System.out.println("e"); 
    	   
    	}
    	System.out.println("f");
    	}
    }
    
    결과
    a
    b
    c
    e
    f
    ```
    

- 예외 발생 과정에서의 검사
    - 예외가 발생하면 catch () 타입의 인스턴스 생성해서 **`instanceof연산자`**를 이용해서 검사결과가 true인 catch 블럭을 만날 때까지 계속 검사한다.
        - if ( e instance of Exception) 을 하는 것과 같다. 이 때는 모든 예외가 처리된다.

- **`다형성`**: 모든 예외 클래스는 Exception 클래스의 자손이므로, catch()에 Exception 클래스 타입의 참조변수 선언하면 어떤 종류의 예외도 이 블록에서 처리된다.
    
    ==> 위에 ArithmeticException 대신 조상인 Exception사용가능(다형성)
    

```java
// catch문을 else if, else처럼 사용할 수 있다!

public class Ex8_7instanceof {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try{
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        }

	// 참조변수 ae(에러에 해당하는)를 통해, 생성된 ARith--- 인스턴스에 접근할 수 있다.
  // 참조변수에 인스턴스의 주소값이 있으니까 
        catch(ArithmeticException ae){
            if(ae instanceof ArithmeticException)
                System.out.println("true");
            System.out.println("ArithmeticException");
        } //catch블럭 괄호 내에 선언된 참조변수의 종류와
        생성된 예외클래스의 인스턴스에 instanceof 연산자를 이용해서 검사하게되는데,
        true인 catch블럭을 만날때까지 계속된다. => 쉽게 생각해서 해당 에러에 맞는가?

           catch(Exception e){
            System.out.println(6);
        } // 위 ArithmeticException을 제외한 모든 예외가 처리된다.
    }
}
```

- printStackTrace() 와 getMessage() ==> 이를 통해 **`예외의 발생원인`**을 파악
    - printStackTrace(): 예외발생 당시의 호출스택에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.  대신, 프로그램은 정상적으로 종료한다.
        - 사용법: 참조변수.printStackTrace(); ⇒ console 창에 나오는 메시지를 출력.
    - getMessage(): 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.
    - 멀티 catch 블록: 여러 catch 블록을 '|' 기호를 통해 합칠 수 있다. ex) 예외클래스 | 예외클래스
        - 다만 조상과 자손의 관계가 있다면 컴파일 에러가 발생!
        - 예외가 발생했을 때, 어느 예외클래스에서 발생했는지 모르기에 예외클래스의 공통적인 부분, 즉 조상예외클래스에 선언된 멤버만 사용가능하다! 즉, 특정 예외클래스에 선언된 멤버는 사용 불가능.

## 1.6 예외발생시키기

![https://blog.kakaocdn.net/dn/bJunxo/btrfbQcGOwT/yyJkg5grCKtlMJtnDFS8zk/img.png](https://blog.kakaocdn.net/dn/bJunxo/btrfbQcGOwT/yyJkg5grCKtlMJtnDFS8zk/img.png)

- 예외클래스의 객체의 괄호()는 **`에러 메시지`**!!! **getmessage**로 얻을 수 있다.
- 예외처리 하지않고 던지기만 하는 경우, 컴파일결과
    
    => java: unreported exception java.lang.Exception; must be caught or declared to be thrown
    

- runtime 예외 고의 발생시 예외처리 되지않은 경우
    - 컴파일결과(exception과는 달리 컴파일에러는 없지만 비정상적 종료된다)
        
        // 예외처리하지않을 때를 말하는 거다. 
        
        => 이러한 runtimeException 클래스와 자손들은 프로그래머의 실수에서 발생하는 것들이기 때문에 예외처리를 강제하지않는다. (unchecekd예외라고 부른다)
        
        ```
        Exception in thread "main" java.lang.RuntimeException
        ```
        
    - 비정상적으로 종료되기 때문에 Runtime예외처리를 해야한다면, 참조변수와 배열이 사용되는 모든 곳에 예외처리를 해주어야한다. ArrayIndexountof- - 와 NullPointer - - 처리
    - RuntimeException과 그 자손들은 예외처리를 해주지않아도 된다. 보통 반드시 처리해줘야하는 예외들만!!

## 1.7 메서드에 예외 선언하기

- 해당 메서드에 여러개의 예외 발생: void method() throws Exception1, Exception2,,,,,,{ /// }
    
    => 모든 예외의 조상인 Exception클래스를 메서드에 선언하면, 이 메서드는 모든종류의 예외가 발생할 가능성이 있다는 것이다. (자손타입의 예외까지도 발생할 수 있다는 뜻)
    
    => 이렇게 자바에서는 메서드 작성 시 메서드 내에서 발생할 가능성이 있는 예외를 선언부에 명시하여 **`사용자 쪽에 이에 대한 처리를 하도록 강요`**하기에 견고한 프로그램 코드 작성 가능
    
    <aside>
    💡 중요!!  java api문서에서 특정 메서드를 찾아보면 throw와 적혀있는게 있는데, 이는 해당 에러가 발생할 수 있으니 **호출 시, 처리**해주어야한다는 것이다. 그리고 **throws 설명**에 예외리스트와 언제 발생하는지에 대한 설명이 작성되어있다. (runtime에러라 작성x인 것도 있다)
    
    </aside>
    

- 예외처리: 메서드에 throws가 붙는다는 것은 반드시 여기서 예외처리를 한다는 것이 아니라, 호출한 메서드(자신을 포함)에 **`예외를 전달하여 예외처리를 맡기는 것`**이다.
    - 즉, 자신을 호출한 메서드가 있다면, 해당 메서드에서 **`try-catch문`**으로 예외처리x시, 호출한 메서드에 예외를 맡긴다. 계속 이어져서, 끝인 main 메서드마저 없다면 프로그램 전체가 비정상적 종료. 결국 어느 한 곳에서는 반드시 예외처리 필요.

```java
public class Ex8_13_예외떠넘기기 {
    public static void main(String[] args) {
        method1(); //같은 클래스 내의 static 멤버이므로 객체 생성없이 직접 호출가능
    }
    static void method1(){
        try{
            throw new Exception();
        }
        catch (Exception e){
            System.out.println("에러가 해결되었습니다.");
            e.printStackTrace();
        }
    }
}

// method1의 try-catch문을 main에서도 가능.
// method1에서 예외처리하면 main에서는 예외가 있는지도 모른다.

결과
에러가 해결되었습니다.
java.lang.Exception
	at javaexp.a01_start.A99_class_java.method1(A99_class_java.java:12) //여기서 에러 발생
	at javaexp.a01_start.A99_class_java.main(A99_class_java.java:8)//method1를 호출한 main
```

## 1.8 finally 블록

- 예외의 발생여부와 관계없이 실행되어야하는 코드를 넣는다. (try, catch문에서 공통적으로)
    
    선택적으로 사용가능, try-catch-finally 순서로 구성
    
    예외 발생시, 위 순서. 예외 미발생 시, try-finally 실행
    
- try 또는 catch 블록에서 return 문을 만나도 finally블럭은 수행된다.

```java
import java.io.*;

public class Ex8_15_예외발생메서드직접처리_createFile {
    public static void main(String[] args) {
        //command line에서 입력받은 값을 이름으로 갖는 파일 생성
        File f = createFile(args[0]); //아래 메서드 호출
        System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
    }

    static File createFile(String filename){
        try{
            if(filename ==null || filename.equals(""))
                throw new Exception("파일이름이 유효하지 않습니다.");
        }
        catch(Exception e){
            filename = "제목없음.txt";
            //fileName이 부적절한 경우, 파일 이름이 "제목없음"로 한다.
						// try에서 if문에 해당하는 경우(예외를 발생시켰기에)다. 
        }

        finally {
            File f = new File(filename); //filename인수를 받아서 File 객체 생성
            createNewFile(f); // 생성된 객체를 이용해서 파일 생성
            return f;

        } // finally 블럭에서는 예외의 발생여부에 관계없이 파일을 생성

    }

    static void createNewFile(File f){
        try{
            f.createNewFile(); //파일 생성. 원래 있는 메서드인듯
        }
        catch(Exception e){}
    }
}
```

// 커맨드라인에 매개변수를 주는 방법. run(edit) configuration 에 매개변수 대입

// 커맨드라인에 입력x시, arrayIndexOutOfBoundsException 에러가 발생

### 자동 자원 반환 – try – with – resources 문 (너무 어렵다. 15장에서 필요)

주로 입출력에 사용되는 클래스 중에서 사용한 후에 꼭 닫아줘야하는 것이 있는데, 사용했던 자원(resources)가 반환되기 떄문.

```java
ex)
try{
       FileInputStream fis = new FileInpuitStream(“score.dat”);
       DataInputStream dis = new DataInputStram(fis)
}
catch(){}

finally{ dis.close(); //작업 중에 예외가 발생해도 dis닫히도록
}
```

//but close에서 예외가 발생하는 경우?

```java
ex)
try{
       FileInputStream fis = new FileInpuitStream(“score.dat”);
       DataInputStream dis = new DataInputStram(fis)
}
catch(){}

finally{
		try{
      if(dis! = null)
          dis.close();
      } catch(IOException ie) {
           ie.printStackTrace();
      }
}
```

// 이런 식으로 finally에 close 예외발생 시, finally 블록 안 close 예외를 위해 try-catch문을 작성했는데, 코드가 이쁘지 않다. 그리고 앞선 try블럭과 finally블럭에서 모두 예외 발생 시,try블럭의 예외가 무시되는 문제(**finally 예외만 챙긴다 ㅠㅠ**). => 이를 개선하기 위해 try-with-resources문 추가

```java
ex) try(FileInputStream fis = new FileInpuitStream(“score.dat”);
       DataInputStream dis = new DataInputStram(fis)) {
}

// try() 괄호 안에 두 문장이상 넣을 경우 ;로 구분
```

=> 이처럼 괄호() 안에 객체 생성 문장을 넣으면, 이 객체는 따로 close()를 호출하지 않아도 try블럭을 벗어나는 순간 자동적으로 close() 호출된다. but 클래스가 AutoCloseable 이라는 인터페이스를 구현한 것이어야만 한다.

[https://blog.naver.com/asrs02041?Redirect=Write&categoryNo=19](https://blog.naver.com/asrs02041?Redirect=Write&categoryNo=19) //Ex8_20 참고

- 억제된 예외(나중에 공부하자) // 두 예외가 동시에 발생할 수 없기에 다른 하나의 예외를 억제된 예외로 다루는 것이다. (try-with-resources 를 통해 close()를 자동적으로 호출해준 것이기에)

### 사용자정의 예외 만들기

- Exception을 보통 상속 받나, 요즘에는 runtimeException 상속받는다.
    
    ```
    기존의 예외 클래스는 주로 exception을 상속받아서 checked예외로 작성하는 경우가 많았지만,
    요즘은 예외처리를 선택적으로 할 수 있도록 runtimeException을 상속받아서 작성하는 쪽으로 
    바뀌어가고 있다. checked예외는 반드시 예외처리를 해줘야하기 때문에 예외처리가 
    불필요한 경우데 try-catch문을 넣어서 코드가 복잡! 필요에 따라 예외처리 여부를 
    선택할 수 있는 unchecked예외 가 각광!
    ```
    

ex) 상속받아서 msg 이외에도 다른 매개변수 추가

```java
class MyException extends Exception {
     private final int ERR_CODE; //생성자를 통해 초기화

     MyException(String msg, int errCode) {
          super(msg);
          ERR_CODE = errCode;
     }  // 두 개의 변수를 했을 때 생성자
     MyException(String msg) {
          this(msg, 100);
     }  // 생성자, ERR_CODE를 100(기본값)으로 초기화한다.  => 오버라이딩인가?
     public int getErrCode(){
          return ERR_CODE;
     } //에러코드를 얻을 수 있는 메서드 추가. 이후 getMessage()와 함께 사용
}
```

### 예외 되던지기

- 하나의 예외에 대해서 예외가 발생한 메서드와 이를 호출한 메서드 양쪽 모두에서 처리해줘야할 작업이 있을 때 사용된다.
- 한 메서드에서 발생할 수 있는 예외가 여럿인 경우, 몇 개는 try-catch문을 통해서 메서드 내에서 자체 처리, 나머지는 선언부에 지정하여 호출한 메서드에서 처리
    
    => 양쪽에서 나눠서 처리하도록 할 수 있다. (심지어 하나의 예외에도 불구하고 양쪽 모두에서 처리가능. (예외 처리 후 인위적으로 다시 발생[이를 **`예외 되던지기`**])) 
    
    => thorw문을 통해 예외를 다시 발생시키고 이는 이 메서드를 호출한 메서드에게 전달되어 호출한 메서드의 try-catch문에서 예외 또 처리한다.
    

```java
class Ex8_22예외되던지기 {
    public static void main(String[] args) {
        try{
            method1();
        } catch (Exception e){
            System.out.println("main메서드에서 예외가 처리되었습니다.");
        }

    }

    static void method1() throws Exception{ //예외발생 가능성 있다.
        try{
            throw new Exception();
        } catch (Exception e){
            System.out.println("method1메서드에서 예외가 처리되었습니다.");
            throw e; // 다시 예외를 발생시킨다. //main메서드로 넘어가서 catch문 실행
        }

    }
}

// 양쪽에 모두 try-catch문!
// 메서드에 void가 아니라 반환값이 있는 경우, **catch문에도 return 값**이 있어야한다!! 아니면      예외되던지기로 대체할 수 있다.
```

### 연결된 예외

한 예외가 다른 예외를 발생시킬 수도 있다. A가 B 발생시, A는 B의 원인 예외(cause Exception)이다.

예외 생성(객체 생성) 후, 참조변수.initCause(catch 참조변수) // 원인예외로 지정.

- 사용하는 이유

1. 여러 가지의 예외를 하나의 큰 분류의 예외로 묶어서 다루기위해 

ex) InstallException으로 MemoryException과 SpaceException을 다루기위해(조상-후손 관계x) 

2. checked예외 -> unchecked 예외(예외를 처리할 수 없는 상황에서 억지로 예외처리하지 않아도 된다)

![https://blog.kakaocdn.net/dn/cLAO83/btrfgE97ZGt/wPn4bHPWze0Vf9KzAFLKv1/img.png](https://blog.kakaocdn.net/dn/cLAO83/btrfgE97ZGt/wPn4bHPWze0Vf9KzAFLKv1/img.png)

- 원인 예외
    
    (다형성처럼 다룰 예외 참조변수.initcause(원인 예외) 이것을 통해 에러 메시지에서 caused by가 나온다! 두 예외가 상속관계 아니더라도 원인 예외를 다형성처럼 다루는 것! 
    
    예외 발생→ 앞 참조변수 예외 중 어떤 원인 예외에 해당하는가? 
    

[https://blog.naver.com/asrs02041?Redirect=Update&logNo=222501479003](https://blog.naver.com/asrs02041?Redirect=Update&logNo=222501479003)

// EX8_23 예제로 복습할 것!!
