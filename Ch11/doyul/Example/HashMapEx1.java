package Ch11.doyul.Example;

import java.util.*;
public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("enter id and pw");
            System.out.println("id:");
            String id = s.nextLine().trim();

            System.out.println("pw:");
            String pw = s.nextLine().trim();

            System.out.println();

            if (!map.containsKey(id)) {

                System.out.println("no id");
                continue;

            }
            if (!(map.get(id).equals(pw))) {
                System.out.println("wrong pw");

            } else {
                System.out.println("correct pw");
                break;
            }
        }

    }

}
