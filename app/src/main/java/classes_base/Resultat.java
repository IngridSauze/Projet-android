package classes_base;

import com.orm.SugarRecord;

/**
 * Created by Ingrid on 10/06/2018.
 */

public class Resultat extends SugarRecord {
    private long compte ;
    private int addition_table ;

    // Constructeurs
    public Resultat() {
    }

    public Resultat(String message, long compte, int addition_table) {
        if(message.equals("addition_table")) {
            this.compte = compte ;
            this.addition_table = addition_table ;
        }
    }

    public int getAddition_table() {
        return addition_table ;
    }

    public void setAddition_table(int t) {
        this.addition_table = t ;
    }
}
