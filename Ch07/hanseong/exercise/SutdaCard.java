package exercise;
// ������ ���� ��������� ���� SutdaCardŬ������ �����Ͻÿ�.
// Ÿ��: int, ������: num, ����: ī���� ����(1~10������ ����)
// Ÿ��: boolean, ������: isKwang, ����: ��(��)�̸� true, �ƴϸ� false
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
