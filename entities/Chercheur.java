/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author User
 */
public class Chercheur {
    
     public int      ID_Chercheur ;
     public String   Nom_ch  ;
     public String   Prenom_ch ;
     public int      Tel_ch       ;
     public String   Email_ch    ;   
     public int      Cin_ch ;
     public String   Niveau_E ;
     public int      ID_Demande ;

    public Chercheur(int ID_Chercheur, String Nom_ch, String Prenom_ch, int Tel_ch, String Email_ch, int Cin_ch, String Niveau_E, int ID_Demande) {
        this.ID_Chercheur = ID_Chercheur;
        this.Nom_ch = Nom_ch;
        this.Prenom_ch = Prenom_ch;
        this.Tel_ch = Tel_ch;
        this.Email_ch = Email_ch;
        this.Cin_ch = Cin_ch;
        this.Niveau_E = Niveau_E;
        this.ID_Demande = ID_Demande;
    }

    public int getID_Chercheur() {
        return ID_Chercheur;
    }

    public void setID_Chercheur(int ID_Chercheur) {
        this.ID_Chercheur = ID_Chercheur;
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

    public String getNiveau_E() {
        return Niveau_E;
    }

    public void setNiveau_E(String Niveau_E) {
        this.Niveau_E = Niveau_E;
    }

    public int getID_Demande() {
        return ID_Demande;
    }

    public void setID_Demande(int ID_Demande) {
        this.ID_Demande = ID_Demande;
    }

 
   
     
            
}
