package Ch11.doyul.Example;

import java.util.TreeSet;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i = 0; i < score.length; i++) {
            set.add(new Integer(score[i]));
        }
        System.out.println("less 50 " + set.headSet(50));
        System.out.println("over 50"+ set.tailSet(50));
        System.out.println("between 40 and 50" + set.subSet(40, 80));
    }
}
