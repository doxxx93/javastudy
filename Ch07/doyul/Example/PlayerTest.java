package Ch07.doyul.Example;

abstract class Player {
    abstract void play(int pos);    //추상 메서드

    abstract void stop();           //추상 메서드
}

class AudioPlayer extends Player {
    @Override
    void play(int pos) {

    }

    @Override
    void stop() {

    }
}

public class PlayerTest {
    public static void main(String[] args) {
//        Player p = new Player();
//        AudioPlayer ap = new AudioPlayer();
        Player ap = new AudioPlayer();  //다형성
        ap.play(100);
        ap.stop();
    }
}
