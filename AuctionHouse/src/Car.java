public class Car extends Collectible {
    private String make;
    private String model;
    private boolean hasBeenServiced;

    //constructor
    public Car(String make, String model, boolean hasBeenServiced, EstimatedYear yearOfOrigin, String owner, String condition, float startingPrice, int id) {
        super(yearOfOrigin, owner, condition, startingPrice, id);
        this.make = make;
        this.model = model;
        this.hasBeenServiced = hasBeenServiced;
    }

    //Return make
    public String getMake() {
        return make;
    }

    //Return model
    public String getModel() {
        return model;
    }

    //Return hasBeenServiced
    public boolean getHasBeenServiced() {
        return hasBeenServiced;
    }
}
