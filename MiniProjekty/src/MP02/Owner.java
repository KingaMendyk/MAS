package MP02;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Person {
    private List<Animal> animals = new ArrayList<Animal>(); //Asocjacja zwykła

    public Owner(String name, String surname){
        super(name, surname);
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
}
