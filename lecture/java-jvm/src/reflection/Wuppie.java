package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Dummy-Annotation.
 *
 * <p>Kann an Methoden angewendet werden, bleibt zur Laufzeit auswertbar.
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Wuppie {
    String value() default "wuppie";
}
