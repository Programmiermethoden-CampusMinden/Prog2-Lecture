package command.undo;

public class Jump implements Command {
    private Entity e;

    public Jump() {
        this(null);
    }

    public Jump(Entity e) {
        this.e = e;
    }

    @Override
    public void execute() {
        e.jump();
    }

    @Override
    public Command newCommand(Entity e) {
        return new Jump(e);
    }

    @Override
    public void undo() {
        // noop
    }
}
