package observer;

import java.util.logging.Logger;

public class Lecturer extends Person implements Observer {
    private static final Logger LOGGER = Logger.getLogger(Lecturer.class.getName());

    public Lecturer(String name) {
        super(name);
    }

    @Override
    public void update() {
        LOGGER.info(name + " has been notified");
    }
}
