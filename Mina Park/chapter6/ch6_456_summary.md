# CHAPTER 6. 객체지향 프로그래밍 1

## 4. 오버로딩(Overlaoding)   
<br>     

### 4.1 기본개념

1. 용어: 메서드 오버로딩 or 오버로딩
2. 의미: 한 클래스 내에 같은 이름의 메서드를 여러개 정의하는것
<br><br>
### 4.2 성립조건

```
1. 메서드 이름이 같아야 한다
2. 매개변수의 개수 or 타입이 달라야 한다
3. 반환타입은 아무런 영향을 주지 못한다
```

### 4.3 사용예시
- 보기1 != 오버로딩 ☞ 성립조건2 준수 X
```
int add(int a, int b) {return a+b;}
int add(int x, int y) {return x+y;}
```
- 보기2 != 오버로딩 ☞ 성립조건3 

```
int add(int a, int b) {return a+b;}
long add(int x, int y) {return (long)(x+y);}
```
- 보기3 == 오버로딩  

```
long add(int a, long b) {return a+b;}
long add(long a, int b) {return a+b;}
```
> 매개변수의 순서가 다르므로 오버로딩으로 간주되지만, 단점도 존재
>> 만약  add(3,3)을 호출한다면?
>>> 컴파일 에러 발생 (ambiguous) : 어느 메서드가 호출되었는지가 모호하므로 
