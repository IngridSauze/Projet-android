package classes_base;

import com.orm.SugarRecord;

/**
 * Created by sauzei on 16/05/18.
 */

public class Compte extends SugarRecord {
    private String nom ;
    private String prenom ;

    // Constructeurs
    public Compte() {
    }

   public Compte(String nom, String prenom) {
        setNom(nom) ;
        setPrenom(prenom) ;
    }

    // Get
    public String getNom() {
        return nom ;
    }
    public String getPrenom() {
        return prenom ;
    }

    // Set
    public void setNom(String nom) {
        this.nom = nom ;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom ; }
}
