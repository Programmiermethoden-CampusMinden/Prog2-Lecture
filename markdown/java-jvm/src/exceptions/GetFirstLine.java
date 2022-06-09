package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetFirstLine {
    static String getFirstLine(String pathToFile) throws IOException {
        // try  mit Resources
        try (FileReader fileReader = new FileReader(pathToFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            return bufferedReader.readLine();
        }
        // impliziert einen finally Block, welcher die Ressourcen schließt.
    }

    public static void main(String[] args) {
        try {
            getFirstLine("gibts nicht");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
