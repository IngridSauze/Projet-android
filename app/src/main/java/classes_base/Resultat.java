package classes_base;

import com.orm.SugarRecord;

/**
 * Created by Ingrid on 10/06/2018.
 */

public class Resultat extends SugarRecord {
    private long compte ;
    private int addition_table ;
    private int culture_g ;
    private int soustraction_table ;
    private int multiplication_table ;
    private int division_table ;

    // Constructeurs
    public Resultat() {
    }

    public Resultat(String message, long compte, int i) {
        if (message.equals("addition_table")) {
            this.compte = compte ;
            this.addition_table = i ;
            this.culture_g = 0 ;
            this.soustraction_table = 0 ;
            this.multiplication_table = 0 ;
            this.division_table = 0 ;
        }
        if (message.equals("culture_g")) {
            this.compte = compte ;
            this.addition_table = 0 ;
            this.culture_g = i ;
            this.soustraction_table = 0 ;
            this.multiplication_table = 0 ;
            this.division_table = 0 ;
        }
        if (message.equals("soustraction_table")) {
            this.compte = compte ;
            this.addition_table = 0 ;
            this.culture_g = 0 ;
            this.soustraction_table = i ;
            this.multiplication_table = 0 ;
            this.division_table = 0 ;
        }
        if (message.equals("multiplication_table")) {
            this.compte = compte ;
            this.addition_table = 0 ;
            this.culture_g = 0 ;
            this.soustraction_table = 0 ;
            this.multiplication_table = i ;
            this.division_table = 0 ;
        }
        if (message.equals("division_table")) {
            this.compte = compte ;
            this.addition_table = 0 ;
            this.culture_g = 0 ;
            this.soustraction_table = 0 ;
            this.multiplication_table = 0 ;
            this.division_table = i ;
        }
    }

    public int getAddition_table() {
        return addition_table ;
    }

    public int getSoustraction_table() {
        return soustraction_table ;
    }

    public int getMultiplication_table() {
        return multiplication_table ;
    }

    public int getDivision_table() {
        return division_table ;
    }

    public  int getCulture() {
        return culture_g ;
    }

    public void setAddition_table(int t) {
        this.addition_table = t ;
    }

    public void setSoustraction_table(int t) {
        this.soustraction_table = t ;
    }

    public void setMultiplication_table(int t) {
        this.multiplication_table = t ;
    }

    public void setDivision_table(int t) {
        this.division_table = t ;
    }

    public void setCulture_g(int t) {
        this.culture_g = t ;
    }
}
