package command.undo;

public class Hero implements Entity {
    @Override
    public void jump() {
        // do jump!
    }

    @Override
    public void moveTo(int x, int y) {
        // do move to (x,y)
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }
}
