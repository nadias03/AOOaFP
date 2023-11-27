import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// which kind of Java element this annotation is valid to be used on
@Target(ElementType.TYPE)   // klasy i metody

@Retention(RetentionPolicy.RUNTIME)
public @interface VeryImportant {
}
