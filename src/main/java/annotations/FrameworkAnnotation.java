package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {

//    public String author(); // without default value (will be mandatory)
    // @FrameworkAnnotation("Someone")

//    public String author() default ""; // with default value (won't be mandatory)

    public String[] author(); // without default value (will be mandatory)
    // @FrameworkAnnotation({"Someone", "Somewho"})

    public String[] category();

}
