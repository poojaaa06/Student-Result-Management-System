
package studentgradebook;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class ViewDetails extends JFrame implements ActionListener {
    
    JTable table;
    JButton print,add,cancel,update;
    
    ViewDetails()
    {
        setSize(800,500);
        setLocation(250,80);
        setLayout(null);
        
        table=new JTable();
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,50,800,500);
        add(jsp);
        
        add=new JButton("Add");
        add.setBounds(30,10, 70 ,20);
        add.addActionListener(this);
        add(add);
        
        print=new JButton("Print");
        print.setBounds(130,10, 70 ,20);
        print.addActionListener(this);
        add(print);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(230,10, 100 ,20);
        cancel.addActionListener(this);
        add(cancel);
        
        update=new JButton("Update");
        update.setBounds(370,10, 100 ,20);
        update.addActionListener(this);
        add(update);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==print)
        {
            try
            {
                table.print();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        else if(ae.getSource()==add)
        {
            setVisible(false);
            new SudentDeatils();
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new Updatestudent();
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new ViewDetails();
    }
    
}
