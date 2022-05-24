package java2d.simplegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/** String als Game-Objekt */
public class GameString extends GameObject {
    private final Random rand;
    private double rot = 0;

    /**
     * Initialisiere Game-String
     *
     * @param x x-Position
     * @param y y-Position
     * @param deltaX verschiebe Objekt pro Schritt um diese Distanz entlang der x-Achse
     */
    public GameString(int x, int y, int deltaX) {
        super(x, y, deltaX);
        rand = new Random();
    }

    /** Mache einen Schritt: Berechne neue Position (Verschiebung entlang x-Achse plus Rotation) */
    @Override
    public void move() {
        super.move();
        rot -= 0.06;
    }

    /** Zeichne einen bunten Text */
    @Override
    public void draw(Graphics g) {
        assert g instanceof Graphics2D; // just to please SpotBugs
        Graphics2D g2 = (Graphics2D) g;

        // drehe den Canvas
        g2.rotate(rot);

        // wähle eine neue Farbe
        if (rand.nextBoolean()) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.YELLOW);
        }
        // setze den Font
        g.setFont(new Font("Serif", Font.BOLD, 12));
        // schreibe den Text
        g.drawString("Serif, 12pt, fett", x, y);

        // drehe den Canvas wieder zurück
        g2.rotate(-rot);
    }
}
