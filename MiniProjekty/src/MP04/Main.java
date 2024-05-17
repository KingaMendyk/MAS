package MP04;

import MP04.AnimalSpecies.*;

public class Main {
    public static void main(String[] args) {
        //disjoint
        Cat cat = new Cat("Mruczek", 10);
        Dog dog = new Dog("Burek", 16);
        Parrot parrot = new Parrot("Ziutek", 4);
        Animal fish = new Fish("Nemo", 2);
        Animal frog = new Frog("Robal", 4);

        for (Animal animal : Animal.getAllAnimals()) {
            animal.feed();
            System.out.println(animal.getName() + " food amount: " + animal.getFoodAmount());
        }
        System.out.println();

        //overlapping
        //dynamic
        Person person1 = new Person("Adam", "Adamski", PersonType.Worker);
        System.out.println(person1);
        person1.becomeOwner();
        System.out.println(person1);
        person1.stopBeingWorker();
        System.out.println(person1);

        //wieloaspektowe


        //wielodziedziczenie
        System.out.println(cat.getAnimalType().getRoomSize());
        System.out.println(fish.getAnimalType().getRoomSize());
        System.out.println(frog.getAnimalType().getRoomSize());
    }
}