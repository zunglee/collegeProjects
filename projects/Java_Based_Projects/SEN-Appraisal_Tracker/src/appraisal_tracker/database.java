/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appraisal_tracker;

import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author kbiiita
 */
public class database {
    Connection con;
	database()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/appraisal","root","");
                        //System.out.println("Connected\n");
		   }
		catch (ClassNotFoundException | SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Start Wamp Server!!!","Failed!!",JOptionPane.ERROR_MESSAGE);
		}
	}

}

