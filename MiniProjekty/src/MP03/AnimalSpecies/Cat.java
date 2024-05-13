package MP03.AnimalSpecies;

import MP03.Animal;
import MP03.AnimalType;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, AnimalType.Land);
    }
}
