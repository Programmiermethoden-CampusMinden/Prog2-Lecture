package command.undo;

import java.util.Stack;

/** Beispielcode für die Folien */
public class InputHandler3 {
    private final Command wbutton;
    private final Command abutton;
    private final Stack<Command> s = new Stack<>();

    public InputHandler3(Command wbutton, Command abutton) {
        this.wbutton = wbutton;
        this.abutton = abutton;
    }

    public void handleInput() {
        Entity e = getSelectedEntity();

        switch (isPressed()) {
            case BUTTON_W -> {
                s.push(wbutton.newCommand(e));
                s.peek().execute();
            }
            case BUTTON_A -> {
                s.push(abutton.newCommand(e));
                s.peek().execute();
            }
            case BUTTON_U -> s.pop().undo();
            default -> {}
        }
    }

    private Entity getSelectedEntity() {
        return new Hero(); // Dummy
    }

    private Buttons isPressed() {
        return Buttons.BUTTON_W;
    }
}
