package exercise;

// ������ ���� ���ǵ� �޼��带 �ۼ��ϰ� �׽�Ʈ�Ͻÿ�

// �޼���� : isNumber
// ��� : �־��� ������ ��� ���ڷθ� �̷�����ִ��� Ȯ���Ѵ�.
//	 	 ��� ���ڷθ� �̷���� ������ true�� ��ȯ�ϰ�,
//		 �׷��� �ʴٸ� false�� ��ȯ�Ѵ�.
//		 ���� �־��� ���ڿ��� null�̰ų� ���ڿ� "" �̶�� false�� ��ȯ�Ѵ�.
// ��ȯŸ�� : boolean
// �Ű����� String str - �˻��� ���ڿ�

public class Exercise6_22 {

	static boolean isNumber(String str) {
		if(str.matches("[+-]?\\d*(\\.\\d+)?")) {
			return true;
		}else if(str == null || str.equals("")) {
			return false;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {

		String str = "123123124512312";
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));

		str = "123aaaaaa";
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));

	}

}
