package MP05;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "Hotel")
public class Hotel implements Serializable {
    private static List<Hotel> allHotels = new ArrayList<>();

    private String name;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    private static Set<Room> allRooms = new HashSet<>(); //Kompozycja
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<Long, Worker> workers = new TreeMap<>(); //Asocjacja kwalifikowana

    private Long id;

    public Hotel() {

    }

    public Hotel(String name){
        this.name = name;
        addHotel(this);
    }

    private void addHotel(Hotel hotel){
        allHotels.add(hotel);
    }

    //Kompozycja
    public void addRoom(Room room){
        if(!rooms.contains(room)) {
            if (allRooms.contains(room)) {
                System.out.println("Room already exists in hotel " + room.getHotel().getName());
                return;
            }

            rooms.add(room);
            allRooms.add(room);
        }
    }

    public void removeRoom(Room room){
        if(rooms.contains(room)){
            rooms.remove(room);
            allRooms.remove(room);
        }
    }

    //Asocjacja kwalifikowana
    public void addWorker(Worker worker) {
        if(!workers.containsKey(worker.getId())) {
            workers.put(worker.getId(), worker);
            worker.addHotel(this);
        }
    }

    public Worker findWorker(long id) {
        if(!workers.containsKey(id)) {
            System.out.println("Can't find worker with id: " + id + " in hotel " + name);
            return null;
        }
        return workers.get(id);
    }

    public void removeWorker(Worker worker){
        if(workers.containsKey(worker.getId())){
            workers.remove(worker.getId());
            worker.removeHotel();
        }
    }

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    public Map<Long, Worker> getWorkers(){
        return workers;
    }


    public String getName(){
        return name;
    }

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Room> getRooms(){
        return rooms;
    }

    @Override
    public String toString(){
        StringBuilder roomString = new StringBuilder();
        if(!rooms.isEmpty()){
            for(Room room : rooms){
                roomString.append(room).append("\n");
            }
        }

        return "Hotel " + name + "\nRooms:\n" + roomString;
    }

    public static List<Hotel> getAllHotels() {
        return allHotels;
    }

    public static void setAllHotels(List<Hotel> allHotels) {
        Hotel.allHotels = allHotels;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static Set<Room> getAllRooms() {
        return allRooms;
    }

    public static void setAllRooms(Set<Room> allRooms) {
        Hotel.allRooms = allRooms;
    }

    public void setWorkers(Map<Long, Worker> workers) {
        this.workers = workers;
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
