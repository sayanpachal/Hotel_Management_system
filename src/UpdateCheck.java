import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField t1,t2,t3,t4,t5;
    JButton check,update,back;

    UpdateCheck(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel l1 = new JLabel("Customer Id");
        l1.setBounds(30,80,100,20);
        add(l1);

        ccustomer = new Choice();
        try{
            Conn c = new Conn();
            String query=" select *  from customer ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(30,120,100,20);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(30,160,100,20);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);

        JLabel l4 = new JLabel("Time");
        l4.setBounds(30,200,100,20);
        add(l4);

        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);

        JLabel l5 = new JLabel("Amount Paid");
        l5.setBounds(30,240,100,20);
        add(l5);

        t4 = new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);

        JLabel l6 = new JLabel(" Pending Amount");
        l6.setBounds(30,280,100,20);
        add(l6);

        t5 = new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);

        check = new JButton("check");
        check.setBounds(30, 340, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("update");
        update.setBounds(150, 340, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("back");
        back.setBounds(270, 340, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/check-in_kiosk 1.jpg"));
       // Image i3 = i1.getImage().getScaledInstance(500, 200,Image.SCALE_SMOOTH);
        //ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i1);
        image.setBounds(500,50,700,600);
        add(image);


        setBounds(200,100,980,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number ='"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()){
                    t1.setText(rs.getString("room_number"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("time"));
                    t4.setText(rs.getString("deposit"));
                }
                ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+t1.getText()+"'");
                while (rs1.next()){
                    String price = rs1.getString("price");
                    int amountPaid = Integer.parseInt(price)- Integer.parseInt(t4.getText());
                    t5.setText("" + amountPaid);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==update){
            String number =ccustomer.getSelectedItem();
            String room =t1.getText();
            String name =t2.getText();
            String time =t3.getText();
            String deposit =t4.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room_number ='"+room+"',name='"+name+"',time='"+time+"',deposit='"+deposit+"' where number='"+number+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }


    }
    public static void main(String[] args){

        new UpdateCheck();

    }
}
