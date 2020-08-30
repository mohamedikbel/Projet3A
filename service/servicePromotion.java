/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.promotion; 
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnexion;

/**
 *
 * @author Amal
 */
public class servicePromotion {
            Connection  c = MaConnexion.getinstence().getcon();
    public servicePromotion() {
    }
    

    
    
   public void addpromo(promotion p) {
 
        try {
            
            String req="insert into promotion (libelle,titre,ancien_prix,reduction,date_debut,date_fin,photo) values (?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps=c.prepareStatement(req);
                ps.setInt(1,p.getLibelle());
                ps.setString(2,p.getTitre());
                ps.setFloat(3,p.getAncien_prix());
                ps.setInt(4,p.getReduction());
                ps.setString(5,p.getDate_debut());
                ps.setString(6,p.getDate_fin());
                ps.setString(7,p.getPhoto());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
            }
            //SELECT (ancien_prix*reduction/100) from promotion WHERE libelle=5
            //UPDATE promotion set nouveau_prix=(SELECT (ancien_prix*reduction/100)) WHERE libelle=5;
            PreparedStatement st; 
            String req1="SELECT (ancien_prix-(ancien_prix*reduction/100)) from promotion where libelle=?"; 
           st = c.prepareStatement(req1);
           st.setInt(1,p.getLibelle());
           ResultSet rs = st.executeQuery();
            while(rs.next())
        {   
             String query = "UPDATE promotion set nouveau_prix = ? where libelle=?";   
             
            PreparedStatement pt =c.prepareStatement(query);
            p.setNouveau_prix(rs.getFloat(1));
            pt.setFloat(1,p.getNouveau_prix());
            pt.setInt(2,p.getLibelle());
            pt.executeUpdate();
         
        // System.out.println("nouveau prix"+rs.getFloat(1));  
        }  
            
        } catch (SQLException ex) {
            Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }} 
   
       public void Findpromo (String cher) {
     try {
        Statement st = c.createStatement();
        String query="SELECT * FROM promotion WHERE CONCAT(`titre`, `photo`, `ancien_prix`,`reduction`,`nouveau_prix`,`date_debut`,`date_fin`) LIKE '%"+cher+"%'";
        ResultSet  rs =st.executeQuery(query);
        while(rs.next())
        {   
         System.out.println("id promotion: "+rs.getInt(1)+"libelle livre: "+rs.getInt(2)+": titre: "+rs.getString(3)+":photo: "+rs.getString(4)+":ancien_prix: "+rs.getFloat(5)+":reduction: "+rs.getInt(6)+":nouveau_prix: "+rs.getFloat(7)+":date_debut: "+rs.getString(8)+":date_fin: "+rs.getString(9));  
        }  
        } catch (SQLException ex) {
        Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }} 
        /*public float  recupererprix(int id){
                
        String query="SELECT prix from produit where libelle = ?";
        float p=0;
        try {
            PreparedStatement pt =c.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet resultSet = pt.executeQuery();
            if (resultSet.next()) {
             p =resultSet.getFloat(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
        }*/
       
   
       
public boolean supprimer_promo(promotion pr) 
{
    try {
        PreparedStatement   pt = c.prepareStatement("delete from promotion where id=?");
        pt.setInt(1,pr.getId());
        pt.execute(); 
        return true ;
    } catch (SQLException ex) {
        Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
    }
       return false;
    
}
/*public void afficher_promo() 
{ 

        try {
        Statement st = c.createStatement();
        
        String query= "select * from promotion";
        ResultSet  rs =st.executeQuery(query);
        
        
        while(rs.next())
        {   
         System.out.println("id promotion: "+rs.getInt(1)+"libelle livre: "+rs.getInt(2)+": titre: "+rs.getString(3)+":photo: "+rs.getString(4)+":ancien_prix: "+rs.getFloat(5)+":reduction: "+rs.getInt(6)+":nouveau_prix: "+rs.getFloat(7)+":date_debut: "+rs.getString(8)+":date_fin: "+rs.getString(9));  
        }  
        } catch (SQLException ex) {
        Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }} */
        
 public void modifierpromo(promotion p) { // tu peut modifier que les champs concernat le promo livre non
 
    
    try {
       
    String query= "UPDATE promotion set reduction = ? , date_debut=? , date_fin=? where id=?";  
    try {
    PreparedStatement pt =c.prepareStatement(query);
   //  pt.setString(1,p.getPhoto());
     pt.setInt(1,p.getReduction());
     pt.setString(2,p.getDate_debut());
     pt.setString(3,p.getDate_fin());
      pt.setInt(4,p.getId());
     pt.executeUpdate();
     }catch (SQLException ex) {
        Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
    }      PreparedStatement st; 
            String req1="SELECT (ancien_prix-(ancien_prix*reduction/100)) from promotion where id=?"; 
           st = c.prepareStatement(req1);
           st.setInt(1,p.getId());
           ResultSet rs = st.executeQuery();
            while(rs.next())
        {   
             String queryy = "UPDATE promotion set nouveau_prix = ? where id=?";   
             
            PreparedStatement pt =c.prepareStatement(queryy);
            p.setNouveau_prix(rs.getFloat(1));
            pt.setFloat(1,p.getNouveau_prix());
            pt.setInt(2,p.getId());
            pt.executeUpdate();
         
        // System.out.println("nouveau prix"+rs.getFloat(1));  
        }  
            
        } catch (SQLException ex) {
            Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }} 
 


 

       public ObservableList<promotion> lister() {

        ObservableList <promotion> list = FXCollections.observableArrayList();
        ResultSet rs; // pour récupérer le résultat de select
        String req = "SELECT * FROM promotion";
        try {
       PreparedStatement   ps = c.prepareStatement(req);
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               promotion p = 
                        new promotion();
                  p.setId(rs.getInt("id"));
                 p.setLibelle(rs.getInt("libelle"));
                p.setTitre(rs.getString("titre"));
                 p.setReduction(rs.getInt("reduction"));
                p.setAncien_prix(rs.getFloat("ancien_prix"));
                p.setNouveau_prix(rs.getFloat("nouveau_prix"));
                p.setDate_debut(rs.getString("date_debut"));
                p.setDate_fin(rs.getString("date_fin"));
            
                //ps.setString(4,p.getPhoto());

                //ps.executeUpdate();

                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } 
    

}


       
/*public void client_promoauto() //nhorha fil partie client 
{ 
      LocalDate localDate = LocalDate.now();
       String a=DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate).toString();
    try {
        PreparedStatement   pt = c.prepareStatement("UPDATE promotion SET affclient=1 WHERE date_fin=?");
        pt.setString(1,a);
        pt.execute();
    } catch (SQLException ex) {
        Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
    }
    
} */

       public ObservableList<promotion> lister_client() { 
       ObservableList <promotion> list = FXCollections.observableArrayList(); 
        ResultSet rs; // pour récupérer le résultat de select
        String req = "SELECT * FROM promotion where affclient=1";
        try {
       PreparedStatement   ps = c.prepareStatement(req);
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               promotion p = 
                        new promotion();
                 // p.setId(rs.getInt("id"));
                 p.setLibelle(rs.getInt("libelle"));
                p.setTitre(rs.getString("titre"));
                 p.setReduction(rs.getInt("reduction"));
                p.setAncien_prix(rs.getFloat("ancien_prix"));
                p.setNouveau_prix(rs.getFloat("nouveau_prix"));
                p.setDate_debut(rs.getString("date_debut"));
                p.setDate_fin(rs.getString("date_fin"));
                p.setPhoto(rs.getString("photo"));
            
                //ps.setString(4,p.getPhoto());

                //ps.executeUpdate();

                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }} 
    


       
       public void client_promoautoo() 
{ 
      
       try 
       {
           int i=0;
           LocalDate localDate = LocalDate.now(); 
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //  System.out.println(localDate);
          String formattedString = localDate.format(formatter);
          LocalDate datefinal = LocalDate.parse(formattedString, formatter);
           // System.out.println(datefinal);
          
          
           ResultSet rs;
           String req = "SELECT date_fin,id FROM promotion";
           int id;
           PreparedStatement   ps = c.prepareStatement(req);
           rs = ps.executeQuery(req);
           while (rs.next()) {
                  i=i+1 ; 
                System.out.println("\n i = "+i); 
               rs.getString("date_fin");
              
                
                  // System.out.println(rs.getString(""+"id"));
               if((datefinal.compareTo(LOCAL_DATE(rs.getString("date_fin")))>0)==false)
               { 
                   
                   id =rs.getInt("id");
                  
                    System.out.println(datefinal.compareTo(LOCAL_DATE(rs.getString("date_fin")))>0);
                 System.out.println("test");
                 PreparedStatement   pt = c.prepareStatement("UPDATE promotion SET affclient=1 Where id=? ");
                 pt.setInt(1,id);
                 pt.executeUpdate(); 
               } 
               else if ((datefinal.compareTo(LOCAL_DATE(rs.getString("date_fin")))>0)==true)
               { 
                   
                   id =rs.getInt("id");
                  
                    System.out.println(datefinal.compareTo(LOCAL_DATE(rs.getString("date_fin")))>0);
                 System.out.println("test2");
                 PreparedStatement   pt = c.prepareStatement("UPDATE promotion SET affclient=0 Where id=? ");
                 pt.setInt(1,id);
                 pt.executeUpdate(); 
               } 
               
      
           }
       } catch (SQLException ex) {
           Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
       }
  

} 
       
        public int nombrepromo() 
     {
         int a=0;
    try {
        Statement st = c.createStatement();
        String query="SELECT count(affclient) as nombre from promotion where affclient=1";
        ResultSet  rs =st.executeQuery(query); 
          while(rs.next())
        {   
            
            a=rs.getInt(1);
       
        } 
    } catch (SQLException ex) {
       // Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return a;
     }
 public static final LocalDate LOCAL_DATE (String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }
}