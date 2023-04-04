package challenges.tictactoe;

public class TicTacToe {
    private final int MAX_TURNS = 9;
    private final Icon[][] gameField;
    private final Player playerA;
    private final Player playerB;
    private Gamestate currentGamestate = Gamestate.CONTINUE;
    private Player currentPlayer;
    private int turn = 0;

    /**
     * Create a game of TicTacToe
     *
     * @param a Player A (this player always starts)
     * @param b Player B
     */
    public TicTacToe(final Player a, final Player b) {
        playerA = a;
        playerB = b;
        currentPlayer = a;
        gameField = new Icon[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                gameField[x][y] = Icon.EMPTY;
            }
        }
    }

    /**
     * Let the current player make a move
     *
     * @param x x-postion of the field
     * @param y y-positon of the field
     * @return whether the move was valid or not
     */
    public final boolean makeMove(final int x, final int y) {
        if (gameField[x][y] == Icon.EMPTY) {
            gameField[x][y] = currentPlayer.getIcon();
            turn++;
            calcGameState(currentPlayer, x, y);
            switchCurrentPlayer();
            return true;
        }
        return false;
    }

    /**
     * Calculate game state
     *
     * @param player last player move
     * @param x last move
     * @param y last move
     */
    private final void calcGameState(Player player, int x, int y) {
        // can´t win in under 5 turns
        if (turn < 5) {
            currentGamestate = Gamestate.CONTINUE;
        }

        // check for win
        if (checkColumn(player, x)
                || checkRow(player, y)
                || checkDiagonal(player, x, y)
                || checkAntiDiagonal(player, x, y)) {
            if (player == playerA) {
                currentGamestate = Gamestate.PLAYER1_WON;
            } else {
                currentGamestate = Gamestate.PLAYER2_WON;
            }
            player.incrPoint();
        } else if (turn == MAX_TURNS) {
            currentGamestate = Gamestate.TIE;
        } else {
            currentGamestate = Gamestate.CONTINUE;
        }
    }

    private final boolean checkAntiDiagonal(Player player, int x, int y) {
        if (x + y == 3 - 1) {
            for (int i = 0; i < 3; i++) {
                if (gameField[i][(3 - 1) - i] != player.getIcon()) {
                    break;
                }
                if (i == 3 - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean checkDiagonal(Player player, int x, int y) {
        if (x == y) {
            // we're on a diagonal
            for (int i = 0; i < 3; i++) {
                if (gameField[i][i] != player.getIcon()) {
                    break;
                }
                if (i == 3 - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean checkRow(Player player, int y) {
        for (int i = 0; i < 3; i++) {
            if (gameField[i][y] != player.getIcon()) {
                break;
            }
            if (i == 3 - 1) {
                return true;
            }
        }
        return false;
    }

    private final boolean checkColumn(Player player, int x) {
        for (int i = 0; i < 3; i++) {
            if (gameField[x][i] != player.getIcon()) {
                break;
            }
            if (i == 3 - 1) {
                return true;
            }
        }
        return false;
    }

    private final void switchCurrentPlayer() {
        if (currentPlayer == playerA) {
            currentPlayer = playerB;
        } else currentPlayer = playerA;
    }

    public final Player getPlayerA() {
        return playerA;
    }

    public final Player getPlayerB() {
        return playerB;
    }

    /** @return the current gamefield */
    public final Icon[][] getGameField() {
        return gameField;
    }

    public final Player getCurrentPlayer() {
        return currentPlayer;
    }

    /** @return winner, tie, still playing */
    public final Gamestate getCurrentGamestate() {
        return currentGamestate;
    }
}
