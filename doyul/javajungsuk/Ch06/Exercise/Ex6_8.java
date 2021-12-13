public class Ex6_8 {
    static int width; // 클래스변수
    static int height; // 클래스변수

    int kind; //인스턴스변수
    int num;  //인스턴스변수


    public Ex6_8(int k, int n) {
        this.kind = k;  //지역변수
        this.num = n;   //지역변수
    }

    public static void main(String[] args) { //args = 지역변수
        Ex6_8 card = new Ex6_8(1, 1);  // card = 지역변수
    }
}

