package MP04;

import MP04.AnimalSpecies.*;

public class Main {
    public static void main(String[] args) {
        // Ograniczenie unique
        Worker w = new Worker(1, "A", "B");
        Worker w1 = new Worker(1, "A", "B");
        System.out.println(Worker.getLatestId());

        // Ograniczenie atrybutu
        w.setWorkHours(3);
        System.out.println(w.getWorkHours());
        w.setWorkHours(10);
        System.out.println(w.getWorkHours());
        w.setWorkHours(7);
        System.out.println(w.getWorkHours());

        // Ograniczenie ordered
        Animal cat = new Cat("Mruczek");
        Animal dog = new Dog("Burek");
        Animal parrot = new Parrot("Kakadu");

        Owner owner = new Owner("Adam", "Adamski");
        owner.addAnimal(cat);
        owner.addAnimal(dog);
        owner.addAnimal(parrot);

        System.out.println(owner.getAnimals());

        owner.removeAnimal(cat);
        owner.addAnimal(cat);
        System.out.println(owner.getAnimals());

        // Ograniczenie Bag
        Hotel hotel = new Hotel("Zwierzolandia");
        hotel.addRoom(Room.createRoom(hotel, 0, 1, 5));
        AnimalRoom animalRoom1 = new AnimalRoom(cat, hotel.getRooms().get(0), "2024-04-01", "2024-05-01");
        AnimalRoom animalRoom2 = new AnimalRoom(cat, hotel.getRooms().get(0), "2024-05-03", "2024-05-10");

        System.out.println("\nAnimal in room for animal: " + cat.getName());
        for(AnimalRoom animalRoom : cat.getAnimalInRoom()){
            System.out.println(animalRoom);
        }

        // Ograniczenie Xor
        

        // Ograniczenie własne
        Animal frog = new Frog("Robert", 3);
        frog.feed(5);
        frog.feed(2);
    }
}