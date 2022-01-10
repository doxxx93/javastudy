package example;

//3.9 참조형 반환타입

class ReferenceReturnEx {
}

class Eg_6_14 {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 100;

		Data d2 = copy(d);
		System.out.println("d.x=" + d.x);
		System.out.println("d2.x=" + d2.x);
	}

	// static이므로 객체생성 없이 가능
	// 반환타입이 찹조형인 경우 객체의 주소를 반환(반환타입은 Data로 일치)
	static Data copy(Data d) {
		Data test = new Data();
		test.x = d.x;

		return test;
	}

}
