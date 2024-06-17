package ProjektKoncowy;

import ProjektKoncowy.Enums.WorkerType;

public class HotelManager extends Worker {
    private int bonus;
    private Worker worker;

    public HotelManager(int id, String name, String surname){
        super(id, name, surname, WorkerType.Manager);
        setManager(this);
    }

    public HotelManager(Worker worker){
        this.worker = worker;
    }

    public HotelManager(Person person){
        super(person, WorkerType.Manager);
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        return salary + bonus;
    }
}
