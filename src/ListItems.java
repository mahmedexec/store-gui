import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.*;




/**
 * @author Muhammad Ahmed
 */
public class ListItems extends JFrame {
    public ListItems() {
        initComponents();
        setSize(600,450);
        setVisible(true);

    }

    private void initComponents() {

        titleLabel = new JLabel();
        subLabel = new JLabel();
        listLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        itemList = new JList();
        nameLabel = new JLabel();
        scrollPane2 = new JScrollPane();
        productArea = new JTextArea();
        priceLabel = new JLabel();
        scrollPane3 = new JScrollPane();
        priceArea = new JTextArea();
        idLabel = new JLabel();
        scrollPane4 = new JScrollPane();
        idArea = new JTextArea();
        descLabel = new JLabel();
        scrollPane5 = new JScrollPane();
        descArea = new JTextArea();
        backBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3,alignx center",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- titleLabel ----
        titleLabel.setText("List Inventory");
        titleLabel.setFont(new Font(".SF NS", Font.BOLD, 18));
        contentPane.add(titleLabel, "cell 1 1 10 1");

        //---- subLabel ----
        subLabel.setText("Please select an item to view details:");
        contentPane.add(subLabel, "cell 1 2 9 1");

        //---- listLabel ----
        listLabel.setText("Items:");
        listLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        contentPane.add(listLabel, "cell 1 4 2 1");

        SortedListModel listModel = new SortedListModel();
        Iterator i = Store.inventory.keySet().iterator();
        while(i.hasNext()){
            listModel.add(Store.inventory.get(i.next()).getName());
        }



        itemList.setModel(listModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        itemList.addListSelectionListener(handleSelect);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(itemList);
        }
        contentPane.add(scrollPane1, "cell 1 5 4 4");

        //---- nameLabel ----
        nameLabel.setText("Product Name:");
        contentPane.add(nameLabel, "cell 7 5");
productArea.setEditable(false);
        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(productArea);
        }
        contentPane.add(scrollPane2, "cell 8 5 9 1");

        //---- priceLabel ----
        priceLabel.setText("Price:");
        contentPane.add(priceLabel, "cell 7 6");
priceArea.setEditable(false);
        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(priceArea);
        }
        contentPane.add(scrollPane3, "cell 8 6 9 1");

        //---- idLabel ----
        idLabel.setText("id:");
        contentPane.add(idLabel, "cell 7 7");
idArea.setEditable(false);
        //======== scrollPane4 ========
        {
            scrollPane4.setViewportView(idArea);
        }
        contentPane.add(scrollPane4, "cell 8 7 9 1");

        //---- descLabel ----
        descLabel.setText("Description:");
        contentPane.add(descLabel, "cell 7 8");
descArea.setEditable(false);
        //======== scrollPane5 ========
        {

            //---- descArea ----
            descArea.setRows(5);
            scrollPane5.setViewportView(descArea);
        }
        contentPane.add(scrollPane5, "cell 8 8 9 1");

        //---- backBtn ----
        backBtn.setText("Go Back");
        backBtn.addActionListener(handleBack);
        contentPane.add(backBtn, "cell 12 10 5 1");
        pack();
        setLocationRelativeTo(getOwner());

    }


    private JLabel titleLabel;
    private JLabel subLabel;
    private JLabel listLabel;
    private JScrollPane scrollPane1;
    private JList itemList;
    private JLabel nameLabel;
    private JScrollPane scrollPane2;
    private JTextArea productArea;
    private JLabel priceLabel;
    private JScrollPane scrollPane3;
    private JTextArea priceArea;
    private JLabel idLabel;
    private JScrollPane scrollPane4;
    private JTextArea idArea;
    private JLabel descLabel;
    private JScrollPane scrollPane5;
    private JTextArea descArea;
    private JButton backBtn;

    ListSelectionListener handleSelect =new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int id;
           if(!e.getValueIsAdjusting()){
            String productName = (String)itemList.getSelectedValue();
               Iterator i = Store.inventory.keySet().iterator();

               while(i.hasNext()){
                   id = (int)i.next();
                   if(Store.inventory.get(id).getName().equals(productName)){
                       productArea.setText(productName);
                       idArea.setText(String.valueOf(id));
                       priceArea.setText(String.valueOf(Store.inventory.get(id).getPrice()));
                       descArea.setText(Store.inventory.get(id).getDescription());
                   }
               }


           }
        }
    };
     ActionListener handleBack = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            LandingPage.frame.setVisible(true);
        }
    };
}
