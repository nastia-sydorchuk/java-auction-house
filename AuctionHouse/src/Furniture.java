public class Furniture extends Collectible {
    //instance variables
    private String type;
    private String style;
    private String makersName;
    private float length;
    private float height;
    private float depth;

    //constructor
    public Furniture(String type, String style, String makersName, float length, float height, float depth, int yearOfOrigin, String owner, String condition, float startingPrice, int id) {
        super(yearOfOrigin, owner, condition, startingPrice, id);
        this.type = type;
        this.style = style;
        this.makersName = makersName;
        this.length = length;
        this.height = height;
        this.depth = depth;
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
}
