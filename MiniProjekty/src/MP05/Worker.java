package MP05;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Worker")
public class Worker {
    private Long id;
    private static long latestId;
    private String name;
    private String surname;
    @ManyToOne
    private Hotel hotel; //Asocjacja kwalifikowana
    private int salary;
    @OneToOne
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }
}
