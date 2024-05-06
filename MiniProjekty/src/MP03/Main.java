package MP03;

import MP03.AnimalSpecies.Dog;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog("Mruczek");
        Animal animal2 = new Dog("Burek");
        Animal animal3 = new Dog("Robal");

        Owner owner1 = new Owner("Adam", "Adamski");
        Owner owner2 = new Owner("Beata", "Beatska");

        //Asocjacja zwykła
        animal1.setOwner(owner1);
        animal2.setOwner(owner2);
        owner2.addAnimal(animal3);

        System.out.println("Animals for owner " + owner1);
        for(Animal animal : owner1.getAnimals()){
            System.out.println(animal);
        }

        System.out.println("\nAnimals for owner " + owner2);
        for(Animal animal : owner2.getAnimals()){
            System.out.println(animal);
        }

        //zmiana właściciela
        animal3.removeOwner();
        animal3.setOwner(owner1);

        System.out.println("Animals for owner " + owner1);
        for(Animal animal : owner1.getAnimals()){
            System.out.println(animal);
        }

        System.out.println("\nAnimals for owner " + owner2);
        for(Animal animal : owner2.getAnimals()){
            System.out.println(animal);
        }

        //Kompozycja
        Hotel hotel1 = new Hotel("Zwierzolandia");
        Hotel hotel2 = new Hotel("Zwierzakowo");

        hotel1.addRoom(Room.createRoom(hotel1, 0, 1, 3));
        hotel1.addRoom(Room.createRoom(hotel1, 1, 2, 4));
        hotel2.addRoom(Room.createRoom(hotel2, 2, 1, 2));

        System.out.println("\nRooms for hotel " + hotel1.getName());
        for(Room room : hotel1.getRooms()){
            System.out.println(room);
        }

        System.out.println("\nRooms for hotel " + hotel2.getName());
        for(Room room : hotel2.getRooms()){
            System.out.println(room);
        }

        hotel1.removeRoom(hotel1.getRooms().get(0));

        System.out.println("\nRooms for hotel " + hotel1.getName());
        for(Room room : hotel1.getRooms()){
            System.out.println(room);
        }

        System.out.println("\nRooms for hotel " + hotel2.getName());
        for(Room room : hotel2.getRooms()){
            System.out.println(room);
        }

        //Asocjacja z atrybutem
        AnimalRoom animalRoom1 = new AnimalRoom(animal1, hotel1.getRooms().get(0), "2024-04-01", "2024-05-01");
        AnimalRoom animalRoom2 = new AnimalRoom(animal2, hotel2.getRooms().get(0), "2024-04-03", "2024-05-03");

        System.out.println("\nAnimal in room for animal: " + animal1.getName());
        for(AnimalRoom animalRoom : animal1.getAnimalInRoom()){
            System.out.println(animalRoom);
        }

        System.out.println("\nAnimal in room for animal: " + animal2.getName());
        for(AnimalRoom animalRoom : animal2.getAnimalInRoom()){
            System.out.println(animalRoom);
        }

        animalRoom2.remove(animal2);

        System.out.println("\nAnimal in room for animal: " + animal1.getName());
        for(AnimalRoom animalRoom : animal1.getAnimalInRoom()){
            System.out.println(animalRoom);
        }

        System.out.println("\nAnimal in room for animal: " + animal2.getName());
        for(AnimalRoom animalRoom : animal2.getAnimalInRoom()){
            System.out.println(animalRoom);
        }

        //Asocjacja kwalifikowana
        Worker worker1 = new Worker(0, "Cecylia", "Cecyliowska");
        Worker worker2 = new Worker(1, "Damian", "Damiański");
        Worker worker3 = new Worker(2, "Edward", "Edwardski");

        hotel1.addWorker(worker1);
        hotel2.addWorker(worker2);
        hotel2.addWorker(worker3);

        System.out.println("\nWorkers for hotel " + hotel1.getName());
        for(Worker worker : hotel1.getWorkers().values()){
            System.out.println(worker);
        }

        System.out.println("\nWorkers for hotel " + hotel2.getName());
        for(Worker worker : hotel2.getWorkers().values()){
            System.out.println(worker);
        }

        System.out.println("\nFinding workers:");
        System.out.println(hotel1.findWorker(0));
        System.out.println(hotel2.findWorker(0));

        hotel2.removeWorker(worker3);
        hotel2.findWorker(2);
        System.out.println("\nWorker3: " + worker3);
    }
}