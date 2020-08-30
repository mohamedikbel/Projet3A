/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import utils.MaConnexion;
import java.sql.*;
import entities.Client;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import javafx.scene.image.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import projet.pkg3a5.BCrypt;
import projet.pkg3a5.clientaf;

/**
 *
 * @author TOSHIBA
 */
public class ClientDB {
    
            Connection  C  = MaConnexion.getinstence().getcon();

    
    public void sinscrire(String uname,String lname,String pass,String email,String num,byte image[],String code,String roles) throws SQLException
     {
        Connection  C  = MaConnexion.getinstence().getcon();

       
            
             try {
            PreparedStatement pst = C.prepareStatement("insert into user(uname,lname,password,email,num,image,code,roles,recode) values (?,?,?,?,?,?,?,?,?)");

            pst.setString(1,uname);
            pst.setString(2,lname);
            String passh= BCrypt.hashpw(pass, BCrypt.gensalt(13));
            pst.setString(3,passh);
            pst.setString(4,email);
            pst.setString(5,num);
            pst.setBytes(6,image);
            pst.setString(7,code);
            pst.setString(8,roles);
            String recode="activ123";
            pst.setString(9,recode);

            pst.executeUpdate();
             
             
             }

          
                    
                    
                    catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }}
            
            /*
            st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);*/
        
     
    public Image userimage (String usr) throws SQLException, IOException
    {
    Connection  C  = MaConnexion.getinstence().getcon();
        Image imagex = null;
     PreparedStatement pst = C.prepareStatement("Select image from user where email=?");
     pst.setString(1,usr);

        ResultSet rs = pst.executeQuery();
             
             while(rs.next())
                {
                    InputStream is = rs.getBinaryStream("image");
                    OutputStream os = new FileOutputStream(new File("photo.jpg"));
                    byte[]content = new byte[1024];
                    int size = 0;
                    while((size=is.read(content))!= -1)
                    {
                        os.write(content,0,size);
                    }
                    os.close();
                    is.close();
                     imagex = new Image("file:photo.jpg",250,250,true,true);
                }
    
           return imagex;    
    }
  
  public  String userfname(String usr) throws SQLException{
  
      Connection  C  = MaConnexion.getinstence().getcon();
        String name = null;
     PreparedStatement pst = C.prepareStatement("Select uname from user where email=?");
     pst.setString(1,usr);

        ResultSet rs = pst.executeQuery();
             
             while(rs.next())
                {
                     name = rs.getString("uname");
  
                }
           
         
   return name;
  }
  
  
  
   public  String userlname(String usr) throws SQLException{
  
    Connection  C  = MaConnexion.getinstence().getcon();
        String name = null;
     PreparedStatement pst = C.prepareStatement("Select lname from user where email=?");
     pst.setString(1,usr);

        ResultSet rs = pst.executeQuery();
             
             while(rs.next())
                {
                     name = rs.getString("lname");
  
                }
           
         
   return name;
  
  
  }
  
  
  
  public  int userid(String usr) throws SQLException{
  
    Connection  C  = MaConnexion.getinstence().getcon();
        int name = 0;
     PreparedStatement pst = C.prepareStatement("Select id from user where email=?");
     pst.setString(1,usr);

        ResultSet rs = pst.executeQuery();
             
             while(rs.next())
                {
                    name = rs.getInt("id");
  
                }
           
         
   return name;
  
  
  }
  
  
  public  String userpass(String usr) throws SQLException{
  
    Connection  C  = MaConnexion.getinstence().getcon();
        String name = null;
                String pass = null;

     PreparedStatement pst = C.prepareStatement("Select password from user where email=?");
     pst.setString(1,usr);

        ResultSet rs = pst.executeQuery();
             
             while(rs.next())
                {
                     name = rs.getString("password");
                      pass=BCrypt.decode_base64(name, 8).toString();
  
                }
           
         
   return pass;
  
  
  }
  
  
   public Boolean authentication(String username, String password) {
        Boolean exist = false;
            Connection  C  = MaConnexion.getinstence().getcon();

        try {
            String query = "select * from user  where email = ?";
            PreparedStatement ps = C.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                if (i == 1) {
                    if (BCrypt.checkpw(password,rs.getString(4)) == true) {
                       Client.setCurrentuser(rs.getString(5));
                       
                        exist = true;

                    } else {
                        exist = false;
                    }
                }

            }

        } catch (SQLException ex) {
        //    Logger.getLogger(IUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }

  
  
   public  String usertel(String usr) throws SQLException{
  
    Connection  C  = MaConnexion.getinstence().getcon();
        String name = null;
     PreparedStatement pst = C.prepareStatement("Select num from user where email=?");
     pst.setString(1,usr);

        ResultSet rs = pst.executeQuery();
             
             while(rs.next())
                {
                     name = rs.getString("num");
  
                }
           
         
   return name;
  
  
  }
  
   public  String getuser(String usr) throws SQLException{
  
    Connection  C  = MaConnexion.getinstence().getcon();
        String name = null;
     PreparedStatement pst = C.prepareStatement("Select * from user where code=?");
     pst.setString(1,usr);

        ResultSet rs = pst.executeQuery();
             
             while(rs.next())
                {
                     name = rs.getString("email");
  
                }
           
         
   return name;
  
  
  }
  
  
  
  
        
         public void Modifier(String name,String lname ,String email,String pass,String tel,String cur,byte image[]){
    
        
                Connection  C  = MaConnexion.getinstence().getcon();

        try {
            PreparedStatement pst = C.prepareStatement("update user set uname = ? , lname=?, password=? , email=? , num=? ,image=?  where email = ?");
            pst.setString(1, name);
            pst.setString(2, lname);
            String passh= BCrypt.hashpw(pass, BCrypt.gensalt(13));
            pst.setString(3, passh);

            pst.setString(4, email);
            pst.setString(5, tel);
            pst.setBytes(6,image);


            pst.setString(7,cur);

            



            
            
            pst.executeUpdate();
                    
                    
                    } catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
         
         
         
         
         
    /*    public void Delete(Client Cl){
    
        
                Connection  C  = MaConnexion.getinstence().getcon();

        try {
            PreparedStatement pst = C.prepareStatement("Delate from personne   where id = ?");
            pst.setString(1, "1");
            
            pst.executeUpdate();
                    
                    
                    } catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
    */
    
      public  int useretat(String usr) throws SQLException{
  
    Connection  C  = MaConnexion.getinstence().getcon();
        int name = 0 ;
     PreparedStatement pst = C.prepareStatement("Select num from user where email=?");
     pst.setString(1,usr);

        ResultSet rs = pst.executeQuery();
             
             while(rs.next())
                {
                     name = rs.getInt("etat");
  
                }
           
         
   return name;
  
  
  }
    
    
    
    public boolean setrec(String email) throws SQLException{
    
       boolean exist=false;
                Connection  C  = MaConnexion.getinstence().getcon();

        try {
            PreparedStatement pst = C.prepareStatement("update user set recode = ?    where email = ?");
            pst.setString(1, "activ123");
            pst.setString(2, email);
            pst.executeUpdate();
            ResultSet rs = pst.executeQuery();    
                    
                    
        
            int i = 0;
            while (rs.next()) {
                i++;
                if (i == 1) {
                        exist = true;

                    } else {
                        exist = false;
                    }
                }

         
        }
        catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
}
      public boolean setrectel(String tel){
    
        
                    boolean exist=false;
                Connection  C  = MaConnexion.getinstence().getcon();

        try {
            PreparedStatement pst = C.prepareStatement("update user set recode = ?    where num = ?");
            pst.setString(1, "activ123");
            pst.setString(2, tel);
            ResultSet rs = pst.executeQuery();    
                    
                    
        
            int i = 0;
            while (rs.next()) {
                i++;
                if (i == 1) {
                        exist = true;

                    } else {
                        exist = false;
                    }
                }

         
        }
        catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;}
    

      
      


    public void setpass(String user,String pass){
    
        
                Connection  C  = MaConnexion.getinstence().getcon();

        try {
            
           PreparedStatement pst = C.prepareStatement("update user set password = ?    where email = ?");
           String passh= BCrypt.hashpw(pass, BCrypt.gensalt(13));
            pst.setString(1, passh);
            pst.setString(2, user);
            pst.executeUpdate();
                    
                    
                    } catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    
    
     public boolean exist(String user){
    
        
                    boolean exist=false;
                Connection  C  = MaConnexion.getinstence().getcon();

        try {
            PreparedStatement pst = C.prepareStatement("Select * from user where email=?");
            pst.setString(1,user);
          
            ResultSet rs = pst.executeQuery();    
                    
                    
        
            int i = 0;
            while (rs.next()) {
                i++;
                if (i == 1) {
                        exist = true;

                    } else {
                        exist = false;
                    }
                }

         
        }
        catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;}
    

      public Boolean userandcode(String username, String code) {
        Boolean exist = false;
            Connection  C  = MaConnexion.getinstence().getcon();

        try {
            String query = "select * from user  where email = ?";
            PreparedStatement ps = C.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                if (i == 1) {
                    String m=rs.getString(11);
                    if(m.equals(code)) {
                       
                        exist = true;

                    } else {
                        exist = false;
                    }
                }

            }

        } catch (SQLException ex) {
        //    Logger.getLogger(IUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }
    
     public boolean setrecnull(String email) throws SQLException{
    
       boolean exist=false;
                Connection  C  = MaConnexion.getinstence().getcon();

        try {
            PreparedStatement pst = C.prepareStatement("update user set recode = ?    where email = ?");
            pst.setString(1, null);
            pst.setString(2, email);
            pst.executeUpdate();
            ResultSet rs = pst.executeQuery();    
                    
                    
        
            int i = 0;
            while (rs.next()) {
                i++;
                if (i == 1) {
                        exist = true;

                    } else {
                        exist = false;
                    }
                }

         
        }
        catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
}
    
     public List<String> getauto() throws SQLException
     {Connection  C  = MaConnexion.getinstence().getcon();
             List<String> list = new  ArrayList<>();
            PreparedStatement pst = C.prepareStatement("Select email from user  ");
         

            int i=0;
            
            ResultSet rs = pst.executeQuery();    
               while(rs.next()){
                i++;
                      System.out.println(i);

                
                    list.add(rs.getString(1));
                     System.out.print(list.get(0));


               }
               
    return list;}
     

     public ObservableList<clientaf> getall() throws SQLException
     {Connection  C  = MaConnexion.getinstence().getcon();

           ObservableList<clientaf> data= FXCollections.observableArrayList();
            PreparedStatement pst = C.prepareStatement("Select *from user");
          
            ResultSet rs = pst.executeQuery();    
               while(rs.next()){
                
                
                

                
                    clientaf ct = new clientaf();
                    ct.setNom(rs.getString(2));
                    
                    ct.setPrenom(rs.getString(3));
                    ct.setEmail(rs.getString(5));
                    ct.setButton(new Button("Supprimer"));
                    ct.setQr(new Button("Attrubuer Code"));

                    
                     data.add(ct);
               }
               
    return data;}
     
     public void delete(String user){
    
        
                Connection  C  = MaConnexion.getinstence().getcon();

        try {
            
           PreparedStatement pst = C.prepareStatement("delete from user where email = ?");
            pst.setString(1, user);
            pst.executeUpdate();
                    
                    
                    } catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    
    
      public ObservableList<clientaf> getalldyn(String user) throws SQLException
     {Connection  C  = MaConnexion.getinstence().getcon();

           ObservableList<clientaf> data= FXCollections.observableArrayList();
            PreparedStatement pst = C.prepareStatement("Select *from user WHERE email LIKE ?");
            pst.setString(1, user + "%");

          
            ResultSet rs = pst.executeQuery();    
               while(rs.next()){
                
                
                

                
                    clientaf ct = new clientaf();
                    ct.setNom(rs.getString(2));
                    
                    ct.setPrenom(rs.getString(3));
                    ct.setEmail(rs.getString(5));
                    ct.setButton(new Button("Supprimer"));
                    ct.setQr(new Button("Attrubuer Code"));
                            System.out.println(ct);

                     data.add(ct);
               }
               
    return data;}
     
     
     
}

