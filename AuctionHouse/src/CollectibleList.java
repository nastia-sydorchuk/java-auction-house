import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectibleList {
    private ArrayList<Collectible> collectibles;

    //create an empty arraylist
    public CollectibleList() {
        this.collectibles = new ArrayList<>();
    }

    // populate collectible list with data from the file
    public void populate(String collectibleFilename) {
        File c = new File(collectibleFilename);
        try (Scanner scanner = new Scanner(c)) {
            CollectibleParser parser = new CollectibleParser();
            byte count = 0;
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                count++;
                Collectible collectible = parser.parseCollectibleFromLine(inputLine, count);
                if (collectible != null) {
                    this.addOneCollectible(collectible);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(collectibleFilename + " not found");
            System.exit(0);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }
    }

    public void addOneCollectible(Collectible c) {
        int id = c.getId();
        Collectible inList = this.findById(id);
        if (inList == null) {
            this.collectibles.add(c);
        }
    }

    public Collectible findById(int id){
        for (Collectible c : collectibles)
            if (c.getId() == id)
                return c;
        return null;
    }

    //return number of items in collectibles
    public int getSize() {
        return this.collectibles.size();
    }

    //return the oldest item in collectibles
    public Collectible findOldestItem() {
        Collectible oldestItem = this.collectibles.getFirst();
        for (Collectible c : this.collectibles) {
            if (oldestItem.getYearOfOrigin().getLow() > c.getYearOfOrigin().getLow())
                oldestItem = c;
        }

        return oldestItem;
    }

    //return the newest item in collectibles
    public Collectible findNewestItem() {
        Collectible newestItem = this.collectibles.getFirst();
        for (Collectible c : this.collectibles) {
            if (newestItem.getYearOfOrigin().getHigh() < c.getYearOfOrigin().getHigh())
                newestItem = c;
        }

        return newestItem;
    }

    //return the least expensive item in collectibles
    public Collectible findLeastExpensiveItem() {
        Collectible leastExpensiveItem = this.collectibles.getFirst();
        for (Collectible c : this.collectibles) {
            if (leastExpensiveItem.getStartingPrice() > c.getStartingPrice())
                leastExpensiveItem = c;
        }

        return leastExpensiveItem;
    }

    //return the most expensive item in collectibles
    public Collectible findMostExpensivePrice() {
        Collectible mostExpensiveItem = this.collectibles.getFirst();
        for (Collectible c : this.collectibles) {
            if (mostExpensiveItem.getStartingPrice() < c.getStartingPrice())
                mostExpensiveItem = c;
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
            prices[i] = this.collectibles.get(i).getStartingPrice();
        }

        return prices;
    }

    public String getBreakdownByCondition() {
        // Initialize counters for each condition
        int newCount = 0;
        int goodCount = 0;
        int damagedCount = 0;

        for (Collectible c : collectibles) {
            String condition = c.getCondition();

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
        Collectible oldestItem = this.findOldestItem();
        Collectible newestItem = this.findNewestItem();
        Collectible leastExpensiveItem = this.findLeastExpensiveItem();
        Collectible mostExpensiveItem = this.findMostExpensivePrice();
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
}
