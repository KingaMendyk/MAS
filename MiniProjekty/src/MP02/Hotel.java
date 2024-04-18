package MP02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hotel {
    private String name;
    private List<Room> rooms = new ArrayList<>();
    private static Set<Room> allRooms = new HashSet<>();

    public Hotel(String name){
        this.name = name;
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
