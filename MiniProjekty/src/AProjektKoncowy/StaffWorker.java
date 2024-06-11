package AProjektKoncowy;

public class StaffWorker extends Worker{

    public boolean assingToRoom(Room room){
        if(room.isAvailable()){
            //TODO
            return true;
        }
        return false;
    }

    @Override
    public int getSalary() {
        return salary;
    }
}
