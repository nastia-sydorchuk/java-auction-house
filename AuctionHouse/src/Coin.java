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
}
