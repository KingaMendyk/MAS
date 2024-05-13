package MP03.AnimalTypes;

import MP03.Animal;

public class WaterLandAnimal extends LandAnimal implements ISwimming { //wielodziedziczenie z wykorzystaniem interfejsu - klasy WaterAnimal, LandAnimal
    private int aquariumSize;

    public WaterLandAnimal(Animal animal) {
        super(animal);
    }

    @Override
    public int getAquariumSize() {
        return aquariumSize;
    }

    @Override
    public void setAquariumSize(int aquariumSize) {
        this.aquariumSize = aquariumSize;
    }

    @Override
    public int getRoomSize(){
        return getAquariumSize() + getPreferredRoomSize();
    }
}
