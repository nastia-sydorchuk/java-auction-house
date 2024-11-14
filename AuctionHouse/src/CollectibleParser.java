public class CollectibleParser {
    String[] parts;
    public Collectible parseCollectibleFromLine(String line, byte count) {
        this.parts = line.split(",");

        try {
            String type = this.parts[0];

            switch(type) {
                case "book": return parseBookFromLine();
                case "coin": return parseCoinFromLine();
                case "car": return parseCarFromLine();
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

    public Book parseBookFromLine() {
        int id = this.parseInt(9);
        EstimatedYear estimatedYear = this.parseEstimatedYear(this.parts[5]);
        float startingPrice = this.parseFloat(8);
        Collectible.ConditionType type = Collectible.ConditionType.valueOf(this.parts[7].trim().toUpperCase());

        return new Book(
                this.parts[1],
                this.parts[2],
                this.parts[3],
                this.parts[4],
                estimatedYear,
                this.parts[6],
                type,
                startingPrice,
                id
        );
    }

    public Coin parseCoinFromLine() {
        float originalValue = this.parseFloat(3);

        int id = this.parseInt(9);
        EstimatedYear estimatedYear = this.parseEstimatedYear(this.parts[5]);
        float startingPrice = this.parseFloat(8);
        Collectible.ConditionType type = Collectible.ConditionType.valueOf(this.parts[7].trim().toUpperCase());

        return new Coin(
                this.parts[1],
                this.parts[2],
                originalValue,
                this.parts[4],
                estimatedYear,
                this.parts[6],
                type,
                startingPrice,
                id
        );
    }

    public Car parseCarFromLine() {
        int id = this.parseInt(8);
        EstimatedYear estimatedYear = this.parseEstimatedYear(this.parts[4]);
        float startingPrice = this.parseFloat(7);
        Collectible.ConditionType type = Collectible.ConditionType.valueOf(this.parts[6].trim().toUpperCase());

        return new Car(
                this.parts[1],
                this.parts[2],
                Boolean.parseBoolean(this.parts[3]),
                estimatedYear,
                this.parts[5],
                type,
                startingPrice,
                id
        );
    }

    public Furniture parseFurnitureFromLine() {
        float length = this.parseFloat(4);
        float height = this.parseFloat(5);
        float depth = this.parseFloat(6);

        int id = this.parseInt(11);
        EstimatedYear estimatedYear = this.parseEstimatedYear(this.parts[7]);
        float startingPrice = this.parseFloat(10);
        Collectible.ConditionType type = Collectible.ConditionType.valueOf(this.parts[9].trim().toUpperCase());

        return new Furniture(
                this.parts[1],
                this.parts[2],
                this.parts[3],
                length,
                height,
                depth,
                estimatedYear,
                this.parts[8],
                type,
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

    private int parseInt(String numString) {
        try {
            String numStringTrimmed = numString.trim();
            return Integer.parseInt(numStringTrimmed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer value: " + numString);
            return 0;
        }
    }

    private EstimatedYear parseEstimatedYear(String estimatedYear) {
        try {
            if (estimatedYear.contains("-")) { // Check if it's a range
                String[] yearRange = estimatedYear.split("-");

                int low = parseInt(yearRange[0]);
                int high = parseInt(yearRange[1]);
                return new EstimatedYear(low, high);
            } else {
                int year = parseInt(estimatedYear);
                return new EstimatedYear(year);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format for estimated year: " + estimatedYear);
            return null;
        }
    }

}
