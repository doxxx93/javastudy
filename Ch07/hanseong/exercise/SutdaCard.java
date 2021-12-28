package exercise;
// 다음과 같은 멤버변수를 갖는 SutdaCard클래스를 정의하시오.
// 타입: int, 변수명: num, 설명: 카드의 숫자(1~10사이의 정수)
// 타입: boolean, 변수명: isKwang, 설명: 광(光)이면 true, 아니면 false
public class SutdaCard {

	int num;
	boolean isKwang;
	
	public SutdaCard() {
	}
	
	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	String info() {
		if(num == 0)
			return "1K";
		else 
			return this.num +"";
		
	}
	
}
