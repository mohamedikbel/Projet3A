package entities;

import java.sql.Date;
import java.time.LocalDate;
import javafx.scene.image.ImageView;

/**
 *
 * @author mehdi
 */
public class livre {
    private int libelle ; 
    private String titre ; 
    private float prix ; //prix de vente
    private float prix_emprunt ; 
    private String resume ;
    private String photo ;
    private String date_sortie ;
    private String nom_auteur ;     
    private String nom_categorie ;
    private int qte_vente ;
    private int qte_emprunt ;
    private ImageView ImageLivre ;

    public livre() {
    }

    public ImageView getImageLivre() {
        return ImageLivre;
    }

    public void setImageLivre(ImageView ImageLivre) {
        this.ImageLivre = ImageLivre;
    } 

    public livre(int libelle, String titre, float prix, String resume, String photo, String nom_auteur, String nom_categorie, int qte_vente) {
        this.libelle = libelle;
        this.titre = titre;
        this.prix = prix;
        this.resume = resume;
        this.photo = photo;
        this.nom_auteur = nom_auteur;
        this.nom_categorie = nom_categorie;
        this.qte_vente = qte_vente;
    }
    

    public livre(int libelle,String titre, float prix, float prix_emprunt, String resume, String photo, String date_sortie, String nom_auteur, String nom_categorie, int qte_vente, int qte_emprunt) {
        this.libelle = libelle ; 
        this.titre = titre;
        this.prix = prix;
        this.prix_emprunt = prix_emprunt;
        this.resume = resume;
        this.photo = photo;
        this.date_sortie = date_sortie;
        this.nom_auteur = nom_auteur;
        this.nom_categorie = nom_categorie;
        this.qte_vente = qte_vente;
        this.qte_emprunt = qte_emprunt;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getPrix_emprunt() {
        return prix_emprunt;
    }

    public void setPrix_emprunt(float prix_emprunt) {
        this.prix_emprunt = prix_emprunt;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getNom_auteur() {
        return nom_auteur;
    }

    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public int getQte_vente() {
        return qte_vente;
    }

    public void setQte_vente(int qte_vente) {
        this.qte_vente = qte_vente;
    }

    public int getQte_emprunt() {
        return qte_emprunt;
    }

    public void setQte_emprunt(int qte_emprunt) {
        this.qte_emprunt = qte_emprunt;
    }
   
}
