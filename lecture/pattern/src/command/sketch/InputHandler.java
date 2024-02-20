package command.sketch;

/** Beispielcode für die Folien */
public class InputHandler {
    private final Entity hero = new Hero();

    public void handleInput() {
        switch (isPressed()) {
            case BUTTON_W -> hero.jump();
            case BUTTON_A -> hero.moveX();
            default -> {}
        }
    }

    private Buttons isPressed() {
        return Buttons.BUTTON_W;
    }
}
