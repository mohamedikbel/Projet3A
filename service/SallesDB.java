/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entite.Salles;
import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import utils.MaConnexion;

/**
 *
 * @author PC
 */
public class SallesDB {
  Connection  C  = MaConnexion.getinstence().getcon(); 
     
     
     public void ajoutersalles(Salles  S){
    
        try {
            Statement st = C.createStatement();
            String query = "insert into salles values("+S.numero+",'"+S.nom+"','"+S.capacitee+"','"+S.superficie+"','"+S.etage+"','"+S.disponibilite+"','"+S.path+"',null)";
            
            st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
     
    public ObservableList<Salles> affichersalles(){
        ObservableList myList = FXCollections.observableArrayList();
        
        try {
            Statement st = C.createStatement();
            String str = "SELECT * FROM salles";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
            System.out.println("Salles : "+rs.getInt(1)
                    +" | "+rs.getString(2)
                    +" | "+rs.getInt(3)
                    +" | "+rs.getInt(4)
                    +" | "+rs.getInt(5)
                    +" | "+rs.getString(6)
                    +" | "+rs.getString(7));
                    
              myList.add(new Salles(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),
                    rs.getString(6),rs.getString(7),null));
            }    
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de l'affichage " + ex.getMessage());
        }      
        return myList;
    }
    
     public void delete_Salles(Salles S) {

     
String requete = "delete from salles where numero = ?";
        try {
            PreparedStatement ps = C.prepareStatement(requete);
            ps.setInt(1, S.getNumero());
            ps.executeUpdate();
            System.out.println("Salles supprimé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    
        
     }
   
	
    
     
     
     
   
    public void Modifier_salle(Salles S) {
   

        
      PreparedStatement ps ;
            String req = "UPDATE salles set nom = ?  where numero=?";
            try {
                ps = C.prepareStatement(req);

                ps.setString(1, S.getNom());
               
                ps.setInt(2,S.getNumero());


                ps.executeUpdate();
                System.out.println("DONE UPDATE");
            } catch (SQLException ex) {
          //Logger.getLogger(BoutiqueDAO.class.getName()).log(Level.SEVERE, null, ex);

            }}
 	
   
    public void RechercheparNom (String nom)
    {
     try {
    String requete;
         requete = "SELECT * from salles where nom='"+nom+"'";
    Statement st = C.createStatement();
     ResultSet rs = st.executeQuery(requete );
     rs.last();
     int nbrRow = rs.getRow();
     if (nbrRow !=0)
     {
         System.out.println("salle trouvee");
     }
     else{
     System.out.println("salles  non trouvee");    
    }
    
       
     }catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }    
     }
    
		

    
    
    public int nombreSalles (String nom){
            int nombre=0;
            
            String requete;
         requete = "SELECT count(*)from salles group by disponibilite=?";
            try {
            PreparedStatement ps = C.prepareStatement(requete);
           ps.setString(1,nom);
           ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()){
                
                
           nombre=resultat.getInt(1) ;}
            System.out.println("le nombre des salles disponibles sont " + nombre);
            
        } catch (SQLException ex) {
            
            System.out.println("erreur  " + ex.getMessage());
        }
         
            return nombre;
            
        }   
     public String afficher_contrat_id(int numero)
    {  
        String msg="";
        try {
            Statement st2 = C.createStatement();
            String requete ="select * from salles where numero='"+numero+"'" ;
            ResultSet rs = st2.executeQuery(requete);
            while(rs.next())
            {
                msg = "nom :  " +rs.getString(2)
                        +"\r\n" +"capacitee :  "+rs.getInt(3)
                        +"\r\n" +    "superficie :  "+rs.getInt(4)
                        +"\r\n" +"etage :  "+rs.getInt(5)
                        +"\r\n" +"   disponibilitee  :   "+rs.getString(6) 
                       +"\r\n" +"  path  :   "+rs.getString(6); 
            }    
        }  catch (SQLException ex) {   
             System.out.println("Pas de pdf" + ex.getMessage());
        } 
        return msg ;
    }
    public  void afficherOrder(){
    
        try {
            Statement st = C.createStatement();
            
            String str;
            str = "select * from salles order by etage ASC ";
            
            ResultSet rs = st.executeQuery(str);
            
             while(rs.next()){
             System.out.println(" num : "+rs.getInt(1)+" nom :  "+rs.getString(2)+" capacitee: "+rs.getInt(3)+" superficie :  "+rs.getInt(4)+" etage "+rs.getInt(5)+" disponibilite: "+rs.getString(6));
             }
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        
    }

    public InputStream UpdatePhoto(int id,FileInputStream fin,int len ){
        PreparedStatement preparedStatement;
        try {
        preparedStatement = C.prepareStatement("UPDATE salles  set photo = ? where  numero = 1 ");
            preparedStatement.setBlob(1, fin,len);
            int status = preparedStatement.executeUpdate();
            if(status>0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Information dialog");
                alert.setContentText("Photo saved successfully");
                alert.showAndWait();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog.");
                alert.setHeaderText("Error Information");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            System.out.println("Error in updating image Company ");
        }
        return null;
    }


   
       public InputStream getPhoto(int id ){
       PreparedStatement preparedStatement;
       try {
           preparedStatement = C.prepareStatement("select photo from salles  where  numero = ? ");
           preparedStatement.setInt(1, id);
           ResultSet rs=preparedStatement.executeQuery();
          while(rs.next()){
               InputStream img =rs.getBinaryStream("photo");

              return img;
          }
       } catch (SQLException ex) {
           System.out.println("Error in updating image Company ");
       }
              return null;
   }
       
       public boolean isANumber(String s)
    {
        for(int i=0;i<s.length();i++)
            if(!Character.isDigit(s.charAt(i)))
                       return false;
    return true;
    }
}

