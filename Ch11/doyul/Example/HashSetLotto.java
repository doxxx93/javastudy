package Ch11.doyul.Example;

import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set set = new HashSet();
        // set크기가 6보다 작은 1~45사이의 난수를 저장
        for (int i = 0; set.size()<6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);
        }
        List list = new LinkedList(set);    // LinkedList(Collecion c)          // 1. set의 요소를 List에 저장
        Collections.sort(list);             // Collections.sort(List list)      // 2. list를 정렬
        System.out.println(list);                                               // 3. list를 출력
    }
}
