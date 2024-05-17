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

    @Override
    public void feed() {
        if(getWeight() > 5)
            foodAmount = 3;
        else
            foodAmount = 5;
    }
}
