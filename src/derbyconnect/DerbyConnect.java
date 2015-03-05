/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derbyconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author benjamin.ramirez006
 */
public class DerbyConnect {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        
        //Connecting to database
        try{
            String host = "CONTACT DB";
            String uName = "nbuser";
            String uPass = "nbuser";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            
            Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);

            String SQL = "SELECT * FROM Members";
            ResultSet rs = stmt.executeQuery( SQL );
            
            while(rs.next()){
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String job = rs.getString("Job_Title");
                System.out.println( id_col + " " + first_name + " " + last_name + " " + job );

            }

        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }

        // TODO code application logic here
    }
    
}
