public class EstimatedYear {
    private int low;
    private int high;

    //constructor to create object with different low and high values
    public EstimatedYear(int lowYearEstimate, int highYearEstimate) {
        this.low = lowYearEstimate;
        this.high = highYearEstimate;
    }

    //constructor to create object using one year estimate and set low and high to the same value
    public EstimatedYear(int yearEstimate) {
        this.low = yearEstimate;
        this.high = yearEstimate;
    }

    //Return low year estimate
    public int getLow() {
        return low;
    }

    //Return high year estimate
    public int getHigh() {
        return high;
    }

    // return middle estimate
    public int getMiddleEstimate() {
        return (this.low + this.high) / 2;
    }
}
