/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Amal
 */
public class promotion {
    private int id;
    private int libelle; 
    private String titre; 
    private float ancien_prix; 
    private float nouveau_prix; 
    private int reduction; 
    private String date_debut; 
    private String date_fin;  
    private String photo; 

    public promotion(int libelle, String titre, float ancien_prix, float nouveau_prix, int reduction, String date_debut, String date_fin, String photo) {
        this.libelle = libelle;
        this.titre = titre;
        this.ancien_prix = ancien_prix;
        this.nouveau_prix = nouveau_prix;
        this.reduction = reduction;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    

    public promotion() {
    }

    public promotion(int id, int libelle, String titre, float ancien_prix,  int reduction, String date_debut, String date_fin) {
        this.id = id;
        this.libelle = libelle;
        this.titre = titre;
        this.ancien_prix = ancien_prix;
        this.reduction = reduction;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    
    
    

    public promotion(int libelle,String titre, float ancien_prix, int reduction, String date_debut, String date_fin,String photo) {
        this.libelle = libelle;
        this.titre = titre;
        this.ancien_prix = ancien_prix;
        this.reduction = reduction;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
         this.photo = photo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibelle() {
        return libelle;
    }

    public void setLibelle(int libelle) {
        this.libelle = libelle;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public float getAncien_prix() {
        return ancien_prix;
    }

    public void setAncien_prix(float ancien_prix) {
        this.ancien_prix = ancien_prix;
    }

    public float getNouveau_prix() {
        return nouveau_prix;
    }

    public void setNouveau_prix(float nouveau_prix) {
        this.nouveau_prix = nouveau_prix;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }
    
    

}