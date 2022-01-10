# CHAPTER 11. 컬렉션 프레임워크

## 1. 컬렉션 프레임워크(collections framework)    
```
ㅇ 컬렉션: 여러 객체를 모아놓은 것
ㅇ 프레임워크: 표준화, 정형화된 체계적인 프로그래밍 방식
ㅇ 컬렉션 프레임워크
  - 컬렉션(다수의 객체)을 다루기 위한 표준화된 프로그래밍 방식
  - 컬렉션을 쉽고 편리하게 다룰 수 있는 다양한 클래스를 제공
  - java.util 패키지에 포함
ㅇ 컬렉션 클래스: 다수의 데이터를 저장할 수 있는 클래스(ex. Vector, ArrayList, HashSEt)
```

### 1.1 컬렉션 프레임워크의 핵심 인터페이스

`★KEY POINT`
- 3개의 인터페이스별 특징 구분
  
| 인터페이스 | 순서 | 중복 |
|:---:|:---:|:---:|
| List | O | O |
| Set | X | X |
| Map | X | key X, value O |

![핵심인터페이스와 특징](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.1_%ED%95%B5%EC%8B%AC%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4%ED%8A%B9%EC%A7%95.JPG)

#### 1.1.1 Collection 인터페이스
* 의미: List와 Set의 조상

![Collection 인터페이스 메서드](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.1.1_Collection%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

#### 1.1.2 List 인터페이스
* 의미: 중복 허용, 저장순서가 유지되는 컬렉션 구현에 사용

![List 인터페이스 메서드](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.1.2_List%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

#### 1.1.3 Set 인터페이스
* 의미: 중복 허용 X, 저장순서가 유지 X 컬렉션 구현에 사용

![Set 인터페이스 메서드](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.1.3_Set%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

#### 1.1.4 Map 인터페이스
* 의미: 키와 값을 쌍으로 묶어서 저장하는 컬렉션 클래스 구현에 사용

![Map 인터페이스 메서드](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.1.4_Map%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

### 1.2 ArrayList
* 특징
  - 컬렉션 프레임워크에서 가장 많이 사용되는 컬렉션 클래스
  - 배열을 이용해서 데이터를 순차적을 저장 

* ArrayList 생성자 및 메서드 

![메서드](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.2_ArrayList%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

* 유의사항
  - 데이터 삭제 시 저장된 마지막 객체부터 삭제해야 속도도 빠르고 데이터값이 다 지워짐

![삭제1](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.2_ArrayList%EC%82%AD%EC%A0%9C.JPG)

![삭제2](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.2_ArrayList%EC%82%AD%EC%A0%9C2.JPG)

### 1.3 LinkedList
* 배열의 장단점
```
ㅇ 장점 : 구조가 간단하고 데이터 읽는 시간(접근시간)이 짧다
ㅇ 단점
  1. 실행 중 크기 변경 불가
    - 새로운 배열을 생성 -> 데이터 복사 -> 참조 변경
    - 크기 변경 피하려고 충분히 큰 배열 생성할 경우 메모리 낭비의 문제
  2. 비순차적인 데이터의 추가/삭제에 많은 시간 소요
    - 추가/삭제를 위해서는 다른 데이터를 옮겨야 함
    - 순차적인 데이터 추가/삭제(맨 끝에 추가/삭제)의 경우는 빠름
```

* 의미: 배열과 달리 불연속적으로 존재하는 데이터를 연결
  - 기존 ArrayList의 단점을 보완하기 위해 고안된 자료구조 
* 장점: 데이터의 추가/삭제 용이
  - 삭제: 단 한 번의 참조변경만으로 가능
  - 추가: 한 번의 Node 객체생성 & 두 번의 참조변경만으로 가능
* 단점: 불연속적이라는 점에서 데이터 접근성이 나쁨
  - 배열처럼 한 번에 이동할 수 없음(이동방향이 단방향이므로 다음 요소에 대한 접근은 쉽지만 이전요소에 대한 접근은 어려움)
* 종류
```
1. 더블리 링크드 리스트(Doubly Linked List): 이중 연결리스트
   - 상기 단점을 보완하고자 참조변수를 하나 추가하여 이전요소/다음요소에 대한 접근이 가능
2. 더블 써큘러 링크드 리스트(Double Circular Linked List): 이중 원형 연결리스트
  - 더블 링크르 리스트의 첫번째&마지막 요소를 연결하여 접근성을 더욱 향상   
```
![종류](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.3_LinkedList%EC%A2%85%EB%A5%98.JPG)

`★KEY POINT`
* ArrayList(배열기반/연속적) vs LinkedList(연결기반/불연속) 성능비교

![성능비교](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.3_%EC%84%B1%EB%8A%A5%EB%B9%84%EA%B5%90.JPG)

### 1.4 Stack과 Queue
#### 1.4.1 기본개념
1) Stack
   * 의미: LIFO(Last In First Out)구조 
   * 특징: 제일 마지막에 저장(push)된 것을 제일 먼저 꺼내게 됨(pop)
   * 구현에 적합한 클래스: 배열
2) Queue
   * 의미: FIFO(First In First Out)구조
   * 특징: 제일 먼저 저장(offer)한 것을 제일 먼저 꺼내게 됨(poll) 
   * 구현에 적합한 클래스: 링크드 리스트
  
  * 스택과 큐의 메서드 

![메서드](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.4_%EC%8A%A4%ED%83%9D%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

![메서드2](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.4_%ED%81%90%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

* 유의사항: 큐는 인터페이스이므로 객체생성 X 
> Q. 큐의 기능을 가진 객체를 만들고 싶을 때 방법은?
> > A. (1) 큐를 직접 구현   (2) 큐를 구현한 클래스를 사용
>>> (2)번의 경우, Java API에서 interface Queue 서칭 =? All Known Implementing Classes 중 선택 사용 가능(Ex. LinkedList)
>>>> Queue q = new LinkedList(); 


![인터페이스구현한클래스찾기](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.4_%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4%EA%B5%AC%ED%98%84%ED%95%9C%ED%81%B4%EB%9E%98%EC%8A%A4%EC%B0%BE%EA%B8%B0.JPG)

``` java
class Test {
  public static void main(String[] args) {
    Stack st = new Stack();
    Queue q = new ArrayList(); //queue 인터페이스를 구현한 클래스

    st.push("0");
    st.push("1");

    q.push("0");
    q.push("1");

    while (!st.empty()) {
      System.out.println(st.pop()); //1,0순으로 출력
    }

    while (!q.empty()) {
      System.out.println(q.pop()); //0,1순으로 출력
    }
  }
}   
```
#### 1.4.2 스택과 큐의 활용
* 활용 
```
1. 스택의 활용 예시: 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 앞/뒤로
2. 큐의 활용 예시: 최근사용문서, 인쇄작업 대기목록, 버퍼 
``` 

``` java
class Ex11_4 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;	// Queue에 최대 5개까지만 저장되도록 한다.

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

		while(true) {
			System.out.print(">>");
			try {
				// 화면으로부터 라인단위로 입력받는다.
				Scanner s = new Scanner(System.in);  
				String input = s.nextLine().trim();

				if("".equals(input)) continue;

				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를 "
                                                  + MAX_SIZE +"개 보여줍니다.");
				} else if(input.equalsIgnoreCase("history")) {
					int i=0;
					// 입력받은 명령어를 저장하고,
					save(input);    

					// LinkedList의 내용을 보여준다.
					LinkedList tmp = (LinkedList)q;
					ListIterator it = tmp.listIterator();

					while(it.hasNext())
						System.out.println(++i+"."+it.next());
				} else {
					save(input);    
					System.out.println(input);
				} // if(input.equalsIgnoreCase("q")) {
			} catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		} // while(true)
	} //  main()
	public static void save(String input) {
		// queue에 저장한다.
		if(!"".equals(input))
          q.offer(input);

		// queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
		if(q.size() > MAX_SIZE)  // size()는 Collection인터페이스에 정의
			q.remove();
	}
} // end of class
```
### 1.5 Enumeration - Iterator - Listlterator

* 의미: 컬렉션에 저장된 데이터를 접근(읽어오기)하는 데 사용되는 인터페이스
* 종류
  - Enumeration: Iterator의 구버전
  - Listlterator: Iterator의 기능 향상 버전(단방향 => 양방향)

![메서드](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.5_%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

> Q. Iterator가 필요한 이유는?
> > A. 컬렉션들마다 구조가 달라서 저장요소를 읽어오는 방법이 다른데, 그것을 "표준화"한 것(Iterator를 사용하면 hasNext, next만으로 요소를 읽어올 수 있음)

* 사용방법
  - 컬렉션에 iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용

![iterator](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.5_iterator.JPG)

``` java 
class Ex11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}

		// iterator는 1회용이므로 사용 후 다시 얻어와야 함
		it = list.iterator(); // 새로운 iterator 객체를 얻음

		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}

    //만약 위에서 HashSet list = new HashSet(); 처럼 컬렉션 클래스가 변경되면, HashSet에는 get이라는 메서드가 없기 때문에 에러 발생
    //하지만 위와 같이 표준화된 iterator를 사용하면 코드 수정 없이 계속 사용 가능!
    for (int i=0; i<list.size(); i++) {
      Object obj = list.get(i);
      System.out.println(obj);
    }

	} // main
}
```

* 유의사항
> Q. Map에는 Iterator()가 없다?
 >> A. Collection 인터페이스는 List,Set의 공통점을 뽑아서 만든 것이므로
 >>> Q. 그럼 Map의 값을 가져오려면 어떻게 해야할까?
 >>>> A. iterator()를 갖고 있는 keySet(), entrySet(), values()를 호출해야 함

``` java
Map map = new HashMap();
  ...
Iterator it = map.entrySet().iterator(); //iterator 객체 생성
```

### 1.6 Arrays
* 개념: 배열을 다루기 편리한 메서드(static) 제공
* 종류
  
 ![종류](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.6_%EC%A2%85%EB%A5%98.JPG)

 ![종류2](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.6_%EC%A2%85%EB%A5%982.JPG)

 ![종류3](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.6_%EC%A2%85%EB%A5%983.JPG)

 ### 1.7 Comparator와 Comparable
 * 개념: 객체 정렬에 필요한 메서드(정렬기준 제공)를 정의한 인터페이스
 * 종류
  
 ![종류](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.7_%EC%A2%85%EB%A5%98.JPG)


``` java
 class Ex11_7 {
	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};

		Arrays.sort(strArr); // String의 Comparable구현에 의한 정렬(기본정렬)
		System.out.println("strArr=" + Arrays.toString(strArr));

		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분안함
		System.out.println("strArr=" + Arrays.toString(strArr));

		Arrays.sort(strArr, new Descending()); // 역순 정렬
		System.out.println("strArr=" + Arrays.toString(strArr));
	}
}

class Descending implements Comparator { 
	public int compare(Object o1, Object o2){
		if( o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1 ; // -1을 곱해서 기본 정렬방식의 역으로 변경한다.
						                // 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
		}
		return -1;
	} 
}
```    

### 1.8 HashSet
* 개념: Set 인터페이스를 구현한 대표적 컬렉션(순서X, 중복X)
  - 순서 유지 필요 시, LinkedHashSet 클래스 사용

```
[비교] TreeSet
- 범위 검색과 정렬에 유리한 컬렉션 클래스
- HashSet보다 데이터 추가/삭제에 시간 소요
```

![메서드](https://github.com/doxxx93/javastudy/blob/main/Ch11/Mina%20Park/summary/capture/ch11_1.8_%EB%A9%94%EC%84%9C%EB%93%9C.JPG)

``` java
class Ex11_9 {
	public static void main(String[] args) {
		Object[] objArr = { "1", new Integer(1), "2", "2", "3", "3", "4", "4", "4" };
		Set set = new HashSet(); // 순서유지하지 않고 중복요소도 허용 X

		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]); // HashSet에 ObjArr의 요소를 저장
		}

		System.out.println(set);

		// HashSet에 저장된 요소 출력(Iterator 이용)
		Iterator it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
```
* 유의사항: 객체 저장 전 "기존에 같은 객체가 있는지 확인" 필요
  - 같은 객체가 없을 경우에만 저장
  - boolean add(Object o): 저장할 객체의 equals() 와 hasCode()를 호출
    - 최고조상인 object 클래스를 상속하는 메서드
  - 저장하려면 equals()와 hasCode()가 오버라이딩 되어 있어야 함


``` java
class Ex11_11 {
	public static void main(String[] args) {
		HashSet set = new HashSet();

		set.add("abc");
		set.add("abc"); // 중복요소이므로 저장 X
		set.add(new Person("David", 10));
		set.add(new Person("David", 10)); //

		System.out.println(set);
	}
}

//equals()와 hashCode()를 오버라이딩해야 HashSet()이 정상 동작
//상단 Source -> Generate hashCode() and equals() 클릭하여 자동 생성
class Person {

	String name;
	int age;

	@Override
	public int hashCode() {
		return Objects.hash(name, age); // iv값 세팅
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}

    // 형변환(object 객체에는 name,age가 없으므로)
		Person p = (Person) obj;

		// 나 자신의 이름과 나이를 p와 비교
		return this.name.equals(p.name) && this.age == p.age;
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + ":" + age;
```


