package methodreferences;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

/** Dummy-Klasse mit statischen Methoden für Aufruf per Methoden-Referenz */
class X {
    /** Prädikat: Ist das Argument größer als 4? */
    public static boolean four(int x) {
        return x > 4;
    }

    /** Prädikat: Sind beide Strings gleich? */
    public static int cmp(String s1, String s2) {
        return s2.compareTo(s1);
    }
}

/** Beispiel: Collections über die Stream-API */
public class CollectionStreams {
    /** Starter - just to please Checkstyle */
    public static void main(String[] args) {
        List<String> words =
                Arrays.asList(
                        "Java8", "Lambdas", "PM", "Dungeon", "libGDX", "Hello", "World", "Wuppie");

        List<Integer> wordLengths =
                words.stream()
                        .sorted(X::cmp)
                        .map(String::length)
                        .filter(X::four)
                        .sorted()
                        .collect(toList());

        System.out.println(wordLengths);
    }
}
