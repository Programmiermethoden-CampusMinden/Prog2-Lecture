package challenges.command;

import java.util.logging.Logger;

public class Dwarf {
    private int x;
    private int jumpcount = 0;
    private Logger logger;

    /**
     * Erstellt einen Zwerg
     */
    public Dwarf() {
        logger = Logger.getLogger(this.getClass().getName());
    }

    /**
     * Bewegt den Zwerg entlang der X-Achse in die Richtung die Angegeben wurde.
     * @param dir in welche sich der Zwerg bewegen soll.
     */
    public void moveX(Direction dir) {
        x += dir == Direction.left ? -10 : +10;
        logger.info("Neue Position des Zwerges = " + x);
    }

    /**
     * Simuliert das der Zwerg springt.
     */
    public void jump() {
        jumpcount++;
        logger.info("Zwerg ist bereits " + jumpcount + " mal gesprungen.");
    }

    /**
     * Simuliert das sich der Zwerg duckt.
     */
    public void duck() {
        logger.info("Der Zwerg duckt sich!");
    }
}
