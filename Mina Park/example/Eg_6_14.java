package example;

//3.9 ������ ��ȯŸ��

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

	// static�̹Ƿ� ��ü���� ���� ����
	// ��ȯŸ���� �������� ��� ��ü�� �ּҸ� ��ȯ(��ȯŸ���� Data�� ��ġ)
	static Data copy(Data d) {
		Data test = new Data();
		test.x = d.x;

		return test;
	}

}
