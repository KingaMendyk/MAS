package MP05;


import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class AnimalRoom { //Atrybut asocjacji
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Animal animal;
    private Room room;

    private static Set<AnimalRoom> allAnimalRooms = new HashSet<>();

    public AnimalRoom() {

    }

    public AnimalRoom(Animal animal, Room room, String dateFrom, String dateTo){
        this.animal = animal;
        this.room = room;
        this.dateFrom = LocalDate.parse(dateFrom);
        this.dateTo = LocalDate.parse(dateTo);

        animal.addAnimalRoom(this);
        room.addAnimalRoom(this);
    }

    public void remove(Animal animal){
        if(animal == this.animal){
            for(AnimalRoom ar : allAnimalRooms){
                if(ar.animal == animal){
                    allAnimalRooms.remove(ar);
                }
            }
            room.removeAnimalRoom(this);
            this.animal = null;
        }
    }

    public void remove(Room room){
        if(room == this.room){
            for(AnimalRoom ar : allAnimalRooms){
                if(ar.room == room){
                    allAnimalRooms.remove(ar);
                }
            }
            animal.removeAnimalRoom(this);
            this.room = null;
        }
    }

    public Animal getanimal(){
        return animal;
    }

    public Room getRoom(){
        return room;
    }

    @Override
    public String toString(){
        return "Animal " + animal.getName() + " in room " + room + " from: " + dateFrom + " to: " + dateTo;
    }

}
