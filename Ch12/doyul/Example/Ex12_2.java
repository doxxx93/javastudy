package Ch12.doyul.Example;


import java.util.*;

public class Ex12_2 {

    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<>(); // JDK 생성자에 타입지정 생략 가능
        map.put("자바왕", new Student("자바왕", 1, 1, 100, 100, 100));

        Student s = map.get("자바왕");
        System.out.println(s.name);
        System.out.println(map);

    }
}

class Student {

    String name = "";   // 이름
    int ban;            // 반
    int no;             // 번호
    int kor;    // 국어
    int eng;    // 영어
    int math;   // 수학


    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
