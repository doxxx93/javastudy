package exercise;

// 다음과 같이 정의된 메서드를 작성하고 테스트하시오

// 메서드명 : isNumber
// 기능 : 주어진 문장이 모두 숫자로만 이루어져있는지 확인한다.
//	 	 모두 숫자로만 이루어져 있으면 true를 반환하고,
//		 그렇지 않다면 false를 반환한다.
//		 만일 주어진 문자열이 null이거나 빈문자열 "" 이라면 false를 반환한다.
// 반환타입 : boolean
// 매개변수 String str - 검사할 문자열

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
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		str = "123aaaaaa";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

	}

}
