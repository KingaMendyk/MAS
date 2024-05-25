package MP05;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "Person")
public class Person implements Serializable {
    protected String name;
    protected String surname;

    // Dziedziczenie overlapping za pomoca kompozycji
    private Owner owner;
    private Worker worker;
    private PersonType personType;
    @Id
    private Long id;

    public Person(){

    }

    public Person(String name, String surname, PersonType type) {
        this.name = name;
        this.surname = surname;
        this.personType = type;

        switch(type){
            case Owner -> owner = new Owner(this);
            case Worker -> worker = new Worker(this);
            case Owner_Worker -> {
                owner = new Owner(this);
                worker = new Worker(this);
            }
        }
    }

    public void becomeOwner(){
        if(!isOwner()) {
            this.owner = new Owner(this);
            if(personType == PersonType.Worker)
                personType = PersonType.Owner_Worker;
            else{
                personType = PersonType.Owner;
            }
        }
    }
    public void stopBeingOwner(){
        if(isOwner()) {
            this.owner.setPerson(null);
            this.owner = null;
            if(personType == PersonType.Owner_Worker)
                personType = PersonType.Worker;
            else{
                personType = null;
            }
        }
    }
    public void becomeWorker(){
        if(!isWorker()) {
            this.worker = new Worker(this);
            if(personType == PersonType.Owner)
                personType = PersonType.Owner_Worker;
            else{
                personType = PersonType.Worker;
            }
        }
    }
    public void stopBeingWorker(){
        if(isWorker()){
            this.worker.setPerson(null);
            this.worker = null;
            if(personType == PersonType.Owner_Worker)
                personType = PersonType.Owner;
            else{
                personType = null;
            }
        }
    }
    public boolean isOwner(){
        return this.owner != null;
    }
    public boolean isWorker(){
        return this.worker != null;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getInfo(){
        switch(personType){
            case Owner -> {
                return owner.getInfo();
            }
            case Worker -> {
                return worker.getInfo();
            }
            case Owner_Worker -> {
                return "Worker and Owner: " +
                        owner.getInfo() + " " +
                        worker.getInfo();
            }
            default -> {
                return name + " " + surname;
            }
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
