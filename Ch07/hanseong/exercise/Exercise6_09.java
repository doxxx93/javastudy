package exercise;

// ������ ��ǻ�� ������ ����(Marine)�� Ŭ������ ������ ���̴�.
// �� Ŭ������ ����߿� static�� �ٿ��� �ϴ� ���� � �͵��̰� �� ������ �����ΰ�?
// (��, ��� ������ ���ݷ°� ������ ���ƾ��Ѵ�)

class Marine{
	int x = 0,y=0;		// Marine�� ��ġ��ǥ(x,y)
	int hp = 60;		// ���� ü��
	int weapon = 6;		// ���ݷ�
	int armor = 0;		// ����
	
	void waponUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// static�� �ٿ��� �ϴ� �� : weapon, armor, waponUp()
// ���� : ���ݷ°� ������ ��� ���� ���� �����ϰ� ����Ǿ� �ϱ� �����̰�
//			���ݷ��� �ö󰡴°��� �� ���翡�� �ش��ϴ� ���� �ƴϱ⶧��?

public class Exercise6_09 {
}
