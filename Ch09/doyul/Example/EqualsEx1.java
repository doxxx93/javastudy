package Ch09.doyul.Example;

import java.util.Objects;

class EqualsEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if (v1.equals(v2)) {
            System.out.println("v1과 v2는 같습니다.");
        } else {
            System.out.println("v1과 v2는 다릅니다.");
        }

        v2 = v1;

        if (v1.equals(v2)) {
            System.out.println("v1과 v2는 같습니다.");
        } else {
            System.out.println("v1과 v2는 다릅니다.");
        }
    } // main
}

class Value {
    int value;

    Value(int value) {
        this.value = value;
    }

    class EqualsEx1 {
        public static void main(String[] args) {
<<<<<<< HEAD
//            Value v1 = new Value(10);
//            Value v2 = new Value(10);
//
//            if (v1.equals(v2)) {
//                System.out.println("v1과 v2는 같습니다.");
//            } else {
//                System.out.println("v1과 v2는 다릅니다.");
//            }
//
//            v2 = v1;
//
//            if (v1.equals(v2)) {
//                System.out.println("v1과 v2는 같습니다.");
//            } else {
//                System.out.println("v1과 v2는 다릅니다.");
//            }
        } // main
    }

//    class Value {
//        int value;
//
//        Value(int value) {
//            this.value = value;
//        }
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 주소 비교
=======
            Value v1 = new Value(10);
            Value v2 = new Value(10);

            if (v1.equals(v2)) {
                System.out.println("v1과 v2는 같습니다.");
            } else {
                System.out.println("v1과 v2는 다릅니다.");
            }

            v2 = v1;

            if (v1.equals(v2)) {
                System.out.println("v1과 v2는 같습니다.");
            } else {
                System.out.println("v1과 v2는 다릅니다.");
            }
        } // main
    }

    class Value {
        int value;

        Value(int value) {
            this.value = value;
        }
    }

    @Override
    public boolean equals(Object obj) {
//        if (this == obj) return true; // 주소 비교
>>>>>>> bebe0bbb5d6601075a7c359ec9fd80e75b69db58
        if (!(obj instanceof Value)) return false; //
        Value v = (Value) obj; // obj
        return this.value == v.value;
    }

}
