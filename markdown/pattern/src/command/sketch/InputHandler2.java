package command.sketch;

/** Beispielcode für die Folien */
public class InputHandler2 {
    private final Command wbutton;
    private final Command abutton;

    public InputHandler2(Command wbutton, Command abutton) {
        this.wbutton = wbutton;
        this.abutton = abutton;
    }

    public void handleInput() {
        switch (isPressed()) {
            case BUTTON_W -> wbutton.execute();
            case BUTTON_A -> abutton.execute();
            default -> {}
        }
    }

    private Buttons isPressed() {
        return Buttons.BUTTON_W;
    }
}
