import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dasboard extends JFrame implements ActionListener {

    Dasboard() {
        setBounds(0,0,1550,1000);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("WELCOME TO HOTEL GATEWAY");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.BOLD,42));
        text.setForeground(Color.magenta);
        image.add(text);

        JMenuBar mb =new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel =new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLUE);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin =new JMenu("ADMIN");
        admin.setForeground(Color.RED);
        mb.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setVisible(true);

    }


    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
        else if(e.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        else if (e.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        else if (e.getActionCommand().equals("ADD DRIVERS")) {
            new AddDrivers();

        }


    }


    public static void main (String[] args) {
        new Dasboard();


    }
}
