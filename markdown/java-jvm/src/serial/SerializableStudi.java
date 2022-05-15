package serial;

import java.io.*;
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
        try (FileOutputStream fos = new FileOutputStream(filename); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(studi);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            final Logger LOG = Logger.getLogger(SerializableStudi.class.getName());
            LOG.severe("Konnte Objekt nicht serialisieren");
        }
    }

    public static SerializableStudi readObject(String filename) {
        SerializableStudi studi = null;
        try (FileInputStream fis = new FileInputStream(filename); ObjectInputStream ois = new ObjectInputStream(fis)) {
            studi = (SerializableStudi) ois.readObject();
            ois.close();
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
