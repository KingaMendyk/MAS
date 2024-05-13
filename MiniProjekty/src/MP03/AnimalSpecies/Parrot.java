package MP03.AnimalSpecies;

import MP03.Animal;
import MP03.AnimalType;
import MP03.AnimalTypes.FlyingAnimal;
import MP03.AnimalTypes.LandAnimal;

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
