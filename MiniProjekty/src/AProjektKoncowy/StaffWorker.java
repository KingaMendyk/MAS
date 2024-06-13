package AProjektKoncowy;

import java.util.Arrays;

public class StaffWorker extends Worker{
    private static int maxRoomCount = 3;
    private Room[] assignedRooms = new Room[maxRoomCount];
    private int roomCount;

    public StaffWorker(Person person){
        super(person);
    }

    public boolean assignToRoom(Room room){
        if(Arrays.asList(assignedRooms).contains(room)){
            System.out.println("Room already assigned");
            return false;
        }

        if(roomCount < maxRoomCount){
            assignedRooms[roomCount++] = room;
            room.assignWorker(this);
            return true;
        }
        return false;
    }

    public void removeFromRoom(Room room){
        if(!Arrays.asList(assignedRooms).contains(room))
            return;
        assignedRooms[Arrays.asList(assignedRooms).indexOf(room)] = null;
        room.removeWorker(this);
    }

    @Override
    public int getSalary() {
        return salary;
    }
}
