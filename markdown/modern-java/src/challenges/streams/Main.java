package challenges.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static final String FILE_PATH_STRING = "file.txt";

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.a());

        List<Student> studentList =
                Arrays.asList(
                        new Student("A", 30),
                        new Student("B", 45),
                        new Student("C", 60),
                        new Student("D", 45),
                        new Student("E", 80));

        System.out.println(main.b(studentList));

        Path path = Paths.get(FILE_PATH_STRING);
        System.out.println(path.toAbsolutePath());
        try {
            System.out.println(main.c(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> a() {
        Random r = new Random();
        List<Integer> randomIntegers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomIntegers.add(r.nextInt(10));
        }
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (randomIntegers.get(i) % 2 == 0) {
                returnList.add(randomIntegers.get(i) * randomIntegers.get(i));
            }
        }
        return returnList;
    }

    public Integer b(List<Student> studentList) {
        Integer sum = 0;
        for (Student s : studentList) {
            sum += s.getCps();
        }
        return sum;
    }

    public String c(Path path) throws IOException {
        String startingWithAExceptFirst = "";
        List<String> allLines = new ArrayList<>();
        BufferedReader r = Files.newBufferedReader(path);
        String newLine = r.readLine();
        while (newLine != null){
            allLines.add(newLine);
            newLine = r.readLine();
        }

        for (int i = 1; i < allLines.size(); i++) {
            if (allLines.get(i).startsWith("a")) {
                startingWithAExceptFirst += allLines.get(i) + "\n";
            }
        }
        return startingWithAExceptFirst;
    }
}
