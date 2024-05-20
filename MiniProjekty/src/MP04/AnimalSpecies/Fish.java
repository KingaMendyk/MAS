package MP04.AnimalSpecies;

import MP04.Animal;
import MP04.AnimalType;
import MP04.AnimalTypes.WaterAnimal;

public class Fish extends Animal {
    public Fish(String name) {
        super(name, AnimalType.Water);
    }
    public Fish(String name, int weight) {
        super(name, weight);
        super.setAnimalType(new WaterAnimal(this));
    }

}
