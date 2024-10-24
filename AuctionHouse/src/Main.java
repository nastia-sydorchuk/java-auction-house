public class Main{

    public static void main(String[] args) {
        FurnitureList furnitureList = new FurnitureList();

        // populate with proper data
        furnitureList.populate("AuctionHouse/datasets/furniture_items.csv");
        // populate with missing fields data
        // furnitureList.populate("AuctionHouse/datasets/furniture_items_missing_fields.csv");
        // populate with wrongly typed data
        // furnitureList.populate("AuctionHouse/datasets/furniture_items_wrong_types.csv");


        //create a report
        furnitureList.writeReportToFile("AuctionHouse/datasets/furniture_statistics.txt");
    }
}