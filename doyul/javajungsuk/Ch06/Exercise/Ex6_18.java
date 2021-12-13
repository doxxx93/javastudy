public class Ex6_18 {
    static int cv = 20;
    int iv = 10;
    int iv2 = cv;
//    static int cv2 = iv; // 라인 A - 컴파일 에러 static 변수의 초기화에 인스턴스변수를 사용할 수 없다

    static void staticMethod1() {
        System.out.println(cv);
//        System.out.println(iv); // 라인 B - 컴파일 에러 static 메서드에 인스턴스변수를 사용할 수 없다
    }

    static void staticMethod2() {
        staticMethod1();
//        instanceMethod1(); // 라인 D - 컴파일 에러 // static 메서드에 인스턴스메서드를 사용할 수 없다
    }

    void instanceMethod1() {
        System.out.println(cv);
        System.out.println(iv); // 라인 C
    }

    void instanceMethod2() {
        staticMethod1(); // 라인 E
        instanceMethod1();
    }
}

