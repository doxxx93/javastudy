package Ch11.doyul.Example;

import java.util.*;
public class HashSetEx5 {
    public static void main(String[] args) {
        HashSet setA = new HashSet();
        HashSet setB = new HashSet();
        HashSet setHab = new HashSet();
        HashSet setKyo = new HashSet();
        HashSet setCha = new HashSet();

        setA.add("1");
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");

        System.out.println("A = " + setA);

        setB.add("4");
        setB.add("5");
        setB.add("6");
        setB.add("7");
        setB.add("8");
        //교집합은 SetA.retainAll(setB)
        System.out.println("B = " + setB);
        Iterator it = setB.iterator();
        while (it.hasNext()) {      //4, 5, 6, 7, 8 순서로 true ,ture, false, false, false 
            Object tmp = it.next();
            if(setA.contains(tmp))
                setKyo.add(tmp);
        }
        // setA.removeAll(setB) setB와 공통요소를 제거
        it = setA.iterator();
        while (it.hasNext()) {
            Object tmp = it.next();
            if(!setB.contains(tmp)) //B에 없는 것만 차집합에 저장 A - B 1, 2, 3 이 저장됨
                setCha.add(tmp);
        }
        // setA.addAll(setB) 합집합
        // 합집합은 set이 중복이 없으므로 setHab 에 A,B를 넣음
        it = setA.iterator();
        while (it.hasNext()) {  
            setHab.add(it.next());
        }
        it = setB.iterator();
        while (it.hasNext()) {
            setHab.add(it.next());
        }

        System.out.println("A ∩ B = " + setKyo);
        System.out.println("A ∪ B = " + setHab);
        System.out.println("A - B = " + setCha);
    }

}
