package exercise;

public class Exercise6_04 {

	// Student클래스에 두 개의 메서드 getTotal()과 getAverage()를 추가하시오
	// getTotal() 기능: 국엉 영어 수학의 점수를 모두 더해서 반환한다
	//				반환타입 : int , 매개변수 없음
	
	// getAverage() 기능: 총점(국어+영어+수학)을 과목수로 나눈 평균을 구한다.
	//					소수점 둘째자리에서 반올림할 것.
	//				반환타입 float, 매개변수 없음
	
	
	public static void main(String[] args) {

		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름 : "+ s.name);
		System.out.println("총점 : "+ s.getTotal());
		System.out.println("평균 : "+ s.getAverage());
		
		
		
	}
}
