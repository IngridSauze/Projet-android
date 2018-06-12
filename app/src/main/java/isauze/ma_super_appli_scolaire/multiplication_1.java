package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class multiplication_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplication_1);

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button valider = (Button) findViewById(R.id.m1_valider) ;

        final EditText edit1  = (EditText) findViewById(R.id.m1_set1) ;
        final EditText edit2  = (EditText) findViewById(R.id.m1_set2) ;
        final EditText edit3  = (EditText) findViewById(R.id.m1_set3) ;
        final EditText edit4  = (EditText) findViewById(R.id.m1_set4) ;
        final EditText edit5  = (EditText) findViewById(R.id.m1_set5) ;
        final EditText edit6  = (EditText) findViewById(R.id.m1_set6) ;
        final EditText edit7  = (EditText) findViewById(R.id.m1_set7) ;
        final EditText edit8  = (EditText) findViewById(R.id.m1_set8) ;
        final EditText edit9  = (EditText) findViewById(R.id.m1_set9) ;
        final EditText edit10  = (EditText) findViewById(R.id.m1_set10) ;

        final TextView texte1 = (TextView) findViewById(R.id.m1_1) ;
        final TextView texte2 = (TextView) findViewById(R.id.m1_2) ;
        final TextView texte3 = (TextView) findViewById(R.id.m1_3) ;
        final TextView texte4 = (TextView) findViewById(R.id.m1_4) ;
        final TextView texte5 = (TextView) findViewById(R.id.m1_5) ;
        final TextView texte6 = (TextView) findViewById(R.id.m1_6) ;
        final TextView texte7 = (TextView) findViewById(R.id.m1_7) ;
        final TextView texte8 = (TextView) findViewById(R.id.m1_8) ;
        final TextView texte9 = (TextView) findViewById(R.id.m1_9) ;
        final TextView texte10 = (TextView) findViewById(R.id.m1_10) ;

        // Récupérer les valeurs passées par l'intent
        final int table = getIntent().getIntExtra("TABLE", 0) ;
        final int id = getIntent().getIntExtra("ID_COMPTE", 0) ;

        texte1.setText("1 X " + table + " = ");
        texte2.setText("2 X " + table + " = ");
        texte3.setText("3 X " + table + " = ");
        texte4.setText("4 X " + table + " = ");
        texte5.setText("5 X " + table + " = ");
        texte6.setText("6 X " + table + " = ");
        texte7.setText("7 X " + table + " = ");
        texte8.setText("8 X " + table + " = ");
        texte9.setText("9 X " + table + " = ");
        texte10.setText("10 X " + table + " = ");

        // Validation
        valider.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           int erreurs = 0 ;
                                           // Vérification des résultats
                                           if(!test_multiplication(table, 1, Integer.parseInt(edit1.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 2, Integer.parseInt(edit2.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 3, Integer.parseInt(edit3.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 4, Integer.parseInt(edit4.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 5, Integer.parseInt(edit5.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 6, Integer.parseInt(edit6.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 7, Integer.parseInt(edit7.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 8, Integer.parseInt(edit8.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 9, Integer.parseInt(edit9.getText().toString()))) {
                                               erreurs++ ;
                                           }
                                           if(!test_multiplication(table, 10, Integer.parseInt(edit10.getText().toString()))) {
                                               erreurs++ ;
                                           }

                                           // Création de l'intention
                                           Intent intent = new Intent(multiplication_1.this, multiplication_2.class);
                                           intent.putExtra("ERREURS", erreurs) ;
                                           intent.putExtra("ID_COMPTE", id) ;
                                           startActivity(intent);
                                       }
                                   }
        );
    }

    public boolean test_multiplication(int table, int base, int resultat) {
        return (table * base) == resultat ;
    }
}
