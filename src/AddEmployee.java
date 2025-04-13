import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField nametxt,agetxt,salarytxt,phonetxt,emailtxt,adhartxt;
    JRadioButton genderradiom,genderradiof;
    JComboBox jcom;
    JButton submit,cancel;


    AddEmployee(){

        JLabel head=new JLabel("ADD EMPLOYEE");
        head.setBounds(300,0,300,30);
        head.setFont(new Font("Montserrat",Font.CENTER_BASELINE,25));
        add(head);

        JLabel name=new JLabel("Name");
        name.setBounds(30,70,100,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(name);

        nametxt=new JTextField();
        nametxt.setBounds(140,70,150,30);
        add(nametxt);

        JLabel age=new JLabel("Age");
        age.setBounds(30,130,100,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(age);

        agetxt=new JTextField();
        agetxt.setBounds(140,130,150,30);
        add(agetxt);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(30,190,100,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(gender);

        genderradiom=new JRadioButton("Male");
        genderradiom.setBounds(140,193,70,30);
        genderradiom.setBackground(Color.WHITE);
        genderradiom.setFont(new Font("Tohima",Font.BOLD,14));
        add(genderradiom);

        genderradiof=new JRadioButton("Female");
        genderradiof.setBounds(220,193,90,30);
        genderradiof.setBackground(Color.WHITE);
        genderradiof.setFont(new Font("Tohima",Font.BOLD,14));
        add(genderradiof);

        ButtonGroup bg=new ButtonGroup();
        bg.add(genderradiom);
        bg.add(genderradiof);

        JLabel job=new JLabel("Job");
        job.setBounds(30,243,100,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(job);


        String str[]={"Receptionist","HR","Executive HR","Management","Housekeeping","Roomservice", "Clerk","Waiter/Waitress"};
        jcom = new JComboBox(str);
        jcom.setBounds(140,243,150,30);
        jcom.setBackground(Color.WHITE);
        add(jcom);


        JLabel salary=new JLabel("Salary");
        salary.setBounds(30,303,100,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(salary);

        salarytxt=new JTextField();
        salarytxt.setBounds(140,303,150,30);
        add(salarytxt);


        JLabel phone=new JLabel("Phone");
        phone.setBounds(30,363,100,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(phone);

        phonetxt=new JTextField();
        phonetxt.setBounds(140,363,150,30);
        add(phonetxt);

        JLabel email=new JLabel("Email");
        email.setBounds(30,423,100,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(email);

        emailtxt=new JTextField();
        emailtxt.setBounds(140,423,150,30);
        add(emailtxt);

        JLabel adhar=new JLabel("Aadhaar");
        adhar.setBounds(30,483,100,30);
        adhar.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(adhar);

        adhartxt=new JTextField();
        adhartxt.setBounds(140,483,150,30);
        add(adhartxt);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/images.png"));
        Image i2= i1.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,140,250,250);
        add(image);

        submit= new JButton("Submit");
        submit.setBounds(400,490,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setBounds(550,490,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setLayout(null);
        setBounds(250,100,800,600);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }
    public void actionPerformed(ActionEvent ae){
                    String name = nametxt.getText();
                    String age = agetxt.getText();
                    String salary = salarytxt.getText();
                    String phone = phonetxt.getText();
                    String email = emailtxt.getText();
                    String aadhar = adhartxt.getText();

                    String gender = null;

                    if ( genderradiom.isSelected()) {
                        gender = "Male";
                    } else if (genderradiof.isSelected()){
                        gender = "Female";
                    }

                    String job = (String)  jcom.getSelectedItem();

                    try{
                       if(ae.getSource()==submit){
                           Conn conn = new Conn();

                           String query = "insert into employee values('" +name+"','"+age+"' ,'"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

                           conn.s.executeUpdate(query);

                           JOptionPane.showMessageDialog(null,"Employee added successfully");

                       }
                       else if(ae.getSource()==cancel){
                           setVisible(false);
                       }

                    }catch (Exception e) {
                        e.printStackTrace();
                    }


    }

    public static void main(String[] args){

        new AddEmployee();

    }



}
