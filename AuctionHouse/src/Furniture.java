public class Furniture extends Collectible {
    //instance variables
    private String type;
    private String style;
    private String makersName;
    private float length;
    private float height;
    private float depth;

    //constructor
    public Furniture(String type, String style, String makersName, float length, float height, float depth, EstimatedYear yearOfOrigin, String owner, ConditionType condition, float startingPrice, int id) {
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

    //Return the String representation of the furniture
    @Override
    public String toString(){ return "Furniture " + super.toString() + ": " + type; }

    //Return the detailed description of the furniture
    @Override
    public String getDetails() {
        return String.format(
                "%s%nType: %s%nStyle: %s%nMaker's name: %s%nLength: %.2f%nHeight: %.2f%nDepth: %.2f",
                super.getDetails(),
                type,
                style,
                makersName,
                length,
                height,
                depth
        );
    }

    //Return furniture specific CSV properties
    @Override
    public String toCSVAttributes() {
        return String.format(
                "%s,%s,%s,%s,%.2f,%.2f,%.2f,%s",
                "furniture",
                type,
                style,
                makersName,
                length,
                height,
                depth,
                super.toCSVAttributes()
        );
    }
}
