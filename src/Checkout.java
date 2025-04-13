import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//import net.proteanit.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    JPanel contentPane;
    JButton b1,b2,b3;
    Choice ccustomer;
    JLabel l2,l3;
    Checkout() {
        setBounds(300, 200, 800, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l10 = new JLabel("Checkout");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(100, 20, 100, 30);
        add(l10);

        JLabel l1 = new JLabel("Customer Id");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        l1.setBounds(30, 80, 100, 30);
        add(l1);

        ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);

        l2 = new JLabel("Room Nmber");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        l2.setBounds(30, 130, 100, 30);
        add(l2);

        l2= new JLabel();
        l2.setBounds(150,130,100,30);
        add(l2);

        l3 = new JLabel("Checkin Time");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        l3.setBounds(30, 180, 100, 30);
        add(l3);

        l3= new JLabel();
        l3.setBounds(150,180,100,30);
        add(l3);

        JLabel l4 = new JLabel("Checkout Time");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        l4.setBounds(30, 230, 100, 30);
        add(l4);

        Date date=new Date();
        l4=new JLabel(""+date);
        l4.setBounds(150,230,150,30);
        add(l4);


        b1 = new JButton("back");
        b1.addActionListener(this);
        b1.setBounds(30, 280, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Check");
        b2.addActionListener(this);
        b2.setBounds(140, 280, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b3=new JButton("Checkout");
        b3.setBounds(250, 280, 100, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        try {
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from customer");
            while (rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/WhatsApp Image 2023-07-12 at 21.04.22.jpg"));
        Image i3 = i1.getImage().getScaledInstance(300, 200,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(370,50,300,200);
        add(l15);

        contentPane.setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number ='"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()){
                    l2.setText(rs.getString("room_number"));
                    l3.setText(rs.getString("time"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b3){
            String query1="delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where room_number= '"+l2.getText()+"'";
            try{
                Conn c =new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Checkout Done");
                setVisible(false);
                new Checkout();
            }catch (Exception e){
                e.printStackTrace();
            }
        }   else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }
}