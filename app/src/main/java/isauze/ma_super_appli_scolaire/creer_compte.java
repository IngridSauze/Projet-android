package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import classes_base.Compte;


public class creer_compte extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_compte);

        // Récupérer les objets de l'arbre graphique avec leur id
        Button valider = (Button) findViewById(R.id.c_bouton_valider) ;

        // La classe "écoute"
        valider.setOnClickListener(this);
    }

    // Quand l'on clique sur le bouton valider : enregistrement du profil et bascule sur la page de validation
    @Override
    public void onClick(View v) {
        // Récupérer les objets de l'arbre graphique avec leur id
        final TextView prenom = (TextView) findViewById(R.id.c_champ_prenom) ;
        final TextView nom = (TextView) findViewById(R.id.c_champ_nom) ;

        // Créer et sauvegarder le compte
        Compte compte = new Compte(nom.toString(), prenom.toString()) ;
        //Compte compte = new Compte("a", "a") ;
        compte.save() ;

        // Basculer sur l'activité validation compte
        Intent intent = new Intent(this, validation_compte.class) ;
        intent.putExtra("PRENOM_C", prenom.toString()) ; // Ajout du prénom à l'intention
        intent.putExtra("NOM_C", nom.toString()) ; // Ajout du nom à l'intention
        startActivity(intent);
    }
}
