package MP03;

public class Worker extends Person {
    private int id;
    private static int latestId;
    private Hotel hotel; //Asocjacja kwalifikowana
    private int salary;

    public Worker(int id, String name, String surname) {
        super(name, surname, PersonType.Worker);
        this.id = id;
        latestId = id;
    }

    public void addHotel(Hotel hotel){
        if(this.hotel == null){
            this.hotel = hotel;
            hotel.addWorker(this);
        }
    }

    public void removeHotel(){
        if(hotel != null){
            hotel.removeWorker(this);
            hotel = null;
        }
    }

    public int getId(){
        return id;
    }

    public static int getLatestId(){
        return latestId;
    }

    public Hotel getHotel(){
        return hotel;
    }

    @Override
    public String getInfo(){
        return "Worker " + super.getInfo() + ", id:" + id + ", hotel: " + (hotel == null ? "no hotel" : hotel.getName());
    }
}
