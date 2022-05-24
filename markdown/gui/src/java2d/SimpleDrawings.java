package java2d;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/** Demo: Umgang mit einfachen geometrischen Formen */
public final class SimpleDrawings {
    /** Zeichne einfache Objekte auf einem JPanel */
    public static JPanel newDrawings() {
        return new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                setBackground(Color.WHITE);

                g.setColor(Color.RED);
                g.drawLine(100, 20, 380, 20);

                g.setColor(Color.BLUE);
                g.drawRect(100, 40, 280, 80);
                g.fillRect(100, 130, 280, 80);

                g.setColor(Color.GREEN);
                g.drawOval(100, 220, 280, 80);
                g.fillOval(100, 310, 280, 80);
            }
        };
    }
}
