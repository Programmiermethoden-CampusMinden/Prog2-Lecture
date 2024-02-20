package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** Beispiel: Wieviel Code im try? */
public class HowMuchTry {
    private static int getFirstLineAsIntV1(String pathToFile)
            throws FileNotFoundException, IOException, NumberFormatException {
        FileReader fileReader = new FileReader(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String firstLine = bufferedReader.readLine();

        return Integer.parseInt(firstLine);
    }

    private static int getFirstLineAsIntV2(String pathToFile) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(pathToFile);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace(); // Datei nicht gefunden
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String firstLine = null;
        try {
            firstLine = bufferedReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace(); // Datei kann nicht gelesen werden
        }

        try {
            return Integer.parseInt(firstLine);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace(); // Das war wohl kein Integer
        }

        return 0;
    }

    private static int getFirstLineAsIntV3(String pathToFile) {
        try {
            FileReader fileReader = new FileReader(pathToFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String firstLine = bufferedReader.readLine();
            return Integer.parseInt(firstLine);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace(); // Datei nicht gefunden
        } catch (IOException ioe) {
            ioe.printStackTrace(); // Datei kann nicht gelesen werden
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace(); // Das war wohl kein Integer
        }

        return 0;
    }
}
