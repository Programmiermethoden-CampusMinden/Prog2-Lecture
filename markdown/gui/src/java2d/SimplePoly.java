package java2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

/** Demo: Umgang mit Polygonen */
public class SimplePoly {
    /** Zeichne einfache Objekte auf einem JPanel */
    public static JPanel newDrawings() {
        return new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.WHITE);

                int[] x1 = {20, 40, 50, 30, 20, 15};
                int[] y1 = {50, 50, 60, 80, 80, 60};
                g.setColor(Color.RED);
                g.drawPolygon(x1, y1, 6);

                int[] x2 = {70, 90, 100, 80, 70, 65, 60};
                int[] y2 = {100, 100, 110, 110, 130, 110, 90};
                Polygon p = new Polygon(x2, y2, 7);
                g.setColor(Color.BLUE);
                g.fillPolygon(p);

                int[] x3 = {120, 140, 150, 190};
                int[] y3 = {40, 70, 80, 60};
                g.setColor(Color.GREEN);
                g.drawPolyline(x3, y3, 4);
            }
        };
    }
}
