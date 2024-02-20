package challenges.exceptions.better_try_catch;

import java.io.File;

public class BetterTryCatchMain {
    public static void main(String[] args) {
        String dirPath = "./bettertry/";
        try {
            File[] files = MyFunctions.getAllFiles(dirPath);
            File randomTxtFile = MyFunctions.getRandomTxtFile(files);
            String input = MyFunctions.readFile(randomTxtFile);
            int a = MyFunctions.getFirstInteger(input);
            randomTxtFile = MyFunctions.getRandomTxtFile(files);
            input = MyFunctions.readFile(randomTxtFile);
            int b = MyFunctions.getFirstInteger(input);
            System.out.print(a + "/" + b + "=" + MyFunctions.div(a, b));
        } catch (Exception e) {
            System.out.println("Ups. Da ist was schief gelaufen!");
        }
    }
}
