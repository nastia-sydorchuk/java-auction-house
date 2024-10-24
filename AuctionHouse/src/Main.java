public class Main{

    public static void main(String[] args) {
        FurnitureList furnitureList = new FurnitureList();

        furnitureList.populate("AuctionHouse/datasets/furniture_items.csv");

        //create a report
        furnitureList.writeReportToFile("AuctionHouse/datasets/furniture_statistics.txt");
    }
}