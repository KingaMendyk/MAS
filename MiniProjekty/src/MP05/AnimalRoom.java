package MP05;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "AnimalRoom")
public class AnimalRoom { //Atrybut asocjacji
    private LocalDate dateFrom;
    private LocalDate dateTo;
    @OneToOne
    private Animal animal;
    @ManyToOne
    private Room room;

    private static Set<AnimalRoom> allAnimalRooms = new HashSet<>();
    private Long id;

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

    @OneToOne
    public Animal getAnimal(){
        return animal;
    }

    @ManyToOne
    public Room getRoom(){
        return room;
    }

    @Override
    public String toString(){
        return "Animal " + animal.getName() + " in room " + room + " from: " + dateFrom + " to: " + dateTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public static Set<AnimalRoom> getAllAnimalRooms() {
        return allAnimalRooms;
    }

    public static void setAllAnimalRooms(Set<AnimalRoom> allAnimalRooms) {
        AnimalRoom.allAnimalRooms = allAnimalRooms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }
}
