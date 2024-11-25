import java.util.Comparator;

public class IdComparator implements Comparator<Collectible> {
    public int compare(Collectible c1, Collectible c2) {
        return c1.getId() - c2.getId();
    }
}
