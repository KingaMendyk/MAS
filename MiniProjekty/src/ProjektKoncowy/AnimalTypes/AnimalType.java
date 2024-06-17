package ProjektKoncowy.AnimalTypes;


import ProjektKoncowy.Animal;

public abstract class AnimalType {
    private Animal animal;

    public AnimalType(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
