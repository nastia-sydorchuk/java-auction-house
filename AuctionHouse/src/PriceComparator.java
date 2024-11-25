import java.util.Comparator;

public class PriceComparator implements Comparator<Collectible> {
    public int compare(Collectible c1, Collectible c2) {
        return Double.compare(c1.getStartingPrice(), c2.getStartingPrice());
    }
}
