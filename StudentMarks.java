
package studentgradebook;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


  public class StudentMarks extends JFrame implements ActionListener {
    
    JTextField  name,sub1,sub2,sub3,sub4,int1,int3,int2,int4;
    
    JComboBox cor;
    JButton Submit,Cancel;
   
    StudentMarks()  {
        
       setSize(600,500);
       setLocation(370,80);
       
       
       JLabel Heading = new JLabel("ENTER STUDENT RESULTS");
       setLayout(null);
       Heading.setBounds(160,6,300,20);
       Heading.setFont(new Font("serif",Font.BOLD,20));
       add(Heading);
       
       JLabel n = new JLabel("Name:");
       setLayout(null);
       n.setBounds(20,70,300,20);
       n.setFont(new Font("serif",Font.BOLD,20));
       
       add(n);   
       
       name=new JTextField();
       name.setBounds(100,72,150,20);
       add(name);
       
        JLabel fn = new JLabel(" Subject 1 Marks:");
       setLayout(null);
       fn.setBounds(15,120,300,20);
       fn.setFont(new Font("serif",Font.BOLD,20));
       add(fn);
       
       sub1=new JTextField();
       sub1.setBounds(170,122,50,20);
       add(sub1);
       
        JLabel rn = new JLabel("Subject 2 Marks:");
       setLayout(null);
       rn.setBounds(20,170,300,20);
       rn.setFont(new Font("serif",Font.BOLD,20));
       add(rn);
       
        sub2=new JTextField();
       sub2.setBounds(170,172,50,20);
       add(sub2);
       
    
      
     
       
          JLabel dob = new JLabel("Subject 3 Marks:");
       setLayout(null);
       dob.setBounds(20,220,300,20);
       dob.setFont(new Font("serif",Font.BOLD,20));
       add(dob);
        sub3=new JTextField();
       sub3.setBounds(170,222,50,20);
       add(sub3);
       
       
       
        JLabel ad = new JLabel("Subject 4 Marks:");
       setLayout(null);
       ad.setBounds(20,270,300,20);
       ad.setFont(new Font("serif",Font.BOLD,20));
       
       add(ad);   
       
       sub4=new JTextField();
       sub4.setBounds(170,272,50,20);
       add(sub4);
       
       JLabel course=new JLabel("Branch:");
           setLayout(null);
       course.setBounds(300,70,300,20);
       course.setFont(new Font("serif",Font.BOLD,20));
       add(course);
       
       String Course[]={"Computer Engg","Chemical Engg","Electronics Engg","Mechanical Engg"};
       cor=new JComboBox(Course);
       cor.setBounds(370,72,150,20);
       add(cor);
       
       
       
        JLabel em = new JLabel("Internal 1 Marks:");
       setLayout(null);
       em.setBounds(300,120,300,20);
       em.setFont(new Font("serif",Font.BOLD,20));
       
       add(em);   
       
       int1=new JTextField();
       int1.setBounds(455,122,50,20);
       add(int1);
       
        JLabel per = new JLabel("Internal 2 Marks:");
       setLayout(null);
       per.setBounds(300,170,300,20);
       per.setFont(new Font("serif",Font.BOLD,20));
       
       add(per);   
       
       int2=new JTextField();
       int2.setBounds(455,172,50,20);
       add(int2);
       
       
        JLabel ph = new JLabel("Internal 3 Marks:");
       setLayout(null);
       ph.setBounds(300,220,300,20);
       ph.setFont(new Font("serif",Font.BOLD,20));
       
       add(ph);   
       
       int3=new JTextField();
       int3.setBounds(455,222,50,20);
       add(int3);
       
       
       JLabel xii=new JLabel("Internal 4 Marks:");
       xii.setBounds(300,272,150,20);
       xii.setFont(new Font("serif",Font.BOLD,20));
       add(xii);
       
       int4=new JTextField();
       int4.setBounds(455,274,50,20);
       add(int4);

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
      String namee=name.getText();
      String sub1marks = sub1.getText();
      String sub2marks=sub2.getText();
      String sub3marks= sub3.getText();
      String sub4marks=sub4.getText();
      String cr= (String) cor.getSelectedItem();
      String int1marks=int1.getText();
      String int2marks=int2.getText();
      String int3marks=int3.getText();
       String int4marks= int4.getText();
       
       try
       {
           String query="insert into marks values('"+namee+"','"+sub1marks+"','"+sub2marks+"','"+sub3marks+"','"+sub4marks+"','"+cr+"','"+int1marks+"','"+int2marks+"','"+int3marks+"','"+int4marks+"')";
           
           Conn con=new Conn();
           con.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null,"Marks Entered Successfully");
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
        new StudentMarks();
    }

   
    
}