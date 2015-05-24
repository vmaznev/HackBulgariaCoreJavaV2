import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface ClassInfo {
    String author();
    int revision = 1;
    boolean isChecked = true;
    Class<?>[] relatedClasses();
}
