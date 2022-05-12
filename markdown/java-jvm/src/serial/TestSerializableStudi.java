package serial;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class TestSerializableStudi {
    @Test
    public void testSerializeStudi() throws IOException, ClassNotFoundException {
        // Neuen Studi über Konstruktor anlegen
        SerializableStudi heiner = new SerializableStudi("Heiner", 9);

        // Studi serialisieren (in Datei)
        SerializableStudi.writeObject(heiner, "studi.ser");

        // Modifiziere Eigenschaften unseres Studis
        heiner.setName("Holger");

        // Lese serialisierten Studi wieder in ein Objekt zurück: Kein Konstruktor-Aufruf!
        SerializableStudi holger = SerializableStudi.readObject("studi.ser");

        // Tests: Objekte sollten unterschiedlich sein, Werte sollten passen
        assertNotSame(holger, heiner);

        assertEquals(heiner.getName(), "Holger");
        assertEquals(heiner.getCredits(), 9);
        assertEquals(SerializableStudi.getWuppie(), 42);   // static
        assertEquals(heiner.getFluppie(), 7);   // transient

        assertEquals(holger.getName(), "Heiner");
        assertEquals(holger.getCredits(), 9);
        assertEquals(SerializableStudi.getWuppie(), 42);   // static: übernimmt Wert
        assertEquals(holger.getFluppie(), 0);   // transient: Initialisierung mit 0
    }
}
