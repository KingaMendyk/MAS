package MP03.AnimalSpecies;

import MP03.Animal;
import MP03.AnimalType;
import MP03.AnimalTypes.LandAnimal;
import MP03.AnimalTypes.WaterLandAnimal;

public class Frog extends Animal {

    public Frog(String name) {
        super(name, AnimalType.WaterLand);
    }
    public Frog(String name, int weight) {
        super(name, weight);
        super.setAnimalType(new WaterLandAnimal(this));
    }

    @Override
    public void feed() {
        foodAmount = 4;
    }
}
