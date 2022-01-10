package Ch11.doyul.Example;


import java.util.*;

class ArrayListEx1 {
    public static void main(String[] args) {
        // 기본 길이(용량, capacity)가 10인 ArrayList를 생성
        ArrayList list1 = new ArrayList(10);
        // ArrayList에는 객체만 저장가능
        // autoboxing에 의해 기본형이 참조형으로 자동변환(9장)
        list1.add(5);
        // list1.add(5); 라 적어도 됨
        // 인텔리제이에서는 boxing을 없애라고 추천해줌
        list1.add(4);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(3);
//        ArrayList(Collection c)
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
//      풀어쓰면 아래의 두줄과 같이 표현가능
//      List sub = list1.subList(1,4);  //sub는 읽기만 가능 [4, 2, 0]
//      ArrayList list2 = new ArrayList(sub); //sub와 같은 내용의 ArrayList생성
        /*  subList의 definition
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, size);
            return new SubList<>(this, fromIndex, toIndex);
        }
        */
        print(list1, list2);
        // 오름차순 정렬
        //Collection은 인터페이스, Collections는 유틸클래스
        Collections.sort(list1);    // list1과 list2를 정렬한다.
        Collections.sort(list2);    // Collections.sort(List l)
        print(list1, list2);

        //list1이 list2의 모든 요소를 담고 있는지 여부 (참이면 true 반환)
        System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));
        /* containsAll의 definition
        public boolean containsAll(Collection<?> c) {
            for (Object e : c)
                if (!contains(e))
                    return false;
            return true;
        }*/

        list2.add("B");
        list2.add("C"); // modcount++가 뭐지?
        /* add 의
        public boolean add(E e) {
            modCount++;
            add(e, elementData, size);
            return true;
        }
        */
        list2.add(3, "A"); // add(int index, E element)
        print(list1, list2);

        list2.set(3, "AA"); // set(int index, E element)
        print(list1, list2);


        list1.add(0, "1");
        // indexOf() 는 지정된 객체의 위치(index)를 알려준다.
        System.out.println("index=" + list1.indexOf("1")); //리스트의 String 1과 integer 1이 다름
        print(list1, list2);

//        list1.remove(1);
//        list1.remove("1");
/*
        Object remove(int index)와 boolean remove(object o) 가 있다 >> 서로 다름 주의!
*/

        // list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
        System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
        print(list1, list2);

        //  list2에서 list1에 포함된 객체들을 삭제한다.
        /*
        1. get(i)으로 list2에서 하나씩 꺼낸다
        2. contains()로 꺼낸 객체가 list1에 있는지 확인
        3. remove(i)로 해당 객체를 list2에서 삭제
        */
        for (int i = list2.size() - 1; i >= 0; i--) {
//      평소의 for문과 다르게 list.size()-1 부터 감소 시키면서 반복
//      변수 i를 증가시켜가면서 삭제하면 나머지 요소들이 자리이동을 하기 때문에 한 것
            if (list1.contains(list2.get(i)))
                list2.remove(i);
        }
        print(list1, list2);
    } // main의 끝

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        System.out.println();
    }
} // class
