package example;

class Eg_6_5 {
	public static void main(String args[]) {
		System.out.println("Car.door =" + Car.door);// Ŭ���������� ��ü���� ���� Ŭ�����̸�.Ŭ���������� ��밡��
		System.out.println("Car.tire = " + Car.tire);

		Car c1 = new Car();
		c1.color = "blue";
		c1.brand = "Hyundai";

		Car c2 = new Car();
		c2.color = "white";
		c2.brand = "kia";

		System.out.println("c1��" + c1.color + c1.brand + c1.door + c1.tire);
		System.out.println("c2��" + c2.color + c2.brand + c2.door + c2.tire);

		System.out.println("door�� tire ����");
		Car.door = 2;// Ŭ�������� ����(c1�� c2�� ����Ű�� �� ��� ����)
		Car.tire = 3;

		System.out.println("c1��" + c1.color + c1.brand + c1.door + c1.tire);
		System.out.println("c2��" + c2.color + c2.brand + c2.door + c2.tire);
	}
}

class Car {
	static int door = 4; // �����׸� static���� ����
	static int tire = 4;
	String color;
	String brand;
}