package MP02;

public class Worker extends Person {
    private int id;

    public Worker(int id, String name, String surname) {
        super(name, surname);
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
