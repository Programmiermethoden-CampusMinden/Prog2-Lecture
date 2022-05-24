package java2d;

import java2d.simplegame.J2DTeaser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Rahmen für die Java2D-Demos */
public final class DemoStarter {
    /** Erzeuge die Komponenten in neuem EDT-Job statt im main()-Tread */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame("Java2D Demo");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        frame.add(J2DTeaser.newJ2DTeaser());
                        // frame.add(SimpleDrawings.newDrawings());
                        // frame.add(SimpleFonts.newWritings());
                        // frame.add(SimplePoly.newDrawings());

                        frame.pack();
                        frame.setSize(480, 460);
                        frame.setVisible(true);
                    }
                });
    }
}
