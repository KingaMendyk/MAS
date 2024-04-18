package MP02;

import java.io.Serializable;
import java.util.*;

public class Hotel implements Serializable {
    private static List<Hotel> allHotels;

    private String name;
    private List<Room> rooms = new ArrayList<>();
    private static Set<Room> allRooms = new HashSet<>();

    private Map<Integer, Worker> workerQualif = new TreeMap<>();

    public Hotel(String name){
        this.name = name;
        addHotel(this);
    }

    private void addHotel(Hotel hotel){
        allHotels.add(hotel);
    }

    public void addRoom(Room room){
        if(!rooms.contains(room)) {
            if (allRooms.contains(room)) {
                System.out.println("Room already exists in ");
            }

            rooms.add(room);
            allRooms.add(room);
        }
    }

    public void addWorkerQualif(Worker newWorker) {
        if(!workerQualif.containsKey(newWorker.getId())) {
            workerQualif.put(newWorker.getId(), newWorker);
            newWorker.addHotel(this);
        }
    }

    public Worker findWorkerQualif(int id) {
        if(!workerQualif.containsKey(id)) {
            System.out.println("Can't find worker with id: " + id);
        }
        return workerQualif.get(id);
    }


    public String getName(){
        return name;
    }

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
}
