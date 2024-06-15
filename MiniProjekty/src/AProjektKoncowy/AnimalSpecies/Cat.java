package AProjektKoncowy.AnimalSpecies;

import AProjektKoncowy.Animal;

public class Cat extends Animal {
    private static int minSeniorAge = 15;

    public Cat(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Cat(String name, String dateOfBirth, Double weight) {
        super(name, dateOfBirth, weight);
    }

    public boolean isSenior(){
        return getAge() >= minSeniorAge;
    }
}
