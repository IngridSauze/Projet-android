package isauze.ma_super_appli_scolaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class creer_compte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_compte);

        // Récupérer les objets de l'arbre graphique avec leur id
        Button valider = (Button) findViewById(R.id.c_bouton_valider) ;
        final TextView prenom = (TextView) findViewById(R.id.c_champ_prenom) ;
        final TextView nom = (TextView) findViewById(R.id.c_champ_nom) ;

        // Quand l'on clique sur le bouton valider : enregistrement du profil et bascule sur la page de validation


    }
}
