package java2d.simplegame;

import java.awt.Color;
import java.awt.Graphics;

/** Rechteckiges Game-Objekt in blau */
public class GameRect extends GameObject {
    /**
     * Initialisiere Game-Rechteck
     *
     * @param x x-Position
     * @param y y-Position
     * @param deltaX verschiebe Objekt pro Schritt um diese Distanz entlang der x-Achse
     */
    public GameRect(int x, int y, int deltaX) {
        super(x, y, deltaX);
    }

    /** Zeichne ein blaues Rechteck */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(x, y, 80, 80);
    }
}
