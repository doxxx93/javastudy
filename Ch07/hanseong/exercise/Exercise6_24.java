package exercise;

// ������ ���� ���ǵ� �޼��带 �ۼ��ϰ� �׽�Ʈ�Ͻÿ�

// �޼���� : abs
// ��� : �־��� ���� ���밪�� ��ȯ�Ѵ�.
// ��ȯŸ�� : int
// �Ű����� : int value

public class Exercise6_24 {
	
	static int abs(int value) {
		if(0 <= value)
			return value;
		else
			return -(value);
	}
	
	public static void main(String[] args) {
		
		int value = 5;
		System.out.println(value + "�� ���밪 : " + abs(value));
		value = -10;
		System.out.println(value+"�� ���밪 : " +abs(value));
	}
	
}
