import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import net.miginfocom.swing.*;



/**
 * @author Muhammad Ahmed
 */
public class SignUp {
    JFrame frame;

    public SignUp() {
        frame = new JFrame("Sign Up");
        initComponents();
        frame.setSize(600, 450);
        frame.setVisible(true);

    }

    private void initComponents() {

        titleLabel = new JLabel();
        subtitleLabel = new JLabel();
        usernameLabel = new JLabel();
        usernameField = new JTextField();
        pinLabel = new JLabel();
        pinField = new JPasswordField();
        confirmLabel = new JLabel();
        confirmField = new JPasswordField();
        signupBtn = new JButton();
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
                        "[]"));

        //---- titleLabel ----
        titleLabel.setText("Sign Up");
        titleLabel.setFont(new Font(".SF NS", Font.BOLD, 18));
        contentPane.add(titleLabel, "cell 2 1");

        //---- subtitleLabel ----
        subtitleLabel.setText("Please enter your details to Sign Up");
        contentPane.add(subtitleLabel, "cell 2 2 3 1");

        //---- usernameLabel ----
        usernameLabel.setText("Username:");
        contentPane.add(usernameLabel, "cell 2 4");
        contentPane.add(usernameField, "cell 3 4 2 1");

        //---- pinLabel ----
        pinLabel.setText("PIN:");
        contentPane.add(pinLabel, "cell 2 5");
        contentPane.add(pinField, "cell 3 5 2 1");

        //---- confirmLabel ----
        confirmLabel.setText("Confirm PIN");
        contentPane.add(confirmLabel, "cell 2 6");
        contentPane.add(confirmField, "cell 3 6 2 1");

        //---- signupBtn ----
        signupBtn.setText("Sign Up");
        contentPane.add(signupBtn, "cell 3 7");
        signupBtn.addActionListener(handleSignup);

        //---- backBtn ----
        backBtn.setText("Go Back");
        contentPane.add(backBtn, "cell 4 7");
        backBtn.addActionListener(handleBack);

        frame.pack();
        frame.setLocationRelativeTo(frame.getOwner());

    }



    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel pinLabel;
    private JPasswordField pinField;
    private JLabel confirmLabel;
    private JPasswordField confirmField;
    private JButton signupBtn;
    private JButton backBtn;

    ActionListener handleSignup = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char[] password = pinField.getPassword();
            StringBuilder pinStr = new StringBuilder();
            for (char c : password) {
                pinStr.append(c);
            }
            char[] passwordcon = confirmField.getPassword();
            StringBuilder pinStr2 = new StringBuilder();
            for (char c : passwordcon) {
                pinStr2.append(c);
            }

            String username = usernameField.getText();
            String pin = pinStr.toString();
            String confirmPin = pinStr2.toString();


            if (username.equals("") || pin.equals("") || confirmPin.equals("")) {
                System.out.println("ERROR 1");
                JOptionPane.showMessageDialog(frame,
                        "one or more fields are empty", "Sign Up", JOptionPane.ERROR_MESSAGE);
            }else if(Store.AdminAccounts.containsValue(username)){
                JOptionPane.showMessageDialog(frame,
                        "Username already exists", "Sign Up", JOptionPane.WARNING_MESSAGE);
                usernameField.setText("");
                pinField.setText("");
                confirmField.setText("");
            }
            else if (!isNumeric(pin) || !isNumeric(confirmPin)) {
                System.out.println("ERROR 2");

                JOptionPane.showMessageDialog(frame,
                        "PIN entered is not a valid number", "Sign Up", JOptionPane.ERROR_MESSAGE);
                pinField.setText("");
                confirmField.setText("");
            }else if(Integer.parseInt(pin) != Integer.parseInt(confirmPin)){
                JOptionPane.showMessageDialog(frame,
                        "PINs Don't Match", "Sign Up", JOptionPane.ERROR_MESSAGE);
                pinField.setText("");
                confirmField.setText("");
            }
            else{
                JOptionPane.showMessageDialog(frame,
                        "Sign Up Successful!", "Sign Up", JOptionPane.PLAIN_MESSAGE);
                Store.addAdminAccount(username,Integer.parseInt(pin));
                frame.setVisible(false);
OnlineStoreGUI.frame.setVisible(true);
            }

        }
    };

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int n = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    ActionListener handleBack = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            OnlineStoreGUI.frame.setVisible(true);
        }
    };
}
