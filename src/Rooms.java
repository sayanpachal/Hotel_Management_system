import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener{

    JPanel contentPane;
    JButton b1;
    JTable table;
    Rooms() {
        setBounds(300, 200, 1050, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/rooms pic 2.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(500,0,600,600);
        add(l15);

        JLabel l10 = new JLabel("All Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(200, 10, 120, 30);
        add(l10);

        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        l1.setBounds(10, 50, 100, 20);
        contentPane.add(l1);


        JLabel l2 = new JLabel("Availability");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        l2.setBounds(120, 50, 100, 20);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        l3.setBounds(230, 50, 100, 20);
        contentPane.add(l3);


        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        l4.setBounds(330, 50, 100, 20);
        contentPane.add(l4);


        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 12));
        l5.setBounds(410, 50, 100, 20);
        contentPane.add(l5);

        table= new JTable();
        table.setBounds(0,80,500,400);
        add(table);

        try {
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from room"); //data table
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        b1 = new JButton("Back");
        b1.addActionListener(this);
        b1.setBounds(200, 500, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        contentPane.setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
            this.setVisible(false);
            new Reception();
        }

    public static void main(String[] args) {
        new Rooms();
    }
}