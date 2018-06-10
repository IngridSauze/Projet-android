package classes_base;

import com.orm.SugarContext;
import com.orm.SugarRecord;

/**
 * Created by sauzei on 16/05/18.
 */

public class Compte extends SugarRecord {
    private String nom ;
    private String prenom ;
    private String avatar ;

    // Constructeurs
    public Compte() {
    }

   public Compte(String nom, String prenom, String avatar) {
        setNom(nom) ;
        setPrenom(prenom) ;
        setAvatar(avatar);
    }

    // Get
    public String getNom() {
        return nom ;
    }
    public String getPrenom() {
        return prenom ;
    }
    public String getAvatar() {
        return avatar ;
    }

    // Set
    public void setNom(String nom) {
        this.nom = nom ;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom ; }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
