import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CollectibleList {
    private ArrayList<Collectible> collectibles;

    //create an empty arraylist
    public CollectibleList() {
        this.collectibles = new ArrayList<>();
    }

    //return the list of collectibles
    public ArrayList<Collectible> listAllCollectibles(){
        return collectibles;
    }

    //sort list of collectibles by Id
    public void sortCollectiblesById(){
        Collections.sort(collectibles, new IdComparator());
    }
    //sort list of collectibles by starting price
    public void sortCollectiblesByPrice(){
        Collections.sort(collectibles, new PriceComparator());
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

    //return the oldest item in collectibles using the low estimate
    public Collectible findOldestItem() {
        Collectible oldestItem = this.collectibles.getFirst();
        for (Collectible c : this.collectibles) {
            if (oldestItem.getYearOfOrigin().getLow() > c.getYearOfOrigin().getLow())
                oldestItem = c;
        }

        return oldestItem;
    }

    //return the newest item in collectibles using high estimate
    public Collectible findNewestItem() {
        Collectible newestItem = this.collectibles.getFirst();
        for (Collectible c : this.collectibles) {
            if (newestItem.getYearOfOrigin().getHigh() < c.getYearOfOrigin().getHigh())
                newestItem = c;
        }

        return newestItem;
    }

    //return the oldest item in collectibles using middle estimate
    public Collectible findOldestItemMiddle() {
        Collectible oldestItem = this.collectibles.getFirst();
        for (Collectible c : this.collectibles) {
            if (oldestItem.getYearOfOrigin().getMiddleEstimate() > c.getYearOfOrigin().getMiddleEstimate())
                oldestItem = c;
        }

        return oldestItem;
    }

    //return the newest item in collectibles using middle estimate
    public Collectible findNewestItemMiddle() {
        Collectible newestItem = this.collectibles.getFirst();
        for (Collectible c : this.collectibles) {
            if (newestItem.getYearOfOrigin().getMiddleEstimate() < c.getYearOfOrigin().getMiddleEstimate())
                newestItem = c;
        }

        return newestItem;
    }

    //return items with the top 3 most differences in year estimates
    public Collectible[] findTopThreeWithMostYearsDifferences() {
        Collectible[] items = new Collectible[3];

        for (Collectible c : this.collectibles) {
            int difference = c.getYearOfOrigin().getDifference();

            if (items[0] == null || difference > items[0].getYearOfOrigin().getDifference()) {
                items[2] = items[1];
                items[1] = items[0];
                items[0] = c;
            } else if (items[1] == null || difference > items[1].getYearOfOrigin().getDifference()) {
                items[2] = items[1];
                items[1] = c;
            } else if (items[2] == null || difference > items[2].getYearOfOrigin().getDifference()) {
                items[2] = c;
            }
        }

        return items;
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
            Collectible.ConditionType condition = c.getCondition();

            switch (condition) {
                case Collectible.ConditionType.MINT:
                    newCount++;
                    break;
                case Collectible.ConditionType.RESTORED:
                    goodCount++;
                    break;
                case Collectible.ConditionType.NEEDS_RESTORING:
                    damagedCount++;
                    break;
                default:
                    break;
            }
        }

        return "Mint: " + newCount + "\n" + "Restored: " + goodCount + "\n" + "Needs restoring: " + damagedCount + "\n";
    }

    public String createReport() {
        Collectible oldestItem = this.findOldestItem();
        Collectible newestItem = this.findNewestItem();
        Collectible oldestItemMiddle = this.findOldestItemMiddle();
        Collectible newestItemMiddle = this.findNewestItemMiddle();
        Collectible[] itemsWithMostYearsDifferences = this.findTopThreeWithMostYearsDifferences();
        Collectible leastExpensiveItem = this.findLeastExpensiveItem();
        Collectible mostExpensiveItem = this.findMostExpensivePrice();
        float[] startingPricesArray = this.extractPrices();

        String report = "Total number of items in inventory is " + this.getSize() + "\n";
        report += "The oldest item using low estimate is under ID " + oldestItem.getId() + ", year of origin: " + oldestItem.getYearOfOrigin().getLow() + "\n";
        report += "The newest item using high estimate is under ID " + newestItem.getId() + ", year of origin: " + newestItem.getYearOfOrigin().getHigh() + "\n";
        report += "The oldest item using middle estimate is under ID " + oldestItem.getId() + ", year of origin: " + oldestItemMiddle.getYearOfOrigin().getMiddleEstimate() + "\n";
        report += "The newest item using middle estimate is under ID " + newestItem.getId() + ", year of origin: " + newestItemMiddle.getYearOfOrigin().getMiddleEstimate() + "\n";
        report += "The top three items with the most years differences are: ID " + itemsWithMostYearsDifferences[0].getId() + ", difference: " + itemsWithMostYearsDifferences[0].getYearOfOrigin().getDifference()
                + ", ID " + itemsWithMostYearsDifferences[1].getId() + ", difference: " + itemsWithMostYearsDifferences[1].getYearOfOrigin().getDifference()
                + ", ID " + itemsWithMostYearsDifferences[2].getId() + ", difference: " + itemsWithMostYearsDifferences[2].getYearOfOrigin().getDifference() + "\n";

        report += "The least expensive item is under ID " + leastExpensiveItem.getId() + ", starting price: " + leastExpensiveItem.getStartingPrice() + "\n";
        report += "The most expensive item is under ID " + mostExpensiveItem.getId() + ", starting price: " + mostExpensiveItem.getStartingPrice() + "\n";
        report += "Breakdown of items by condition:\n" + this.getBreakdownByCondition();
        report += "The average deviation of starting prices is " + this.calculateAverageDeviation(startingPricesArray) + "\n";
        report += "The standard deviation of starting prices is " + this.calculateStandardDeviation(startingPricesArray) + "\n";

        return report;
    }

    public void writeReportToFile() {
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeReportToFile("AuctionHouse/datasets/furniture_statistics.txt", this.createReport());
    }

    public void saveUpdatedCollectibleList(String collectibleFilename) {
        File f = new File(collectibleFilename);

        try(PrintWriter writer = new PrintWriter(f)) {
            for (Collectible c : this.collectibles) {
                writer.println(c.toCSVAttributes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
