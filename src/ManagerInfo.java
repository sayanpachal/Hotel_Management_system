import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton b1;
    ManagerInfo(){
        setLayout(null);


        table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        add(table);

        try {
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from employee where job='Management'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(41, 11, 46, 14);
        add(lblNewLabel);

        JLabel lblJob = new JLabel("Age");
        lblJob.setBounds(159, 11, 46, 14);
        add(lblJob);

        JLabel lblName = new JLabel("Gender");
        lblName.setBounds(273, 11, 46, 14);
        add(lblName);

        JLabel lblDepartment = new JLabel("Job");
        lblDepartment.setBounds(416, 11, 86, 14);
        add(lblDepartment);

        JLabel l1 = new JLabel("Salary");
        l1.setBounds(536, 11, 86, 14);
        add(l1);

        JLabel l2 = new JLabel("Phone");
        l2.setBounds(656, 11, 86, 14);
        add(l2);

        JLabel l3 = new JLabel("Aadhar");
        l3.setBounds(786, 11, 86, 14);
        add(l3);

        JLabel l4 = new JLabel("Gmail");
        l4.setBounds(896, 11, 86, 14);
        add(l4);

        b1 = new JButton("Back");
        b1.addActionListener(this);
        b1.setBounds(440, 500, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);


        setBounds(200, 100, 1000, 600);
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
        new ManagerInfo();
    }
}
