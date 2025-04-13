import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class NewCustomer extends JFrame implements ActionListener {


    JComboBox idcom;
    Choice croom;
    JTextField numbertxt,nametxt,countrytxt,deposittxt;
    JRadioButton rbmale,rbfemale;
    JButton add,back;
    JLabel lblcheckin;
    NewCustomer(){

        setLayout(null);

        JLabel head=new JLabel("New Customer Form");
        head.setBounds(220,0,300,30);
        head.setFont(new Font("Montserrat",Font.BOLD,25));
        add(head);

        JLabel id=new JLabel("ID");
        id.setBounds(30,60,100,30);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        add(id);


        String str1[]={"Passport","Driving Licence","PAN Card","Other"};
        idcom = new JComboBox(str1);
        idcom.setBackground(Color.WHITE);
        idcom.setBounds(210,60,150,30);
        add(idcom);


        JLabel number=new JLabel("Number");
        number.setBounds(30,100,100,30);
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        add(number);

        numbertxt=new JTextField();
        numbertxt.setBounds(210,100,150,30);
        add(numbertxt);

        JLabel name=new JLabel("Name");
        name.setBounds(30,140,100,30);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        add(name);

        nametxt=new JTextField();
        nametxt.setBounds(210,140,150,30);
        add(nametxt);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(30,180,100,30);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        add(gender);

        rbmale=new JRadioButton("Male");
        rbmale.setBounds(210,180,60,30);
        rbmale.setBackground(Color.WHITE);
        rbmale.setFont(new Font("Tohima",Font.BOLD,14));
        add(rbmale);

        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(280,180,80,30);
        rbfemale.setBackground(Color.WHITE);

        rbfemale.setFont(new Font("Tohima",Font.BOLD,14));
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel country=new JLabel("Country");
        country.setBounds(30,220,100,30);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        add(country);


        countrytxt=new JTextField();
        countrytxt.setBounds(210,220,150,30);
        add(countrytxt);


        JLabel room_no=new JLabel("Allocated Room Number");
        room_no.setBounds(30,260,170,30);
        room_no.setFont(new Font("Tahoma",Font.BOLD,14));
        add(room_no);


        croom = new Choice();
        try{
            Conn conn=new Conn();
            String query="Select room_number from room where availability='available' and cleaning_status='cleaned' ";
            ResultSet rs= conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("room_number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(210,260,150,30);
        add(croom);


        JLabel checkin=new JLabel("Check in time");
        checkin.setBounds(30,300,100,30);
        checkin.setFont(new Font("Tahoma",Font.BOLD,14));
        add(checkin);

        Date date =new Date();

        lblcheckin=new JLabel(""+date);
        lblcheckin.setBounds(210,300,145,30);
        lblcheckin.setFont(new Font("Tahoma",Font.BOLD,14));
        add(lblcheckin);



        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(30,340,100,30);
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        add(deposit);

        deposittxt=new JTextField();
        deposittxt.setBounds(210,340,150,30);
        add(deposittxt);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/customer.jpg"));
        Image i2= i1.getImage().getScaledInstance(230,300,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(420,90,230,300);
        add(image);

        add= new JButton("Add Customer");
        add.setBounds(50,400,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back= new JButton("Back");
        back.setBounds(220,400,127,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        setBounds(350,150,700,500);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);


    }


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==add){
            String id=(String) idcom.getSelectedItem();
            String number=numbertxt.getText();
            String name=nametxt.getText();
            String gender=null;
            if(rbmale.isSelected()){
                gender="Male";
            }
            else{
                gender="Female";
            }
            String country=countrytxt.getText();
            String room=croom.getSelectedItem();
            String time=lblcheckin.getText();
            String deposit=deposittxt.getText();
            try {
                String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2="update room set availability='Occupied' where room_number='"+room+"'";

                Conn conn =new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");



            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==back){
            setVisible(false);
            new Reception();

        }
    }


    public static void main(String[] args){
        new NewCustomer();
    }
}
