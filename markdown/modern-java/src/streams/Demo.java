package streams;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Teaser für die Folien */
public class Demo {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        LSF lsf = new LSF();

        Studi holger = new Studi("Holger", 7);
        Studi anne = new Studi("Anne", 42);
        Studi heiner = new Studi("Heiner", 1);
        Studi beate = new Studi("Beate", 120);

        Studiengang ifm = new Studiengang("IFM", List.of(holger, anne, heiner));
        Studiengang elm = new Studiengang("ELM", List.of(beate, heiner));

        Fachbereich cm = new Fachbereich("CM", List.of(ifm, elm));

        // Anzahl der Studis im FB mit ECTS>100
        long count = getCountFB(cm);
        long count2 = getCountFB2(cm);
        long count3 = getCountFB3(cm);
    }

    private static void createStreams() {
        List<String> l1 = List.of("Hello", "World", "foo", "bar", "wuppie");
        Stream<String> s1 = l1.stream();

        Stream<String> s2 = Stream.of("Hello", "World", "foo", "bar", "wuppie");

        Random random = new Random();
        Stream<Integer> s3 = Stream.generate(random::nextInt);

        Pattern pattern = Pattern.compile(" ");
        Stream<String> s4 = pattern.splitAsStream("Hello world! foo bar wuppie!");
    }

    private static void intermediateOperations(Studiengang sg) {
        sg.studis().stream()
                .peek(s -> System.out.println("Looking at: " + s.name()))
                .map(Studi::credits)
                .peek(c -> System.out.println("This one has: " + c + " ECTS"))
                .filter(c -> c > 5)
                .peek(c -> System.out.println("Filtered: " + c))
                .sorted()
                .forEach(System.out::println);
    }

    private static void closeStreams() {
        Stream<String> s = Stream.of("Hello", "World", "foo", "bar", "wuppie");

        long count = s.count();
        s.forEach(System.out::println);
        String first = s.findFirst().get();
        Boolean b = s.anyMatch(e -> e.length() > 3);

        List<String> s1 = s.collect(Collectors.toList());
        List<String> s2 = s.toList();
        Set<String> s3 = s.collect(Collectors.toSet());
        List<String> s4 = s.collect(Collectors.toCollection(LinkedList::new));
    }

    private static long getCountFB(Fachbereich fb) {
        long count = 0;
        for (Studiengang sg : fb.studiengaenge()) {
            for (Studi s : sg.studis()) {
                if (s.credits() > 100) count += 1;
            }
        }
        return count;
    }

    private static long getCountSG(Studiengang sg) {
        return sg.studis().stream().map(Studi::credits).filter(c -> c > 100).count();
    }

    private static long getCountFB2(Fachbereich fb) {
        long count = 0;
        for (Studiengang sg : fb.studiengaenge()) {
            count += getCountSG(sg);
        }
        return count;
    }

    private static long getCountFB3(Fachbereich fb) {
        return fb.studiengaenge().stream()
                .flatMap(sg -> sg.studis().stream())
                .map(Studi::credits)
                .filter(c -> c > 100)
                .count();
    }
}
