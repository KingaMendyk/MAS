package MP03.AnimalSpecies;

import MP03.Animal;
import MP03.AnimalType;
import MP03.AnimalTypes.LandAnimal;
import MP03.AnimalTypes.WaterAnimal;

public class Fish extends Animal {
    public Fish(String name) {
        super(name, AnimalType.Water);
    }
    public Fish(String name, int weight) {
        super(name, weight);
        super.setAnimalType(new WaterAnimal(this));
    }

    @Override
    public void feed() {
        foodAmount = 5;
    }
}
