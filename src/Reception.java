import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    JButton newcustomer,rooms,department,employees,customerinfo,managerinfo,checkout,updatestatus,updateroom,pickupservice,searchroom,logout;

    Reception(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel head=new JLabel("HOTEL RECEPTION");
        head.setBounds(220,0,400,30);
        head.setFont(new Font("Montserrat",Font.BOLD,25));
        add(head);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Images/reception.jpg"));
        Image i2= i1.getImage().getScaledInstance(370,440,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(280,90,370,440);
        add(image);

        newcustomer= new JButton("New Customer Form");
        newcustomer.addActionListener(this);
        newcustomer.setFont(new Font("Arial",Font.BOLD,14));
        newcustomer.setBounds(40,50,200,35);
        newcustomer.setBackground(Color.BLUE);
        newcustomer.setForeground(Color.yellow);
        add(newcustomer);

        rooms= new JButton("Rooms");
        rooms.setFont(new Font("Arial",Font.BOLD,14));
        rooms.setBounds(40,95,200,35);
        rooms.setBackground(Color.BLUE);
        rooms.setForeground(Color.yellow);
        rooms.addActionListener(this);
        add(rooms);

        department= new JButton("Department");
        department.setFont(new Font("Arial",Font.BOLD,14));
        department.setBounds(40,140,200,35);
        department.setBackground(Color.BLUE);
        department.setForeground(Color.yellow);
        department.addActionListener(this);
        add(department);

        employees= new JButton("All Employees");
        employees.setFont(new Font("Arial",Font.BOLD,14));
        employees.setBounds(40,185,200,35);
        employees.setBackground(Color.BLUE);
        employees.setForeground(Color.yellow);
        employees.addActionListener(this);
        add(employees);

        customerinfo= new JButton("Customer Info");
        customerinfo.setFont(new Font("Arial",Font.BOLD,14));
        customerinfo.setBounds(40,230,200,35);
        customerinfo.setBackground(Color.BLUE);
        customerinfo.setForeground(Color.yellow);
        customerinfo.addActionListener(this);
        add(customerinfo);

        managerinfo= new JButton("Manager Info");
        managerinfo.setFont(new Font("Arial",Font.BOLD,14));
        managerinfo.setBounds(40,275,200,35);
        managerinfo.setBackground(Color.BLUE);
        managerinfo.setForeground(Color.yellow);
        managerinfo.addActionListener(this);
        add(managerinfo);

        checkout= new JButton("Checkout");
        checkout.setFont(new Font("Arial",Font.BOLD,14));
        checkout.setBounds(40,320,200,35);
        checkout.setBackground(Color.BLUE);
        checkout.setForeground(Color.yellow);
        checkout.addActionListener(this);
        add(checkout);

        updatestatus= new JButton("Update Status");
        updatestatus.setFont(new Font("Arial",Font.BOLD,14));
        updatestatus.setBounds(40,365,200,35);
        updatestatus.setBackground(Color.BLUE);
        updatestatus.setForeground(Color.yellow);
        updatestatus.addActionListener(this);
        add(updatestatus);

        updateroom= new JButton("Update Room Status");
        updateroom.setFont(new Font("Arial",Font.BOLD,14));
        updateroom.setBounds(40,410,200,35);
        updateroom.setBackground(Color.BLUE);
        updateroom.setForeground(Color.yellow);
        updateroom.addActionListener(this);
        add(updateroom);

        pickupservice= new JButton("Pickup Service");
        pickupservice.setFont(new Font("Arial",Font.BOLD,14));
        pickupservice.setBounds(40,455,200,35);
        pickupservice.setBackground(Color.BLUE);
        pickupservice.setForeground(Color.yellow);
        pickupservice.addActionListener(this);
        add(pickupservice);

        searchroom= new JButton("Search Room");
        searchroom.setFont(new Font("Arial",Font.BOLD,14));
        searchroom.setBounds(40,500,200,35);
        searchroom.setBackground(Color.blue);
        searchroom.setForeground(Color.yellow);
        searchroom.addActionListener(this);
        add(searchroom);

        logout= new JButton("Logout");
        logout.setFont(new Font("Arial",Font.BOLD,14));
        logout.setBounds(40,545,200,35);
        logout.setBackground(Color.BLUE);
        logout.setForeground(Color.yellow);
        logout.addActionListener(this);
        add(logout);




        setBounds(330,50,700,670);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newcustomer) {
            setVisible(false);
            new NewCustomer();
        }
        else if (ae.getSource() == checkout) {
            setVisible(false);
            new Checkout();

        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Rooms();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == searchroom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == pickupservice) {
            setVisible(false);
            new Pickup();
        } else if (ae.getSource() == updateroom) {
            setVisible(false);
            new UpdateRoom();
        } else if (ae.getSource() == managerinfo) {
            setVisible(false);
            new ManagerInfo();

        } else if (ae.getSource() == customerinfo) {
            setVisible(false);
            new CustomerInfo();

        } else if (ae.getSource() == employees) {
            setVisible(false);
            new Employee();

        } else if (ae.getSource() == logout) {
            setVisible(false);
            System.exit(0);

        } else if (ae.getSource() == updatestatus) {
            setVisible(false);
            new UpdateCheck();
        }
    }


    public static void main(String[] args){
            new Reception();
    }
}
