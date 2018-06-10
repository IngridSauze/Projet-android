package classes_base;

import java.util.List;

/**
 * Created by Ingrid on 10/06/2018.
 */

public class ResultatDAO {
    public static List<Resultat> selectRes(int id_utilisateur) {
        return Resultat.findWithQuery(Resultat.class, "Select * from Resultat where compte = ?", Integer.toString(id_utilisateur));
    }
}
