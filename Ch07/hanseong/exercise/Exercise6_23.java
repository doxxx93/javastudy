package exercise;

import java.util.Arrays;

// ������ ���� ���ǵ� �޼��带 �ۼ��ϰ� �׽�Ʈ�Ͻÿ�

// �޼���� : max
// ��� : �־��� int�� �迭�� �� �߿��� ���� ū ���� ��ȯ�Ѵ�.
// 		 ���� �־��� �迭�� null�̰ų� ũ�Ⱑ 0�� ���, -999999�� ��ȯ�Ѵ�.
// ��ȯŸ�� : int
// �Ű����� : int[] arr - �ִ밪�� ���� �迭

public class Exercise6_23 {
	
	static int max(int[] arr) {
		int temp = 0;
	

		for(int i = 0; i< arr.length-1; i++) {
			for(int j = 0; j < arr.length -1-i; j++) {
				if(arr[i] < arr[j]) {
					temp = arr[j];
				}
			}
		}
		if(arr == null || arr.length == 0) {
			temp = -999999;
			
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		
		int[] data = {3,2,8,4,11};
		System.out.println(Arrays.toString(data));
		System.out.println("�ִ밪:" + max(data));
		System.out.println("�ִ밪:" + max(null));
		System.out.println("�ִ밪:" + max(new int[] {})); //ũ�Ⱑ 0�� �迭
		
		
	}
	
}
