package MP05;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "MP05.Worker")
public class Worker {
    @Id
    private Long id;
    private static long latestId;
    private String name;
    private String surname;
    private Hotel hotel; //Asocjacja kwalifikowana
    private int salary;
    private Person person;

    public Worker() {

    }

    public Worker(long id, String name, String surname) {
        new Worker(new Person(name, surname, PersonType.Worker));
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

    public static long getLatestId(){
        return latestId;
    }

    @ManyToOne
    public Hotel getHotel(){
        return hotel;
    }

    @OneToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getInfo(){
        return "Worker " + name + " " + surname + ", id: " + id + ", hotel: " + (hotel == null ? "no hotel" : hotel.getName());
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
