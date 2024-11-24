import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AuctionHouseGUI extends JFrame implements ActionListener {
    private JButton moreInfo, edit;
    private DefaultListModel<Collectible> collectibleListModel;
    private JList<Collectible> collectibleList;

    //constructor
    public AuctionHouseGUI(String title){
        super(title);
        this.setSize(400,400);
        this.setLocation(100,100);
        this.makeLayout();
        this.setClicks();
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
        moreInfo = new JButton("More info");
        edit = new JButton("Edit");
        collectibleList = new JList<>();
        // create containers
        JPanel bottom = new JPanel();
        JScrollPane scrollList = new JScrollPane(collectibleList);
        // add components to containers
        bottom.add(moreInfo);
        bottom.add(edit);
        // add containers to frame
        this.add(bottom, BorderLayout.SOUTH);
        this.add(scrollList, BorderLayout.CENTER);
    }

    //private method adding click commands to buttons
    private void setClicks(){
        moreInfo.setActionCommand("moreInfo");
        edit.setActionCommand("edit");
        moreInfo.addActionListener(this);
        edit.addActionListener(this);
    }

    //event handler for the button clicks
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        if(command.equals("moreInfo")
                && !collectibleList.isSelectionEmpty()){
            Collectible c = collectibleList.getSelectedValue();
            String message = c.getDetails();
            JOptionPane.showMessageDialog(this, message, "Collectible details", JOptionPane.INFORMATION_MESSAGE);
            collectibleList.updateUI();
        }
        else if(command.equals("edit")
                && !collectibleList.isSelectionEmpty()){
            Collectible c = collectibleList.getSelectedValue();
            // set new price
            float initialStartingPrice = c.getStartingPrice();
            String newPriceInput = JOptionPane.showInputDialog(this, "Enter new price:", initialStartingPrice);
            if (newPriceInput != null) { // user didn't cancel the input dialog
                try {
                    float newPrice = Float.parseFloat(newPriceInput);
                    c.changeStartingPrice(newPrice);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please provide a number.", "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
            }
            collectibleList.updateUI();
        }
    }

     //command to set the content of the device list
    public void setCollectibleListContent(ArrayList<Collectible> collectibles){
        collectibleListModel = new DefaultListModel<>();
        collectibleListModel.addAll(collectibles);
        collectibleList.setModel(collectibleListModel);
    }
}
