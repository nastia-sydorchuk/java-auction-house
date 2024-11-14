public class CollectibleParser {
    String[] parts;
    public Collectible parseCollectibleFromLine(String line, byte count) {
        this.parts = line.split(",");

        try {
            String type = this.parts[0];

            switch(type) {
                case "furniture": return parseFurnitureFromLine();
                default:
                    System.out.println("Unknown type " + type + " in line " + count);
                    return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough fields in line " + count);
            return null;
        }
    }

    public Furniture parseFurnitureFromLine() {
        float length = this.parseFloat(4);
        float height = this.parseFloat(5);
        float depth = this.parseFloat(6);

        int id = this.parseInt(11);
        int year = this.parseInt(7);
        float startingPrice = this.parseFloat(10);

        return new Furniture(
                this.parts[1],
                this.parts[2],
                this.parts[3],
                length,
                height,
                depth,
                year,
                this.parts[8],
                this.parts[9],
                startingPrice,
                id
        );
    }

    private float parseFloat(int index) {
        String numString = this.parts[index];
        try {
            String numStringTrimmed = numString.trim();
            return Float.parseFloat(numStringTrimmed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid float value: " + numString + ", line: " + index + 1);
            return 0.0f;
        }
    }

    private int parseInt(int index) {
        String numString = this.parts[index];

        try {
            String numStringTrimmed = numString.trim();
            return Integer.parseInt(numStringTrimmed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer value: " + numString + ", line: " + index + 1);
            return 0;
        }
    }
}
