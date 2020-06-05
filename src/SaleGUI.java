import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import net.miginfocom.swing.*;
import org.w3c.dom.events.Event;


/**
 * @author Muhammad Ahmed
 */
public class SaleGUI {
    JFrame frame;
    int id;

    public SaleGUI() {

        frame = new JFrame();
        initComponents();
        frame.setSize(600, 450);
        frame.setVisible(true);

    }

    private void initComponents() {

        firstPanel = new JPanel();
        titleLabel = new JLabel();
        subLabel = new JLabel();
        idLabel = new JLabel();
        idField = new JTextField();
        searchBtn = new JButton();
        promptLabel = new JLabel();
        nameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        nameArea = new JTextArea();
        priceLabel = new JLabel();
        scrollPane2 = new JScrollPane();
        priceArea = new JTextArea();
        continueBtn = new JButton();
        backBtn = new JButton();



        secondPanel = new JPanel();
        titleLabel2 = new JLabel();
        subLabel2 = new JLabel();
        nameLabel2 = new JLabel();
        cnameField = new JTextField();
        emailLabel = new JLabel();
        emailField = new JTextField();
        noLabel = new JLabel();
        noField = new JTextField();
        rollerLabel = new JLabel();
        comboField = new JComboBox();
        type1Label = new JLabel();
        type1Field = new JTextField();
        type2Label = new JLabel();
        type2Field = new JTextField();
        backBtn2 = new JButton();
        submitBtn = new JButton();

        //======== this ========
        var contentPane = frame.getContentPane();
        contentPane.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]"));

        {

            secondPanel.setLayout(new MigLayout(
                    "fill,hidemode 3",
                    // columns
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
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]"));

            //---- titleLabel2 ----
            titleLabel2.setText("Customer Details");
            titleLabel2.setFont(new Font(".SF NS", Font.BOLD, 18));
            secondPanel.add(titleLabel2, "cell 1 0 3 1");

            //---- subLabel2 ----
            subLabel2.setText("Please enter the required details to complete the purchase:");
            secondPanel.add(subLabel2, "cell 1 2 5 1");

            //---- nameLabel2 ----
            nameLabel2.setText("Name:");
            secondPanel.add(nameLabel2, "cell 1 4,alignx left,growx 0");
            secondPanel.add(cnameField, "cell 2 4 3 1");

            //---- emailLabel ----
            emailLabel.setText("Email Address:");
            secondPanel.add(emailLabel, "cell 1 5,alignx left,growx 0");
            secondPanel.add(emailField, "cell 2 5 3 1");

            //---- noLabel ----
            noLabel.setText("Phone No:");
            secondPanel.add(noLabel, "cell 1 6,alignx left,growx 0");
            secondPanel.add(noField, "cell 2 6 3 1");

            //---- rollerLabel ----
            rollerLabel.setText("Payment Through:");
            secondPanel.add(rollerLabel, "cell 1 8");
            secondPanel.add(comboField, "cell 2 8 3 1");

            comboField.addItem("Credit/Debit Card");
            comboField.addItem("Cash");

            comboField.addActionListener(handleCombo);
            comboField.setSelectedIndex(0);

            //---- type1Label ----
            type1Label.setText("Card Type:");
            secondPanel.add(type1Label, "cell 1 9");
            secondPanel.add(type1Field, "cell 2 9 3 1");

            //---- type2Label ----
            type2Label.setText("Card No:");
            secondPanel.add(type2Label, "cell 1 10");
            secondPanel.add(type2Field, "cell 2 10 3 1");

            //---- backBtn2 ----
            backBtn2.setText("Go Back");
            backBtn2.addActionListener(handleBack);
            secondPanel.add(backBtn2, "cell 2 14");

            //---- button1 ----
            submitBtn.setText("Submit");
            submitBtn.addActionListener(handleSubmit);
            secondPanel.add(submitBtn, "cell 3 14");
        }


        //======== firstPanel ========
        {


            firstPanel.setLayout(new MigLayout(
                    "fill,hidemode 3",
                    // columns
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
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]"));

            //---- titleLabel ----
            titleLabel.setText("Make a Sale");
            titleLabel.setFont(new Font(".SF NS", Font.BOLD, 18));
            firstPanel.add(titleLabel, "cell 1 0 3 1");

            //---- subLabel ----
            subLabel.setText("Please enter the product's id to make a sale:");
            firstPanel.add(subLabel, "cell 1 2 4 1");

            //---- idLabel ----
            idLabel.setText("id:");
            firstPanel.add(idLabel, "cell 1 4,alignx right,growx 0");
            firstPanel.add(idField, "cell 2 4 2 1");

            //---- searchBtn ----
            searchBtn.setText("Search");
            firstPanel.add(searchBtn, "cell 2 5");
            searchBtn.addActionListener(handleSearch);

            //---- promptLabel ----
            promptLabel.setText("Following are the product's details:");
            firstPanel.add(promptLabel, "cell 1 8 4 1");

            //---- nameLabel ----
            nameLabel.setText("Name:");
            firstPanel.add(nameLabel, "cell 1 10,alignx right,growx 0");

            //======== scrollPane1 ========
            {

                //---- nameArea ----
                nameArea.setEditable(false);
                nameArea.setEnabled(false);
                scrollPane1.setViewportView(nameArea);
            }
            firstPanel.add(scrollPane1, "cell 2 10 2 1");

            //---- priceLabel ----
            priceLabel.setText("Price:");
            firstPanel.add(priceLabel, "cell 1 12,alignx right,growx 0");

            //======== priceArea ========
            {

                //---- textArea2 ----
                priceArea.setEditable(false);
                priceArea.setEnabled(false);
                scrollPane2.setViewportView(priceArea);
            }
            firstPanel.add(scrollPane2, "cell 2 12 2 1");

            backBtn.setText("Go Back");
            backBtn.addActionListener(handleBack);
            firstPanel.add(backBtn, "cell 2 15");

            //---- button2 ----
            continueBtn.setText("Continue");
            continueBtn.setEnabled(false);
            continueBtn.addActionListener(handleNext);
            firstPanel.add(continueBtn, "cell 2 14");
        }


        secondPanel.setVisible(false);
        contentPane.add(secondPanel, "cell 0 0,alignx center,growx 0");
        contentPane.add(firstPanel, "cell 0 0");

        frame.pack();
        frame.setLocationRelativeTo(frame.getOwner());

    }


    private JPanel firstPanel;
    private JLabel titleLabel;
    private JLabel subLabel;
    private JLabel idLabel;
    private JTextField idField;
    private JButton searchBtn;
    private JLabel promptLabel;
    private JLabel nameLabel;
    private JScrollPane scrollPane1;
    private JTextArea nameArea;
    private JLabel priceLabel;
    private JScrollPane scrollPane2;
    private JTextArea priceArea;
    private JButton continueBtn;
    private JButton backBtn;
    private JPanel secondPanel;
    private JLabel titleLabel2;
    private JLabel subLabel2;
    private JLabel nameLabel2;
    private JTextField cnameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel noLabel;
    private JTextField noField;
    private JLabel rollerLabel;
    private JComboBox comboField;
    private JLabel type1Label;
    private JTextField type1Field;
    private JLabel type2Label;
    private JTextField type2Field;
    private JButton backBtn2;
    private JButton submitBtn;


    ActionListener handleSearch = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!SignUp.isNumeric(idField.getText())) {
                JOptionPane.showMessageDialog(frame,
                        "id entered is not a valid number", "ERROR", JOptionPane.ERROR_MESSAGE);
                idField.setText("");
                nameArea.setEnabled(false);
                priceArea.setEnabled(false);
                continueBtn.setEnabled(false);
                nameArea.setText("");
                priceArea.setText("");
            } else {
                id = Integer.parseInt(idField.getText());
                if (Store.inventory.get(id) == null) {
                    JOptionPane.showMessageDialog(frame,
                            "Product not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    idField.setText("");
                    nameArea.setEnabled(false);
                    priceArea.setEnabled(false);
                    continueBtn.setEnabled(false);
                    nameArea.setText("");
                    priceArea.setText("");
                } else {
                    String productName = Store.inventory.get(id).getName();
                    int price = Store.inventory.get(id).getPrice();

                    idField.setText("");
                    nameArea.setText(productName);
                    priceArea.setText(String.valueOf(price));
                    nameArea.setEnabled(true);
                    priceArea.setEnabled(true);
                    continueBtn.setEnabled(true);

                }
            }
        }
    };
    ActionListener handleBack = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!secondPanel.isVisible()) {
                frame.setVisible(false);
                LandingPage.frame.setVisible(true);
            } else {
                secondPanel.setVisible(false);
                firstPanel.setVisible(true);
            }
        }
    };
    ActionListener handleNext = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstPanel.setVisible(false);
            secondPanel.setVisible(true);
        }
    };
    ActionListener handleCombo = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (comboField.getSelectedIndex() == 0) {
                type1Label.setText("Card Type:");
                type2Label.setText("Card No:");
                type2Label.setVisible(true);
                type1Field.setText("");
                type2Field.setText("");
                type2Field.setVisible(true);

            } else {
                type1Field.setText("");
                type1Label.setText("Amount Paid:");
                type2Label.setVisible(false);
                type2Field.setVisible(false);
            }
        }
    };
    ActionListener handleSubmit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = cnameField.getText();
            String email = emailField.getText();
            String phoneNo = noField.getText();
            if (name.equals("") || email.equals("") || phoneNo.equals("")) {
                JOptionPane.showMessageDialog(frame,
                        "One or more fields are empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (comboField.getSelectedIndex() == 0 && (type1Field.getText().equals("") || type2Field.getText().equals(""))) {
                    JOptionPane.showMessageDialog(frame,
                            "One or more fields are empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (comboField.getSelectedIndex() == 0 && (type1Field.getText().equals(""))) {
                    JOptionPane.showMessageDialog(frame,
                            "One or more fields are empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (comboField.getSelectedIndex() == 0) {
                        if (!SignUp.isNumeric(type2Field.getText()))
                            JOptionPane.showMessageDialog(frame,
                                    "Card number can only contain numeric digits!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        else if (Store.cards.get(type2Field.getText())==null) {
                            JOptionPane.showMessageDialog(frame,
                                    "Card invalid!", "ERROR", JOptionPane.ERROR_MESSAGE);

                        }else if(Store.cards.get(type2Field.getText()).balance<Store.inventory.get(id).getPrice()){
                            JOptionPane.showMessageDialog(frame,
                                    "Insufficient funds", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(frame,
                                    "Payment Successful", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                             Item item =Store.inventory.get(id);
                             frame.setVisible(false);
                            ReceiptGUI receiptGUI = new ReceiptGUI(item.getName(),String.valueOf(item.getiD()),String.valueOf(item.getPrice()),name,phoneNo,email,"Credit/Debit Card","Null");
                        }
                    }else{
                        if(!SignUp.isNumeric(type1Field.getText())){
                            JOptionPane.showMessageDialog(frame,
                                    "Cash not valid", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }else{
                            Cash cash = new Cash(Double.parseDouble(type1Field.getText()),true);
                            double remaining= cash.canMake(Store.inventory.get(id).getPrice());
                            if(remaining<0){
                                JOptionPane.showMessageDialog(frame,
                                        "Insufficient Funds", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(frame,
                                        "Payment Successful", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                                Item item =Store.inventory.get(id);
                                frame.setVisible(false);
                                ReceiptGUI receiptGUI = new ReceiptGUI(item.getName(),String.valueOf(item.getiD()),String.valueOf(item.getPrice()),name,phoneNo,email,"Cash",String.valueOf(remaining));

                            }
                        }

                    }
                }

            }
        }
    };
}
