package MP05;


import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Room")
@Embeddable
public class Room {
    @Id
    private long id;
    private int number;
    private int size;
    private Hotel hotel; //Kompozycja
    private List<AnimalRoom> animalInRoom = new ArrayList<>(); //Asocjacja z atrybutem

    public Room() {

    }

    private Room(Hotel hotel, int id, int number, int size){
        this.id = id;
        this.number = number;
        this.size = size;
        this.hotel = hotel;
    }

    //Kompozycja
    public static Room createRoom(Hotel hotel, int id, int number, int size){
        if(hotel == null){
            System.out.println("Hotel does not exist!");
            return null;
        }

        Room room = new Room(hotel, id, number, size);
        hotel.addRoom(room);

        return room;
    }

    //Asocjacja z atrybutem
    public void addAnimalRoom(AnimalRoom animalRoom){
        if(!animalInRoom.contains(animalRoom)) {
            animalInRoom.add(animalRoom);
        }
    }

    public void removeAnimalRoom(AnimalRoom animalRoom){
        if(animalInRoom.contains(animalRoom)) {
            animalInRoom.remove(animalRoom);
            animalRoom.remove(this);
        }
    }

    @ElementCollection
    public List<AnimalRoom> getAnimalInRoom(){
        return animalInRoom;
    }

    public Hotel getHotel(){
        return hotel;
    }

    @Override
    public String toString() {
        return "Room { " + "id: " + id + ", number: " + number + ", size: " + size + " }";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
