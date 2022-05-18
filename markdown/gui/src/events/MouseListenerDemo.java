package events;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Demo: Einsatz des MouseListeners */
public class MouseListenerDemo extends JPanel {
    private final JLabel label;

    /** Erzeuge neue Demo: Ändere die Hintergrundfarbe bei Mouse-Events */
    public MouseListenerDemo(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        frame.add(this, BorderLayout.CENTER);

        label = new JLabel("Statusleiste");
        frame.add(label, BorderLayout.SOUTH);

        addMouseListener(newMouseListener());
    }

    // MouseListener => *ALLE* Methoden aus Interface implementieren!
    private MouseListener newMouseListener() {
        return new MouseListener() { // anonyme innere Klasse
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Clicked: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("Pressed: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("Released: (" + e.getX() + ", " + e.getY() + ")");
            }

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
