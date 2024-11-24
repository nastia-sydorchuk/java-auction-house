public class Car extends Collectible {
    private String make;
    private String model;
    private boolean hasBeenServiced;

    //constructor
    public Car(String make, String model, boolean hasBeenServiced, EstimatedYear yearOfOrigin, String owner, ConditionType condition, float startingPrice, int id) {
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

    //Return the String representation of the car
    @Override
    public String toString(){ return "Car " + super.toString() + ": " + make; }

    //Return the detailed description of the book
    @Override
    public String getDetails() {
        return String.format(
                "%s%nMake: %s%nModel: %s%nHas been serviced: %b",
                super.getDetails(),
                make,
                model,
                hasBeenServiced
        );
    }
}
