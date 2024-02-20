package studentgradebook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Login extends JFrame implements ActionListener{
    
    JButton Login,Cancel;
    JTextField tfusername,pf;
     
    
    Login()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        //username 
        JLabel lbusername=new JLabel("USERNAME");
        lbusername.setBounds(40,30,100,20);
        tfusername=new JTextField();
        tfusername.setBounds(150, 30, 150, 20);
        add(tfusername);
        
        add(lbusername);
        
        //password
        JLabel pass=new JLabel("PASSWORD");
        pass.setBounds(40,70,100,20);
        add(pass);
        pf=new JPasswordField();
        pf.setBounds(150, 70, 150, 20);
        add(pf);
        //login
        Login=new JButton("LOGIN");
        Login.setBounds(40, 140, 120, 30);
        Login.setBackground(Color.black);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        
        add(Login);
        //cancel
        Cancel=new JButton("CANCEL");
        Cancel.setBounds(180, 140, 120, 30);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        add(Cancel);
        
        //login image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New Folder/login.jpeg"));
        Image i2=i1.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(330, 20, 140, 140);
        add(image);
        setSize(500,300);
        setLocation(450,200);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()== Login)
        {
            
            String username=tfusername.getText();
            String password=pf.getText();
            
            String query="select * from login where username ='"+username+"'and password ='" + password +"'";
            
            try
            {
               Conn c= new Conn();
               ResultSet rs= c.s.executeQuery(query);
               
               if(rs.next())
               {
                   setVisible(false);
                   new LandingPage();
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Invalid username or password");
                   setVisible(false);
               }
               
               
              
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(ae.getSource()==Cancel)
                {
                    setVisible(false);
                }
    }
    
    
    

public static void main(String[]args)
{
new Login();

}
}
    

