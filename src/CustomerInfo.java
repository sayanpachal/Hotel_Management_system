import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton b1;
    CustomerInfo(){
        setLayout(null);


        table = new JTable();
        table.setBounds(0, 40, 900, 450);
        add(table);

        try {
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(31, 11, 46, 14);
        add(lblId);

        JLabel l1 = new JLabel("Number");
        l1.setBounds(150, 11, 46, 14);
        add(l1);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(270, 11, 65, 14);
        add(lblname);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(360, 11, 46, 14);
        add(lblGender);



        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(480, 11, 46, 14);
        add(lblCountry);

        JLabel lblRoom = new JLabel("Room");
        lblRoom.setBounds(600, 11, 46, 14);
        add(lblRoom);

        JLabel lblStatus = new JLabel("Check-in Status");
        lblStatus.setBounds(680, 11, 100, 14);
        add(lblStatus);

        JLabel lbldeoposit = new JLabel("Deposit");
        lbldeoposit.setBounds(800, 11, 100, 14);
        add(lbldeoposit);

        b1 = new JButton("Back");
        b1.addActionListener(this);
        b1.setBounds(400, 500, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);


        setBounds(200, 100, 900, 600);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }



    public  void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args){
        new CustomerInfo();
    }
}
