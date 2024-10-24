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
                if (furniture != null) {
                    this.addOneFurniture(furniture);
                }
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

    // return average of an array of numbers
    public double calculateMean(float[] numbers) {
        double sum = 0.0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    // return average deviation
    public double calculateAverageDeviation(float[] numbers) {
        double mean = calculateMean(numbers);
        double sumOfDeviations = 0.0;
        for (double num : numbers) {
            sumOfDeviations += Math.abs(num - mean);
        }

        return sumOfDeviations / numbers.length;
    }

    // return standard deviation
    public double calculateStandardDeviation(float[] prices) {
        int n = prices.length;
        double mean = this.calculateMean(prices);
        double variance = 0;
        for (Float price : prices) {
            variance += Math.pow(price - mean, 2);
        }
        variance /= n;

        return Math.sqrt(variance);
    }

    public float[] extractPrices() {
        int length = this.getSize();
        float[] prices = new float[length];
        for (int i = 0; i < length; i++) {
            prices[i] = this.furnitureList.get(i).getStartingPrice();
        }

        return prices;
    }

    public String getBreakdownByCondition() {
        // Initialize counters for each condition
        int newCount = 0;
        int goodCount = 0;
        int damagedCount = 0;

        for (Furniture f : furnitureList) {
            String condition = f.getCondition();

            switch (condition) {
                case "New":
                    newCount++;
                    break;
                case "Good":
                    goodCount++;
                    break;
                case "Damaged":
                    damagedCount++;
                    break;
                default:
                    break;
            }
        }

        return "New: " + newCount + "\n" + "Good: " + goodCount + "\n" + "Damaged: " + damagedCount + "\n";
    }

    public String createReport() {
        Furniture oldestItem = this.findOldestItem();
        Furniture newestItem = this.findNewestItem();
        Furniture leastExpensiveItem = this.findLeastExpensiveItem();
        Furniture mostExpensiveItem = this.findMostExpensivePrice();
        float[] startingPricesArray = this.extractPrices();

        String report = "Total number of items in inventory is " + this.getSize() + "\n";
        report += "The oldest item is under ID " + oldestItem.getId() + ", year of origin: " + oldestItem.getYearOfOrigin() + "\n";
        report += "The newest item is under ID " + newestItem.getId() + ", year of origin: " + newestItem.getYearOfOrigin() + "\n";
        report += "The least expensive item is under ID " + leastExpensiveItem.getId() + ", starting price: " + leastExpensiveItem.getStartingPrice() + "\n";
        report += "The most expensive item is under ID " + mostExpensiveItem.getId() + ", starting price: " + mostExpensiveItem.getStartingPrice() + "\n";
        report += "Breakdown of items by condition:\n" + this.getBreakdownByCondition();
        report += "The average deviation of starting prices is " + this.calculateAverageDeviation(startingPricesArray) + "\n";
        report += "The standard deviation of starting prices is " + this.calculateStandardDeviation(startingPricesArray) + "\n";

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
