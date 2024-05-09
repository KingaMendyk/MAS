package MP03;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Person {
    private List<Animal> animals = new ArrayList<Animal>(); //Asocjacja zwykła

    public Owner(String name, String surname){
        super(name, surname, PersonType.Owner);
    }

    public Owner(Person person){
        super(person.name, person.surname, PersonType.Owner);
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

    public List<Animal> getAnimals(){
        return animals;
    }

    @Override
    public String getInfo(){
        StringBuilder animalString = new StringBuilder();
        for (Animal animal : animals) {
            animalString.append(animal).append(", ");
        }
        animalString.deleteCharAt(animalString.length()-1);
        return "Owner " + super.getInfo() + ", animals: {" + animalString + "}";
    }
}
