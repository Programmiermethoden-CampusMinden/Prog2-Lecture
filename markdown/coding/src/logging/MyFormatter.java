package logging;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

class MyFormatter extends SimpleFormatter {
    private final String name;

    public MyFormatter(String n) {
        name = n;
    }

    @Override
    public String format(LogRecord record) {
        return "---- " + name + " ::" + record.getMessage() + ":: " + name + " ----\n";
    }
}
