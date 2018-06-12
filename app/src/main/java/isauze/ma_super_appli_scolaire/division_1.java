package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class division_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.division_1);

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button valider = (Button) findViewById(R.id.d1_valider) ;
        final TextView texte0 = (TextView) findViewById(R.id.d1_texte) ;

        final EditText edit1  = (EditText) findViewById(R.id.d1_set1) ;
        final EditText edit2  = (EditText) findViewById(R.id.d1_set2) ;
        final EditText edit3  = (EditText) findViewById(R.id.d1_set3) ;
        final EditText edit4  = (EditText) findViewById(R.id.d1_set4) ;
        final EditText edit5  = (EditText) findViewById(R.id.d1_set5) ;
        final EditText edit6  = (EditText) findViewById(R.id.d1_set6) ;
        final EditText edit7  = (EditText) findViewById(R.id.d1_set7) ;
        final EditText edit8  = (EditText) findViewById(R.id.d1_set8) ;
        final EditText edit9  = (EditText) findViewById(R.id.d1_set9) ;
        final EditText edit10  = (EditText) findViewById(R.id.d1_set10) ;

        final TextView texte1 = (TextView) findViewById(R.id.d1_1) ;
        final TextView texte2 = (TextView) findViewById(R.id.d1_2) ;
        final TextView texte3 = (TextView) findViewById(R.id.d1_3) ;
        final TextView texte4 = (TextView) findViewById(R.id.d1_4) ;
        final TextView texte5 = (TextView) findViewById(R.id.d1_5) ;
        final TextView texte6 = (TextView) findViewById(R.id.d1_6) ;
        final TextView texte7 = (TextView) findViewById(R.id.d1_7) ;
        final TextView texte8 = (TextView) findViewById(R.id.d1_8) ;
        final TextView texte9 = (TextView) findViewById(R.id.d1_9) ;
        final TextView texte10 = (TextView) findViewById(R.id.d1_10) ;

        // Récupérer les valeurs passées par l'intent
        final int table = getIntent().getIntExtra("TABLE", 0) ;
        final int id = getIntent().getIntExtra("ID_COMPTE", 0) ;

        texte1.setText(1 * table + " / " + table + " = ");
        texte2.setText(2 * table + " / " + table + " = ");
        texte3.setText(3 * table + " / " + table + " = ");
        texte4.setText(4 * table + " / " + table + " = ");
        texte5.setText(5 * table + " / " + table + " = ");
        texte6.setText(6 * table + " / " + table + " = ");
        texte7.setText(7 * table + " / " + table + " = ");
        texte8.setText(8 * table + " / " + table + " = ");
        texte9.setText(9 * table + " / "+ table + " = ");
        texte10.setText(10 * table + " / " + table + " = ");

        // Validation
        valider.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (
                                                   edit1.getText().toString().equals("") ||
                                                           edit2.getText().toString().equals("") ||
                                                           edit3.getText().toString().equals("") ||
                                                           edit4.getText().toString().equals("") ||
                                                           edit5.getText().toString().equals("") ||
                                                           edit6.getText().toString().equals("") ||
                                                           edit7.getText().toString().equals("") ||
                                                           edit8.getText().toString().equals("") ||
                                                           edit9.getText().toString().equals("") ||
                                                           edit10.getText().toString().equals("")
                                                   ) {
                                               texte0.setText("Il faut répondre à toutes les questions !");
                                           }
                                            else {
                                               int erreurs = 0;
                                               // Vérification des résultats
                                               if (!test_division(table, 1 * table, Integer.parseInt(edit1.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 2 * table, Integer.parseInt(edit2.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 3 * table, Integer.parseInt(edit3.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 4 * table, Integer.parseInt(edit4.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 5 * table, Integer.parseInt(edit5.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 6 * table, Integer.parseInt(edit6.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 7 * table, Integer.parseInt(edit7.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 8 * table, Integer.parseInt(edit8.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 9 * table, Integer.parseInt(edit9.getText().toString()))) {
                                                   erreurs++;
                                               }
                                               if (!test_division(table, 10 * table, Integer.parseInt(edit10.getText().toString()))) {
                                                   erreurs++;
                                               }

                                               // Création de l'intention
                                               Intent intent = new Intent(division_1.this, division_2.class);
                                               intent.putExtra("ERREURS", erreurs);
                                               intent.putExtra("ID_COMPTE", id);
                                               startActivity(intent);
                                           }
                                       }
                                   }
        );
    }

    public boolean test_division(int table, int base, int resultat) {
        return (base / table) == resultat ;
    }
}
