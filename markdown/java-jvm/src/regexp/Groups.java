package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Demo für Gruppen */
public class Groups {
    /** Starter - use the debugger */
    public static void main(String[] args) {
        Pattern p = Pattern.compile(".*((\\d+)\\s*A).*");
        Matcher m = p.matcher("A 12 A 45 A");

        if (m.matches()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                m.group(i); // i. Gruppe
            }
        }
    }
}
