package classes_base;

import java.util.List;

/**
 * Created by sauzei on 16/05/18.
 */

public class CompteDAO {

    // Liste de tous les comptes
    public static List<Compte> selectTous() {
        return Compte.listAll(Compte.class, "prenom") ;
    }

    public static List<Compte> selectCompte(String prenom, String nom) {
        return Compte.findWithQuery(Compte.class, "Select * from Compte where nom = ? and prenom = ?", nom, prenom) ;
    }
}
