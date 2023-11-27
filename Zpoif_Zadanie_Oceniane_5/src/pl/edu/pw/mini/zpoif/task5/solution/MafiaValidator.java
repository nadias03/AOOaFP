package pl.edu.pw.mini.zpoif.task5.solution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface MafiaValidator {
    boolean notEmpty() default true;
    int maxLength() default 5;
}
