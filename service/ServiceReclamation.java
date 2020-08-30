/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entities.Reclamation; 
import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnexion;

/**
 *
 * @author Amal
 */
public class ServiceReclamation {
            Connection  c = MaConnexion.getinstence().getcon();

    public ServiceReclamation() {
    }


    
public void ajouter_reclam(Reclamation p ) 
{
    String req="insert into reclamation (nom,prenom,messagerie_electronique,sujet,datee,message,id_client) values (?,?,?,?,CURDATE(),?,?)";
        try {
     PreparedStatement ps=c.prepareStatement(req);
     ps.setString(1,p.getNom());
     ps.setString(2,p.getPrenom());
     ps.setString(3,p.getMessagerie_electronique());
     ps.setString(4,p.getSujet());
     ps.setString(5,p.getMessage());
     ps.setInt(6,p.getId_client());
      
     ps.executeUpdate();
        } catch (SQLException ex) { 
              Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }}
      
 public ResultSet afficher_reclam(){
         try {
             Statement st = c.createStatement();
             
             
             ResultSet re = st.executeQuery("select * from reclamation");
             return re;
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
         return null;
    
    } 
        public ObservableList<Reclamation> lister() {

        ObservableList <Reclamation> list = FXCollections.observableArrayList();
        ResultSet rs; // pour récupérer le résultat de select
        String req = "SELECT * FROM reclamation";
        try {
       PreparedStatement   ps = c.prepareStatement(req);
            rs = ps.executeQuery(req);
            
            while (rs.next()) {
               Reclamation r = 
                        new Reclamation();
                  r.setId(rs.getInt("id"));
                  r.setNom(rs.getString("nom"));
                  r.setPrenom(rs.getString("prenom"));
                  r.setMessagerie_electronique(rs.getString("messagerie_electronique"));
                  r.setDatee(rs.getString("datee"));
                  r.setSujet(rs.getString("sujet"));
                  r.setMessage(rs.getString("message"));
                  r.setEtat(rs.getString("etat"));
                //ps.setString(4,p.getPhoto());

                //ps.executeUpdate();

                list.add(r);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } 
    

} 
        
     public ObservableList<Reclamation> listerclient(int client) {

        ObservableList <Reclamation> list = FXCollections.observableArrayList();
        ResultSet rs; // pour récupérer le résultat de select
        String req = "SELECT * FROM reclamation WHERE id_client=?";
        try {
       PreparedStatement   ps = c.prepareStatement(req);
        ps.setInt(1,client);
            rs= ps.executeQuery();
            while (rs.next()) {
               Reclamation r = 
                        new Reclamation();
                  r.setSujet(rs.getString("sujet"));
                  r.setMessage(rs.getString("message"));
                  r.setEtat(rs.getString("etat"));
                 
                 
            
                  
                //ps.setString(4,p.getPhoto());

                //ps.executeUpdate();

                list.add(r);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(servicePromotion.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        } 
    

}


public void updateetat(int id) {
    try {   
    String query ="UPDATE reclamation SET etat='Traitee' WHERE id=?";    
    PreparedStatement pt =c.prepareStatement(query);
    pt.setInt(1,id);
    pt.executeUpdate();
    
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }}
    
     public void FindId (String cher) {
     try {
        Statement st = c.createStatement();
        String query="SELECT * FROM reclamation WHERE CONCAT(`nom`, `prenom`, `messagerie_electronique`,`sujet`) LIKE '%"+cher+"%'";
        ResultSet  rs =st.executeQuery(query);
        while(rs.next())
        {   
         System.out.println("id reclamation: "+rs.getInt(1)+": nom: "+rs.getString(2)+":Prenom: "+rs.getString(3)+":messagerie_electronique: "+rs.getString(4)+":date: "+rs.getDate(5)+":sujet: "+rs.getString(6)+":message: "+rs.getString(7)+":etat: "+rs.getString(8));  
        }  
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }}
     
     public int nombrereclamevent() 
     {
         int a=0;
    try {
        Statement st = c.createStatement();
        String query="SELECT count(sujet) as nombre from reclamation where sujet='Événement'";
        ResultSet  rs =st.executeQuery(query); 
          while(rs.next())
        {   
            
            a=rs.getInt(1);
       
        } 
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return a;
     }
     
         public int nombrereclamachat() 
     {
         int a=0;
    try {
        Statement st = c.createStatement();
        String query="SELECT count(sujet) as nombre from reclamation where sujet='Achat'";
        ResultSet  rs =st.executeQuery(query); 
          while(rs.next())
        {   
            
            a=rs.getInt(1);
       
        } 
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return a;
     }
    
public void supprimer_reclam (int id) 
{
    try {
        PreparedStatement   pt = c.prepareStatement("delete from reclamation where id=?");
        pt.setInt(1, id);
        pt.execute();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
public String  recupererMail(int id){
                
        String query="SELECT messagerie_electronique from reclamation where id = ?";
        String p="";
        try {
            PreparedStatement pt =c.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet resultSet = pt.executeQuery();
            if (resultSet.next()) {
             p =resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
} 

     public int nombrereclamtraitee() 
     {
         int a=0;
    try {
        Statement st = c.createStatement();
        String query="SELECT count(etat) as nombre from reclamation where etat='Traitée'";
        ResultSet  rs =st.executeQuery(query); 
          while(rs.next())
        {   
            
            a=rs.getInt(1);
       
        } 
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return a;
     } 
     
        public int non_traitee() 
     {
         int a=0;
    try {
        Statement st = c.createStatement();
        String query="SELECT count(etat) as nombre from reclamation where etat='non traitée'";
        ResultSet  rs =st.executeQuery(query); 
          while(rs.next())
        {   
            
            a=rs.getInt(1);
       
        } 
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return a;
     }
     





}
