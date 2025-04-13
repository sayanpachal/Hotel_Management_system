import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{

     JPanel contentPane;
     JComboBox comboBox_4;
     JCheckBox available;
    JButton b1,b2;
    JTable table;
    SearchRoom() {
        setBounds(330, 130, 940, 570);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel l10 = new JLabel("Search For Room");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(400, 30, 200, 30);
        add(l10);

        JLabel lbed=new JLabel("Bed Type");
        lbed.setBounds(50,100,100,20);
        add(lbed);

        comboBox_4=new JComboBox(new String[]{"Single Bed","Double Bed"});
        comboBox_4.setBounds(150,100,150,25);
        comboBox_4.setBackground(Color.WHITE);
        add(comboBox_4);

        available=new JCheckBox("Only display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        l1.setBounds(50, 160, 100, 20);
        contentPane.add(l1);


        JLabel l2 = new JLabel("Availability");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        l2.setBounds(270, 160, 100, 20);
        contentPane.add(l2);



        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        l3.setBounds(450, 160, 100, 20);
        contentPane.add(l3);


        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        l4.setBounds(670, 160, 100, 20);
        contentPane.add(l4);


        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 12));
        l5.setBounds(820, 160, 100, 20);
        contentPane.add(l5);

        table= new JTable();
        table.setBounds(0,200,1000,250);
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
        b1.setBounds(300, 480, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Submit");
        b2.addActionListener(this);
        b2.setBounds(500, 480, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        contentPane.setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b2){
               try{
                   String query1="select * from room where bed_type = '"+comboBox_4.getSelectedItem()+"'";
                   String query2="select * from room where availability='Available' AND bed_type = '"+comboBox_4.getSelectedItem()+"'";
                   Conn c =new Conn();
                   ResultSet rs;
                   if(available.isSelected()){
                       rs= c.s.executeQuery(query2);
                   }else{
                       rs=c.s.executeQuery(query1);
                   }
                   table.setModel(DbUtils.resultSetToTableModel(rs));
               }catch (Exception e){
                   e.printStackTrace();
               }
            } else {
                this.setVisible(false);
                new Reception();
            }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}