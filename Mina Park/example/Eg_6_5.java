package example;

class Eg_6_5 {
	public static void main(String args[]) {
		System.out.println("Car.door =" + Car.door);// 클래스변수는 객체생성 없이 클래스이름.클래스변수로 사용가능
		System.out.println("Car.tire = " + Car.tire);

		Car c1 = new Car();
		c1.color = "blue";
		c1.brand = "Hyundai";

		Car c2 = new Car();
		c2.color = "white";
		c2.brand = "kia";

		System.out.println("c1은" + c1.color + c1.brand + c1.door + c1.tire);
		System.out.println("c2은" + c2.color + c2.brand + c2.door + c2.tire);

		System.out.println("door와 tire 변경");
		Car.door = 2;// 클래스변수 변경(c1과 c2가 가리키는 값 모두 변경)
		Car.tire = 3;

		System.out.println("c1은" + c1.color + c1.brand + c1.door + c1.tire);
		System.out.println("c2은" + c2.color + c2.brand + c2.door + c2.tire);
	}
}

class Car {
	static int door = 4; // 공통항목 static으로 선언
	static int tire = 4;
	String color;
	String brand;
}