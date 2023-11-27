import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunImmediately {   // bedziemy tego uzywac do metod
    int times() default 1;   // potrzebujemy '()' jak w metodzie, ale w praktyce to sie zachowuje jak normalne pole
}
