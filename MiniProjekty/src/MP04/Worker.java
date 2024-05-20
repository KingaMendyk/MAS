package MP04;

import java.util.Set;
import java.util.TreeSet;

public class Worker extends Person {
    protected int id; //Ograniczenie {unique}
    private static Set<Integer> allIds = new TreeSet<Integer>();
    protected Hotel hotel; //Asocjacja kwalifikowana
    protected int salary;
    protected int workHours; //Ograniczenie statyczne atrybutu
    private static int maxWorkHours = 8;
    private static int minWorHours = 4;
    private Person person;
    private StaffWorker staffWorker;
    private HotelManager hotelManager;
    private WorkerType workerType;

    public Worker(){

    }

    public Worker(int id, String name, String surname) {
        super(name, surname, PersonType.Worker);
        setId(id);
    }

    public Worker(Person person){
        this.person = person;
    }

    public Worker(int id, String name, String surname, WorkerType workerType) {
        super(name, surname, PersonType.Worker);
        setId(id);
        this.workerType = workerType;
        switch(workerType){
            case Staff -> staffWorker = new StaffWorker(this);
            case Manager -> hotelManager = new HotelManager(this);
        }
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

    public void setId(int id){ //Ograniczenie {unique}
        if(allIds.contains(id)){
            System.out.println("Id must be unique!");
            id = getLatestId() + 1;
            System.out.println("Id has been changed to " + id);
            //return;
        }
        this.id = id;
        allIds.add(id);
    }

    public static int getLatestId(){
        return Integer.parseInt(allIds.toArray()[allIds.size()-1].toString());
    }

    public Hotel getHotel(){
        return hotel;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) { //Ograniczenie statyczne atrybutu
        if(workHours < minWorHours){
            System.out.println("Work hours must be at least " + minWorHours + "!");
            return;
        }
        if(workHours > maxWorkHours){
            System.out.println("Work hours must not exceed " + maxWorkHours + "!");
            return;
        }
        this.workHours = workHours;
    }

    @Override
    public String getInfo(){
        switch(workerType){
            case Staff -> {
                return staffWorker.getInfo();
            }
            case Manager -> {
                return hotelManager.getInfo();
            }
            default -> {
                return "Worker " + name + " " + surname;
            }
        }
    }
}
