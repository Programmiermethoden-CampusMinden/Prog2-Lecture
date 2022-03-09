package wildcards.v1;

import java.util.ArrayList;
import java.util.List;

class A {
    void printInfo() {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    void printInfo() {
        System.out.println("B");
    }
}

public class X {
    public static void printInfo(List<A> list) {
        for (A a : list) {
            a.printInfo();
        }
    }

    public static void main(String[] args) {
        List<A> x = new ArrayList<A>();
        x.add(new A());
        x.add(new B());
        printInfo(x);

        List<B> y = new ArrayList<B>();
        y.add(new B());
        y.add(new B());
        // printInfo(y);  // Compiler-Fehler
    }
}
