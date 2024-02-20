package command.undo;

public interface Command {
    void execute();

    Command newCommand(Entity e);

    void undo();
}
