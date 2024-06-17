package ProjektKoncowy.AnimalTypes;

import ProjektKoncowy.Animal;

public class WaterLandAnimal extends AnimalType implements ISwimming{
    private double avgTimeInWater;
    private double avgTimeOnLand;

    public WaterLandAnimal(Animal animal) {
        super(animal);
    }

    public double getAvgTimeInWater() {
        return avgTimeInWater;
    }

    public void setAvgTimeInWater(double avgTimeInWater) {
        this.avgTimeInWater = avgTimeInWater;
    }

    public double getAvgTimeOnLand() {
        return avgTimeOnLand;
    }

    public void setAvgTimeOnLand(double avgTimeOnLand) {
        this.avgTimeOnLand = avgTimeOnLand;
    }
}
