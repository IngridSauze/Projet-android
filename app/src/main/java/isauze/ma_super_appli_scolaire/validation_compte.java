package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import classes_base.Compte;

public class validation_compte extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validation_compte);

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button accueil = (Button) findViewById(R.id.v_accueil) ;
        final Button exercices = (Button) findViewById(R.id.v_exercices) ;
        final TextView texte = (TextView) findViewById(R.id.v_texte) ;


        // La classe "écoute"
        accueil.setOnClickListener(this);
        exercices.setOnClickListener(this);

        // Récupérer les valeurs passées par l'intent
        int id = getIntent().getIntExtra("ID_COMPTE", 0) ;
        Compte compte = Compte.findById(Compte.class, ((long) id)) ;

        if(compte != null) {
            texte.setText("Bienvenue " + compte.getNom() + " !");
        }
        else if (compte == null) {
            texte.setText("Erreur ! Aucun compte détecté");
        }
    }

    @Override
    public void onClick(View v) {
        int id = getIntent().getIntExtra("ID_COMPTE", 0) ; // Récupérer les valeurs passées par l'intent
        switch (v.getId()) { // récupération de l'id du bouton qui a été cliqué
            case R.id.v_accueil :
                Intent intent = new Intent(this, Accueil.class) ;
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
                intent.putExtra("ID_COMPTE", id) ;
                startActivity(intent);
                break;

            case R.id.v_exercices :
                Intent intent1 = new Intent(this, liste_exercices.class) ;
                intent1.putExtra("ID_COMPTE", id) ;
                startActivity(intent1);
                break;
        }
    }

}
