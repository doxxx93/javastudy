package Ch12.doyul.Example;

import java.util.ArrayList;

class Product {


}

class Tv extends Product {


}

class Audio extends Product {

}

public class GenericTest {

    public static void main(String[] args) {
        ArrayList<Product> productArrayList = new ArrayList<Product>();
        ArrayList<Tv> tvArrayList = new ArrayList<Tv>(); // Tv타입만 저장가능

        productArrayList.add(new Tv());
        productArrayList.add(new Audio());

        tvArrayList.add(new Tv());
        tvArrayList.add(new Tv());
//        tvArrayList.add(new Audio());

        printAll(productArrayList);

    }

    public static void printAll(ArrayList<Product> list) {
        for (Product p : list)
            System.out.println(p);
    }
}





