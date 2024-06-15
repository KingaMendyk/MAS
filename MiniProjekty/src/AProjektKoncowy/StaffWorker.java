package AProjektKoncowy;

import AProjektKoncowy.Enums.WorkerType;

import java.util.Arrays;

public class StaffWorker extends Worker{
    private static int maxRoomCount = 3;
    private Room[] assignedRooms = new Room[maxRoomCount];
    private int roomCount;
    private Worker worker;

    public StaffWorker(int id, String name, String surname){
        super(id, name, surname, WorkerType.StaffWorker);
    }

    public StaffWorker(Worker worker){
        this.worker = worker;
    }

    public StaffWorker(Person person){
        super(person, WorkerType.StaffWorker);
    }

    public boolean assignToRoom(Room room){
        if(Arrays.asList(assignedRooms).contains(room)){
            return false;
        }

        if(roomCount >= maxRoomCount){
            System.out.println("Max limit reached");
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
