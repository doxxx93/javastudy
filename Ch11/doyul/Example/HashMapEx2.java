package Ch11.doyul.Example;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("kim", 100);
        map.put("lee", 100);
        map.put("kang", 80);
        map.put("ahn", 90);

        Set set = map.entrySet();   // Map Interface
        Iterator it = set.iterator();   // Map의 내부 인터페이스

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("name" + e.getKey() + ",score" + e.getValue());

        }

        set = map.keySet();
        System.out.println("names" + set);
        Collection values = map.values();
        it = values.iterator();

        int total = 0;

        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            total += i.intValue();
        }
        System.out.println("total score" + total);
        System.out.println("avg" + (float) total / set.size());
        System.out.println("Max" + Collections.max(values));
        System.out.println("Min" + Collections.min(values));

    }
}
