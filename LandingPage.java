
package studentgradebook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LandingPage extends JFrame implements ActionListener{
    
    LandingPage()
    {
       setSize(1550,720);
       //landing page image
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New Folder/land.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 720, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        //menu bar
        
        
        //entering details
        JMenuBar jb = new JMenuBar();
      
        jb.setBackground(Color.black);
        JMenu Studentdetails = new JMenu(" ENTER STUDENT INFORMATION");
        Studentdetails.setForeground(Color.white);
        
        
        jb.add(Studentdetails);
        
        JMenuItem StDetails = new JMenuItem("Enter Student details");
        StDetails.setBackground(Color.black);
        StDetails.setForeground(Color.white);
        StDetails.addActionListener(this);
        Studentdetails.add(StDetails);
        
         JMenuItem StResult = new JMenuItem("Enter Student Results");
        StResult.setBackground(Color.black);
        StResult.setForeground(Color.white);
        StResult.addActionListener(this);
        Studentdetails.add(StResult);
        
        //viewing details
        JMenu Viewdetails = new JMenu(" VIEW STUDENT INFORMATION");
        Viewdetails.setForeground(Color.white);
        jb.add(Viewdetails);
        
        JMenuItem Vsdetails = new JMenuItem(" View Student details");
        Vsdetails.setBackground(Color.black);
        Vsdetails.setForeground(Color.white);
        Vsdetails.addActionListener(this);
        Viewdetails.add(Vsdetails);
        
         JMenuItem Result = new JMenuItem(" View Student Results");
        Result.setBackground(Color.black);
        Result.setForeground(Color.white);
        Result.addActionListener(this);
        Viewdetails.add(Result);
        
        
        //update details
        /*JMenu Udetails = new JMenu(" UPDATE STUDENT INFORMATION");
        Udetails.setForeground(Color.white);
        jb.add(Udetails);
        
        JMenuItem USdetails = new JMenuItem(" Update Student details");
        USdetails.setBackground(Color.black);
        USdetails.setForeground(Color.white);
        Udetails.add(USdetails);
        
         JMenuItem UResult = new JMenuItem(" Update Student Results");
        UResult.setBackground(Color.black);
        UResult.setForeground(Color.white);
        Udetails.add(UResult);
*/
        
        
        //exit
        
        JMenu Exit = new JMenu("EXIT");
        Exit.setForeground(Color.white);
       
        jb.add(Exit);
        setJMenuBar(jb);
        
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);
        
        Exit.add(exitMenuItem);
        
       
       setVisible(true);
    }
    
        public void actionPerformed(ActionEvent ae)
        {
            String msg=ae.getActionCommand();
            if (msg.equals("Enter Student details"))
            {
                new SudentDeatils();
            
                
            }
            
            else if(msg.equals("Enter Student Results"))
            {
                new StudentMarks();
            }
            
            else if(msg.equals(" View Student details"))
            {
                new ViewDetails();
            }
            else if(msg.equals(" View Student Results"))
            {
                new ViewMarks();
            }
            else if(msg.equals("Exit"))
            {
                setVisible(false);
            }
            
        }
    
    public static void main(String[] args)
    {
        new LandingPage();
    }
    
}
