import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] arguments) throws NoSuchFieldException, SecurityException {
        AnnotateClass something = new AnnotateClass();
        
        System.out.println(ClassInfo.revision);
        System.out.println(ClassInfo.isChecked);
        System.out.println(ClassInfo.class);
        
        Annotation[] annotation = something.getClass().getAnnotations();
        for(int i = 0; i < annotation.length; i++) {
            System.out.println(annotation[i]);
        }
        
        
        // Second way of writing the above code...!
        for(Annotation a : something.getClass().getAnnotations()){
            System.out.println(a.toString());
        }
        
        // Third way off writing the above code...!
        System.out.println(something.getClass().getAnnotation(ClassInfo.class));
                
        Field[] fields = ClassInfo.class.getFields();
        for(Field field : fields){
            System.out.println("method = " + field.getName());
        }
        
        Field field = ClassInfo.class.getField("revision");
        System.out.println("Revision Field: " + field);
        
        ClassInfo ca =  AnnotateClass.class.getAnnotation(ClassInfo.class);
        System.out.println("Author: " + ca.author());
        
    }
}
