package observer;

import java.util.logging.Logger;

public class Tutor extends Person implements Observer {
    private static final Logger LOGGER = Logger.getLogger(Tutor.class.getName());

    public Tutor(String name) {
        super(name);
    }

    @Override
    public void update() {
        LOGGER.info(name + " has been notified");
    }
}
