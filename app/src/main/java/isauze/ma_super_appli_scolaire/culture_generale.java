package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import classes_base.Resultat;

import static classes_base.ResultatDAO.selectRes;

public class culture_generale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.culture_generale);

        // Récupérer les valeurs passées par l'intent
        final int id = getIntent().getIntExtra("ID_COMPTE", 0);

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button valider = (Button) findViewById(R.id.g_valider);
        final Button exercices = (Button) findViewById(R.id.g_exercice);
        final Button accueil = (Button) findViewById(R.id.g_b_accueil);
        final TextView texte = (TextView) findViewById(R.id.g_texte_accueil_ac);
        final TextView alerte = (TextView) findViewById(R.id.g_alerte);
        final RadioGroup groupe = (RadioGroup) findViewById(R.id.g_groupe);
        final RadioButton radio1 = (RadioButton) findViewById(R.id.g_radio1);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.g_radio2);
        final RadioButton radio3 = (RadioButton) findViewById(R.id.g_radio3);

        exercices.setVisibility(View.INVISIBLE);
        accueil.setVisibility(View.INVISIBLE);

        // Mise en place des questionss
        Questions[] questions = Questions.values() ;
        final List<Questions> l_questions = Arrays.asList(questions);
        Collections.shuffle(l_questions);

        texte.setText(l_questions.get(0).getNom());
        radio1.setText(l_questions.get(0).getTab()[0]);
        radio2.setText(l_questions.get(0).getTab()[1]);
        radio3.setText(l_questions.get(0).getTab()[2]);
        final String reponse = l_questions.get(0).getReponse() ;

        valider.setOnClickListener(new View.OnClickListener() {
            int erreurs = 0;
            int nb_question = 0;

            @Override
            public void onClick(View v) {
                if (!(radio1.isChecked())&& !(radio2.isChecked()) && !(radio3.isChecked())) {
                    alerte.setText("Il faut choisir une réponse ! ");
                }
                else {
                    if (nb_question < 10) {
                        if (radio1.isChecked() && !(radio1.getText().equals(reponse))) {
                            erreurs++ ;
                        }
                        else if (radio2.isChecked() && !(radio2.getText().equals(reponse))) {
                            erreurs++ ;
                        }
                        if (radio3.isChecked() && !(radio3.getText().equals(reponse))) {
                            erreurs++ ;
                        }

                        texte.setText(l_questions.get(nb_question+1).getNom());
                        radio1.setText(l_questions.get(nb_question+1).getTab()[0]);
                        radio2.setText(l_questions.get(nb_question+1).getTab()[1]);
                        radio3.setText(l_questions.get(nb_question+1).getTab()[2]);
                        final String reponse = l_questions.get(nb_question+1).getReponse() ;
                        nb_question++;
                    }
                    else {
                        groupe.setVisibility(View.INVISIBLE);
                        exercices.setVisibility(View.VISIBLE);
                        accueil.setVisibility(View.VISIBLE);
                        valider.setVisibility(View.INVISIBLE);

                        List<Resultat> res1 = selectRes(id) ;
                        if(res1.size()== 1) {
                            Resultat res = res1.get(0) ; // Récupération du résultat de l'utilisateur
                            if (res.getCulture() >= 10-erreurs) {
                                texte.setText("Votre record à cet exercice est de " + res.getCulture() + ".");
                            }
                            else {
                                res.setCulture_g(10-erreurs);
                                res.save() ;
                                texte.setText("Votre record à cet exercice est de " + res.getCulture() + ".");
                            }
                        }
                        else if(res1.size()== 0) {
                            Resultat res2 = new Resultat("culture_g", (long) id, 10-erreurs) ;
                            res2.save();
                            texte.setText("Votre record à cet exercice est de " + res2.getCulture() + ".");
                        }
                        else {
                            texte.setText("Impossible d'afficher le score.");
                        }
                    }
                }
            }
        });

        accueil.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(culture_generale.this, Accueil.class) ;
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
                                             Intent intent = new Intent(culture_generale.this, liste_exercices.class) ;
                                             intent.putExtra("ID_COMPTE", id) ;
                                             intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
                                             startActivity(intent);
                                         }
                                     }
        );
    }
}
