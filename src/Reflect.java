import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {
    /**
     *
     * @param LoaderClass
     */

    // напечатать общую информацию п классе
    private void printClassCommonInfo(Class LoaderClass, StringBuilder stringBuilder) {
        //напечатать аннотаций
        Annotation[] annotations = LoaderClass.getAnnotations();
        for (Annotation annotation : annotations)
            stringBuilder.append("@" + annotation.annotationType().getSimpleName() + " " + "\n");
        stringBuilder.append(String.format("Load %s", LoaderClass));
        stringBuilder.append("\n");
    }
    // напечатать поля
    private void printFields(Field[] fields, StringBuilder stringBuilder) {
        for (Field field : fields) {
            stringBuilder.append(field);
            stringBuilder.append("\n");
        }
    }
    // напечатать методы
    private void printMethods(Method[] methods, StringBuilder stringBuilder){
        for (Method method:methods){
            //напечатать аннотаций
           // Annotation[] annotations = method.getAnnotations();
          //  for (Annotation annotation : annotations)
           //     stringBuilder.append("@" + annotation.annotationType().getSimpleName() + " " + "\n");
            stringBuilder.append(method);
            stringBuilder.append("\n");
        }
    }
    // напечатать аннотаций
    private void printAnnotation(Class LoaderClass, StringBuilder stringBuilder) {
        Annotation[] annotationsClass = LoaderClass.getDeclaredAnnotations();
        for (Annotation annotation : annotationsClass) {
            stringBuilder.append(annotation + " --> ");
            stringBuilder.append(annotation.annotationType() + " -->> ");
            stringBuilder.append(annotation.getClass() + "\n");
            stringBuilder.append("Аннотации методов\n");
            Method[] methods = LoaderClass.getDeclaredMethods();
            for (Method method : methods) {
                Annotation[] annotationsMethod = method.getDeclaredAnnotations();
                for (Annotation annotationM : annotationsMethod) {
                    stringBuilder.append(annotationM + " --> ");
                    stringBuilder.append(annotationM.hashCode() + " -->> ");
                    stringBuilder.append(annotationM.annotationType() + "\n");
                }
            }
            stringBuilder.append("Аннотации полей\n");
            Field[] fields = LoaderClass.getDeclaredFields();
            for (Field field : fields) {
                Annotation[] annotationsField = field.getDeclaredAnnotations();
                for (Annotation annotationF : annotationsField) {
                    stringBuilder.append(annotationF + " --> ");
                    stringBuilder.append(annotationF.toString() + " -->> ");
                    stringBuilder.append(annotationF.annotationType() + "\n");
                    stringBuilder.append(" -->>> " + field.getName() + "\n");
                }
            }
        }
    }

    // напечатать интерфейсы
    private void printInterfaces(Class[] interfaces, StringBuilder stringBuilder){
        for (Class interfac:interfaces){
            stringBuilder.append(interfac);
            stringBuilder.append("\n");
        }
    }
    // напечатать парент объект
    private void printSuperClass(Class SuperClass, StringBuilder stringBuilder){
        if (SuperClass.getSuperclass() != null) {
            stringBuilder.append(SuperClass.getSuperclass().getName() +"\n");
        }
    }


    public void printClass(Class LoaderClass, StringBuilder stringBuilder){
        // напечатать общую информацию п классе
        this.printClassCommonInfo(LoaderClass, stringBuilder);
        // напечатать поля
        Field[] fields = LoaderClass.getDeclaredFields();
        this.printFields(fields, stringBuilder);
        // напечатать методы
        Method[] methods =LoaderClass.getDeclaredMethods();
        this.printMethods(methods, stringBuilder);
        // напечатать аннотации
        //Annotation[] annotations = LoaderClass.getDeclaredAnnotations();
        this.printAnnotation(LoaderClass, stringBuilder);
        // напечатать интерфейсы
        Class[] interfaces = LoaderClass.getInterfaces();
        this.printInterfaces(interfaces, stringBuilder);
        // напечатать парент объект
        Class predok = LoaderClass;
        this.printSuperClass(predok, stringBuilder);
    }
}
