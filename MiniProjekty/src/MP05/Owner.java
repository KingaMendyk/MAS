package MP05;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Owner")
@Embeddable
public class Owner extends Person {
    private List<Animal> animals = new ArrayList<Animal>(); //Asocjacja zwykła
    private Person person;

    public Owner() {

    }

    public Owner(String name, String surname){
        super(name, surname, PersonType.Owner);
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

    @Embedded
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String getInfo(){
        StringBuilder animalString = new StringBuilder();
        if(animals.size() > 0) {
            for (Animal animal : animals) {
                animalString.append(animal).append(", ");
            }
            animalString.deleteCharAt(animalString.length() - 1);
        }
        return "Owner " + name + " " + surname + ", animals: {" + animalString + "}";
    }
}
