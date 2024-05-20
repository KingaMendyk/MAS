package MP04.AnimalSpecies;

import MP04.Animal;
import MP04.AnimalType;
import MP04.AnimalTypes.LandAnimal;

public class Dog extends Animal {
    public Dog(String name) {
    super(name, AnimalType.Land);
    }
    public Dog(String name, int weight) {
        super(name, weight);
        super.setAnimalType(new LandAnimal(this));
    }
}
