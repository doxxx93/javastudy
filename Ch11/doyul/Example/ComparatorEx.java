package Ch11.doyul.Example;

import java.util.*;

public class ComparatorEx {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};      // String 클래스가 implements Comparable<String>, Constable

        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println(Arrays.toString(strArr));

    }
}

class Descending implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;
        }
        return -1;
    }
    /*
    public int compareTo(String anotherString) {
        byte v1[] = value;
        byte v2[] = anotherString.value;
        byte coder = coder();
        if (coder == anotherString.coder()) {
            return coder == LATIN1 ? StringLatin1.compareTo(v1, v2)
                                   : StringUTF16.compareTo(v1, v2);
        }
        return coder == LATIN1 ? StringLatin1.compareToUTF16(v1, v2)
                               : StringUTF16.compareToLatin1(v1, v2);
     }
     */
}
