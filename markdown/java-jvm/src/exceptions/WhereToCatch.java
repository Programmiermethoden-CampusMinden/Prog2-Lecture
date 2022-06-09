package exceptions;

import java.io.*;

public class WhereToCatch {

    // Wirft eine IOException, wenn etwas beim schreiben in der Datei schief läuft
    private static void methode3(String path, int x, int y, int z) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("X:" + x + " Y: " + y + " Z:" + z);
            bufferedWriter.flush();
        }
    }

    public static void methode1(String path, int x) throws IOException {
        methode2(path, x, x * 2);
    }

    private static void methode2(String path, int x, int y) throws IOException {
        methode3(path, x, y, x + y);
    }

    public static void main(String[] args) {
        try {
            methode1("wuppi/flupp", 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
