package MP04.AnimalSpecies;

import MP04.Animal;
import MP04.AnimalType;
import MP04.AnimalTypes.FlyingAnimal;

public class Parrot extends Animal {

    public Parrot(String name) {
        super(name, AnimalType.Flying);
    }
    public Parrot(String name, int weight) {
        super(name, weight);
        super.setAnimalType(new FlyingAnimal(this));
    }

}
