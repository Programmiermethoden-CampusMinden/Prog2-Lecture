package command.sketch;

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
}
