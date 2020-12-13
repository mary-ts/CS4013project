import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;

    private JPanel panelIdentity;
    private JLabel lblPersonType, lblOwnerName;
    private JTextField txtOwnerName;
    private JButton btnOwnerLogin, btnManagement, btnBack;
    private JScrollPane vertScroll, horzScroll;



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
    private JPanel panelOwner;
    private JLabel lblWelcome, lblQueryYear, lblQueryProp;
    private JTextField txtQueryYear, txtQueryProp;
    private JButton btnRegisterProp, btnViewProperty, btnQueryYear, btnQueryProp;
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

    private JPanel panelReg;
    private JLabel lblAddress, lblEircode, lblLocation, lblMarketValue, lblPrivateResidence;
    private JTextField txtAddress, txtEircode, txtLocation, txtMarketValue, txtPrivateResidence;
    private JButton btnActuallyRegProp;

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

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnOwnerLogin){
            name = txtOwnerName.getText();
            ownerInit();
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
        frame.validate();
        frame.repaint();
    }
}
