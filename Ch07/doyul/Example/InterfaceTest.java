package Ch07.doyul.Example;

class A {
    public void method(I i) {   //인터페이스 I를 구현한 
        i.method();
    }
}

interface I {
    public void method();
} 

class B implements I{
    public void method() {
        System.out.println("B클래스의 메서드");
        }
}
class C implements I{
    public void method() {
        System.out.println("C클래스의 메서드");
        }
}

public class InterfaceTest {
    public static void main(String[] args) {
        A a = new A();
        a.method(new C());
//        a.method(new B()); //인터페이스를 이용하게 되면 B->C 로 바꾸기만 하면 됨

    }
}
