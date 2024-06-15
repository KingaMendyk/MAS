package AProjektKoncowy.AnimalSpecies;

import AProjektKoncowy.Animal;

public class Dog extends Animal {
    private static int minSeniorAge = 12;

    public Dog(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Dog(String name, String dateOfBirth, Double weight) {
        super(name, dateOfBirth, weight);
    }

    public boolean isSenior(){
        return getAge() >= minSeniorAge;
    }
}
