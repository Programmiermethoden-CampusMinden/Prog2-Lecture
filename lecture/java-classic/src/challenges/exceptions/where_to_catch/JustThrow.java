package challenges.exceptions.where_to_catch;

import java.util.Random;

public class JustThrow {

    private static Random r = new Random();

    public int method1() throws MyException {
        return method2(r.nextInt());
    }

    public int method2(int a) throws MyException {
        return method3(a, r.nextInt());
    }

    public int method3(int a, int b) throws MyException {
        if (a > b) throw new MyException();
        return method4(a, b, r.nextInt());
    }

    public int method4(int a, int b, int c) throws MyException {
        if (a > b || b > c) throw new MyException();
        return method5(a, b, c, r.nextInt());
    }

    public int method5(int a, int b, int c, int d) throws MyException {
        if (a > b || b > c || c > d) throw new MyException();
        return r.nextInt(b - a) * r.nextInt(d - c);
    }

    public static void main(String[] args) throws MyException {
        JustThrow jt = new JustThrow();
        System.out.println(jt.method1());
        System.out.println(jt.method3(r.nextInt(), r.nextInt()));
    }
}
