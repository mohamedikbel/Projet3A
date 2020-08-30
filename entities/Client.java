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
public class Client {

    public static void setCurrentuser(String currentuser) {
        Client.currentuser = currentuser;
    }

private static String currentuser;   

    public static String getCurrentuser() {
        return currentuser;
    }
private int id;
private String uname;
private String lname;
private int image;
private String num;
private String email;
private String password;
private String code;
private String roles;
private String soldes;

    public String getSoldes() {
        return soldes;
    }

    public int getEtat() {
        return etat;
    }

    public String getRecup() {
        return recup;
    }
private int etat;
private String recup;



     public int getId() {
        return id;
    }

    public String getUname() {
        return uname;
    }

    public String getLname() {
        return lname;
    }

    public int getImage() {
        return image;
    }

    public String getNum() {
        return num;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCode() {
        return code;
    }

    public String getRoles() {
        return roles;
    }
    
    
    
    
}
