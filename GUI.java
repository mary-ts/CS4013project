import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panelIdentity, panelOwner;
    private JLabel lblPersonType, lblOwnerName;
    private JTextField txtOwnerName;
    private JButton btnOwnerLogin, btnManagement, btnRegisterProp, btnViewProperty;

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

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnOwnerLogin){
            ownerInit();
        }
        if(e.getSource() == btnRegisterProp){
            System.out.println("Registered");
        }
        frame.validate();
        frame.repaint();
    }

    private void ownerInit() {
        panelOwner = new JPanel();
        panelOwner.setLayout(new GridLayout(3,3,1,1));

        btnRegisterProp = new JButton("Register Property");
        btnViewProperty = new JButton("View Properties");

        btnRegisterProp.addActionListener(this);
        btnViewProperty.addActionListener(this);

        panelOwner.add(btnRegisterProp);
        panelOwner.add(btnViewProperty);

        frame.remove(panelIdentity);
        frame.setContentPane(panelOwner);


    }
}
