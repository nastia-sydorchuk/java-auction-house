public class Furniture {
    //instance variables
    private String type;
    private String style;
    private String makersName;
    private float length;
    private float height;
    private float depth;
    private int yearOfOrigin;
    private String owner;
    private String condition;
    private float startingPrice;
    private int id;

    //constructor
    public Furniture(String type, String style, String makersName, float length, float height, float depth, int yearOfOrigin, String owner, String condition, float startingPrice, int id) {
        this.type = type;
        this.style = style;
        this.makersName = makersName;
        this.length = length;
        this.height = height;
        this.depth = depth;
        this.yearOfOrigin = yearOfOrigin;
        this.owner = owner;
        this.condition = condition;
        this.startingPrice = startingPrice;
        this.id = id;
    }

    //Return type
    public String getType() {
        return type;
    }

    //Return style
    public String getStyle() {
        return style;
    }

    //Return makersName
    public String getMakersName() {
        return makersName;
    }

    //Return length
    public float getLength() {
        return length;
    }

    //Return height
    public float getHeight() {
        return height;
    }

    //Return depth
    public float getDepth() {
        return depth;
    }

    //Return yearOfOrigin
    public int getYearOfOrigin() {
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
