public class CollectibleParser {
    public static Collectible parseCollectibleFromLine(String line, byte count) {
        String[] parts = line.split(",");

        try {
            String type = parts[0];

            switch(type) {
                case "book": return Book.parseBookFromLine(parts);
                case "coin": return Coin.parseCoinFromLine(parts);
                case "car": return Car.parseCarFromLine(parts);
                case "furniture": return Furniture.parseFurnitureFromLine(parts);
                default:
                    System.out.println("Unknown type " + type + " in line " + count);
                    return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough fields in line " + count);
            return null;
        }
    }

    public static float parseFloat(int index, String[] parts) {
        String numString = parts[index];
        try {
            String numStringTrimmed = numString.trim();
            return Float.parseFloat(numStringTrimmed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid float value: " + numString + ", line: " + index + 1);
            return 0.0f;
        }
    }

    public static int parseInt(int index, String[] parts) {
        String numString = parts[index];

        try {
            String numStringTrimmed = numString.trim();
            return Integer.parseInt(numStringTrimmed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer value: " + numString + ", line: " + index + 1);
            return 0;
        }
    }

    public static int parseInt(String numString) {
        try {
            String numStringTrimmed = numString.trim();
            return Integer.parseInt(numStringTrimmed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer value: " + numString);
            return 0;
        }
    }

    public static EstimatedYear parseEstimatedYear(String estimatedYear) {
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

    public static Collectible.ConditionType parseConditionType(String input) {
        try {
            return Collectible.ConditionType.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid media type: " + input);
            return Collectible.ConditionType.MINT; // assume MINT is default
        }
    }

}
