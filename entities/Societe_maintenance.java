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
public class Societe_maintenance {

    
    
              public int      ID_Societe ;
              public String   Nom ;
              public String   Adresse;
              public int      Tel;
              public String   Email;
              
              public Societe_maintenance(int ID_Societe, String Nom, String Adresse, int Tel, String Email) {
                     this.ID_Societe = ID_Societe;
                     this.Nom = Nom;
                     this.Adresse = Adresse;
                     this.Tel = Tel;
                     this.Email = Email;
                    }

    public int getID_Societe() {
        return ID_Societe;
    }

    public void setID_Societe(int ID_Societe) {
        this.ID_Societe = ID_Societe;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
              
             
      
    
}
