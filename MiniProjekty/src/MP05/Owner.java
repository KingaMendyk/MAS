package MP05;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Owner")
public class Owner {
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animals = new ArrayList<Animal>(); //Asocjacja zwykła
    @OneToOne
    private Person person;
    private Long id;
    private String name;
    private String surname;

    public Owner() {

    }

    public Owner(String name, String surname){
        new Owner(new Person(name, surname, PersonType.Owner));
    }

    public Owner(Person person){
        name = person.name;
        surname = person.surname;
        this.person = person;
    }

    public void addAnimal(Animal animal){
        if(!animals.contains(animal)){
            animals.add(animal);
            animal.setOwner(this);
        }
    }

    public void removeAnimal(Animal animal){
        if(animals.contains(animal)){
            animals.remove(animal);
            animal.removeOwner();
        }
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Animal> getAnimals(){
        return animals;
    }

    @OneToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
