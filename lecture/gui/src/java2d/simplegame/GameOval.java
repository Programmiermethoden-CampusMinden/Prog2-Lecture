package java2d.simplegame;

import java.awt.Color;
import java.awt.Graphics;

/** Ovales Game-Objekt in grün */
public class GameOval extends GameObject {
    /**
     * Initialisiere Game-Oval
     *
     * @param x x-Position
     * @param y y-Position
     * @param deltaX verschiebe Objekt pro Schritt um diese Distanz entlang der x-Achse
     */
    public GameOval(int x, int y, int deltaX) {
        super(x, y, deltaX);
    }

    /** Zeichne ein grünes Oval */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 80, 80);
    }
}
