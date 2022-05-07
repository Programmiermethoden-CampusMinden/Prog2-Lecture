package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LSF {
    private static final Logger LOGGER = Logger.getLogger(LSF.class.getName());
    private final List<Observer> observers = new ArrayList<>();

    public void register(Observer o) {
        LOGGER.info("adding observer");
        observers.add(o);
    }

    public void notifyObservers() {
        LOGGER.info("notifying all observers");
        for (Observer o : observers) {
            o.update();
        }
    }
}
