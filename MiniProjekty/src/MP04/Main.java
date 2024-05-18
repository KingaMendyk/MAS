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

        Worker w = new Worker(1, "A", "B");
        Worker w1 = new Worker(1, "A", "B");
        System.out.println(Worker.getLatestId());
    }
}