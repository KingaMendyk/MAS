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
            return false;
        }

        if(roomCount >= maxRoomCount){
            System.out.println("MAx limit reached");
            return false;
        }

        assignedRooms[roomCount++] = room;
        room.assignWorker(this);
        return true;
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
