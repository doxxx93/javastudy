package Ch07.doyul.Exercise.Ex7_1;

/*
7-1
섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의한 것이다.
섯다카드 20장을 담는 SutdaCard배열을 초기화하시오.
단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고,
숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다.
즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.
*/

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];


    SutdaDeck() {

//(7-1) 배열 SutdaCard를 적절히 초기화 하시오.

        int i = 0;
        for (int n = 0; n < cards.length; n++) {
            if (i == 0 || i == 2 || i == 7) {
                cards[i++] = new SutdaCard(n % 10 + 1, true);
            } else {
                cards[i++] = new SutdaCard(n % 10 + 1, false);
            }
        }
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

class Exercise7_1 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();
        for (int i = 0; i < deck.cards.length; i++) // 20
            System.out.print(deck.cards[i] + ",");
    }
}
//실행결과 : 1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10,