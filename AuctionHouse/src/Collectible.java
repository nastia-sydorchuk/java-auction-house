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

    public enum ConditionType {
        MINT,
        RESTORED,
        NEEDS_RESTORING
    }
}
