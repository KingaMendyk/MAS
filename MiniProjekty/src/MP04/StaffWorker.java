package MP04;

public class StaffWorker extends Worker{
    private Worker worker;

    public StaffWorker(int id, String name, String surname) {
        super(id, name, surname, WorkerType.Staff);
    }

    public StaffWorker(Worker worker){
        this.worker = worker;
    }

    @Override
    public String getInfo() {
        return "Hotel staff " + name + " " + surname + ", id: " + id + ", hotel: " + (hotel == null ? "no hotel" : hotel.getName());
    }
}
