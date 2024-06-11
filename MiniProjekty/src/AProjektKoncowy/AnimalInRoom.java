package AProjektKoncowy;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class AnimalInRoom {
    private boolean healthCheckup;
    private Animal animal;
    private Room room;

    private static Set<AnimalInRoom> allAnimalRooms = new HashSet<>();

    public AnimalInRoom(Animal animal, Room room){
        this.animal = animal;
        this.room = room;
        if(animal.isSenior())
            healthCheckup = true;

        animal.addAnimalInRoom(this);
        room.addAnimalInRoom(this);
    }

    public AnimalInRoom(Animal animal, Room room, boolean healthCheckup){
        this.animal = animal;
        this.room = room;
        if(animal.isSenior())
            healthCheckup = true;
        else{
            this.healthCheckup = healthCheckup;
        }

        animal.addAnimalInRoom(this);
        room.addAnimalInRoom(this);
    }

    public void removeAnimal(Animal animal){
        if(animal == this.animal){
            for(AnimalInRoom ar : allAnimalRooms){
                if(ar.animal == animal){
                    allAnimalRooms.remove(ar);
                }
            }
            room.removeAnimalInRoom(this);
            this.animal = null;
        }
    }

    public void removeRoom(Room room){
        if(room == this.room){
            for(AnimalInRoom ar : allAnimalRooms){
                if(ar.room == room){
                    allAnimalRooms.remove(ar);
                }
            }
            animal.removeAnimalInRoom(this);
            this.room = null;
        }
    }

    public Animal getAnimal(){
        return animal;
    }

    public Room getRoom(){
        return room;
    }
}
