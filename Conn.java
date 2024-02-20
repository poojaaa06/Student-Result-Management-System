
package studentgradebook;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {
    
    Statement s;
    Connection c;
    Conn()
    {
       
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","ilovesci123");
            s=c.createStatement();
            System.out.println(c);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentGradebook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentGradebook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[]args)
    {
        Conn c= new Conn();
    }
}
