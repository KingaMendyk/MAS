package AProjektKoncowy;

import AProjektKoncowy.Enums.WorkerType;

public class HotelManager extends Worker {
    private int bonus;
    private Worker worker;

    public HotelManager(int id, String name, String surname){
        super(id, name, surname, WorkerType.Manager);
    }

    public HotelManager(Worker worker){
        this.worker = worker;
    }

    public HotelManager(Person person){
        super(person, WorkerType.Manager);
    }

    @Override
    public int getSalary() {
        return salary + bonus;
    }
}
