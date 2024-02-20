package challenges.command;

import java.util.logging.Logger;

public class Cursor {
    private Position p;
    private Logger logger;

    public Cursor(int x, int y) {
        this.p = new Position(x,y);
        this.logger = Logger.getLogger(this.getClass().getName());
    }

    /**
     * Moves the Cursor to the Position given
     * @param p the new Position where the Cursor should be placed at
     */
    public void move(Position p) {
        this.p.x = p.x;
        this.p.y = p.y;
        logger.info("Die aktuelle Position des Cursors ist: " + this.p);
    }

    /**
     *
     * @return returns the current Position of the Cursor
     */
    public Position getPosition() {
        return p;
    }
}
