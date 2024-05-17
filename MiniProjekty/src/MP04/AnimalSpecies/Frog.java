package MP04.AnimalSpecies;

import MP04.Animal;
import MP04.AnimalType;
import MP04.AnimalTypes.WaterLandAnimal;

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
