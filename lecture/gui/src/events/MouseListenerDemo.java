package events;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import javax.swing.JPanel;

/** Demo: Einsatz des MouseListeners */
public final class MouseListenerDemo extends JPanel {
    private static final Logger LOG = Logger.getLogger(MouseListenerDemo.class.getName());

    /** Erzeuge neue Demo: Ändere die Hintergrundfarbe bei Mouse-Events */
    public MouseListenerDemo() {
        super();

        setBackground(Color.WHITE);
        addMouseListener(newMouseListener());
    }

    // MouseListener => *ALLE* Methoden aus Interface implementieren!
    private MouseListener newMouseListener() {
        return new MouseListener() { // anonyme innere Klasse
            @Override
            public void mouseClicked(MouseEvent e) {
                LOG.info("Clicked: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                LOG.info("Pressed: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                LOG.info("Released: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                LOG.info("Entered at: (" + e.getX() + ", " + e.getY() + ")");
                setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LOG.info("Exited");
                setBackground(Color.WHITE);
            }
        };
    }
}
