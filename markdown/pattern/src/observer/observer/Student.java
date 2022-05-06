package observer;

import java.util.logging.Logger;

public class Student extends Person implements Observer {
    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

    public Student(String name) {
        super(name);
    }

    @Override
    public void update() {
        LOGGER.info(name + " has been notified");
    }
}
