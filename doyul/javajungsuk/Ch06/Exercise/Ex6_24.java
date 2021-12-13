public class Ex6_24 {

    public static int abs(int value) {

        return value < 0 ? -value : value;


    }

    public static void main(String[] args) {
        int value = 5;
        System.out.println(value +","+ abs(value));
        value = -10;
        System.out.println(value +","+ abs(value));
    }
}
