package java2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/** Demo: Umgang mit Fonts */
public class SimpleFonts {
    /** Formatiere Zeichenketten auf einem JPanel */
    public static JPanel newWritings() {
        return new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.WHITE);

                g.setFont(new Font("Serif", Font.BOLD, 12));
                g.drawString("Serif, 12pt, fett", 20, 30);

                g.setFont(new Font("Monospaced", Font.ITALIC, 18));
                g.drawString("Mono, 18pt, schraeg", 20, 60);

                g.setColor(Color.RED);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 24));
                g.drawString("SansSerif, 24pt, fett und schraeg", 20, 90);
            }
        };
    }
}
