### Collection 프레임워크

- 이 프레임워크는 공통 클래스를 제공하여 편리한 기능
- 공통 collection 조상을 가진 List(순서)와 Set(집합)
- Map은 key와 value
- 중복은 구별가능한가?의 여부

### Collection 메서드

- 추가, 삭제, 포함?, 비교, hashcode, 비어있나?, size, 배열반환, iterator 얻기 등
- **범위를 매개변수로 활용할 때 끝부분은 포함하지않는다**!!!

### List 메서드

- **`index 활용`** + 정렬(by 정렬기준(Comparator) + listiterator(list 객체 접근)

### Map 메서드

- Key 활용 → key-value 쌍
- May.entry 인터페이스
    - key-value쌍을 다루기위해 필요한 내부 interface

### ArrayList

- 가장 많이 사용된다. 기본값은 Object
- 메서드: index 활용, 기본크기 10, 크기 조절 등
- Collections.sort(정렬할 객체)
- 새로 포함된 거 삭제 혹은 남기기 ex) 예제 11-1
- **`추가, 삭제 시 index 주의`**
    - 빈 공간을 채우기 위해 다른 요소들이 자리 이동(속도 느려짐)
        - for문 사용 시 뒤에서부터 하는게 오히려 좋다.
        - 요소 추가 시, 미리 공간을 여유롭게 하는 것이 좋다.

- 예제 11-2 : 원하는 크기만큼 자르기 → substring 매개변수의 개수에 따라
- 예제 11-3 : **`배열, size, capacitry 관련 중요!!`**
    - 배열의 capacity 변경 시 새로운 주소의 인스턴스 생성
    - size(null값이라도 필요) vs capacity(여유공간. 부족 시 기존 x2 해서 새 인스턴스 생성)

<aside>
💡 ArrayList와 Vector는 검색과 추가에 장점 but 변경, 삭제 시 불리함, 크기 변경x(새 인스턴스), 비순차적 요소 추가, 삭제 시 시간 소요 많이 된다.

</aside>

- 예제 11-4 는 이렇게 Api에 구현되어 있다는 것 ⇒ 내가 직접 구현해서 연습해야한다.

### system.arraycopy()?

- 매개변수: (기존 배열 참조변수, 어디서부터, 새 배열 참조변수, 어디서부터, 얼만큼)
    - 참조변수가 같다면 덮어쓰는 것이다.
    - p.594 그림 참고!!!

---

<aside>
💡 작업시간이 길어지는 이유가 중간에 if문을 거쳤다가 처리되기에 혹시나 모르니 예외 대처하기위해 마련을 했으나 그런일이 발생하지 않도록 노력해야 속도 증진에 도움이 된다.

</aside>

- Java Api: 595 p

### LinkedList

ex) 기차 연결, 퍼즐 연결   

- 데이터와 명찰만 있다고 생각하면 된다. 삭제, 추가 시 명찰(다음 혹은 이전 요소의 위치)만 바꿔주면 된다.
- 발전: LinkedList → double LinkedList → double circular LinkedList
- 메서드의 매개변수로는 collection 객체, index(첫번째, 마지막도 포함)
- 접근하는 시간이 느리다. 차례대로 따라가야하는 ....

### 배열 vs LinkedList

- 배열: 기본적인 자료구조. Stack 사용
- LinkedList: 변경이 자주 발생한다면 사용하자. Queue 사용
- 11-5 예제

### 참고

- 시간 측정: system.currentTimeMillis();
- Queue 인터페이스의 기능을 사용하고자할 때 Java Api 문서를 보면 All known implementing Classes를 통해 인터페이스를 구현한 클래스들을 볼 수 있다.
    
    ⇒ 사용법: Queue q = new LinkedList();
    
- Java api → 예외 발생가능한 녀석을 예외 처리

### Stack vs Queue

- stack: Vector를 상속받아 구현한 것이며, LIFO
- Queue: FIFO
- 예제: 11-9 에서 forward.push(back.pop)은 back의 마지막 것을 빼서 forward에 넣어주는 것
- 예제 11-11 천천히 정리

- 11-10 예제는 뭔지........

- PriorityQueue → 우선순위
- Deque → 양쪽 끝에 추가/삭제 가능 ⇒ stack+queue 와도 같다.

### Iterator(신), ListIterator(개선), Enumeration(구)

- 컬렉션에 저장된 요소 접근하는 인터페이스이다.
- iterator() 메서드는 iterator를 반환한다.
- iterator 인터페이스 메서드 - hasnext() 확인, next() 다음으로 넘어가기, remove() 읽은 거 삭제
- **`Iterator it = list.iterator`**를 하는 이유
    - Collection의 자손인 List들에 접근하기 위해 Iterator 객체 생성으로 메서드를 활용하여 요소 접근 ⇒ 컬렉션 요소 읽는 방법을 표준화한 것이다.
- Map 인터페이스를 구현한 컬랙션 클래스는 다른 방법을 사용해야한다.
    - Iterator it = map.entryset().iterator();
- 예제 11-13 연습
- Listiterator → iterator에서 이전 방향 접근까지를 추가한 것이다.
- next와 remove → 연습 11-15 예제
- 11-16~17 중요

### Arrays 클래스의 메서드들(모두 static이다)

- 배열의 복사: copyOf(), copyOfRange()
    - 길이보다 더 크게 복사해오면 0이나 null으로 채운다.
- 배열 채우기: fill(배열, 매개변수), setAll(배열, 함수형인터페이스 or 람다식)
- 배열의 정렬과 검색: sort(), binarySearch() 이진검색(정렬상태에서만)
- 문자열의 비교와 출력: equals(), **`toString()`** // 1차원 배열, deepTo String() // 다차원 배열
    - 다차원 배열은 배열의 배열의 형태이기에 toString()으로 비교하면 주소 비교
- 배열을 LIst로 변환: asList(Object... a) // 매개변수 타입이 가변인수
    - 다만 크기(추가, 삭제) 불가. 내용만 변경 가능
- 스트림 관련 메서드: parallelXXX(), spliterator(), stream()

### Comparator와 Comparable [https://st-lab.tistory.com/243](https://st-lab.tistory.com/243)

- Comparable: 기본 정렬기준을 구현하는데 사용(sort 기본값), Comparator: 기본 정렬 이외 다른 기준으로 정렬하고자 할 떄 사용
    
    ⇒ sort(정렬할 배열, (정렬기준)) // 정렬기준이 없으면 객체 배열에 저장된 객체가 구현한 comparable 
    
    ex) **`문자열은 사전 순이다. 공백, 숫자, 대문자, 소문자 순.`**
    
- 두 객체를 비교: Comparator는 compare()가 있고, Comparable는 compareTo()가 있다. ⇒ 모두 같으면 0, 비교하는 값보다 크면 양수.
- **`compare()과 compareTo()`** ??? EX 11-19
    
    ```java
    if(o1 instanceof Comparable && o2 instanceof Comparable)
    // Comparable을 구현하고 있는 클래스들은 같은 타입의 인스턴스끼리 서로 비교가능
    // (숫자는 기본값으로 작은->큰 값으로 정렬. 문자는 사전순으로(유니코드값))
    // 1과 2를, "a"와 "b"를 비교할 수 있는 것도, Comparable을 구현하고 있는 녀석들이기에
    // 어차피 모든 것들은 다 이진수가 될 것이지만 컴퓨터의 입장에서는 그래서 뭘하라고?...
    // comparable 로 형변환해서 비교하는 메서드를 자동으로 사용하게끔.
    // 위에 있는 if문에 해당하지않는다는 뜻은 서로 비교할 수 없는 경우라는 뜻이다.
    
    Comparable c1 = (Comparable) o1; 
    // 이라는 것은 o1을 비교가능한 메서드를 사용할 수 있는
    // Comparable 클래스로 형변환한다는 뜻이다.
    
    compare()이나 compareTo() 라는 녀석은 배열의 인덱스 0과 1, 1과 2,... 이렇게 차례대로
    적용해나가며 return 0이나 1(비교하려는 값이 더 큰 경우)이면 그대로. -1이면 역순으로.
    ```
    
- **`차이점`**
    - 쉽게 말하자면, Comparable은 자기 자신과 파라미터로 들어오는 객체를 비교하는 것이고, Comparator는 자기 자신의 상태가 어떻던 상관없이 파라미터로 들어오는 두 객체를 비교하는 것이다. 즉, **본질적으로 비교한다는 것 자체는 같지만, 비교 대상이 다르다는 것**이다.
    - 또 다른 차이점이라면 Comparable은 lang패키지에 있기 때문에 import 를 해줄 필요가 없지만, Comparator는 util패키지에 있다.
    - Comparable은 기본 정렬. Comparator는 다른 정렬 기준

### HashSet

- Set 인터페이스를 구현한 가장 대표적인 컬렉션
- add나 addAll 로 새로운 요소를 추가하는데, 중복값이 있으면 false 반환(추가 실패)
    - but “1”인 String 인스턴스와 1인 Integer 인스턴스는 서로 다른 객체로 본다.
- 정렬되어있지 않다. 필요하면 collections 클래스를 활용 ⇒ 매개변수로 List 필요

```java
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class tests {

	public static void main(String[] args) {
		Set set= new HashSet();
		
		for(int i=0; set.size()<6 ; i++) {
			int num = (int)(Math.random()*45)+1;
			boolean a  = set.add(num); 
			// set.add(num)은 작동하면서, 그 결과값은 a에 넣어준다.
			// for문 안에서 false가 발생하면 다시 실행하는듯???														
			System.out.println(a);
		}
		List list = new LinkedList(set);
		Collections.sort(list);
		System.out.println(list);
	}

}
```

![20220113_085303.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a9dfe04e-336c-4ffd-bb26-ee68f7cab7f1/20220113_085303.png)

- ex 11-22 next()는 다음 차례 그대로
    - 같은 숫자가 비슷한 위치에 나온다(HashSet은 저장된 순서를 보장하지않고 자체적인 저장방식에 따라 순서가 결정되기에 LinkedHashSet이 더 나은 방식)

- ex 11-24
    - HashSet의 add메서드는 새로운 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별하기위해 추가하려는 요소의 **`equals()와 hashCode()`**를 호출 ⇒ 오버라이딩 필요
    
    ```java
    public boolean equals(Object obj) {
        return (this == obj) // 객체 비교 시 주소값 비교가 되버린다.
    } 를
    
    public boolean equals(Object obj){
    	if(obj instanceof Person2){
    		Person2 tmp = (Person2) obj;
    		return name.equals(tmp.name) && age == tmp.age;
    }
    	return false;
    } 로 오버라이딩
    
    // hashcode는 일반적으로 객체의 주소값을 반환
    // 두 객체라면 당연히 다를 수밖에 없다.
    
    publiuc int hashCode(){
    		return (name+age).hashCode(); 
    	// name+age를 더 한 것의 hashcode라면
    	// 다른 두 객체여도 name과 age가 같으면 같은 hashcode값이 나온다.			
    }
    
    --- 1.8부터는
    
    publiuc int hashCode(){
    		return Objects.hash(name,age,,,,); 
    }
    ```
    
- ex 11-25 교, 차, 합집합 예제

### Treeset ex) 사전 찾기

- 이진 검색트리라는 자료구조의 형태로 데이터 저장
- 특징: 정렬, 검색, 범위검색 유리, 중복 x, 저장순서 x, 추가 삭제 시간 소요
    
    ```html
    class TreeNode{
    		TreeNode left;
    		Object element;
    		TreeNode right;
    }
    ```
    
    - 첫번쨰로 저장되는 값이 root가 되고, 두번쨰 값부터 그 루트부터 시작해서 왼쪽/오른쪽
    - 컴퓨터는 알아서 값을 비교하지못하기에 Comparable을 구현한 객체가 들어가거나 Comparator를 제공해서 두 객체를 비교할 방법을 제공해야한다.
    - 관련 메서드도 자기보다 큰, 작은 녀석들 갖고 활용
    - **`Treeset은 저장할 때 이미 정렬해놓는다.`**

### HashMap(신버전)과 Hashtable

- key와 value 한 쌍의 entry
- hashing을 사용하기에 많은 양의 데이터를 검색하는데 용이
    - Hashing이란?
        - 선형 탐색이나 이진 탐색은 모두 키를 저장된 키 값과 반복적으로 비교함으로써 탐색하고자 하는 항목에 접근한다.  더 빠른 탐색 알고리즘을 요구될때, 해싱은 키에 산술적인 연산을 적용하여 항목이 저장되어 있는 테이블의 주소를 계산하여 항목에 접근한다.
            
            ![다운로드.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/217e348b-97d1-4a41-8b83-38fd011b1d08/다운로드.png)
            
            - 키값 k를 입력받아 해시 함수 h(k)로 연산한 결과인 해시 주소 h(k)를 인덱스로 사용하여 해시 테이블에 있는 항목에 접근
        
- entry는 키와 값을 갖고있는 하나의 클래스. key는 unique여야한다.
- 메서드: key를 활용하는 게 많다

- EX 11-30 로그인 제대로 할 때까지 탈출x
    - key로 비밀번호 값을 가져와서 비교
- EX 11-31 HashMap의 **`entryset을 Set 클래스로 형변환`**하고 iterator를 사용하여 읽어나간다.
    - Collection과 이를 구현한 List와 Set만 사용가능하기 떄문에
    - keyset(), values() 처럼 key 값들만 모아놓거나 값들만 모아놓을 수도 있다.

- Ex **`11-32`**  연락처 등록 ⇒ 꼭 직접 해볼 것
    - key값이 없을 때 등록하게끔하는 메서드
