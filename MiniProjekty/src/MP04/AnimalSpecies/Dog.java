package MP04.AnimalSpecies;

import MP04.Animal;
import MP04.AnimalType;
import MP04.AnimalTypes.LandAnimal;

public class Dog extends Animal {
    private static int minSeniorAge = 12;
    public Dog(String name) {
    super(name, AnimalType.Land);
    }
    public Dog(String name, int weight) {
        super(name, weight);
        super.setAnimalType(new LandAnimal(this));
    }

    public Dog(String name, String birthDate) {
        super(name, birthDate);
        super.setAnimalType(new LandAnimal(this));
    }

    @Override
    public boolean getIsSenior() {
        return getAge() > minSeniorAge;
    }
}
