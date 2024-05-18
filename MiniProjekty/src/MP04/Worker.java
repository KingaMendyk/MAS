package MP04;

public class Worker extends Person {
    private int id;
    private static int latestId;
    private Hotel hotel; //Asocjacja kwalifikowana
    private int salary;
    private int workHours; //Ograniczenie statyczne atrybutu
    private static int maxWorkHours;
    private static int minWorHours;
    private Person person;
    private WorkerType workerType;

    public Worker(int id, String name, String surname) {
        super(name, surname, PersonType.Worker);
        this.id = id;
        latestId = id;
    }

    public Worker(Person person){
        name = person.name;
        surname = person.surname;
        this.id = Worker.getLatestId() + 1;
        latestId = id;
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

    public int getId(){
        return id;
    }

    public static int getLatestId(){
        return latestId;
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
        return "Worker " + name + " " + surname + ", id: " + id + ", hotel: " + (hotel == null ? "no hotel" : hotel.getName());
    }
}
