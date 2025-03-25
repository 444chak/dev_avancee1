package chkb.dev_avancee1;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String nom;
    private String attribut1;
    private String attribut2;

    public UserBean() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAttribut1() {
        return attribut1;
    }

    public void setAttribut1(String attribut1) {
        this.attribut1 = attribut1;
    }

    public String getAttribut2() {
        return attribut2;
    }

    public void setAttribut2(String attribut2) {
        this.attribut2 = attribut2;
    }
}