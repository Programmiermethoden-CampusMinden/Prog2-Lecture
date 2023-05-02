package functionalinterfaces;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.function.Predicate.not;

/**
 * Demo für Package java.util.function
 * (https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)
 * (https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html)
 *
 * <p>
 * Function<T,R>:     R apply(T t)
 * BiFunction<T,U,R>: R apply(T t, U u)
 *
 * <p>
 * Predicate<T>:      boolean test(T t)
 *
 * <p>
 * Consumer<T>:       void accept(T t)
 * Supplier<T>:       T get()
 */
public class DemoFI {
    private List<String> demo = List.of("", "Hello", "World", ":)", "wuppie", "fluppie", "FOO", "bar");
    private Random rand = new Random();

    // Demo: Start
    public void demoA() {
        for (String s : demo) {
            if (!s.isEmpty()) {
                String r1 = s.toLowerCase();
                String r2 = String.valueOf(rand.nextInt(100));
                System.out.println(r1+r2);
            }
        }
    }


    // Demo: Nach Refactoring
    public void demoB() {
        for (String s : demo) {
            if (isNotEmpty(s)) {
                String r1 = toLowerCase(s);
                String r2 = nextIntAsString();
                print(r1+r2);
            }
        }
    }

    // Predicate<T>: boolean test(T t)
    private boolean isNotEmpty(String s) {
        return !s.isEmpty();
    }

    // Function<T,R>: R apply(T t)
    private String toLowerCase(String s) {
        return s.toLowerCase();
    }

    // Supplier<T>: T get()
    private String nextIntAsString() {
        return String.valueOf(rand.nextInt(100));
    }

    // Consumer<T>: void accept(T t)
    private void print(String s) {
        System.out.println(s);
    }


    // Demo: Direkter Einsatz der vordefinierten funktionalen Interfaces
    public void demoC() {
        // Predicate<T>: boolean test(T t)
        Predicate<String> isNotEmpty = not(String::isEmpty);
        // Function<T,R>: R apply(T t)
        Function<String, String> toLowerCase = String::toLowerCase;
        // Supplier<T>: T get()
        Supplier<String> nextIntAsString = () -> String.valueOf(rand.nextInt(100));
        // Consumer<T>: void accept(T t)
        Consumer<String> print = System.out::println;

        for (String s : demo) {
            if (isNotEmpty.test(s)) {
                String r1 = toLowerCase.apply(s);
                String r2 = nextIntAsString.get();
                print.accept(r1+r2);
            }
        }
    }


    // Demo: Einsatz analog zu ecs.components.skill.Skill
    public void demoD() {
        Predicate<String> isNotEmpty = not(String::isEmpty);
        Function<String, String> toLowerCase = String::toLowerCase;
        Supplier<String> nextIntAsString = () -> String.valueOf(rand.nextInt(100));
        Consumer<String> print = System.out::println;

        for (String s : demo) {
            if (isNotEmpty.test(s)) {
                String r1 = toLowerCase.apply(s);
                String r2 = nextIntAsString.get();

                execute(print, r1+r2);  // "print" ist in Skill die ISkillFunction ...
            }
        }
    }

    private void execute(Consumer<String> cs, String s) {
        cs.accept(s);
    }
}
