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
		System.out.println("change 메소드 실행 이후");
		System.out.println("main: x=" + d.x);// d.x 자체의 값이 변경된게 아니라 change메서드의 지역변수 x만 변경된 것
	}

	static void change(int x) {
		x = 1000;
		System.out.println("change: x=" + x);
	}
}
