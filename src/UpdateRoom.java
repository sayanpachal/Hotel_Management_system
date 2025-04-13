import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.jar.JarFile;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice c1;
    JTextField txt_Ava,txt_Status,txt_Room;
    JButton b1,b2,b3;
    UpdateRoom(){

        setLayout(null);

        JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
        lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUpdateRoomStatus.setBounds(280, 11, 206, 34);
        add(lblUpdateRoomStatus);

        JLabel lblNewLabel = new JLabel("Guest ID:");
        lblNewLabel.setBounds(27, 87, 90, 14);
        add(lblNewLabel);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){ }
        c1.setBounds(160, 87, 140, 20);
        add(c1);


        JLabel lblroom = new JLabel("Room Number:");
        lblroom.setBounds(27, 130, 90, 14);
        add(lblroom);


        txt_Room = new JTextField();
        txt_Room.setBounds(160, 130, 140, 20);
        add(txt_Room);
        txt_Room.setColumns(10);


        JLabel lblAvailability = new JLabel("Availability:");
        lblAvailability.setBounds(27, 187, 90, 14);
        add(lblAvailability);


        txt_Ava = new JTextField();
        txt_Ava.setBounds(160, 184, 140, 20);
        add(txt_Ava);
        txt_Ava.setColumns(10);


        JLabel lblCleanStatus = new JLabel("Clean Status:");
        lblCleanStatus.setBounds(27, 240, 90, 14);
        add(lblCleanStatus);


        txt_Status = new JTextField();
        txt_Status.setBounds(160, 237, 140, 20);
        add(txt_Status);
        txt_Status.setColumns(10);



        b1 = new JButton("Check");
        b1.setBounds(30, 355, 90, 23);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);


        b2=new JButton("Update");
        b2.setBounds(140, 355, 90, 23);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBounds(250, 355, 90, 23);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/WhatsApp Image 2023-07-11 at 20.03.14.jpg"));
        Image i2= i1.getImage().getScaledInstance(400,250,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,80,400,250);
        add(image);

        setBounds(250, 100, 800, 450);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }


    public  void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){

            try{
                String id=c1.getSelectedItem();
                String query="Select * from customer where number='"+id+"'";
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        txt_Room.setText(rs.getString("room_number"));

                    }
                    ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+txt_Room.getText()+"'");
                    while (rs1.next()){
                        txt_Ava.setText(rs1.getString("availability"));
                        txt_Status.setText(rs1.getString("cleaning_status"));
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }


                Conn c=new Conn();



            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (ae.getSource()==b2) {

            String id =c1.getSelectedItem();
            String room =txt_Room.getText();
            String available =txt_Ava.getText();
            String status =txt_Status.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room_number='" + room + "' where number='" + id + "'");
                c.s.executeUpdate("update room set availability='" + available + "',cleaning_status='" + status + "' where room_number='" + room + "'");
                JOptionPane.showMessageDialog(null,"Room Updated Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        else{
            setVisible(false);
            new Reception();
        }
    }





    public static void main(String[] args){

        new UpdateRoom();
    }
}
