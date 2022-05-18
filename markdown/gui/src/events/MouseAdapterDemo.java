package events;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import javax.swing.*;

/** Demo: Einsatz des MouseAdapters */
public class MouseAdapterDemo extends JPanel {
    private static final Logger LOG = Logger.getLogger(MouseAdapterDemo.class.getName());

    /** Erzeuge neue Demo: Ändere die Hintergrundfarbe bei Mouse-Events */
    public MouseAdapterDemo() {
        super();

        setBackground(Color.WHITE);
        addMouseListener(newMouseAdapter());
    }

    // MouseAdapter => nur *benötigte* Methoden implementieren!
    private MouseListener newMouseAdapter() {
        return new MouseAdapter() { // anonyme innere Klasse
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
