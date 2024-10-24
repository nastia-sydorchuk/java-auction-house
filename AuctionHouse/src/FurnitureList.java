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

    //return the oldest item in furnitureList
    public Furniture findOldestItem() {
        Furniture oldestItem = this.furnitureList.getFirst();
        for (Furniture f : this.furnitureList) {
            if (oldestItem.getYearOfOrigin() > f.getYearOfOrigin())
                oldestItem = f;
        }

        return oldestItem;
    }

    //return the newest item in furnitureList
    public Furniture findNewestItem() {
        Furniture newestItem = this.furnitureList.getFirst();
        for (Furniture f : this.furnitureList) {
            if (newestItem.getYearOfOrigin() < f.getYearOfOrigin())
                newestItem = f;
        }

        return newestItem;
    }

    //return the least expensive item in furnitureList
    public Furniture findLeastExpensiveItem() {
        Furniture leastExpensiveItem = this.furnitureList.getFirst();
        for (Furniture f : this.furnitureList) {
            if (leastExpensiveItem.getStartingPrice() > f.getStartingPrice())
                leastExpensiveItem = f;
        }

        return leastExpensiveItem;
    }

    //return the most expensive item in furnitureList
    public Furniture findMostExpensivePrice() {
        Furniture mostExpensiveItem = this.furnitureList.getFirst();
        for (Furniture f : this.furnitureList) {
            if (mostExpensiveItem.getStartingPrice() < f.getStartingPrice())
                mostExpensiveItem = f;
        }

        return mostExpensiveItem;
    }

    public String createReport() {
        Furniture oldestItem = this.findOldestItem();
        Furniture newestItem = this.findNewestItem();
        Furniture leastExpensiveItem = this.findLeastExpensiveItem();
        Furniture mostExpensiveItem = this.findMostExpensivePrice();

        String report = "Total number of items in inventory is " + this.getSize() + "\n";
        report += "The oldest item is under ID " + oldestItem.getId() + ", year of origin: " + oldestItem.getYearOfOrigin() + "\n";
        report += "The newest item is under ID " + newestItem.getId() + ", year of origin: " + newestItem.getYearOfOrigin() + "\n";
        report += "The least expensive item is under ID " + leastExpensiveItem.getId() + ", starting price: " + leastExpensiveItem.getStartingPrice() + "\n";
        report += "The most expensive item is under ID " + mostExpensiveItem.getId() + ", starting price: " + mostExpensiveItem.getStartingPrice() + "\n";

        return report;
    }

    public void writeReportToFile(String filename) {
        FileWriter fw;
        String report = createReport();
        try {
            fw = new FileWriter(filename);
            fw.write(report);
            fw.close();
        }
        //message and stop if file not found
        catch (FileNotFoundException fnf) {
            System.out.println(filename + " not found ");
            System.exit(0);
        }
        //stack trace here because we don't expect to come here
        catch (IOException ioe) {
            ioe.printStackTrace(); //goes to standard output
            System.exit(1);
        }
    }
}
