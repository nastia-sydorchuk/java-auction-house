public abstract class Collectible {
    //instance variables
    private EstimatedYear yearOfOrigin;
    private String owner;
    private ConditionType condition;
    private float startingPrice;
    private int id;

    protected Collectible(EstimatedYear yearOfOrigin, String owner, ConditionType condition, float startingPrice, int id) {
        this.yearOfOrigin = yearOfOrigin;
        this.owner = owner;
        this.condition = condition;
        this.startingPrice = startingPrice;
        this.id = id;
    }

    //Return yearOfOrigin
    public EstimatedYear getYearOfOrigin() {
        return yearOfOrigin;
    }

    //Return owner
    public String getOwner() {
        return owner;
    }

    //Return condition
    public ConditionType getCondition() {
        return condition;
    }

    //Return startingPrice
    public float getStartingPrice() {
        return startingPrice;
    }

    //Return id
    public int getId() {
        return id;
    }

    //Return the String representation of the collectible
    @Override
    public String toString() { return String.valueOf(id); }

    //Return the detailed description of the collectible
    public String getDetails() {
        return String.format(
                "ID: %d%nStarting price: %.2f%nCondition: %s%nOwner: %s%nEstimated year (middle): %d",
                id,
                startingPrice,
                condition.toString(),
                owner,
                yearOfOrigin.getMiddleEstimate()
        );
    }

    public enum ConditionType {
        MINT,
        RESTORED,
        NEEDS_RESTORING
    }
}
