package Ch07.doyul.Example;

// 전원상태 on off , 채널, 파워 상태 변환
class Tv {
    boolean power; // 전원상태(on/off)
    int channel;    //채널

    void power() {
        power = !power;
    }

    void channelUp() { ++channel; }

    void channelDown() {
        --channel;
    }

}
// Tv class를 상속 받는 CaptionTv 클래스
//
class CaptionTv extends Tv {
    boolean caption;    // 캡션상태(on/off)

    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);        // 캡션상태가 on(ture)일 때만 text를 보여준다
        }
    }
}

public class CaptionTvTest {
    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;                   // 조상클래스로부터 상속받은 멤버
        ctv.channelUp();                    // 조상클래스로부터 상속받은 멤버
        System.out.println(ctv.channel);
        ctv.channelUp();                    // 조상클래스로부터 상속받은 멤버
        ctv.displayCaption("Hello, World"); //출력되지 않음
        System.out.println(ctv.channel);
        ctv.caption = true;
        ctv.displayCaption("Hello, World");

    }

}