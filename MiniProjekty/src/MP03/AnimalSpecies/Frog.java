package MP03.AnimalSpecies;

import MP03.Animal;
import MP03.AnimalType;

public class Frog extends Animal {

    public Frog(String name) {
        super(name, AnimalType.WaterLand);
    }
    public Frog(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void feed() {
        foodAmount = 4;
    }
}
