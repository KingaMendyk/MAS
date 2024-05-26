package MP05;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Room")
public class Room {
    private long id;
    private int number;
    private int size;
    @ManyToOne
    private Hotel hotel; //Kompozycja
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
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

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<AnimalRoom> getAnimalInRoom(){
        return animalInRoom;
    }

    @ManyToOne
    public Hotel getHotel(){
        return hotel;
    }

    @Override
    public String toString() {
        return "Room { " + "id: " + id + ", number: " + number + ", size: " + size + " }";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setAnimalInRoom(List<AnimalRoom> animalInRoom) {
        this.animalInRoom = animalInRoom;
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
