/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author PC
 */
public class Salles {
   public int numero;
   public String nom; 
   public int capacitee;
   public int superficie;
   public int etage;
  public String disponibilite;
  public String path;

  public byte [] photo;

    public Salles(int numero, String nom, int capacitee, int superficie, int etage, String disponibilite, String path, byte[] photo) {
        this.numero = numero;
        this.nom = nom;
        this.capacitee = capacitee;
        this.superficie = superficie;
        this.etage = etage;
        this.disponibilite = disponibilite;
        this.path = path;
        this.photo = photo;
    }
  

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacitee() {
        return capacitee;
    }

    public void setCapacitee(int capacitee) {
        this.capacitee = capacitee;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
  
}
