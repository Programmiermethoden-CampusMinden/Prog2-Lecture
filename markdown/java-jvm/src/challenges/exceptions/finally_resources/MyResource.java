package challenges.exceptions.finally_resources;

import java.util.Random;
import java.util.logging.Logger;

public class MyResource {
    private Logger log;
    private static Random r = new Random();

    public MyResource() {
        log = Logger.getLogger("A");
        log.info(this + " created");
    }

    public void doSomething(int parameter) throws MyException {
        open();
        if (parameter < r.nextInt()) throw new MyException("UPS");
        else log.info("Alles gut gegangen!");
    }

    private void open() {
        log.info(this + " opened");
    }
}
