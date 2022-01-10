### Collection 프레임워크

- 이 프레임워크는 공통 클래스를 제공하여 편리한 기능
- 공통 collection 조상을 가진 List(순서)와 Set(집합)
- Map은 key와 value
- 중복은 구별가능한가?의 여부

### Collection 메서드

- 추가, 삭제, 포함?, 비교, hashcode, 비어있나?, size, 배열반환, iterator 얻기 등

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
