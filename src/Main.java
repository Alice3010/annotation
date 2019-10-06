public class Main {
    public static void main(String[] ags) {
        StringBuilder stringBuilder = new StringBuilder();
        Reflect reflect = new Reflect();
        reflect.printClass(AnnotationDemo.class, stringBuilder);
        System.out.println("----->");
        System.out.println(stringBuilder);

    }
}
