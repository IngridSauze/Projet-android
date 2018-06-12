package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class maths_accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths_accueil);

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button addition = (Button) findViewById(R.id.am_b_addition);
        final Button soustraction = (Button) findViewById(R.id.am_b_soustraction);
        final Button multiplication = (Button) findViewById(R.id.am_b_multiplication);
        final Button division = (Button) findViewById(R.id.am_b_division);

        // Récupérer les valeurs passées par l'intent
        final int id = getIntent().getIntExtra("ID_COMPTE", 0) ;

        // Basculer sur la page de l'exercice en cas de clic sur le bouton
        addition.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            // Création de l'intention
                                            Intent intent = new Intent(maths_accueil.this, addition.class);
                                            intent.putExtra("ID_COMPTE", id) ;
                                            startActivity(intent);
                                        }
                                    }
        );

        multiplication.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            // Création de l'intention
                                            Intent intent = new Intent(maths_accueil.this, addition.class);
                                            intent.putExtra("ID_COMPTE", id) ;
                                            startActivity(intent);
                                        }
                                    }
        );

    }
}
