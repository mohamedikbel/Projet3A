/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author TOSHIBA
 */
public class Formation {

    
    public Formation()
    {}
      public Formation(String titre, String desc, String formateur, String date, int nbplace, byte[] image) {
        this.titre = titre;
        this.desc = desc;
        this.formateur = formateur;
        this.date = date;
        this.nbplace = nbplace;
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public String getDesc() {
        return desc;
    }

    public String getFormateur() {
        return formateur;
    }

    public String getDate() {
        return date;
    }

    public int getNbplace() {
        return nbplace;
    }

    public byte[] getImage() {
        return image;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFormateur(String formateur) {
        this.formateur = formateur;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Formation(int id ,String titre, String desc, String formateur, String date, int nbplace) {
        this.id = id;
        this.titre = titre;
        this.desc = desc;
        this.formateur = formateur;
        this.date = date;
        this.nbplace = nbplace;
    }
  
    
    private String titre,desc,formateur,date;
    private int nbplace,id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private   byte[] image;
  
  

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
