package cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/** Demo für Command Line Arguments mit Apache Commons-CLI */
public class Args {
    /** Hier gibt's nix zu sehen, gehen Sie weiter :) */
    public static void main(String... args) throws ParseException {
        // Schritt 0: Argumente zusammenbauen (erspart die Änderung der Konfigurion in IDE)
        String[] myArgs = new String[]{"--breite=12", "-y", "99", "--answer='wuppie'", "-d"};

        // Schritt 1: Optionen basteln
        // https://commons.apache.org/proper/commons-cli/javadocs/api-release/org/apache/commons/cli/Options.html
        // https://commons.apache.org/proper/commons-cli/javadocs/api-release/org/apache/commons/cli/Option.html
        Options opts = new Options();

        // short+long+arg: "-x 12" oder "--breite=12"
        opts.addOption("x", "breite", true, "Angabe der Breite");
        // short+arg: "-y 99"
        opts.addOption("y", true, "Angabe der Hoehe");
        // long+arg: "--answer=wuppie": Builder notwendig, da addOption nur Short ("-x") ODER Short _und_ Long ("--xxxx")
        opts.addOption(Option.builder()
                .longOpt("answer")
                .desc("Angabe der Defaultantwort")
                .hasArg()
                .build());
        // short: "-d"
        opts.addOption("d", false, "Debugmodus setzen");

        // Schritt 2: Parser bauen und ausfuehren
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(opts, myArgs);

        // Schritt 3: Ergebnisse abfragen (Beispiele)
        if (cmd.hasOption("x")) {
            int breite = Integer.parseInt(cmd.getOptionValue("x"));
        }
        if (cmd.hasOption("breite")) {
            int breite = Integer.parseInt(cmd.getOptionValue("breite"));
        }
        if (cmd.hasOption("answer")) {
            String antwort = cmd.getOptionValue("answer");
        }
        if (cmd.hasOption("d")) {
            boolean debug = Boolean.parseBoolean(cmd.getOptionValue("debug"));
        }

        // Schritt 4: Hilfe ausgegeben (bei Bedarf)
        HelpFormatter help = new HelpFormatter();
        help.printHelp("Demo Apache Commons-CLI", opts);
    }
}
