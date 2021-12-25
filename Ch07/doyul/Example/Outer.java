package Ch07.doyul.Example;
class Outer {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner{
        int iiv = outerIv; // 외부 클래스의 private멤버도 접근 가능 << 핵심
        int iiv2 = outerCv;
    }

    static class StaticInner {
        // static 클래스는 외부 클래스의 인스턴스멤버에 접근 불가
        // int siv = outerIv;
        static int scv = outerCv;
    }

    void myMethod() {
        int lv = 0; // 값이 바뀌지 않는 변수는 상수로 간주 "constant pool"
        final int LV = 0; // JDK1.8부터 final 생략 가능

        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;
            // 외부 클래스의 지역변수 filnal이 붙은 변수(상수)만 접근 가능(JDK1.8 이전)
            int liv3 = lv; // 에러. JDK1.8 이전 버전까지만 에러
            int liv4 = LV;

            void method() {
                System.out.println(lv);
                //
            }
        }
    }
}