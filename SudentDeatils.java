
package studentgradebook;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

  public class SudentDeatils extends JFrame implements ActionListener {
     JDateChooser dcdob;
    JTextField tfname,fname,address,email,phone,cet,xi;
    JLabel rf;
    JComboBox cor;
    JButton Submit,Cancel;
    Random ran=new Random();
    long four=Math.abs((ran.nextLong()%9000L)+ 1000L);
    SudentDeatils()
    {
        
       setSize(600,500);
       setLocation(370,80);
       
       
       JLabel Heading = new JLabel("ENTER STUDENT DETAILS");
       setLayout(null);
       Heading.setBounds(160,6,300,20);
       Heading.setFont(new Font("serif",Font.BOLD,20));
       add(Heading);
       
       JLabel n = new JLabel("Name:");
       setLayout(null);
       n.setBounds(20,70,300,20);
       n.setFont(new Font("serif",Font.BOLD,20));
       
       add(n);   
       
       tfname=new JTextField();
       tfname.setBounds(100,72,150,20);
       add(tfname);
       
        JLabel fn = new JLabel(" Father Name:");
       setLayout(null);
       fn.setBounds(15,120,300,20);
       fn.setFont(new Font("serif",Font.BOLD,20));
       add(fn);
       
       fname=new JTextField();
       fname.setBounds(150,122,100,20);
       add(fname);
       
        JLabel rn = new JLabel("Roll No. :");
       setLayout(null);
       rn.setBounds(20,170,300,20);
       rn.setFont(new Font("serif",Font.BOLD,20));
       add(rn);
       
        rf = new JLabel("2203"+four);
       setLayout(null);
       rf.setBounds(110,162,300,40);
      
       add(rf);
       
          JLabel dob = new JLabel("Date of Birth:");
       setLayout(null);
       dob.setBounds(20,220,300,20);
       dob.setFont(new Font("serif",Font.BOLD,20));
       add(dob);
       
       dcdob = new JDateChooser();
       dcdob.setBounds(150,223,100,20);
       add(dcdob);
       
        JLabel ad = new JLabel("Address:");
       setLayout(null);
       ad.setBounds(20,270,300,20);
       ad.setFont(new Font("serif",Font.BOLD,20));
       
       add(ad);   
       
       address=new JTextField();
       address.setBounds(100,272,150,20);
       add(address);
       
        JLabel ph = new JLabel("Phone:");
       setLayout(null);
       ph.setBounds(300,70,300,20);
       ph.setFont(new Font("serif",Font.BOLD,20));
       
       add(ph);   
       
       phone=new JTextField();
       phone.setBounds(370,72,150,20);
       add(phone);
       
        JLabel em = new JLabel("Email:");
       setLayout(null);
       em.setBounds(300,120,300,20);
       em.setFont(new Font("serif",Font.BOLD,20));
       
       add(em);   
       
       email=new JTextField();
       email.setBounds(370,122,150,20);
       add(email);
       
        JLabel per = new JLabel("Mht-Cet(%):");
       setLayout(null);
       per.setBounds(300,170,300,20);
       per.setFont(new Font("serif",Font.BOLD,20));
       
       add(per);   
       
       cet=new JTextField();
       cet.setBounds(420,172,100,20);
       add(cet);
       
       JLabel course=new JLabel("Branch:");
           setLayout(null);
       course.setBounds(300,223,300,20);
       course.setFont(new Font("serif",Font.BOLD,20));
       add(course);
       
       String Course[]={"Computer Engg","Chemical Engg","Electronics Engg","Mechanical Engg"};
       cor=new JComboBox(Course);
       cor.setBounds(380,225,160,20);
       add(cor);
       
       JLabel xii=new JLabel("Class XII(%):");
       xii.setBounds(300,272,150,20);
       xii.setFont(new Font("serif",Font.BOLD,20));
       add(xii);
       
       xi=new JTextField();
       xi.setBounds(430,274,100,20);
       add(xi);

        Submit=new JButton("Submit");
        Submit.setBounds(150, 350, 120, 30);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);
       
        
        Cancel=new JButton("Cancel");
        Cancel.setBounds(300, 350, 120, 30);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        add(Cancel);
        setVisible(true);
       
    }
    
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==Submit)
    {
      String name=tfname.getText();
      String fathername = fname.getText();
      String rollno=rf.getText();
      String date=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
      String ad= address.getText();
      String ph=phone.getText();
      String em=email.getText();
      String cetmarks=cet.getText();
       String cr= (String) cor.getSelectedItem();
       String percent= xi.getText();
       
       try
       {
           String query="insert into student values('"+name+"','"+fathername+"','"+rollno+"','"+date+"','"+ad+"','"+ph+"','"+em+"','"+cetmarks+"','"+cr+"','"+percent+"')";
           
           Conn con=new Conn();
           con.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null,"Information Entered Successfully");
           setVisible(false);
       }catch(Exception e)
               {
                   e.printStackTrace();
                   
               }
    }
    else
    {
        setVisible(false);
    }
}
    
    
    public static void main(String[]args)
    {
        new SudentDeatils();
    }

   
    
}
