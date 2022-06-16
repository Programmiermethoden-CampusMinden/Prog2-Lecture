package cli;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/** Demo für Properties */
public class Props {
    /** Hier gibt's nix zu sehen, gehen Sie weiter :) */
    public static void main(String... args) throws IOException {
        Properties props = new Properties();

        props.setProperty("breite", "9");
        props.setProperty("breite", "99");
        String value = props.getProperty("breite");
        props.setProperty("hoehe", "2");
        props.setProperty("gewicht", "12");
        props.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));

        props.store(new FileOutputStream("wuppie.txt"), "Hier koennten Ihre Kommentare stehen");
        props.clear();
        props.load(new FileInputStream("wuppie.txt"));
        props.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));

        props.storeToXML(new FileOutputStream("wuppie.xml"), "Hier koennten Ihre Kommentare stehen");
        props.clear();
        props.loadFromXML(new FileInputStream("wuppie.xml"));
        props.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
    }
}
