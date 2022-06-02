package command.undo;

public class Move implements Command {
    private Entity e;
    private int x;
    private int y;
    private int oldX;
    private int oldY;

    public Move() {
        this(null);
        x = 0;
        y = 0;
        oldX = 0;
        oldY = 0;
    }

    public Move(Entity e) {
        this.e = e;
        x = 0;
        y = 0;
        oldX = 0;
        oldY = 0;
    }

    @Override
    public void execute() {
        oldX = e.getX();
        oldY = e.getY();
        x = oldX + 42;
        y = oldY;
        e.moveTo(x, y);
    }

    @Override
    public Command newCommand(Entity e) {
        return new Move(e);
    }

    @Override
    public void undo() {
        e.moveTo(oldX, oldY);
    }
}
