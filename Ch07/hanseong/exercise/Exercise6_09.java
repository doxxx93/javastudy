package exercise;

// 다음은 컴퓨터 게임의 병사(Marine)를 클래스로 정의한 것이다.
// 이 클래스의 멤버중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가?
// (단, 모든 병사의 공격력과 방어력은 같아야한다)

class Marine{
	int x = 0,y=0;		// Marine의 위치좌표(x,y)
	int hp = 60;		// 현재 체력
	int weapon = 6;		// 공격력
	int armor = 0;		// 방어력
	
	void waponUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// static을 붙여야 하는 것 : weapon, armor, waponUp()
// 이유 : 공격력과 방어력은 모든 병사 마다 동일하게 적용되야 하기 때문이고
//			공격력이 올라가는것은 한 병사에만 해당하는 것이 아니기때문?

public class Exercise6_09 {
}
