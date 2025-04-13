import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
        setSize(1966,1024);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/wallpaperflare.com_wallpaper.jpg"));
        JLabel image = new JLabel(i1);
        add(image);


        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(400,100,800 ,100);
        text.setForeground(Color.black);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);


        JButton next = new JButton("Next");
        next.setBounds(1300,700,150,50);
        next.setBackground(Color.blue);
        next.setForeground(Color.magenta);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,25));
        image.add(next);



        setVisible(true);


        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
    public void actionPerformed(ActionEvent ac){
        setVisible(false);
        new Login();


    }

    public static void main(String[] args){
        new HotelManagementSystem();

    }
}