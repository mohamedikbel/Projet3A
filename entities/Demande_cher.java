/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Demande_cher {
    
    
           public int      ID_Demande ;
           public String   Discription ;
           public String   Nom_ch ;
           public String   Prenom_ch ;
           public int      Tel_ch ;
           public String   Email_ch ;
           public int      Cin_ch   ;                
           public String   Etat ;
           public Date     Date_demande  ;
           public String   Niveau_E ;
           public int      ID_Collection  ;

    public Demande_cher(int ID_Demande, String Discription, String Nom_ch, String Prenom_ch, int Tel_ch, String Email_ch, int Cin_ch, String Etat, Date Date_demande, String Niveau_E, int ID_Collection) 
    {
        this.ID_Demande = ID_Demande;
        this.Discription = Discription;
        this.Nom_ch = Nom_ch;
        this.Prenom_ch = Prenom_ch;
        this.Tel_ch = Tel_ch;
        this.Email_ch = Email_ch;
        this.Cin_ch = Cin_ch;
        this.Etat = Etat;
        this.Date_demande = Date_demande;
        this.Niveau_E = Niveau_E;
        this.ID_Collection = ID_Collection;
    }

    public int getID_Demande() {
        return ID_Demande;
    }

    public void setID_Demande(int ID_Demande) {
        this.ID_Demande = ID_Demande;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }

    public String getNom_ch() {
        return Nom_ch;
    }

    public void setNom_ch(String Nom_ch) {
        this.Nom_ch = Nom_ch;
    }

    public String getPrenom_ch() {
        return Prenom_ch;
    }

    public void setPrenom_ch(String Prenom_ch) {
        this.Prenom_ch = Prenom_ch;
    }

    public int getTel_ch() {
        return Tel_ch;
    }

    public void setTel_ch(int Tel_ch) {
        this.Tel_ch = Tel_ch;
    }

    public String getEmail_ch() {
        return Email_ch;
    }

    public void setEmail_ch(String Email_ch) {
        this.Email_ch = Email_ch;
    }

    public int getCin_ch() {
        return Cin_ch;
    }

    public void setCin_ch(int Cin_ch) {
        this.Cin_ch = Cin_ch;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public Date getDate_demande() {
        return Date_demande;
    }

    public void setDate_demande(Date Date_demande) {
        this.Date_demande = Date_demande;
    }

    public String getNiveau_E() {
        return Niveau_E;
    }

    public void setNiveau_E(String Niveau_E) {
        this.Niveau_E = Niveau_E;
    }

    public int getID_Collection() {
        return ID_Collection;
    }

    public void setID_Collection(int ID_Collection) {
        this.ID_Collection = ID_Collection;
    }

   
           
           

            
                            
                            
}
