public class Main{

    public static void main(String[] args) {
        FurnitureList furnitureList = new FurnitureList();

        furnitureList.populate("AuctionHouse/datasets/furniture_items.csv");

        //get number of items
        int numberOfItems = furnitureList.getSize();
        System.out.println(numberOfItems);

    }
}