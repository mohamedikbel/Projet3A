/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import javafx.scene.control.Button;

/**
 *
 * @author TOSHIBA
 */
public class clientaf {

    public Button getQr() {
        return qr;
    }
    
    Button qr;

    public void setQr(Button qr) {
        this.qr = qr;
    }
    
    
    public clientaf() {
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }
    
    
    
     public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public clientaf(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.button = new  Button("Supprimer");
        this.qr = new  Button("Attribuer");

    }

      Button button;

      String nom;
    String prenom;
   String email;

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

 
    @Override
    public String toString() {
        return "clientaf{" + "nom=" + nom + ", prenom=" + prenom + ", email=" + email +  '}';
    }
    
}
