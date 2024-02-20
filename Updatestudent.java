
package studentgradebook;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;



  public class Updatestudent extends JFrame implements ActionListener
  {
     
    JTextField tfname,fname,address,email,phone,cet,xi,cor;
    JLabel rf,dcdob;
   
    JButton Submit,Cancel;
    Choice crollno;
  
    Updatestudent()
    {
        
       setSize(600,500);
       setLocation(370,80);
       
       
       JLabel Heading = new JLabel("UPDATE STUDENT DETAILS");
       setLayout(null);
       Heading.setBounds(160,0,300,20);
       Heading.setFont(new Font("serif",Font.BOLD,20));
       add(Heading);
       
       JLabel lbrollno=new JLabel("Select Roll no.:");
       lbrollno.setBounds(15, 20, 150, 20);
       lbrollno.setFont(new Font("serif",Font.PLAIN,20));
       add(lbrollno);
       
       crollno=new Choice();
       crollno.setBounds(165, 23, 200, 20);
       add(crollno);
       
       
       
  
       
       
       try
       {
           Conn c= new Conn();
           ResultSet rs=c.s.executeQuery("select * from student");
           while(rs.next())
           {
               crollno.add(rs.getString("rollno"));
               
               
           }
       }catch(Exception e)
       {
           
        e.printStackTrace();
       }
    
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
       
        rf = new JLabel();
       setLayout(null);
       rf.setBounds(110,162,300,40);
      
       add(rf);
       
          JLabel dob = new JLabel("Date of Birth:");
       setLayout(null);
       dob.setBounds(20,220,300,20);
       dob.setFont(new Font("serif",Font.BOLD,20));
       add(dob);
       
         dcdob = new JLabel();
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
       
     
        cor=new JTextField();
       cor.setBounds(380,225,160,20);
       add(cor);
       
       JLabel xii=new JLabel("Class XII(%):");
       xii.setBounds(300,272,150,20);
       xii.setFont(new Font("serif",Font.BOLD,20));
       add(xii);
       
       xi=new JTextField();
       xi.setBounds(430,274,100,20);
       add(xi);
        try
        {
          Conn c= new Conn();
          String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
          ResultSet rs=c.s.executeQuery(query);
          while(rs.next())
          {
              tfname.setText(rs.getString("name"));
              fname.setText(rs.getString("fathername"));
              rf.setText(rs.getString("rollno"));
              address.setText(rs.getString("address"));
              dcdob.setText(rs.getString("date"));
              phone.setText(rs.getString("phone"));
              email.setText(rs.getString("email"));
              xi.setText(rs.getString("xii_percent"));
              cet.setText(rs.getString("cetmarks"));
              cor.setText(rs.getString("course"));
              
          }
    
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
         
        
        crollno.addItemListener(new ItemListener()
        {public void itemStateChanged(ItemEvent ie)
        {
             try
        {
          Conn c= new Conn();
          String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
          ResultSet rs=c.s.executeQuery(query);
          while(rs.next())
          {
              tfname.setText(rs.getString("name"));
              fname.setText(rs.getString("fathername"));
              rf.setText(rs.getString("rollno"));
              address.setText(rs.getString("address"));
              dcdob.setText(rs.getString("date"));
              phone.setText(rs.getString("phone"));
              email.setText(rs.getString("email"));
              xi.setText(rs.getString("xii_percent"));
              cet.setText(rs.getString("cetmarks"));
              cor.setText(rs.getString("course"));
              
          }
    
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        
        });

        Submit=new JButton("Update");
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
      String ad= address.getText();
      String ph=phone.getText();
      String em=email.getText();
      String cetmarks=cet.getText();
       String cr=cor.getText();
       String percent= xi.getText();
       
       try
       {
           String query="update student set name ='"+name+"',fathername='"+fathername+"',address='"+ad+"',phone= '"+ph+"',email ='"+em+"',cetmarks='"+cetmarks+"',course='"+cr+"',xii_percent='"+percent+"'where rollno='"+rollno+"'";
           
           Conn con=new Conn();
           con.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");
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
        new Updatestudent();
    }

   
    
}
