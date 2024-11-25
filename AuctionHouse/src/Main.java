public class Main{

    public static void main(String[] args) {
        CollectibleList collectibleList = new CollectibleList();

        // populate with proper data
        collectibleList.populate("AuctionHouse/datasets/furniture_items.csv");
        // populate with missing fields data
        //collectibleList.populate("AuctionHouse/datasets/furniture_items_missing_fields.csv");
        // populate with wrongly typed data
        //collectibleList.populate("AuctionHouse/datasets/furniture_items_wrong_types.csv");

        System.out.println(collectibleList);

        //create a report
        collectibleList.writeReportToFile();

        AuctionHouseGUI gui = new AuctionHouseGUI("Auction House");
        gui.setVisible(true);
        gui.setCollectibleList(collectibleList);
    }
}