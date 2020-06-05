import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.miginfocom.swing.*;




/**
 * @author Muhammad Ahmed
 */
public class ReceiptGUI extends JFrame {
    public ReceiptGUI(String pName,String pId,String pPrice,String cName,String cNo,String cEmail,String mop,String rm) {
        initComponents(pName,pId,pPrice,cName,cNo,cEmail,mop,rm);
        setSize(600,450);
        setVisible(true);
    }

    private void initComponents(String pName,String pId,String pPrice,String cName,String cNo,String cEmail,String mop,String rm) {

        titleLabel = new JLabel();
        subLabel = new JLabel();
        pnameLabel = new JLabel();
        productName = new JLabel();
        pidLabel = new JLabel();
        productId = new JLabel();
        ppriceLabel = new JLabel();
        productPrice = new JLabel();
        cnameLabel = new JLabel();
        customerName = new JLabel();
        cnoLabel = new JLabel();
        customerNo = new JLabel();
        cemailLabel = new JLabel();
        customerEmail = new JLabel();
        mopLabel = new JLabel();
        modeOfPayment = new JLabel();
        rmLabel = new JLabel();
        remainingBalance = new JLabel();
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
            "[]"));

        //---- titleLabel ----
        titleLabel.setText("Summary");
        titleLabel.setFont(new Font(".SF NS", Font.BOLD, 18));
        contentPane.add(titleLabel, "cell 1 1");

        //---- subLabel ----
        subLabel.setText("The payment was successful. Here's the receipt:");
        contentPane.add(subLabel, "cell 1 2 12 1");

        //---- pnameLabel ----
        pnameLabel.setText("Product Name:");
        pnameLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(pnameLabel, "cell 1 4");

        //---- productName ----
        productName.setText(pName);
        contentPane.add(productName, "cell 3 4 5 1");

        //---- pidLabel ----
        pidLabel.setText("Product id:");
        pidLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(pidLabel, "cell 1 5");

        //---- productId ----
        productId.setText(pId);
        contentPane.add(productId, "cell 3 5 5 1");

        //---- ppriceLabel ----
        ppriceLabel.setText("Product Price:");
        ppriceLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(ppriceLabel, "cell 1 6");

        //---- productPrice ----
        productPrice.setText(pPrice);
        contentPane.add(productPrice, "cell 3 6 5 1");

        //---- cnameLabel ----
        cnameLabel.setText("Customer Name:");
        cnameLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(cnameLabel, "cell 1 7");

        //---- customerName ----
        customerName.setText(cName);
        contentPane.add(customerName, "cell 3 7 5 1");

        //---- cnoLabel ----
        cnoLabel.setText("Customer's No:");
        cnoLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(cnoLabel, "cell 1 8");

        //---- customerNo ----
        customerNo.setText(cNo);
        contentPane.add(customerNo, "cell 3 8 5 1");

        //---- cemailLabel ----
        cemailLabel.setText("Customer's Email:");
        cemailLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(cemailLabel, "cell 1 9");

        //---- customerEmail ----
        customerEmail.setText(cEmail);
        contentPane.add(customerEmail, "cell 3 9 5 1");

        //---- mopLabel ----
        mopLabel.setText("Mode of Payment:");
        mopLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(mopLabel, "cell 1 10");

        //---- modeOfPayment ----
        modeOfPayment.setText(mop);
        contentPane.add(modeOfPayment, "cell 3 10 5 1");

        //---- rmLabel ----
        rmLabel.setText("Remaining Balance:");
        rmLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(rmLabel, "cell 1 11");

        //---- remainingBalance ----
        remainingBalance.setText(rm);
        contentPane.add(remainingBalance, "cell 3 11 5 1");

        //---- backBtn ----
        backBtn.setText("Go To HomePage");
        contentPane.add(backBtn, "cell 9 13 6 1");
        backBtn.addActionListener(handleBack);
        pack();
        setLocationRelativeTo(getOwner());

    }


    private JLabel titleLabel;
    private JLabel subLabel;
    private JLabel pnameLabel;
    private JLabel productName;
    private JLabel pidLabel;
    private JLabel productId;
    private JLabel ppriceLabel;
    private JLabel productPrice;
    private JLabel cnameLabel;
    private JLabel customerName;
    private JLabel cnoLabel;
    private JLabel customerNo;
    private JLabel cemailLabel;
    private JLabel customerEmail;
    private JLabel mopLabel;
    private JLabel modeOfPayment;
    private JLabel rmLabel;
    private JLabel remainingBalance;
    private JButton backBtn;

    ActionListener handleBack = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            LandingPage.frame.setVisible(true);
        }
           
    };
}
