package java2d.simplegame;

import java.awt.Graphics;

/** Basisklasse für einfache "Game"-Objekte */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int deltaX;

    /**
     * Initialisiere Game-Objekt
     *
     * @param x x-Position
     * @param y y-Position
     * @param deltaX verschiebe Objekt pro Schritt um diese Distanz entlang der x-Achse
     */
    public GameObject(int x, int y, int deltaX) {
        this.x = x;
        this.y = y;
        this.deltaX = deltaX;
    }

    /** Mache einen Schritt: Berechne neue Position des Objekts (Verschiebung entlang x-Achse) */
    public void move() {
        x += deltaX;
    }

    /** Bewegungsrichtung umkehren */
    public void turn() {
        deltaX = -deltaX;
    }

    /**
     * Berühren sich zwei Objekte?
     *
     * @param g Zweites GameObject zur Prüfung auf Berührung
     * @return true, wenn sich die Objekte berühren
     */
    public boolean intersects(GameObject g) {
        return false;
    }

    /**
     * Template-Methode: Wird in <code>paintComponent</code> aufgerufen und zeichnet Objekt (neu)
     *
     * <p>Macht eine Art "Kollisionserkennung": Wenn das Objekt zu weit nach rechts gewandert ist,
     * soll es wieder am linken Fensterrand "hereinkommen". Danach wird dann die von den Subklassen
     * implementierte Methode zum tatsächlichen Zeichnen aufgerufen.
     */
    public final void paintTo(Graphics g) {
        if (x > 380) {
            x = 20;
        }

        draw(g);
    }

    /** Helper-Methode: Wie soll sich ein Objekt tatsächlich zeichnen? */
    public abstract void draw(Graphics g);
}
