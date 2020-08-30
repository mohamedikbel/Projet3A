/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.livre;
import entities.promotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnexion;

/**
 *
 * @author Amal
 */
public class ServiceLivre { 
   
            Connection  C  = MaConnexion.getinstence().getcon();
    public ServiceLivre() {
    }
  public ObservableList<livre> DisplayBooksList() {
        List<livre> arraylist = new ArrayList<livre>();   
        ObservableList<livre> list = FXCollections.observableList(arraylist);
    
        try {  
            Statement stmt=C.createStatement(); 
            String query= "select * from livre";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                int libelle = rs.getInt("libelle") ;
                String titre = rs.getString("titre");
                float prix  = rs.getFloat("prix");
               // float prix_emprunt  = rs.getFloat("prix_emprunt");
                String resume = rs.getString("resume");
                String photo = rs.getString("photo"); 
               // CustomImage  first_img = new CustomImage(new ImageView(new Image("1000.jpg")));
              //  String date_sortie=rs.getString("date_sortie") ;
                String nom_auteur = rs.getString("nom_auteur");
                String nom_categorie = rs.getString("nom_categorie");
                int qte_vente = rs.getInt("qte_vente") ;
            //    int qte_emprunt = rs.getInt("qte_emprunt") ;
               // livre l = new livre(libelle, titre, prix, prix_emprunt, resume, photo, date_sortie, nom_auteur, nom_categorie, qte_vente, qte_emprunt);
                livre l = new livre(libelle, titre, prix, resume, photo, nom_auteur, nom_categorie, qte_vente);                
                list.add(l);
                //System.out.println("\nsucces ajout a la liste  d'un livre papi");
            }
            return list ;
        } catch (SQLException ex) {
            System.out.println("Erreur : "+ ex.getMessage());
        }
         return null;
    }

    
}
