public class Coin extends Collectible {
    private String material;
    private String placeOfOrigin;
    private float originalValue;
    private String currency;

    //constructor
    public Coin(String material, String placeOfOrigin, float originalValue, String currency, EstimatedYear yearOfOrigin, String owner, ConditionType condition, float startingPrice, int id) {
        super(yearOfOrigin, owner, condition, startingPrice, id);
        this.material = material;
        this.placeOfOrigin = placeOfOrigin;
        this.originalValue = originalValue;
        this.currency = currency;
    }

    //Return material
    public String getMaterial() {
        return material;
    }

    //Return placeOfOrigin
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    //Return originalValue
    public float getOriginalValue() {
        return originalValue;
    }

    //Return currency
    public String getCurrency() {
        return currency;
    }

    //Return the String representation of the coin
    @Override
    public String toString(){ return "Coin " + super.toString() + ": " + material; }

    //Return the detailed description of the coin
    @Override
    public String getDetails() {
        return String.format(
                "%s%nMaterial: %s%nPlace of origin: %s%nOriginal value: %.2f%nCurrency: %s",
                super.getDetails(),
                material,
                placeOfOrigin,
                originalValue,
                currency
        );
    }

    //Return coin specific CSV properties
    @Override
    public String toCSVAttributes() {
        return String.format(
                "%s,%s,%s,%.2f,%s,%s",
                "coin",
                material,
                placeOfOrigin,
                originalValue,
                currency,
                super.toCSVAttributes()
        );
    }

    public static Coin parseCoinFromLine(String[] parts) {
        float originalValue = CollectibleParser.parseFloat(3, parts);
        int id = CollectibleParser.parseInt(9, parts);
        EstimatedYear estimatedYear = CollectibleParser.parseEstimatedYear(parts[5]);
        float startingPrice = CollectibleParser.parseFloat(8, parts);
        Collectible.ConditionType type = CollectibleParser.parseConditionType(parts[7]);

        return new Coin(
                parts[1],
                parts[2],
                originalValue,
                parts[4],
                estimatedYear,
                parts[6],
                type,
                startingPrice,
                id
        );
    }
}
