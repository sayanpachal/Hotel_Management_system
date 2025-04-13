import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDrivers extends JFrame implements ActionListener{

    public JPanel contentPane;
    public JTextField t1,t2,t3,t4,t5;
    public JComboBox comboBox,comboBox_2;
    JButton b1,b2;
    Choice c1;




    AddDrivers() {

        setBounds(300, 150, 850, 470);
        contentPane = new JPanel();
        setContentPane(contentPane);
        setVisible(true);
        contentPane.setLayout(null);
        //getContentPane().setBackground(Color.BLUE);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/young-male-being-uber-driver-female-client.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(450,80,350,250);
        add(l15);

        JLabel l10 = new JLabel("Add Drivers");
        l10.setBounds(350, 10, 200, 20);
        l10.setFont(new Font("Montserrat", Font.CENTER_BASELINE, 25));
        contentPane.add(l10);



        JLabel l1 = new JLabel("Name");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(60, 70, 120, 30);
        contentPane.add(l1);


        t4 = new JTextField();
        t4.setBounds(200, 70, 150, 30);
        contentPane.add(t4);


        JLabel l2 = new JLabel("Age");
        l2.setForeground(Color.blue);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(60, 110, 120, 30);
        contentPane.add(l2);

        t5 = new JTextField();
        t5.setBounds(200, 110, 150, 30);
        contentPane.add(t5);


        JLabel l3 = new JLabel("Gender");
        l3.setForeground(Color.blue);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(60, 150, 120, 30);
        contentPane.add(l3);

        comboBox = new JComboBox(new String[] { "Male", "Female" });
        comboBox.setBounds(200, 150, 150, 30);
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.magenta);
        contentPane.add(comboBox);

        JLabel l4 = new JLabel("Car Company");
        l4.setForeground(Color.blue);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(60, 190, 120, 30);
        contentPane.add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 190, 150, 30);
        contentPane.add(t2);


        JLabel l6 = new JLabel("Available");
        l6.setForeground(Color.blue);
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(60, 270, 120, 30);


        contentPane.add(l6);JLabel l5 = new JLabel("Car Model");
        l5.setForeground(Color.blue);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(60, 230, 120, 30);
        contentPane.add(l5);


        t1 = new JTextField();
        t1.setBounds(200, 230, 150, 30);
        contentPane.add(t1);


        comboBox_2 = new JComboBox(new String[] { "Available", "Occupied" });
        comboBox_2.setBounds(200, 270, 150, 30);
        comboBox_2.setBackground(Color.WHITE);
        comboBox_2.setForeground(Color.magenta);
        contentPane.add(comboBox_2);



        JLabel l7 = new JLabel("Location");
        l7.setForeground(Color.blue);
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(60, 310, 120, 30);
        contentPane.add(l7);


        t3 = new JTextField();
        t3.setBounds(200, 310, 150, 30);
        contentPane.add(t3);


        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(60, 370, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(220, 370, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        contentPane.setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    Conn c = new Conn();
                    String name = t4.getText();
                    String age = t5.getText();
                    String gender  = (String)comboBox.getSelectedItem();
                    String company = t2.getText();
                    String brand = t1.getText();
                    String available = (String)comboBox_2.getSelectedItem();
                    String location = t3.getText();
                    if (name.equals("")){
                        JOptionPane.showMessageDialog(null, "Car Can't Be Empty");
                        return;
                    }
                    String str = "INSERT INTO driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "New Driver Successfully Added");


                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){

        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}

