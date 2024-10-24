public class FurnitureParser {
    public Furniture parseFurnitureFromLine(String line) {
        String[] parts = line.split(",");

        int year = this.parseInt(parts[6]);
        float length = this.parseFloat(parts[3]);
        float height = this.parseFloat(parts[4]);
        float depth = this.parseFloat(parts[5]);
        float startingPrice = this.parseFloat(parts[9]);
        int id = this.parseInt(parts[10]);

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
    }

    private float parseFloat(String numString) {
        String numStringTrimmed = numString.trim(); //remove any spaces
        return Float.parseFloat(numStringTrimmed);
    }

    private int parseInt(String numString) {
        String numStringTrimmed = numString.trim(); //remove any spaces
        return Integer.parseInt(numStringTrimmed);
    }
}
