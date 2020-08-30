/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Amal
 */
public class Reclamation {
private int id; 
private String nom; 
private String prenom; 
private String sujet; 
private String messagerie_electronique; 
private String message; 
private String etat;
private String datee;
private int id_client;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Reclamation(int id, String nom, String prenom, String sujet, String messagerie_electronique, String message, String etat, String datee, int id_client) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sujet = sujet;
        this.messagerie_electronique = messagerie_electronique;
        this.message = message;
        this.etat = etat;
        this.datee = datee;
        this.id_client = id_client;
    }


    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }


    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessagerie_electronique() {
        return messagerie_electronique;
    }

    public void setMessagerie_electronique(String messagerie_electronique) {
        this.messagerie_electronique = messagerie_electronique;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reclamation(String nom, String prenom,String messagerie_electronique,String sujet,String message ,int id_client) {
        this.nom = nom;
        this.prenom = prenom;
        this.messagerie_electronique = messagerie_electronique;
        this.sujet = sujet;
        this.message = message;
         this.id_client = id_client;
    }

    public Reclamation() {
    }



}
