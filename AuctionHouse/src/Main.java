public class Main{

    public static void main(String[] args) {
        CollectibleList collectibleList = new CollectibleList();

        // populate with proper data
        collectibleList.populate("AuctionHouse/datasets/furniture_items.csv");
        // populate with missing fields data
        // furnitureList.populate("AuctionHouse/datasets/furniture_items_missing_fields.csv");
        // populate with wrongly typed data
        // furnitureList.populate("AuctionHouse/datasets/furniture_items_wrong_types.csv");

        System.out.println(collectibleList);

        //create a report
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeReportToFile("AuctionHouse/datasets/furniture_statistics.txt", collectibleList.createReport());
    }
}