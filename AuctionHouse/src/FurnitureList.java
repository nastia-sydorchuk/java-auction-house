import java.util.ArrayList;

public class FurnitureList {
    private ArrayList<Furniture> furnitureList;

    //create an empty arraylist
    public FurnitureList() {
        this.furnitureList = new ArrayList<Furniture> ();
    }

    // populate furniture list with some mock data
    public void populate() {
        Furniture furniture1 = new Furniture ("chair", "modern", "JL", 10, 15,20, 2022, "JL", "new", 30, 1);
        this.furnitureList.add(furniture1);

        Furniture furniture2 = new Furniture ("desk", "modern", "JL", 15,20,25,2023, "JL", "new", 40, 2);
        this.furnitureList.add(furniture2);

        Furniture furniture3 = new Furniture ("sofa","modern", "JL", 20,25,30,2024, "JL", "new", 200, 3);
        this.furnitureList.add(furniture3);
    }

    //return number of items in furnitureList
    public int getSize() {
        return this.furnitureList.size();
    }

    //return the oldest item id in furnitureList
    public int findOldestItemId() {
        Furniture oldestItem = this.furnitureList.getFirst();
        for (Furniture f : this.furnitureList) {
            if (oldestItem.getYearOfOrigin() > f.getYearOfOrigin())
                oldestItem = f;
        }

        return oldestItem.getId();
    }

    //return the newest item id in furnitureList
    public int findNewestItemId() {
        Furniture newestItem = this.furnitureList.getFirst();
        for (Furniture f : this.furnitureList) {
            if (newestItem.getYearOfOrigin() < f.getYearOfOrigin())
                newestItem = f;
        }

        return newestItem.getId();
    }

    //return the cheapest price in furnitureList
    public float findCheapestPrice() {
        float cheapestPrice = this.furnitureList.getFirst().getStartingPrice();
        for (Furniture f : this.furnitureList) {
            if (cheapestPrice > f.getStartingPrice())
                cheapestPrice = f.getStartingPrice();
        }

        return cheapestPrice;
    }

    //return the most expensive price in furnitureList
    public float findMostExpensivePrice() {
        float mostExpensivePrice = this.furnitureList.getFirst().getStartingPrice();
        for (Furniture f : this.furnitureList) {
            if (mostExpensivePrice < f.getStartingPrice())
                mostExpensivePrice = f.getStartingPrice();
        }

        return mostExpensivePrice;
    }
}
