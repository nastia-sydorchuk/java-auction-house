import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AuctionHouseGUI extends JFrame implements ActionListener {
    private JButton moreInfo, edit, sortById, sortByPrice, generateSummary, save;
    private JList<Collectible> collectibleJList;
    private CollectibleList collectibleList;

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
        sortById = new JButton("Sort by ID");
        sortByPrice = new JButton("Sort by starting price");
        generateSummary = new JButton("Generate Summary");
        save = new JButton("Save");
        collectibleJList = new JList<>();
        // create containers
        JPanel bottom = new JPanel();
        JPanel top = new JPanel();
        JScrollPane scrollList = new JScrollPane(collectibleJList);
        // add components to containers
        top.add(sortById);
        top.add(sortByPrice);
        top.add(save);
        bottom.add(moreInfo);
        bottom.add(edit);
        bottom.add(generateSummary);
        // add containers to frame
        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(scrollList, BorderLayout.CENTER);
    }

    //private method adding click commands to buttons
    private void setClicks(){
        moreInfo.setActionCommand("moreInfo");
        edit.setActionCommand("edit");
        sortById.setActionCommand("sortById");
        sortByPrice.setActionCommand("sortByPrice");
        generateSummary.setActionCommand("generateSummary");
        save.setActionCommand("save");

        moreInfo.addActionListener(this);
        edit.addActionListener(this);
        sortById.addActionListener(this);
        sortByPrice.addActionListener(this);
        generateSummary.addActionListener(this);
        save.addActionListener(this);
    }

    //event handler for the button clicks
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        if(command.equals("moreInfo")
                && !collectibleJList.isSelectionEmpty()){
            Collectible c = collectibleJList.getSelectedValue();
            String message = c.getDetails();
            JOptionPane.showMessageDialog(this, message, "Collectible details", JOptionPane.INFORMATION_MESSAGE);
            collectibleJList.updateUI();
        }
        else if(command.equals("edit")
                && !collectibleJList.isSelectionEmpty()){
            Collectible c = collectibleJList.getSelectedValue();
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
            // set new condition
            Collectible.ConditionType[] conditions = Collectible.ConditionType.values();
            Collectible.ConditionType initialCondition = c.getCondition();
            Collectible.ConditionType newCondition = (Collectible.ConditionType) JOptionPane.showInputDialog(
                    this,
                    "Select new condition:",
                    "Edit Condition",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    conditions,
                    initialCondition
            );
            if (newCondition != null) {
                c.changeCondition(newCondition);
            }
            // update UI
            collectibleJList.updateUI();
        }
        else if(command.equals("sortById")){
            collectibleList.sortCollectiblesById();
            this.setCollectibleListContent(collectibleList.listAllCollectibles());
        }
        else if(command.equals("sortByPrice")){
            collectibleList.sortCollectiblesByPrice();
            this.setCollectibleListContent(collectibleList.listAllCollectibles());
        }
        else if(command.equals("generateSummary")){
            collectibleList.writeReportToFile();
            JOptionPane.showMessageDialog(this, "Summary generated successfully!");
        }
        else if(command.equals("save")){
            collectibleList.saveUpdatedCollectibleList("AuctionHouse/datasets/furniture_items_updated.csv");
            JOptionPane.showMessageDialog(this, "Data saved successfully!");
        }
    }

    //command to set the content of the collectible list
    private void setCollectibleListContent(ArrayList<Collectible> collectibles){
        DefaultListModel<Collectible> collectibleListModel = new DefaultListModel<>();
        collectibleListModel.addAll(collectibles);
        collectibleJList.setModel(collectibleListModel);
    }

    //command to update the collectibleList and the content of the collectible list
    public void setCollectibleList(CollectibleList collectibles){
        this.collectibleList = collectibles;
        this.setCollectibleListContent(collectibles.listAllCollectibles());
    }
}
