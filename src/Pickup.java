import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{

    JPanel contentPane;
    Choice typeofcar;
    JCheckBox available;
    JButton b1,b2;
    JTable table;
    Pickup() {
        setBounds(330, 130, 1000, 570);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel l10 = new JLabel("Pickup Service");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(400, 30, 200, 30);
        add(l10);

        JLabel lbed=new JLabel("Type Of Car");
        lbed.setBounds(50,100,100,20);
        add(lbed);

        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()){
                typeofcar.add(rs.getString("car_model"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        JLabel l1 = new JLabel("Name");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        l1.setBounds(30, 160, 100, 20);
        contentPane.add(l1);


        JLabel l2 = new JLabel("Age");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        l2.setBounds(200, 160, 100, 20);
        contentPane.add(l2);



        JLabel l3 = new JLabel("Gender");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        l3.setBounds(330, 160, 100, 20);
        contentPane.add(l3);


        JLabel l4 = new JLabel("Car_company");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        l4.setBounds(460, 160, 100, 20);
        contentPane.add(l4);


        JLabel l5 = new JLabel("Car_model");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 12));
        l5.setBounds(620, 160, 100, 20);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Available");
        l6.setForeground(new Color(25, 25, 112));
        l6.setFont(new Font("Tahoma", Font.BOLD, 12));
        l6.setBounds(740, 160, 100, 20);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setForeground(new Color(25, 25, 112));
        l7.setFont(new Font("Tahoma", Font.BOLD, 12));
        l7.setBounds(890, 160, 100, 20);
        contentPane.add(l7);

        table= new JTable();
        table.setBounds(0,200,1000,250);
        add(table);

        try {
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from driver"); //data table
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
                String query="select * from driver where car_model = '"+typeofcar.getSelectedItem()+"'";

                Conn c =new Conn();
                ResultSet rs;
                rs= c.s.executeQuery(query);
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
        new Pickup();
    }
}
