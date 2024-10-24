public class FurnitureParser {
    public Furniture parseFurnitureFromLine(String line) {
        String[] parts = line.split(",");

        try {
            int id = this.parseInt(parts[10]);
            int year = this.parseInt(parts[6]);
            float length = this.parseFloat(parts[3]);
            float height = this.parseFloat(parts[4]);
            float depth = this.parseFloat(parts[5]);
            float startingPrice = this.parseFloat(parts[9]);

            return new Furniture(
                    parts[0],
                    parts[1],
                    parts[2],
                    length,
                    height,
                    depth,
                    year,
                    parts[7],
                    parts[8],
                    startingPrice,
                    id
            );
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough fields in the line");
            return null;
        }
    }

    private float parseFloat(String numString) {
        try {
            String numStringTrimmed = numString.trim();
            return Float.parseFloat(numStringTrimmed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid float value: " + numString);
            return 0.0f;
        }
    }

    private int parseInt(String numString) {
        try {
            String numStringTrimmed = numString.trim();
            return Integer.parseInt(numStringTrimmed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer value: " + numString);
            return 0;
        }
    }
}
