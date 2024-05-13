package MP03.AnimalSpecies;

import MP03.Animal;
import MP03.AnimalType;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, AnimalType.Land);
    }

    public Cat(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void feed() {
        if(getWeight() > 10)
            foodAmount = 5;
        else
            foodAmount = 10;
    }
}
