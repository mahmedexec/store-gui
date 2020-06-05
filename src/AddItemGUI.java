import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import net.miginfocom.swing.*;



/**
 * @author Muhammad Ahmed
 */
public class AddItemGUI {
    JFrame frame;

    public AddItemGUI() {
        frame = new JFrame("Add an item");
        initComponents();
        frame.setSize(600, 450);
        frame.setVisible(true);
    }

    private void initComponents() {

        titleLabel = new JLabel();
        promptLabel = new JLabel();
        nameLabel = new JLabel();
        nameField = new JTextField();
        priceLabel = new JLabel();
        priceField = new JTextField();
        idLabel = new JLabel();
        idField = new JTextField();
        descLabel = new JLabel();
        descField = new JTextField();
        submitBtn = new JButton();
        backBtn = new JButton();

        //======== this ========
        var contentPane = frame.getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3,alignx center",
                // columns
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
                        "[]"));

        //---- titleLabel ----
        titleLabel.setText("Add an Item");
        titleLabel.setFont(new Font(".SF NS", Font.BOLD, 18));
        contentPane.add(titleLabel, "cell 0 1 2 1");

        //---- promptLabel ----
        promptLabel.setText("Please enter the product details:");
        contentPane.add(promptLabel, "cell 0 3 7 1");

        //---- nameLabel ----
        nameLabel.setText("Name:");
        contentPane.add(nameLabel, "cell 0 4");
        contentPane.add(nameField, "cell 1 4 5 1");

        //---- priceLabel ----
        priceLabel.setText("Price(USD):");
        contentPane.add(priceLabel, "cell 0 5");
        contentPane.add(priceField, "cell 1 5 5 1");

        //---- idLabel ----
        idLabel.setText("id:");
        contentPane.add(idLabel, "cell 0 6");
        contentPane.add(idField, "cell 1 6 5 1");

        //---- descLabel ----
        descLabel.setText("Description:");
        contentPane.add(descLabel, "cell 0 7");
        contentPane.add(descField, "cell 1 7 5 1");


        //---- backBtn ----
        backBtn.setText("Go Back");
        backBtn.addActionListener(handleBack);
        contentPane.add(backBtn, "cell 3 8 3 1");

        //---- submitBtn ----
        submitBtn.setText("Submit");
        contentPane.add(submitBtn, "cell 1 8 2 1");
        submitBtn.addActionListener(handleSubmit);
        frame.pack();
        frame.setLocationRelativeTo(frame.getOwner());

    }


    private JLabel titleLabel;
    private JLabel promptLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel priceLabel;
    private JTextField priceField;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel descLabel;
    private JTextField descField;
    private JButton submitBtn;
    private JButton backBtn;



    ActionListener handleSubmit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String desc = descField.getText();

            if (name.equals("") || desc.equals("") || idField.getText().equals("") || priceField.getText().equals("")) {
                System.out.println("ERROR 1");
                JOptionPane.showMessageDialog(frame,
                        "One or more fields are empty", "Add item(s)", JOptionPane.ERROR_MESSAGE);
            } else if (!SignUp.isNumeric(idField.getText()) || !SignUp.isNumeric(priceField.getText())) {
                System.out.println("ERROR 2");

                JOptionPane.showMessageDialog(frame,
                        "id or Price is not a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                idField.setText("");
                priceField.setText("");
            } else {
                int price = Integer.parseInt(priceField.getText());
                int id = Integer.parseInt(idField.getText());
                if (Store.inventory.containsKey(id)) {
                    JOptionPane.showMessageDialog(frame,
                            "id already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    idField.setText("");
                }else
                {
                    Store.inventory.put(id,new Item(name,id,desc,price));
                    int selected=JOptionPane.showConfirmDialog(frame,
                            "Item added! \nAdd another item?", "Success", JOptionPane.YES_NO_OPTION);
                    if (selected==JOptionPane.YES_OPTION){
                        nameField.setText("");
                        priceField.setText("");
                        idField.setText("");
                        descField.setText("");
                    }else{

                        frame.setVisible(false);
                        LandingPage.frame.setVisible(true);
                    }

                }

            }

        }
    };
    ActionListener handleBack = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            LandingPage.frame.setVisible(true);
        }
    };
}
