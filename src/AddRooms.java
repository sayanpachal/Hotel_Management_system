import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRooms extends JFrame implements ActionListener{

    public JPanel contentPane;
    public JTextField t1,t2,t3,t4;
    public JComboBox comboBox,comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;
    AddRooms() {

        setBounds(250, 150, 940, 470);
        contentPane = new JPanel();
        setContentPane(contentPane);
        setVisible(true);
        contentPane.setLayout(null);
        //getContentPane().setBackground(Color.BLUE);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/Bed_rooms.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(450,80,350,250);
        add(l15);

        JLabel l10 = new JLabel("Add Rooms");
        l10.setBounds(330, 0, 150, 30);
        l10.setFont(new Font("Montserrat", Font.CENTER_BASELINE, 25));
        contentPane.add(l10);



        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(Color.yellow);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(60, 80, 120, 20);
        contentPane.add(l1);


        t4 = new JTextField();
        t4.setBounds(200, 80, 150, 30);
        contentPane.add(t4);


        JLabel l2 = new JLabel("Availability");
        l2.setForeground(Color.yellow);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(60, 130, 120, 30);
        contentPane.add(l2);

        comboBox = new JComboBox(new String[] { "Available", "Occupied" });
        comboBox.setBounds(200, 130, 150, 30);
        comboBox.setBackground(Color.WHITE);
        contentPane.add(comboBox);


        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(Color.yellow);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(60, 180, 120, 30);
        contentPane.add(l3);

        comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
        comboBox_2.setBounds(200, 180, 150, 30);
        comboBox_2.setBackground(Color.WHITE);
        contentPane.add(comboBox_2);

        JLabel l4 = new JLabel("Price");
        l4.setForeground(Color.yellow);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(60, 230, 120, 30);
        contentPane.add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 230, 150, 30);
        contentPane.add(t2);

        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(Color.yellow);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(60, 280, 120, 30);
        contentPane.add(l5);


        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
        comboBox_3.setBounds(200, 280, 150, 30);
        comboBox_3.setBackground(Color.WHITE);
        contentPane.add(comboBox_3);


        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(60, 350, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(220, 350, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        contentPane.setBackground(Color.blue);

    }

    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    Conn c = new Conn();
                    String room_number = t4.getText();
                    String availability = (String)comboBox.getSelectedItem();
                    String cleaning_status = (String)comboBox_2.getSelectedItem();
                    String price  = t2.getText();
                    String bed_type = (String)comboBox_3.getSelectedItem();
                    if (room_number.equals("")){
                       JOptionPane.showMessageDialog(null, "Room Can't Be Empty");
                       return;
                    }
                    String str = "INSERT INTO room values( '"+room_number+"', '"+availability+"', '"+cleaning_status+"','"+price+"', '"+bed_type+"')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");


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
        new AddRooms();
    }
}