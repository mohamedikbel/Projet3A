package utils;

/**
 *
 * @author sofiene
 */

import java.sql.*;


public class MaConnexion {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/projet";
    
    private static final String user = "root";
    
    private static final String password ="";
    
    private static  Connection conn;
    
    
    private static  MaConnexion  inst ;
    
    public Connection getcon(){return conn;}
    
    private MaConnexion(){
         try {
            // TODO code application logic here
            
            //Class.forName(password);

            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            //Logger.getLogger(MO_Bleed_jf.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("MO_ERROR_CONN !!");
            System.out.println(ex.getMessage());
        }
         
         
         
         
         
    }
    
    
    public static MaConnexion getinstence(){
        
        if(inst == null){
            inst = new MaConnexion();
        }
        return inst;
    }
    
    
    
    
}
