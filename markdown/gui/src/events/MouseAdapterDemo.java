package events;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Demo: Einsatz des MouseAdapters */
public class MouseAdapterDemo extends JPanel {
    private final JLabel label;

    /** Erzeuge neue Demo: Ändere die Hintergrundfarbe bei Mouse-Events */
    public MouseAdapterDemo(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        frame.add(this, BorderLayout.CENTER);

        label = new JLabel("Statusleiste");
        frame.add(label, BorderLayout.SOUTH);

        addMouseListener(newMouseAdapter());
    }

    // MouseAdapter => nur *benötigte* Methoden implementieren!
    private MouseListener newMouseAdapter() {
        return new MouseAdapter() { // anonyme innere Klasse
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Entered at: (" + e.getX() + ", " + e.getY() + ")");
                setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Exited");
                setBackground(Color.WHITE);
            }
        };
    }
}
