public abstract class Collectible {
    //instance variables
    private EstimatedYear yearOfOrigin;
    private String owner;
    private String condition;
    private float startingPrice;
    private int id;

    protected Collectible(EstimatedYear yearOfOrigin, String owner, String condition, float startingPrice, int id) {
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
    public String getCondition() {
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
}
