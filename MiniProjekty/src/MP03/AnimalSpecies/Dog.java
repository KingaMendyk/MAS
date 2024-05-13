package MP03.AnimalSpecies;

import MP03.Animal;
import MP03.AnimalType;

public class Dog extends Animal {
    public Dog(String name) {
    super(name, AnimalType.Land);
    }
    public Dog(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void feed() {
        if(getWeight() > 15)
            foodAmount = 10;
        else
            foodAmount = 5;
    }
}
