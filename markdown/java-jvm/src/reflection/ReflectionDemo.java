package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo {
    public static void main(String[] argv) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        // Class
        Class<?> c1 = Class.forName("reflection.Studi");
        Class<?> c2 = Studi.class;

        // Konstruktoren
        Studi s1 = (Studi) c1.getDeclaredConstructor().newInstance();

        Class<?>[] paramTypes = new Class<?>[]{String.class};
        Studi s2 = (Studi) c2.getDeclaredConstructor(paramTypes).newInstance("Heinz");

        // Attribute
        Field[] allFields = c1.getDeclaredFields();

        for (Field f : allFields) {
            System.out.println(f.toGenericString());
            System.out.println("  Modifiers:  " + Modifier.toString(f.getModifiers()));
        }
        System.out.println();

        // Methoden
        Method[] allMethods = c1.getDeclaredMethods();   // all methods (excl. inherited)
        Method[] methods = c1.getMethods();              // public methods (incl. inherited)

        for (Method m : allMethods) {
            System.out.println(m.toGenericString());
            System.out.println("  Modifiers:  " + Modifier.toString(m.getModifiers()));
            System.out.println("  Parameter:  " + m.getParameterCount());


            // Variante I:  getAnnotation() plus Vergleich
            Wuppie w = m.getAnnotation(Wuppie.class);
            if (w != null) System.out.println("  Annotation (value): " + w.value());

            // Variante II: isAnnotationPresent()
            if (m.isAnnotationPresent(Wuppie.class)) System.out.println("  isAnnotationPresent(Wuppie.class): true");
        }
        System.out.println();

        // Aufruf
        String methodName = "hello";
        Method method = c1.getDeclaredMethod(methodName);

        method.setAccessible(true);
        String result = (String) method.invoke(s2);

        System.out.println("hello() via Reflection: " + result);
    }
}
