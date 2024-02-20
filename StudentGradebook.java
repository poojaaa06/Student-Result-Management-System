package studentgradebook;

import javax.swing.*;
import java.awt.*;
public class StudentGradebook extends JFrame implements Runnable{
    Thread t;

    StudentGradebook()
    {
        //initial background//
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New Folder/my.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        setVisible(true);
        setSize(900,600);
        setLocation(210,40);
        t= new Thread(this);
        t.start();
    }
    
     public void run()
    {
        //background automatically closes after 5sec// 
        try{
            Thread.sleep(5000);
            setVisible(false);
            
            new Login();
    }catch(Exception e)
    {
        
    }
    
            
}
    public static void main(String[] args) {
        
        StudentGradebook s= new StudentGradebook();
       
        
    
    }

   
}
