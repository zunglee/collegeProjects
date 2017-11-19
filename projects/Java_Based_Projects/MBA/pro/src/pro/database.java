/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

/**
 *
 * @author rajendra
 */
import java.sql.*;
import javax.swing.JOptionPane;



public class database {
    Connection con;
	database()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eas","root","binary71");
                        System.out.println("Connected\n");
		   }
		catch (Exception e) 
		{
                    System.out.println(e);
			JOptionPane.showMessageDialog(null, "Start Wamp Server!!!","Failed!!",JOptionPane.ERROR_MESSAGE);
		}
	}
}
