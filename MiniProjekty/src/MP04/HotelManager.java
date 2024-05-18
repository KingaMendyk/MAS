package MP04;

public class HotelManager extends Worker{
    private Worker worker;

    public HotelManager(int id, String name, String surname) {
        super(id, name, surname, WorkerType.Manager);
    }

    public HotelManager(Worker worker){
        this.worker = worker;
    }

    @Override
    public String getInfo() {
        return "Hotel manager " + name + " " + surname + ", id: " + id + ", hotel: " + (hotel == null ? "no hotel" : hotel.getName());
    }
}
