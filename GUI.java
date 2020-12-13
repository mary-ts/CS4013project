import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 
    @Author: Luke O Loughlin, 19231326
    */

public class GUI implements ActionListener {
    private JFrame frame;

    private JPanel panelIdentity;
    private JLabel lblPersonType, lblOwnerName;
    private JTextField txtOwnerName;
    private JButton btnOwnerLogin, btnManagement, btnBack;



    public GUI(){
        initGUI();
        frame.setLocationRelativeTo(null);
    }

    public void initGUI(){
        frame = new JFrame("Property Tax Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelIdentity = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panelIdentity, BoxLayout.Y_AXIS);
        panelIdentity.setLayout(boxlayout);
        panelIdentity.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));

        lblPersonType = new JLabel("Choose who you are:");
        lblOwnerName = new JLabel("Property Owner Name:");

        txtOwnerName = new JTextField(1);

        btnOwnerLogin = new JButton("Login");
        btnManagement = new JButton("Department of Environment Employee");

        btnOwnerLogin.addActionListener(this);
        btnManagement.addActionListener(this);

        panelIdentity.add(lblPersonType);
        panelIdentity.add(Box.createRigidArea(new Dimension(0, 20)));
        panelIdentity.add(lblOwnerName);
        panelIdentity.add(Box.createRigidArea(new Dimension(0, 5)));
        panelIdentity.add(txtOwnerName);
        panelIdentity.add(Box.createRigidArea(new Dimension(0, 5)));
        panelIdentity.add(btnOwnerLogin);
        panelIdentity.add(Box.createRigidArea(new Dimension(0, 10)));
        panelIdentity.add(btnManagement);

        frame.setContentPane(panelIdentity);
        frame.setSize(500, 300);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        new GUI();
    }

    private String name;
    private PropertyOwner p;
    private  Management m;
    private JPanel panelOwner, panelStat, panelManage;
    private JLabel lblWelcome, lblQueryYear, lblQueryProp, lblPropTax, lblOverdueTax, lblOther;
    private JTextField txtQueryYear, txtQueryProp;
    private JButton btnRegisterProp, btnViewProperty, btnQueryYear, btnQueryProp,
            btnPropTax1, btnPropTax2, btnStatistics, btnNewRates, btnOverdueTax1, btnOverdueTax2;
    private JTextArea display;

    private void ownerInit() {
        p = new PropertyOwner(name);

        panelOwner = new JPanel();
        //panelOwner.setLayout(new GridLayout(3,3,1,1));

        lblWelcome = new JLabel("Welcome");
        lblQueryYear = new JLabel("Query by year:");
        lblQueryProp = new JLabel("Query by property(eircode)");
        txtQueryYear = new JTextField(5);
        txtQueryProp = new JTextField(10);
        btnRegisterProp = new JButton("Register Property");
        btnViewProperty = new JButton("View Properties");
        btnQueryYear = new JButton("Search");
        btnQueryProp = new JButton("Search");
        display = new JTextArea(10, 15);
        /*
        vertScroll = new JScrollPane(display);
        vertScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        horzScroll = new JScrollPane(display);
        horzScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
         */

        btnRegisterProp.addActionListener(this);
        btnViewProperty.addActionListener(this);
        btnQueryYear.addActionListener(this);
        btnQueryProp.addActionListener(this);

        panelOwner.add(lblWelcome);
        panelOwner.add(btnRegisterProp);
        panelOwner.add(btnViewProperty);
        panelOwner.add(lblQueryYear);
        panelOwner.add(txtQueryYear);
        panelOwner.add(btnQueryYear);
        panelOwner.add(lblQueryProp);
        panelOwner.add(txtQueryProp);
        panelOwner.add(btnQueryProp);
        panelOwner.add(display);
        //panelOwner.add(vertScroll);
        //panelOwner.add(horzScroll);

        frame.remove(panelIdentity);
        frame.setContentPane(panelOwner);
    }

    private void managementInit() {
        m = new Management();
        panelManage = new JPanel();
        panelManage.setLayout(new GridLayout(3,3,1,1));

        lblPropTax = new JLabel("View property tax:");
        lblOverdueTax = new JLabel("View overdue tax:");
        lblOther = new JLabel("Other:");
        btnStatistics = new JButton("Payment Statistics");
        btnNewRates = new JButton("Change tax rates");
        btnPropTax1 = new JButton("by Eircode");
        btnPropTax2 = new JButton("by Owner");
        btnOverdueTax1 = new JButton("All");
        btnOverdueTax2 = new JButton("Eircode");
        //btnBack

        btnStatistics.addActionListener(this);
        btnNewRates.addActionListener(this);
        btnPropTax1.addActionListener(this);
        btnPropTax2.addActionListener(this);
        btnOverdueTax1.addActionListener(this);
        btnOverdueTax2.addActionListener(this);


        panelManage.add(lblPropTax);
        panelManage.add(btnPropTax1);
        panelManage.add(btnPropTax2);
        panelManage.add(lblOverdueTax);
        panelManage.add(btnOverdueTax1);
        panelManage.add(btnOverdueTax2);
        panelManage.add(lblOther);
        panelManage.add(btnStatistics);
        panelManage.add(btnNewRates);

        frame.remove(panelIdentity);
        frame.setContentPane(panelManage);
    }

    private JPanel panelReg;
    private JLabel lblAddress, lblEircode, lblEircode2, lblLocation, lblMarketValue, lblPrivateResidence;
    private JTextField txtAddress, txtEircode, txtEircode2, txtLocation, txtMarketValue, txtPrivateResidence;
    private JButton btnActuallyRegProp, btnGetTaxStats;

    public void registerProp(){
        panelReg = new JPanel();
        panelReg.setLayout(new FlowLayout());

        lblAddress = new JLabel("Address: ");
        lblEircode = new JLabel("Eircode: ");
        lblLocation = new JLabel("Location: ");
        lblMarketValue = new JLabel("Market value(€): ");
        lblPrivateResidence = new JLabel("Private residence(true/false): ");
        txtAddress = new JTextField(30);
        txtEircode = new JTextField(10);
        txtLocation = new JTextField(10);
        txtMarketValue = new JTextField(10);
        txtPrivateResidence = new JTextField(5);
        btnActuallyRegProp = new JButton("Register");
        btnBack = new JButton("Back");

        btnActuallyRegProp.addActionListener(this);
        btnBack.addActionListener(this);

        panelReg.add(lblAddress);
        panelReg.add(txtAddress);

        panelReg.add(lblEircode);
        panelReg.add(txtEircode);

        panelReg.add(lblLocation);
        panelReg.add(txtLocation);

        panelReg.add(lblMarketValue);
        panelReg.add(txtMarketValue);

        panelReg.add(lblPrivateResidence);
        panelReg.add(txtPrivateResidence);
        panelReg.add(btnActuallyRegProp);
        panelReg.add(btnBack);

        frame.remove(panelOwner);
        frame.setContentPane(panelReg);

    }

    public void getStatistics(){
        panelStat = new JPanel();
        panelStat.setLayout(new FlowLayout());
//        panelStat.setLayout(new GridLayout(1, 1));
//        display = new JTextArea(10, 15);


        lblEircode2 = new JLabel("Eircode: ");
        txtEircode2 = new JTextField(10);
        btnGetTaxStats = new JButton("Calculate Statistics");

        btnGetTaxStats.addActionListener(this);

        panelStat.add(lblEircode2);
        panelStat.add(txtEircode2);
        panelStat.add(btnGetTaxStats);

        frame.remove(panelManage);
        frame.setContentPane(panelStat);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnOwnerLogin){
            name = txtOwnerName.getText();
            ownerInit();
        } else {
            managementInit();
        }
        if(e.getSource() == btnRegisterProp){
            registerProp();
        }
        if(e.getSource() == btnActuallyRegProp){
            String address = txtAddress.getText();
            String eircode = txtEircode.getText();
            String location = txtLocation.getText();
            double marketVal = Double.parseDouble(txtMarketValue.getText());
            boolean priv = Boolean.parseBoolean(txtPrivateResidence.getText());
            p.registerProperty(address, eircode, location, marketVal, priv);
        }
        if(e.getSource() == btnBack){
            frame.remove(panelReg);
            frame.setContentPane(panelOwner);
        }
        if(e.getSource() == btnViewProperty){
            display.setText(p.viewProperties());
        }
        if(e.getSource() == btnQueryYear){
            int year = Integer.parseInt(txtQueryYear.getText());
            display.setText(p.specificQuery(year));
        }
        if(e.getSource() == btnQueryProp){
            String eircode = txtQueryProp.getText();
            display.setText(p.specificQuery(eircode));
        }
        if(e.getSource() == btnStatistics){
            getStatistics();
        }
        if(e.getSource() == btnGetTaxStats){
            String eircode = txtEircode.getText();
            m.getTaxStatistics(eircode);
        }
        frame.validate();
        frame.repaint();
    }
}
