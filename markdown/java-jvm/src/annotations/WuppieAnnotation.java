package annotations;

import org.jetbrains.annotations.NotNull;

public class WuppieAnnotation {
    public static void main(String[] args) {
        WuppieAnnotation w = new WuppieAnnotation();
        w.foo(null);
    }

    public void foo(@NotNull Object o) {
        int i = o.hashCode();
    }
}
