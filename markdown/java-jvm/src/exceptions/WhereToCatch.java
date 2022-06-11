package exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

/** Beispiel: Wo fange ich eine Exception */
public class WhereToCatch {
    private static void methode1(int x) throws IOException {
        JFileChooser fc = new JFileChooser();
        fc.showDialog(null, "ok");
        methode2(fc.getSelectedFile().toString(), x, x * 2);
    }

    private static void methode2(String path, int x, int y) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("X:" + x + " Y: " + y);
        bw.flush();
    }

    /** Just to please Checkstyle */
    public static void main(String[] args) {
        try {
            methode1(42);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
