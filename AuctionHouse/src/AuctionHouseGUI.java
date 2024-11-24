import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AuctionHouseGUI extends JFrame {
    private DefaultListModel<Collectible> collectibleListModel;
    private JList<Collectible> collectibleList;

    //constructor
    public AuctionHouseGUI(String title){
        super(title);
        this.setSize(400,400);
        this.setLocation(100,100);
        this.makeLayout();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("System closing");
                super.windowClosing(e);
            }
        });
    }

    //generate the UI layout
    private void makeLayout(){
        // instantiate components
        collectibleList = new JList<>();
        // create containers
        JScrollPane scrollList = new JScrollPane(collectibleList);
        // add containers to frame
        this.add(scrollList, BorderLayout.CENTER);
    }

     //command to set the content of the device list
    public void setCollectibleListContent(ArrayList<Collectible> collectibles){
        collectibleListModel = new DefaultListModel<>();
        collectibleListModel.addAll(collectibles);
        collectibleList.setModel(collectibleListModel);
    }
}
