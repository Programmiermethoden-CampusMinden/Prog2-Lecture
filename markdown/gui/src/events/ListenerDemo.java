package events;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/** Rahmen für die Listener-Demos */
public class ListenerDemo {
    /** Erzeuge die Komponenten in neuem EDT-Job statt im main()-Tread */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame("Listener Demo");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        JPanel contentPane = new MouseListenerDemo(frame);
                        // JPanel contentPane = new MouseAdapterDemo(frame);
                        // JPanel contentPane = new ListenerPanel();

                        frame.add(contentPane);
                        frame.pack();
                        frame.setVisible(true);
                    }
                });
    }
}
