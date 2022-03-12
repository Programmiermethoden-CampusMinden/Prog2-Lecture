package annotations;

public class Wuppie {
    public static void main(String[] args) {
        Wuppie w = new Wuppie();
        w.foo(null);
    }

    /**
     * @param o should NOT be null
     */
    public void foo(Object o) {
        int i;
        if (o != null) {
            i = o.hashCode();
        }
    }
}
