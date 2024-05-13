package MP03.AnimalTypes;

import MP03.Animal;
import MP03.Type;

public class FlyingAnimal extends Type {
    private double flightDuration;
    private double flightHeight;
    private int cageSize = 10;

    public FlyingAnimal(Animal animal) {
        super(animal);
    }

    public double getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(double flightDuration) {
        this.flightDuration = flightDuration;
    }

    public double getFlightHeight() {
        return flightHeight;
    }

    public void setFlightHeight(double flightHeight) {
        this.flightHeight = flightHeight;
    }

    public int getCageSize() {
        return cageSize;
    }

    public void setCageSize(int cageSize) {
        this.cageSize = cageSize;
    }

    @Override
    public int getRoomSize() {
        return getCageSize();
    }
}
