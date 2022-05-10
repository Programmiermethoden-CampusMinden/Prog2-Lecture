package reflection;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Demo für das Laden von Klassen über einen zweiten Class-Loader
 *
 * <p>Für diese Demo wird angenommen, dass sich die compilierte Klasse reflection.Studi
 * (d.h. reflection/Studi.class) NICHT im normalen Classpath befindet.
 * => Vor der Demo aus dem bin-Ordner, wo die IDE die compilierten Dateien ablegt, entfernen!
 *
 * <p>Stattdessen wird die compilierte Klasse unter dem Pfad /home/user/Schreibtisch/ erwartet.
 * => Vor der Demo dort manuell kompilieren!
 */
public class ClassLoaderDemo {
    public static void main(String[] argv) throws ClassNotFoundException, MalformedURLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // URL-Array für neuen Class-Loader basteln
        File folder = new File("/home/user/Schreibtisch/");  // Smell! Absoluter Pfad ...
        URL[] ua = new URL[]{folder.toURI().toURL()};

        // neuer Class-Loader
        URLClassLoader ucl = URLClassLoader.newInstance(ua);

        // Klasse von "extern" laden
        Class<?> c1 = Class.forName("reflection.Studi", true, ucl);

        // Klasse von "extern" laden: Alternativer Weg
        Class<?> c2 = ucl.loadClass("reflection.Studi");

        // Ab hier dann "normale" Reflection
        Object eve = c1.getDeclaredConstructor().newInstance();
        Method m = c1.getDeclaredMethod("hello");
        m.invoke(eve);
    }
}
