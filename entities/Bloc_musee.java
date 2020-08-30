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
public class Bloc_musee {

    public Bloc_musee() {
    }
    
     public int       ID_M ;
     public String    Nom_Musee_bloc ;
      

    public Bloc_musee(int ID_M , String Nom_Musee_bloc )
    { 
        this.ID_M = ID_M ;
        this.Nom_Musee_bloc = Nom_Musee_bloc ;
        
    }

    public int getID_M() {
        return ID_M;
    }

    public void setID_M(int ID_M) {
        this.ID_M = ID_M;
    }

    public String getNom_Musee_bloc() {
        return Nom_Musee_bloc;
    }

    public void setNom_Musee_bloc(String Nom_Musee_bloc) {
        this.Nom_Musee_bloc = Nom_Musee_bloc;
    }
    
    
    
    
}
