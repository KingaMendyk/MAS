package AProjektKoncowy;

import AProjektKoncowy.Enums.PersonType;
import AProjektKoncowy.Enums.WorkerType;

public abstract class Worker extends Person{
    protected int id;
    protected int salary;
    protected int workHours;
    private static int minWorkHours = 4;
    private static int maxWorkHours = 8;
    private WorkerType workerType;
    private Person person;
    private Hotel hotel;

    protected Worker(){

    }

    public Worker(int id, String name, String surname){
        super(name, surname, PersonType.Worker);
        this.id = id;
    }

    public Worker(Person person){
        name = person.name;
        surname = person.surname;
        this.person = person;
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

    public abstract int getSalary();

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}
