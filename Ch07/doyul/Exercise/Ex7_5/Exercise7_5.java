package Ch07.doyul.Exercise.Ex7_5;

class Product {
    int price; // 제품의 가격
    int bonusPoint; // 제품구매 시 제공하는 보너스점수

    Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }

    public Product() {
    }
}

class Tv extends Product {
    Tv() {
    }

/*
1. Tv() 생성자 내에 super();
    Tv() {
        super();    // 이 부분에 에러 발생
    }

    1-1. Product(int price) // 부모클래스의 매개변수가 있는 생성자의 매개변수의 매개변수를 없앤다(기본생성자로 만든다)
        -> 에러 해결
    1-2. Product() // 부모클래스에 매개변수가 없는 생성자를 만든다(기본생성자를 만든다)
        -> 에러 해결

2. Tv(int price) // 매개변수가 있는 생성자를 만든다.
    Tv(int price) {
        super(price);
    }

    결과: 1. 의 상황과 똑같아짐


3. Product() // 부모 클래스에 기본생성자를 만든다.
    Product() {
    }
    -> 에러 해결
*/
//  결론: 부모 클래스에 기본생성자를 생성함으로서 문제가 해결 됨
    public String toString() {
        return "Tv";
    }
}

class Exercise7_5 {
    public static void main(String[] args) {
        Tv t = new Tv();
    }
}