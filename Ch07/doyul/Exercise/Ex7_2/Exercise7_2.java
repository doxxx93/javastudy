package Ch07.doyul.Exercise.Ex7_2;

/*
7-2
1. 메서드명 : shuffle
기 능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다.(Math.random()사용)
반환타입 : 없음
매개변수 : 없음
2. 메서드명 : pick
기 능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
반환타입 : SutdaCard
매개변수 : int index - 위치
3. 메서드명 : pick
기 능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다.(Math.random()사용)
반환타입 : SutdaCard
매개변수 : 없음


*/
class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];


    SutdaDeck() { // SutdaDeck 메서드 시작
//(7-1) 배열 SutdaCard를 적절히 초기화 하시오.
        int i = 0;
        for (int n = 0; n < cards.length; n++) {
            if (i == 0 || i == 2 || i == 7) {
                cards[i++] = new SutdaCard(n % 10 + 1, true);
            } else {
                cards[i++] = new SutdaCard(n % 10 + 1, false);
            }
        }
    } // SutdaDeck 메서드 끝
/*
    1. 메서드명 : shuffle
    기 능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다.(Math.random()사용)
    반환타입 : 없음
    매개변수 : 없음
*/
    void shuffle() { // shuffle 메서드 시작
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * cards.length);
            SutdaCard tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
    }   // shuffle 메서드 끝
/*
2. 메서드명 : pick
    기 능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
    반환타입 : SutdaCard
    매개변수 : int index - 위치
*/

    SutdaCard pick(int index) {
        return cards[index];
    }
/*
3. 메서드명 : pick
    기 능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다.(Math.random()사용)
    반환타입 : SutdaCard
    매개변수 : 없음
*/
    SutdaCard pick() {
        return cards[(int) (Math.random() * cards.length)];
    }

}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard(int i) {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // info()대신 Object클래스의 toString()을 오버라이딩했다.
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

class Exercise7_2 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();
//        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();
        for (int i = 0; i < deck.cards.length; i++)
            System.out.print(deck.cards[i] + ",");
        System.out.println();
//        System.out.println(deck.pick(0));
    }
}
//실행결과 : 1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10,