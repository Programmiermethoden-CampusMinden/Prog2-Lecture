package command.undo;

public interface Entity {
    void jump();

    void moveTo(int x, int y);

    int getX();

    int getY();
}
