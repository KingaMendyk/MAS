package MP03;

public abstract class Type {
    private Animal animal;
    public Type(Animal animal){
        this.animal = animal;
    }
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public abstract int getRoomSize();
}
