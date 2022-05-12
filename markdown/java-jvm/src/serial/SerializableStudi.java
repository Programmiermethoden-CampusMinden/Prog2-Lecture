package serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class SerializableStudi implements Serializable {
    static final long serialVersionUID = 42L;

    private static int wuppie;
    private final transient int fluppie;

    private final int credits;
    private String name;

    SerializableStudi() {
        this("", 0);

        final Logger LOG = Logger.getLogger(SerializableStudi.class.getName());
        LOG.info("Default-Konstruktor von SerializableStudi");
    }

    SerializableStudi(String n, int c) {
        name = n;
        credits = c;
        wuppie = 42;
        fluppie = 7;

        final Logger LOG = Logger.getLogger(SerializableStudi.class.getName());
        LOG.info("Konstruktor von SerializableStudi mit (" + n + ", " + c + ")");
    }

    public static void writeObject(SerializableStudi studi, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            out.writeObject(studi);
            out.flush();
            out.close();
        } catch (IOException ex) {
            final Logger LOG = Logger.getLogger(SerializableStudi.class.getName());
            LOG.severe("Konnte Objekt nicht serialisieren");
        }
    }

    public static SerializableStudi readObject(String filename) {
        SerializableStudi studi = null;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            studi = (SerializableStudi) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            final Logger LOG = Logger.getLogger(SerializableStudi.class.getName());
            LOG.severe("Konnte Objekt nicht de-serialisieren");
        }
        return studi;
    }

    public static int getWuppie() {
        return wuppie;
    }

    public int getFluppie() {
        return fluppie;
    }

    public int getCredits() {
        return credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
