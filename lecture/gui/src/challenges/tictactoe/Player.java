package challenges.tictactoe;

public class Player {
    private final String name;
    private final Icon icon;
    private int points = 0;

    /**
     * Create a Player
     *
     * @param name Name of the Player
     * @param icon Icon of the Player (X,O)
     */
    public Player(final String name, final Icon icon) {
        this.name = name;
        this.icon = icon;
    }

    public Icon getIcon() {
        return icon;
    }

    public void incrPoint() {
        points++;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}
