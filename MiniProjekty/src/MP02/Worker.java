package MP02;

public class Worker extends Person {
    private int id;
    private Hotel hotel;

    public Worker(int id, String name, String surname) {
        super(name, surname);
        this.id = id;
    }

    public void addHotel(Hotel hotel){
        this.hotel = hotel;
    }

    public int getId(){
        return id;
    }
}
