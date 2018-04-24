package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Surcharge du XML pour créer la hiérarchie des composants graphiques
        setContentView(R.layout.accueil);

        // Récupérer les objets de l'arbre graphique avec leur id
        Button creer = (Button) findViewById(R.id.a_bouton_nouv_compte) ;

        // Basculer sur la page de création du compte en cas de clic sur le bouton
        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Création de l'intention
               Intent intent = new Intent(Accueil.this, creer_compte.class) ;
                startActivity(intent);
            }
            }

        ) ;
    }
}
