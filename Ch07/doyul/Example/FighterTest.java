package Ch07.doyul.Example;
// 인터페이스의 다형성 연습
abstract class Unit2 {
    int x, y;

    abstract void move(int x, int y);

    void stop() {
        System.out.println("stop");
    }
}

interface Fightable {
    void move(int x, int y);        //public abstract가 생략됨

    void attack(Fightable f);       //public abstract가 생략됨
}

class Fighter extends Unit2 implements Fightable {
    // 오버라이딩 규칙: 조상보다 접근 제어자가 좁으면 안된다.
    // public 생략 불가 void move : public 이므로 생략(=default)불가
    public void move(int x, int y) {
        System.out.println("[" + x + "," + y + "]로 이동");
    }

    public void attack(Fightable f) {
        System.out.println(f + "를 공격");
    }
    // 싸울 수 있는 상대를 불러온다
    Fightable getFightable() {
        Fighter f = new Fighter(); //Fighter 를 생성해서 반환
        return f;           //(Fightable)f 형변환 가능해서 생략 가능
    }
}

public class FighterTest {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        Fightable f2 = f.getFightable();        //
//        f.move(100, 200);
//        f.attack(new Fighter());
//        f.stop();
//
//        Unit2 u = new Fighter();
//        u.move(100, 200);
////        u.attack(new Fighter());        //Unit2 에는 attack()이 없어서 호출 불가
//        u.stop();
//
//        Fightable f2 = new Fighter();
//        f2.move(100, 200);
//        f2.attack(new Fighter());
////        f2.stop();                       //참조 변수 Fightable 에는 stop()이 없어서 호출 불가
    }

}
