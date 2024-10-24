public class FurnitureParser {
    String[] parts;
    public Furniture parseFurnitureFromLine(String line, byte count) {
        this.parts = line.split(",");

        try {
            int id = this.parseInt(10);
            int year = this.parseInt(6);
            float length = this.parseFloat(3);
            float height = this.parseFloat(4);
            float depth = this.parseFloat(5);
            float startingPrice = this.parseFloat(9);

            return new Furniture(
                    this.parts[0],
                    this.parts[1],
                    this.parts[2],
                    length,
                    height,
                    depth,
                    year,
                    this.parts[7],
                    this.parts[8],
                    startingPrice,
                    id
            );
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough fields in line " + count);
            return null;
        }
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
