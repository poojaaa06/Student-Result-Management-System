package studentgradebook;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class ViewMarks extends JFrame implements ActionListener {
    
    JTable table;
    JButton print,add,cancel;
    
    ViewMarks()
    {
        setSize(800,500);
        setLocation(250,80);
        setLayout(null);
        
        table=new JTable();
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from marks");
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
            new StudentMarks();
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new ViewMarks();
    }
    
}
