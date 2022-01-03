package test;
import java.util.Arrays;

public class Exercise6_23 {


	//다음과 같이 정의된 메서드를 작성하고 테스트하시오
	
	//메서드명 : max
	//기능 : 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
	//       만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
	//반환타입 : int
	//매개변수 : int[] arr - 최대값을 구할 배열
	
	
	 static int max(int[] arr) {
	     int temp = 0; // 임시변수를 사용하기위해 초기화
	     
	     if(arr == null || arr.length == 0) { // arr가 null이거나 0이라면
	         
	         return -999999; // return으로 인해 max를 벗어남
	     }
	 	
	     for(int i = 0; i< arr.length-1; i++) {
	    	 for(int j=1; j<arr.length-i;j++) {
	         if (arr[j-1]>arr[j]) { // 앞 숫자가 뒷숫자보다 크면 자리 바꿔준다.
	        	 temp = arr[j-1];
	        	 arr[j-1] = arr[j];
	        	 arr[j] = temp;
	        	 
	         	}
	    	 }
	     }
	     System.out.println(Arrays.toString(arr));
	     
	     return arr[arr.length-1];
	 }

	
	
//	 static int max(int[] arr) {
//	     int temp = 0; // 임시변수를 사용하기위해 초기화
//	     
//	     if(arr == null || arr.length == 0) { // arr가 null이거나 0이라면
//	         temp = -999999; 
//	         return temp; // return으로 인해 max를 벗어남
//	     }
//	 	
//	     for(int i = 1; i< arr.length; i++) {
//	         if (arr[i-1]<=arr[i]) { 
//	        	 if(temp<arr[i]) { //만약 temp가 arr[i]보다 크다면
//	        	 temp = arr[i]; // 그 때, arr[i]값을 temp로
//	        	 }
//	         }
//	     }
//	 	System.out.println(Arrays.toString(arr));
//	 	
//	     return temp;
//	 }


 public static void main(String[] args) {

     int[] data = {3,2,8,4,11};
     
     int[] data2 = {2,7,1,5,3};
     
     int[] data3 = {23,1,56,63,12};
     
     System.out.println(Arrays.toString(data));
     System.out.println("최대값:" + max(data));
     
     System.out.println(Arrays.toString(data2));
     System.out.println("최대값:" + max(data2));
     
     System.out.println(Arrays.toString(data3));
     System.out.println("최대값:" + max(data3));
     System.out.println("최대값:" + max(null));
     System.out.println("최대값:" + max(new int[] {})); //크기가 0인 배열


 }

}
