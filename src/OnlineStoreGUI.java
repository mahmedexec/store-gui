import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

import net.miginfocom.swing.*;


/**
 * @author Muhammad Ahmed
 */
public class OnlineStoreGUI extends Store {
    public static JFrame frame;

    public OnlineStoreGUI(String storeStr, String addressStr) {
        super(storeStr, addressStr);
        frame = new JFrame("Store");
        initComponents(storeStr, addressStr);

    }

    @Override
    void accessStore() {
        frame.setSize(600, 450);
        frame.setVisible(true);
    }


    private void initComponents(String storeStr, String addressStr) {

        storeLabel = new JLabel();
        addressLabel = new JLabel();
        promptLabel = new JLabel();
        usernameLabel = new JLabel();
        usernameField = new JTextField();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        loginBtn = new JButton();
        signupBtn = new JButton();

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

        //---- storeLabel ----
        storeLabel.setText("Welcome to " + this.getName());
        storeLabel.setFont(new Font(".SF NS", Font.BOLD, 18));
        contentPane.add(storeLabel, "cell 0 1 7 1");

        //---- addressLabel ----
        addressLabel.setText("Located at " + this.getAddress());
        addressLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
        contentPane.add(addressLabel, "cell 0 2 7 1");

        //---- promptLabel ----
        promptLabel.setText("Please enter your credentials:");
        promptLabel.setFont(promptLabel.getFont().deriveFont(promptLabel.getFont().getStyle() | Font.ITALIC));
        contentPane.add(promptLabel, "cell 0 5 7 1");

        //---- usernameLabel ----
        usernameLabel.setText("Username:");
        contentPane.add(usernameLabel, "cell 0 6 3 1");
        contentPane.add(usernameField, "cell 3 6 3");

        //---- passwordLabel ----
        passwordLabel.setText("PIN:");
        contentPane.add(passwordLabel, "cell 0 7 3 1");
        contentPane.add(passwordField, "cell 3 7 3");

        //---- loginBtn ----
        loginBtn.setText("Log In");
        loginBtn.addActionListener(handleLogin);
        contentPane.add(loginBtn, "cell 3 8");

        //---- signupBtn ----
        signupBtn.setText("Sign Up");
        contentPane.add(signupBtn, "cell 4 8");
        signupBtn.addActionListener(handleSignup);


        frame.pack();
        frame.setLocationRelativeTo(frame.getOwner());
        // JFormDesigner - End of component initialization
    }


    private JLabel storeLabel;
    private JLabel addressLabel;
    private JLabel promptLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton signupBtn;

    ActionListener handleSignup = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            SignUp signUp = new SignUp();
        }
    };
    ActionListener handleLogin = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("login button pressed");
            System.out.println();
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            StringBuilder passwordStr = new StringBuilder();
            for (char c : password) {
                passwordStr.append(c);
            }

            if (passwordStr.toString().equals("") || username.equals("")) {
                JOptionPane.showMessageDialog(frame,
                        "One or more fields empty", "Log In", JOptionPane.PLAIN_MESSAGE);
            } else if (!SignUp.isNumeric(passwordStr.toString())) {
                System.out.println("ERROR 2");

                JOptionPane.showMessageDialog(frame,
                        "PIN entered is not a valid number", "Log In", JOptionPane.ERROR_MESSAGE);
                passwordField.setText("");
            } else {
                int pin = Integer.parseInt(passwordStr.toString());
                System.out.println("username:" + username + "\npassword:" + pin);
                System.out.println();
                if (AdminAccounts.get(pin) != null && username.equals(AdminAccounts.get(pin))) {

                    System.out.println("Account Matched");
                    JOptionPane.showMessageDialog(frame,
                            "Logged in successfully", "Log In", JOptionPane.PLAIN_MESSAGE);
                    System.out.println();
                    frame.setVisible(false);
                    passwordField.setText("");

                    LandingPage landingPage = new LandingPage(username);

                } else {

                    JOptionPane.showMessageDialog(frame,
                            "Incorrect Username or Password", "Log In", JOptionPane.PLAIN_MESSAGE);
                    passwordField.setText("");
                    usernameField.setText("");
                    System.out.println("Account Unmatchable");
                }
            }

        }
    };

}
