

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JTextField username,password;
    JButton login,cancel;
    Login()  {

        getContentPane().setBackground(Color.BLUE);

        setLayout(null);

        JLabel user = new JLabel("USERNAME :");
        user.setBounds(40,20,100,30);
        user.setForeground(Color.yellow);
        add(user);

        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass = new JLabel("PASSWORD :");
        pass.setBounds(40,80,100,30);
        pass.setForeground(Color.yellow);
        add(pass);

        password = new JTextField();
        password.setBounds(150,80,150,30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/images.png"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        setBounds(500,200,600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==login){
            String user = username.getText();
            String pass = password.getText();

            try{
                Conn  c = new Conn();

                String query = "select * from login where username ='" + user + "' and password = '" + pass + "' ";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Dasboard();
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                    new Login();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource()==cancel){
            setVisible(false);
        }

    }


    public static void main(String[] args){
        new Login();
    }
}

