package example;

class Data {
	int x;
}

class Eg_6_9 {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main: x=" + d.x);

		change(d.x);
		System.out.println("change �޼ҵ� ���� ����");
		System.out.println("main: x=" + d.x);// d.x ��ü�� ���� ����Ȱ� �ƴ϶� change�޼����� �������� x�� ����� ��
	}

	static void change(int x) {
		x = 1000;
		System.out.println("change: x=" + x);
	}
}
