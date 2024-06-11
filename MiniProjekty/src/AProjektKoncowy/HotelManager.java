package AProjektKoncowy;

public class HotelManager extends Worker {
    private int bonus;

    @Override
    public int getSalary() {
        return salary + bonus;
    }
}
