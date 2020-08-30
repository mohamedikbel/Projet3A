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
public class Collections {
    
     public int     ID_Collection ;
     public String  Nom ;
     public String  Image_C ;
     public String  Discription ;
     public Date    Date_debut_M ;
     public Date    Date_fin_M ;
     public String  Type ;
     public int     ID_Societe;
     public int     ID_M;
     
     
     
       
    public Collections(int ID_Collection, String Nom, String Image_C, String Discription, Date Date_debut_M, Date Date_fin_M, String Type, int ID_Societe, int ID_M) {
        this.ID_Collection = ID_Collection;
        this.Nom = Nom;
        this.Image_C = Image_C;
        this.Discription = Discription;
        this.Date_debut_M = Date_debut_M;
        this.Date_fin_M = Date_fin_M;
        this.Type = Type;
        this.ID_Societe = ID_Societe;
        this.ID_M = ID_M;
    }
    
  

    public int getID_Collection() {
        return ID_Collection;
    }

    public void setID_Collection(int ID_Collection) {
        this.ID_Collection = ID_Collection;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getImage_C() {
        return Image_C;
    }

    public void setImage_C(String Image_C) {
        this.Image_C = Image_C;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }

    public Date getDate_debut_M() {
        return Date_debut_M;
    }

    public void setDate_debut_M(Date Date_debut_M) {
        this.Date_debut_M = Date_debut_M;
    }

    public Date getDate_fin_M() {
        return Date_fin_M;
    }

    public void setDate_fin_M(Date Date_fin_M) {
        this.Date_fin_M = Date_fin_M;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getID_Societe() {
        return ID_Societe;
    }

    public void setID_Societe(int ID_Societe) {
        this.ID_Societe = ID_Societe;
    }

    public int getID_M() {
        return ID_M;
    }

    public void setID_M(int ID_M) {
        this.ID_M = ID_M;
    }

    @Override
    public String toString() {
        return "Collections{" + "ID_Collection=" + ID_Collection + ", Nom=" + Nom + ", Image_C=" + Image_C + ", Discription=" + Discription + ", Date_debut_M=" + Date_debut_M + ", Date_fin_M=" + Date_fin_M + ", Type=" + Type + ", ID_Societe=" + ID_Societe + ", ID_M=" + ID_M + '}';
    }

    
            
            
    
}
