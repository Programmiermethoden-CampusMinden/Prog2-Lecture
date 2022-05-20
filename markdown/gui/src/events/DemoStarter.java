package events;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Rahmen für die Listener-Demos */
public final class DemoStarter {
    /** Erzeuge die Komponenten in neuem EDT-Job statt im main()-Tread */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame("Listener Demo");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        // frame.setContentPane(new MouseListenerDemo());
                        // frame.setContentPane(new MouseAdapterDemo());
                        frame.setContentPane(new ListenerDemo());

                        frame.pack();
                        frame.setVisible(true);
                    }
                });
    }
}
