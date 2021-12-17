public class Ex6_7 {
    static double getDistance(int x, int y, int x1, int y1) {

        return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
    }

    public static void main(String[] args) {
        Mypoint p = new Mypoint(1, 1);
        System.out.println(p.getDistance(2, 2));
    }
}

class Mypoint {
    int x;  //인스턴스변수
    int y;  //인스턴스변수

    public Mypoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(int x1, int y1) {
        return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
    }

}
