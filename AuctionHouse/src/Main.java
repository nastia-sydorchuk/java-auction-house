public class Main{

    public static void main(String[] args) {
        FurnitureList furnitureList = new FurnitureList();

        furnitureList.populate();

        //get number of items
        int numberOfItems = furnitureList.getSize();
        System.out.println(numberOfItems);

        //get oldest item id
        int oldestItemId = furnitureList.findOldestItemId();
        System.out.println("The oldest item is with id " + oldestItemId);

        //get newest item id
        int newestItemId = furnitureList.findNewestItemId();
        System.out.println("The newest item is with id " + newestItemId);

        //get the cheapest price
        float cheapestPrice = furnitureList.findCheapestPrice();
        System.out.println("The cheapest price is " + cheapestPrice);

        //get the most expensive price
        float mostExpensivePrice = furnitureList.findMostExpensivePrice();
        System.out.println("The cheapest price is " + mostExpensivePrice);

        System.out.println("Hello Auction House");
    }
}