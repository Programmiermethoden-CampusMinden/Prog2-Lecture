package java2d.simplegame;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/** Erzeuge eine Demo mit bewegten Objekten */
public final class J2DTeaser extends JPanel {
    private final GameObject[] gameObjs;
    private Timer t = null;

    private J2DTeaser() {
        super();

        gameObjs =
                new GameObject[] {
                    new GameRect(20, 20, 20), new GameOval(20, 120, 10), new GameString(20, 220, 1)
                };

        addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        doOneTick();
                    }
                });
    }

    /** Erzeuge ein neues Demo-Objekt und ziehe den Timer auf */
    public static J2DTeaser newJ2DTeaser() {
        J2DTeaser o = new J2DTeaser();
        o.startTimer(2000);
        return o;
    }

    private void startTimer(int i) {
        t = new Timer(i, e -> doOneTick());
        t.start();
    }

    /** Zeichne alle Objekte neu: Wird bei einem Repaint-Event aufgerufen */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Lasse alle "registrierten" Objekte sich neu zeichnen
        for (GameObject go : gameObjs) {
            go.paintTo(g);
        }
    }

    /** Mache einen Schritt in der Game-Loop */
    private synchronized void doOneTick() {
        // Lasse alle "registrierten" Objekte die neue Position berechnen
        move();
        // Führe Prüfungen durch
        checks();
        // Löse ein Repaint-Event für die Komponente (Panel) aus
        repaint();
    }

    // Lasse alle "registrierten" Objekte die neue Position berechnen
    private void move() {
        for (GameObject go : gameObjs) {
            go.move();
        }
    }

    // Führe Prüfungen durch
    private void checks() {
        for (GameObject g1 : gameObjs) {
            for (GameObject g2 : gameObjs) {
                if (g1 != g2 && g1.intersects(g2)) {
                    reactWhenTouching(g1, g2);
                }
            }
        }
    }

    // Verhalten bei Kollision
    private void reactWhenTouching(GameObject g1, GameObject g2) {
        g1.turn();
        g1.move();
        g2.turn();
        g2.move();
    }
}
