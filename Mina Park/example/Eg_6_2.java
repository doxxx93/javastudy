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

		System.out.println("m1�� price��" + m1.price);
		System.out.println("m1�� price��" + m1.price);

		m1.price = 10000;
		System.out.println("m1�� price��" + m1.price + "�� ����");

		System.out.println("m1�� price��" + m1.price);
		System.out.println("m2�� price��" + m2.price);// m1�� m2�� ����Ű�� ��ü�� ���� �����ϹǷ� m1.price�� ����
	}
}