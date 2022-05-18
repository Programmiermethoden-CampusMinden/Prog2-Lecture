package widgets;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Rahmen für die Widget-Demos */
public class DemoStarter {
    /** Erzeuge die Komponenten in neuem EDT-Job statt im main()-Tread */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame("Widget Demo");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        // frame.setContentPane(new RadioButtonDemo());
                        // frame.setContentPane(new FileChooserDemo());
                        // frame.setContentPane(new TabbedPaneDemo());
                        frame.setContentPane(new PopupDemo());

                        frame.pack();
                        frame.setVisible(true);
                    }
                });
    }
}
