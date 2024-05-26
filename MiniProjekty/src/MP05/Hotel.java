package MP05;


import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.*;

@Entity(name = "Hotel")
@Embeddable
public class Hotel implements Serializable {
    private static List<Hotel> allHotels = new ArrayList<>();

    private String name;
    private List<Room> rooms = new ArrayList<>();
    private static Set<Room> allRooms = new HashSet<>(); //Kompozycja
    private Map<Long, Worker> workers = new TreeMap<>(); //Asocjacja kwalifikowana
    @Id
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

    public Worker findWorker(int id) {
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

    @ElementCollection
    public Map<Long, Worker> getWorkers(){
        return workers;
    }


    public String getName(){
        return name;
    }

    @ElementCollection
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
