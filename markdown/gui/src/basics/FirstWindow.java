package basics;

import javax.swing.JFrame;

/** Erzeuge ein minimales Fenster */
public class FirstWindow {
    /** Erzeuge die Komponenten in neuem EDT-Job statt im main()-Tread */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame("Hello World :)");

                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        frame.pack();
                        frame.setVisible(true);
                    }
                });
    }
}
