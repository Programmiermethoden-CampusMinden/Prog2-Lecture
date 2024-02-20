package annotations;

import org.jetbrains.annotations.NotNull;

public class WuppieAnnotation {
    public static void main(String[] args) {
        WuppieAnnotation w = new WuppieAnnotation();
        w.foo(null);
    }

    /** @param o must not be null */
    public void foo(@NotNull Object o) {
        int i = o.hashCode();
    }

    /** @param o should not be null */
    public void bar(Object o) {
        int i;
        if (o != null) {
            i = o.hashCode();
        }
    }
}
