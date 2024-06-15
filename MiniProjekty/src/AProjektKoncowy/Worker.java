package AProjektKoncowy;

import AProjektKoncowy.Enums.WorkerType;
import AProjektKoncowy.Enums.PersonType;

import java.util.ArrayList;
import java.util.List;

public abstract class Worker extends Person{
    protected int id;
    private static List<Integer> allIds = new ArrayList<>();
    protected int salary;
    protected int workHours;
    private static int minWorkHours = 4;
    private static int maxWorkHours = 8;
    private WorkerType workerType;
    private Person person;
    private StaffWorker staffWorker;
    private HotelManager manager;
    private Hotel hotel;

    protected Worker(){

    }

    public Worker(int id, String name, String surname, WorkerType workerType){
        super(name, surname, PersonType.Worker);
        setId(id);
        this.workerType = workerType;
        switch(workerType){
            case StaffWorker -> staffWorker = new StaffWorker(this);
            case Manager -> manager = new HotelManager(this);
        }
    }

    public Worker(Person person, WorkerType workerType){
        name = person.name;
        surname = person.surname;
        this.person = person;
        this.workerType = workerType;
    }

    public void becomeManager(){

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

    private void setId(int newId){
        if(allIds.contains(newId)){
            newId = allIds.get(allIds.size()-1) + 1;
        }
        this.id = newId;
        allIds.add(newId);
    }

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
