package Ch07.doyul.Example;

public class CastingTest1 {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = null;  // 실제 인스턴스가 무엇인지 중요.


//        FireEngine fe = new FireEngine();
//        FireEngine fe2 = null;
//
//        fe.water();
//        car = fe;
//        car.water();  car. 을 쳤을 때 water() 멤버는 없음
//        fe2 = (FireEngine) car; // fe2 = car; 를 치면 에러와 함께 형변환 추천이 뜸
//        fe2.water();
//
        FireEngine fe2 = (FireEngine) car; //null
        Car car2 = (Car)fe2; //null
        car2.drive(); // NullPointException 발생.
    }
}

class Car {
    String color;
    int door;
    void drive() {
        System.out.println("drive");
    }
    void stop() {
        System.out.println("stop");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("water");
    }
}