import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{

    JPanel contentPane;
    JButton b1;
    JTable table;
    Department() {
        setBounds(400, 200, 700, 480);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Department");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        l1.setBounds(150, 10, 100, 20);
        contentPane.add(l1);


        JLabel l2 = new JLabel("Budget");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        l2.setBounds(450, 10, 100, 20);
        contentPane.add(l2);

        table= new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try {
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from department"); //data table
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        b1 = new JButton("Back");
        b1.addActionListener(this);
        b1.setBounds(280, 400, 120, 30);
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
        new Department();
    }
}