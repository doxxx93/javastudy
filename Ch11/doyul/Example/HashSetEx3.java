package Ch11.doyul.Example;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx3 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc"); //중복이라 저장안됨
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));
        // equals()랑 hashCode()가 없어서 제대로 안됨
        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        // 나 자신(this)의 이름과 나이를 서로 비교
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        // int hash(Ojbect .... values); // 가변인자
        return Objects.hash(name, age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}

