package Ch11.doyul.Example;

import java.util.*;

class IteratorEx1 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
//        Collection c = new HashSet(); 바껴도 상관 없음
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");

        Iterator it = c.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
        //  iterator는 1회용이라 다쓰고나면 다시 얻어와야 한다.
//        it = list.iterator();
//
//        만약 컬렉션을 바꾸게 되면 아래 for문은 사용할 수 없음
//        for (int i = 0; i < c.size(); i++) {
//            Object obj = c.get(i);
//            System.out.println(obj);
//        }
    } // main
}
