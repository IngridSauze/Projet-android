package classes;

import java.util.List;

/**
 * Created by sauzei on 16/05/18.
 */

public class CompteDAO {

    // Liste de tous les comptes
    public static List<Compte> selectTous() {
        return Compte.listAll(Compte.class, "prenom") ;
    }

    // Sélectionner un compte à partir du prénom
    public static Compte selectParPrenom(String prenom) {

    }
}
