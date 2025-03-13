package nested;

import java.util.ArrayList;
import java.util.List;

/** Sortieren einer Liste mit einem Lambda-Ausdruck */
public class DemoLambda {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        List<Studi> sl = new ArrayList<>();

        // Parametrisierung mit Lambda-Ausdruck
        sl.sort((Studi o1, Studi o2) -> o1.getCredits() - o2.getCredits());
    }
}
