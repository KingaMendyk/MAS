package MP03.AnimalSpecies;

import MP03.Animal;
import MP03.AnimalType;

public class Fish extends Animal {
    public Fish(String name) {
        super(name, AnimalType.Water);
    }
    public Fish(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void feed() {
        foodAmount = 5;
    }
}
