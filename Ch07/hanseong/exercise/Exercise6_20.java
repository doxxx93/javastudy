package exercise;

import java.util.Arrays;

// ������ ���� ���ǵ� �޼��带 �ۼ��ϰ� �׽�Ʈ�Ͻÿ�.
// 		* ���� Math.random()�� ����ϴ� ��� �������� �ٸ� �� ����
// �޼���� : suffle
// ��� : �־��� �迭�� ��� ���� ��ġ�� �ٲٴ� �۾��� �ݺ��Ͽ� �ڼ��̰� �Ѵ�.
//		 ó���� �迭�� ��ȯ�Ѵ�.
// ��ȯŸ�� : int[]
// �Ű����� : int[] arr - �������� ��� �迭

public class Exercise6_20 {
	
	static int[] suffle(int[] arr) {
		
		for(int i = 0; i< arr.length; i++) {
			int random = (int)(Math.random() * arr.length);
			int temp = 0;
			
			temp = arr[i];
			arr[i] = arr[random];
			arr[random] = temp;
			
		}
		return  arr;
		
	}
	
	public static void main(String[] args) {
		
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(original));
		
		int[] result = suffle(original);
		System.out.println(Arrays.toString(result));
		
	}
}
