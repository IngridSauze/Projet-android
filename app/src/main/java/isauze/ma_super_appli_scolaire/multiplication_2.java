package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import classes_base.Resultat;

import static classes_base.ResultatDAO.selectRes;

public class multiplication_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplication_2);

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button accueil = (Button) findViewById(R.id.m2_accueil) ;
        final Button exercices = (Button) findViewById(R.id.m2_liste_ex) ;
        final Button maths = (Button) findViewById(R.id.m2_liste_maths) ;
        final TextView texte = (TextView) findViewById(R.id.m2_texte) ;
        final TextView texte_res = (TextView) findViewById(R.id.m2_resultat) ;

        // Récupérer les valeurs passées par l'intent
        final int erreurs = getIntent().getIntExtra("ERREURS", -1) ;
        final int id = getIntent().getIntExtra("ID_COMPTE", 0) ;

        // Résultats
        if (erreurs == 0) {
            texte.setText("Bravo ! Vous n'avez fait aucune erreur.") ;
        }
        else if (erreurs == 1) {
            texte.setText("Vous avez fait " + erreurs + " erreur.") ;
        }
        else if(erreurs > 1) {
            texte.setText("Vous avez fait " + erreurs + " erreurs.") ;
        }
        else {
            texte.setText("impossible d'afficher le nombre d'erreurs.") ;
        }

        // Affichage du score
        List<Resultat> res1 = selectRes(id) ;
        if(res1.size()== 1) {
            Resultat res = res1.get(0) ; // Récupération du résultat de l'utilisateur
            if (res.getMultiplication_table() >= 10-erreurs) {
                texte_res.setText("Votre record à cet exercice est de " + res.getMultiplication_table() + ".");
            }
            else {
                res.setMultiplication_table(10-erreurs);
                res.save() ;
                texte_res.setText("Votre record à cet exercice est de " + res.getMultiplication_table() + ".");
            }
        }
        else if(res1.size()== 0) {
            Resultat res2 = new Resultat("multiplication_table", (long) id, 10-erreurs) ;
            res2.save();
            texte_res.setText("Votre record à cet exercice est de " + res2.getMultiplication_table() + ".");
        }
        else {
            texte_res.setText("Impossible d'afficher le score.");
        }

        accueil.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(multiplication_2.this, Accueil.class) ;
                                           intent.putExtra("ID_COMPTE", id) ;
                                           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
                                           startActivity(intent);
                                       }
                                   }
        );

        exercices.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             // Création de l'intention
                                             Intent intent = new Intent(multiplication_2.this, liste_exercices.class) ;
                                             intent.putExtra("ID_COMPTE", id) ;
                                             intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
                                             startActivity(intent);
                                         }
                                     }
        );

        maths.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         // Création de l'intention
                                         Intent intent = new Intent(multiplication_2.this, maths_accueil.class) ;
                                         intent.putExtra("ID_COMPTE", id) ;
                                         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
                                         startActivity(intent);
                                     }
                                 }
        );
    }
}
