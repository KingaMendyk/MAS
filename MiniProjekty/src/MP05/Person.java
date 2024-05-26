package MP05;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Person")
public class Person implements Serializable {
    protected String name;
    protected String surname;
    @OneToOne
    private Owner owner;
    @OneToOne
    private Worker worker;

    private PersonType personType;
    private Long id;

    public Person(){

    }

    public Person(String name, String surname, PersonType type) {
        this.name = name;
        this.surname = surname;
        this.personType = type;
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

    @Transient
    public boolean isOwner(){
        return this.owner != null;
    }

    @Transient
    public boolean isWorker(){
        return this.worker != null;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Enumerated
    public PersonType getType(){return personType;}
    public void setType(PersonType personType){
        this.personType = personType;
    }
    @OneToOne
    public Owner getOwner(){
        return owner;
    }

    public void setOwner(Owner owner){
        this.owner = owner;
    }

    @OneToOne
    public Worker getWorker(){
        return worker;
    }

    public void setWorker(Worker worker){
        this.worker = worker;
    }

    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
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
