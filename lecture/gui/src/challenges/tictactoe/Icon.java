package challenges.tictactoe;

/** The Icon a player draws on the board */
public enum Icon {
    PLAYER_ONE("X"),
    PLAYER_TWO("O"),
    EMPTY("");

    private final String text;

    Icon(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
