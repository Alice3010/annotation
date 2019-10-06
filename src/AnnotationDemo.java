
@Copyright("Alice Palamar")
public class AnnotationDemo {
    private Long ID;
    @Show (value="")
    String name;
    String fam;

    @Logged(value=LogType.ERROR,
            loggedClass = AnnotationDemo.class)
    public Long getID() {
        return ID;
    }

    @Logged(value=LogType.DEBUG,
            loggedClass = AnnotationDemo.class)
    public void setID(Long ID) {
        this.ID = ID;
    }

}
