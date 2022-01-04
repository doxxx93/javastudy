package example;

class Menu {
	String name;
	boolean spicy;
	int price;

	void makeSpicy() {
		spicy = !spicy;
	}

	void onSale() {
		--price;
	}

	void offSale() {
		++price;
	}
}

class Eg_6_2 {
	public static void main(String args[]) {
		Menu m1 = new Menu();
		Menu m2 = new Menu();

		System.out.println("m1의 price는" + m1.price);
		System.out.println("m1의 price는" + m1.price);

		m1.price = 10000;
		System.out.println("m1의 price를" + m1.price + "로 변경");

		System.out.println("m1의 price는" + m1.price);
		System.out.println("m2의 price는" + m2.price);// m1과 m2가 가리키는 객체가 서로 상이하므로 m1.price만 변경
	}
}