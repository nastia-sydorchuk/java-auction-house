import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FurnitureList {
    private ArrayList<Furniture> furnitureList;

    //create an empty arraylist
    public FurnitureList() {
        this.furnitureList = new ArrayList<Furniture> ();
    }

    // populate furniture list with data from the file
    public void populate(String furnitureFilename) {
        File f = new File(furnitureFilename);
        try (Scanner scanner = new Scanner(f)) {
            FurnitureParser parser = new FurnitureParser();
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                Furniture furniture = parser.parseFurnitureFromLine(inputLine);
                this.addOneFurniture(furniture);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addOneFurniture(Furniture f) {
        int id = f.getId();
        Furniture inList = this.findById(id);
        if (inList == null) {
            this.furnitureList.add(f);
        }
    }

    public Furniture findById(int id){
        for (Furniture f : furnitureList)
            if (f.getId() == id)
                return f;
        return null;
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
