package annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* Mit @Documented geht die Annotation in die generierte Javadoc */
@Documented
@interface MyFirstAnnotation {}

/* Sichtbarkeit: SOURCE, CLASS, RUNTIME */
@Retention(RetentionPolicy.RUNTIME)
/* Wo erlaubt: TYPE, CONSTRUCTOR, METHOD, ... */
@Target(ElementType.METHOD)
@interface MySecondAnnotation {
    String value();
}

/* Sichtbarkeit: SOURCE, CLASS, RUNTIME */
@Retention(RetentionPolicy.RUNTIME)
/* Wo erlaubt: TYPE, CONSTRUCTOR, METHOD, ... */
@Target(ElementType.TYPE)
@interface MyThirdAnnotation {
    String author();

    int vl() default 1;
}

@MyFirstAnnotation
@MyThirdAnnotation(author = "Carsten Gips", vl = 3)
public class C {

    @MySecondAnnotation("main")
    public static void main(String[] args) {
        // Vorgriff spaetere VL: Einsatz von Reflection
        System.out.println(C.class.isAnnotationPresent(MyFirstAnnotation.class));
        System.out.println(C.class.isAnnotationPresent(MySecondAnnotation.class));
        System.out.println(C.class.isAnnotationPresent(MyThirdAnnotation.class));
    }
}

/*
@MySecondAnnotation("wuppie") // NUR an Methoden erlaubt
class D {}
*/

/*
@MySecondAnnotation(value = "wuppie") // NUR an Methoden erlaubt
class E {}
*/
