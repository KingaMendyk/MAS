package ProjektKoncowy.AnimalTypes;

import ProjektKoncowy.Animal;

public class WaterAnimal extends AnimalType implements ISwimming{
    private double swimSpeed;
    private double waterTemperature;

    public WaterAnimal(Animal animal) {
        super(animal);
    }

    public double getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(double swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public double getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }
}
