import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import net.miginfocom.swing.*;



/**
 * @author Muhammad Ahmed
 */
public class  LandingPage  {
   static JFrame frame;
    public LandingPage(String username) {
        System.out.println("-------------Landing page---------------");
        frame = new JFrame();
        initComponents(username);
        frame.setTitle("Main Page");
        frame.setVisible(true);
        frame.setSize(600, 450);
    }


    private void initComponents(String username) {

        titleLabel = new JLabel();
        usernameLabel = new JLabel();
        logoutBtn = new JButton();
        prompt = new JLabel();
        addItemRadio = new JRadioButton();
        checkitemsRadio = new JRadioButton();
        makesaleRadio = new JRadioButton();
        okBtn = new JButton();
        buttonGroup = new ButtonGroup();

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
                        "[]"));

        //---- titleLabel ----
        titleLabel.setText("Main Page");
        titleLabel.setFont(new Font(".SF NS", titleLabel.getFont().getStyle() | Font.BOLD, 18));
        contentPane.add(titleLabel, "cell 0 2 3 1");

        //---- usernameLabel ----
        usernameLabel.setText(username);
        usernameLabel.setFont(new Font("Fira Code", Font.BOLD, 14));
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(usernameLabel, "cell 5 2");

        //---- logoutBtn ----
        logoutBtn.setText("Log Out");
        contentPane.add(logoutBtn, "cell 5 3");
        logoutBtn.addActionListener(handleLogout);

        //---- prompt ----
        prompt.setText("Please select one of the following options:");
        contentPane.add(prompt, "cell 0 6 6 1");

        //---- addItemRadio ----
        addItemRadio.setText("Add an item to the inventory");
        addItemRadio.setActionCommand("add");
        contentPane.add(addItemRadio, "cell 0 7 5 1");

        //---- checkitemsRadio ----
        checkitemsRadio.setText("Check Inventory");
        contentPane.add(checkitemsRadio, "cell 0 8 5 1");
        checkitemsRadio.setActionCommand("check");

        //---- makesaleRadio ----
        makesaleRadio.setText("Make a sale");
        contentPane.add(makesaleRadio, "cell 0 9 5 1");
        makesaleRadio.setActionCommand("sale");

        buttonGroup.add(addItemRadio);
        buttonGroup.add(checkitemsRadio);
        buttonGroup.add(makesaleRadio);

        //---- okBtn ----
        okBtn.setText("OK");
        contentPane.add(okBtn, "cell 0 10");
        okBtn.addActionListener(handleOk);
        frame.pack();
        frame.setLocationRelativeTo(frame.getOwner());

    }


    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JButton logoutBtn;
    private JLabel prompt;
    private JRadioButton addItemRadio;
    private JRadioButton checkitemsRadio;
    private JRadioButton makesaleRadio;
    private JButton okBtn;
    private ButtonGroup buttonGroup;

    ActionListener handleLogout = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            OnlineStoreGUI.frame.setVisible(true);
        }
    };
    ActionListener handleOk = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (buttonGroup.getSelection().getActionCommand()){
                case "add":
                    frame.setVisible(false);
                    AddItemGUI addItemGUI = new AddItemGUI();
                    break;

                case "check":
                    frame.setVisible(false);
                    ListItems listItems = new ListItems();
                    break;
                case "sale":
                    frame.setVisible(false);
                    SaleGUI saleGUI = new SaleGUI();

                    break;
            }

        }
    };
}
