package challenges.exceptions.better_try_catch;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFunctions {
    private static Random r = new Random();

    /**
     * Führ eine Division durch
     *
     * @param x Zähler
     * @param y Nenner
     * @return Result
     * @throws ArithmeticException Wenn es bei der Berechnung zu mathematischen Problememn gekommen
     *     ist
     */
    public static double div(int x, int y) throws ArithmeticException {
        return (double) x / y;
    }

    /**
     * Liest ein File asl String ein
     *
     * @param file File das eingelesen werden soll
     * @return Inhalt des Files als String
     * @throws IOException Wenn beim einlesen des Files etwas schiefläuft
     */
    public static String readFile(File file) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Liest alle Files im übergebenen Verzeichnis ein
     *
     * @param path Der Pfad zum Verzeichnis das eingelesen werden soll
     * @return Array mit allen Files des Verezeichnis
     * @throws NotDirectoryException Wenn der übergebene Pfad kein Verzeichnis ist
     */
    public static File[] getAllFiles(String path) throws NotDirectoryException {
        File dir = new File(path);
        if (!dir.isDirectory()) throw new NotDirectoryException("Given path is no directory");
        return dir.listFiles();
    }

    /**
     * Gibt ein zufälliges .txt File aus dem übergebenen File-Array zurücl
     *
     * @param files Das File-Array aus dem die .txt ausgwählt werden soll
     * @return Das ausgewählte File
     * @throws NoSuchFileException Wenn im File-Array kein .txt File enthalten ist
     */
    public static File getRandomTxtFile(File[] files) throws NoSuchFileException {
        File randomFile = null;
        // fore some reason the list given from Array.asList is immutable, so we just copy the List
        List<File> filelist = new ArrayList<>(Arrays.asList(files));
        filelist.removeIf(f -> !f.getPath().endsWith(".txt"));
        if (filelist.size() <= 0)
            throw new NoSuchFileException("Kein .txt File in der Liste enthalten.");
        else return filelist.get(r.nextInt(filelist.size()));
    }

    /**
     * Gibt die erste (zusammenhängende) Zahl zurücl, die im String gefunden wird.
     *
     * @param string String der untersucht werden soll
     * @return Die gefundene Zahl
     * @throws NoNumberFoundException Wenn im String keine Zahl enthalten sit
     */
    public static int getFirstInteger(String string) throws NoNumberFoundException {
        Matcher matcher = Pattern.compile("\\d+").matcher(string);
        if (!matcher.find()) throw new NoNumberFoundException("Keine Zahl im String gefunden.");
        return Integer.valueOf(matcher.group());
    }
}
