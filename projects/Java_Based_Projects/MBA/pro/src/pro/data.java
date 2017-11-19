/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author rajendra
 */
public class data {
  Connection conn = null;  
     String url = "jdbc:mysql://localhost/";  
     String dbName = "hms";  
     String driver = "com.mysql.jdbc.Driver";  
     String userName = "root";  
     String password = "binary71";  
     data(){
     try {  
           try{  
             java.sql.Driver mySQLDriver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();  
             DriverManager.registerDriver(mySQLDriver);  
             //Class.forName(driver).newInstance();  
             }catch(Exception ex1){  
                  //javax.swing.JOptionPane.showMessageDialog(null,ex1.getMessage());  
                 ex1.printStackTrace();  
                   
             }
     }
           catch(Exception ex2){
               ex2.printStackTrace();
           }
}
    
}

