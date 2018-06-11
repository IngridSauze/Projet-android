package classes_base;

import com.orm.SugarRecord;

/**
 * Created by Ingrid on 10/06/2018.
 */

public class Resultat extends SugarRecord {
    private long compte ;
    private int addition_table ;
    private int culture_g ;

    // Constructeurs
    public Resultat() {
    }

    public Resultat(String message, long compte, int i) {
        if (message.equals("addition_table")) {
            this.compte = compte ;
            this.addition_table = i ;
            this.culture_g = 0 ;
        }
        if (message.equals("culture_g")) {
            this.compte = compte ;
            this.addition_table = 0 ;
            this.culture_g = i ;
        }
    }

    public int getAddition_table() {
        return addition_table ;
    }

    public  int getCulture() {
        return culture_g ;
    }

    public void setAddition_table(int t) {
        this.addition_table = t ;
    }

    public void setCulture_g(int t) {
        this.culture_g = t ;
    }
}
